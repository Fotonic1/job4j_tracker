package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {
    @Test
    public void addressList() {
       List<Profile> profiles = Arrays.asList
               (new Profile(new Address("Samara", "Kirova", 50, 24)),
               new Profile(new Address("Astrahan", "Tolstogo", 50, 24)),
               new Profile(new Address("Astrahan", "Tolstogo", 50, 24)));
       List<Address>  rsl= Profiles.collect(profiles);
        List<Address> expected = Arrays.asList(
                        new Address("Astrahan", "Tolstogo", 50, 24),
                        new Address("Samara", "Kirova", 50, 24));
        assertThat(rsl, is(expected));
    }
}