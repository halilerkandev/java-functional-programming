package streams;

import java.util.List;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import static streams._Stream.Gender.*;

public class _Stream {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE),
                new Person("Bob", PREFER_NOT_TO_SAY)
        );

//        people.stream()
//                .map(person -> person.gender)
//                .collect(Collectors.toSet())
//                .forEach(System.out::println);
//
//        Function<Person, String> getPersonName = person -> person.name;
//        ToIntFunction<String> getNameLength = String::length;
//        IntConsumer printLength = System.out::println;
//
//        people.stream()
//                .map(getPersonName)
//                .mapToInt(getNameLength)
//                .forEach(printLength);

        Predicate<Person> isFemale =
                person -> FEMALE.equals(person.gender);

        Predicate<Person> isPreferNotToSay =
                person -> PREFER_NOT_TO_SAY.equals(person.gender);

        boolean containsOnlyFemales = people.stream()
                .allMatch(isFemale);

        System.out.println(containsOnlyFemales);

        boolean containsAnyFemales = people.stream()
                .anyMatch(isFemale);

        System.out.println(containsAnyFemales);

        boolean notContainsAnyPreferNotToSay = people.stream()
                .noneMatch(isPreferNotToSay);

        System.out.println(notContainsAnyPreferNotToSay);
    }

    static class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE, PREFER_NOT_TO_SAY
    }
}
