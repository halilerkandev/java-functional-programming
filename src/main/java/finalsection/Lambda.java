package finalsection;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Lambda {
    public static void main(String[] args) {

        BiFunction<String, Integer, String> upperCaseName = (name, age) -> {
            // logic
            if (name.isBlank()) throw new IllegalArgumentException("Name cannot be blank");
            System.out.println(age);
            return name.toUpperCase();
        };

        String upperCasedName = upperCaseName.apply("Alex", 20);

        System.out.println(upperCasedName);

    }
}
