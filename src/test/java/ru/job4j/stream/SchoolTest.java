package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SchoolTest {
    @Test
    public void aClass() {
        List<Student> students = Arrays.asList(new Student("Petrov", 30),
                new Student("Ivanov", 60),
                new Student("Smirnov", 70));
        Predicate<Student> predict1 = student -> student.getScore() >= 70;
        Predicate<Student> predict2 = student -> student.getScore() <= 100;
        Predicate<Student> predict = predict1.and(predict2);
        List<Student> rsl = School.collect(students, predict);
        List<Student> expected = Collections.singletonList(new Student("Smirnov", 70));
        assertThat(rsl, is(expected));
    }

    @Test
    public void bClass() {
        List<Student> students = Arrays.asList(new Student("Petrov", 30),
                new Student("Ivanov", 60),
                new Student("Smirnov", 70));
        Predicate<Student> predict1 = student -> student.getScore() >= 50;
        Predicate<Student> predict2 = student -> student.getScore() < 70;
        Predicate<Student> predict = predict1.and(predict2);
        List<Student> rsl = School.collect(students, predict);
        List<Student> expected = Collections.singletonList(new Student("Ivanov", 60));
        assertThat(rsl, is(expected));
    }

    @Test
    public void vClass() {
        List<Student> students = Arrays.asList(new Student("Petrov", 30),
                new Student("Ivanov", 60),
                new Student("Smirnov", 70));
        Predicate<Student> predict1 = student -> student.getScore() > 0;
        Predicate<Student> predict2 = student -> student.getScore() < 50;
        Predicate<Student> predict = predict1.and(predict2);
        List<Student> rsl = School.collect(students, predict);
        List<Student> expected = Collections.singletonList(new Student("Petrov", 30));
        assertThat(rsl, is(expected));
    }
}