package combinatorpattern;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static combinatorpattern.CustomerRegistrationValidator.*;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(
                "Alice",
                "alice@gmail.com",
                "+0123456789",
                LocalDate.of(2015, 1, 1)
        );

//        System.out.println(isValid(customer));

        // if valid we can save the customer

        // Using Combinator Pattern
        List<ValidationResult> validationsResults = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAnAdult())
                .apply(customer, new ArrayList<>());

        System.out.println(validationsResults.toString());

    }
}
