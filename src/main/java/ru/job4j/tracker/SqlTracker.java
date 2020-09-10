package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {
    private Connection cn;

    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (final PreparedStatement st = cn.prepareStatement("insert into items(name) values (?)",
                Statement.RETURN_GENERATED_KEYS)) {
            st.setString(1, item.getName());
            st.executeUpdate();
            try (ResultSet key = st.getGeneratedKeys()) {
                if (key.next()) {
                    item.setId(key.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        var rsl = false;
        try (final PreparedStatement st = cn
                .prepareStatement("update items set name = ? where id = ?")) {
            st.setString(1, item.getName());
            st.setInt(2, id);
            if (st.executeUpdate() == 1) {
                item.setId(id);
                rsl = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public boolean delete(int id) {
        var rsl = false;
        try (final PreparedStatement st = cn
                .prepareStatement("delete from items where id = ?")) {
            st.setInt(1, id);
            if (st.executeUpdate() == 1) {
                rsl = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public List<Item> findAll() {
        var rsl = new ArrayList<Item>();
        try (final PreparedStatement st = cn
                .prepareStatement("select * from items")) {
            ResultSet r = st.executeQuery();
            while (r.next()) {
                rsl.add(new Item(r.getInt("id"), r.getString("name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public List<Item> findByName(String key) {
        var rsl = new ArrayList<Item>();
        try (final PreparedStatement st = cn
                .prepareStatement("select * from items where name = ?")) {
            st.setString(1, key);
            ResultSet r = st.executeQuery();
            while (r.next()) {
                rsl.add(new Item(r.getInt("id"), r.getString("name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public Item findById(int id) {
        Item rsl = null;
        try (final PreparedStatement st = cn
                .prepareStatement("select * from items where id = ?")) {
            st.setInt(1, id);
            ResultSet r = st.executeQuery();
            while (r.next()) {
                rsl = new Item(r.getInt("id"), r.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rsl;
    }
}
