package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.getSubjects()
                        .stream())
                .flatMapToInt(subject -> IntStream.of(subject.getScore()))
                .average()
                .orElse(0);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(pupil -> new Tuple(
                        pupil.getName(),
                        pupil.getSubjects()
                                .stream()
                                .flatMapToInt(subject -> IntStream.of(subject.getScore()))
                                .average()
                                .orElse(0)
                )
                )
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        var list = stream.collect(Collectors.toList());
        var sum = list.stream()
                .flatMap(pupil -> pupil.getSubjects()
                .stream())
                .collect(Collectors.toMap(Subject::getName
                        , Subject::getScore
                        , Integer::sum));
        var count = list.stream()
                .flatMap(pupil -> pupil.getSubjects()
                .stream())
                .collect(Collectors.toMap(Subject::getName
                        , v -> 1
                        , Integer::sum));
        return sum.keySet()
                .stream()
                .map(s -> new Tuple(s,(double)sum.get(s)/(double)count.get(s)))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(pupil -> new Tuple(
                                pupil.getName(),
                                pupil.getSubjects()
                                        .stream()
                                        .flatMapToInt(subject -> IntStream.of(subject.getScore()))
                                        .sum()
                        )
                )
                .max(Comparator.comparingDouble(Tuple::getScore))
                .orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.getSubjects()
                        .stream())
                .collect(Collectors.toMap(Subject::getName
                        , Subject::getScore
                        , Integer::sum))
                .entrySet()
                .stream()
                .map(e -> new Tuple(e.getKey(),e.getValue()))
                .max(Comparator.comparingDouble(Tuple::getScore))
                .orElse(null);
    }
}
