package combinatorpattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.function.BiFunction;

import static combinatorpattern.CustomerRegistrationValidator.*;
import static combinatorpattern.CustomerRegistrationValidator.ValidationResult.*;

public interface CustomerRegistrationValidator
        extends BiFunction<Customer, List<ValidationResult>, List<ValidationResult>> {

    static CustomerRegistrationValidator isEmailValid() {
        return (customer, validationResults) -> {
            if (!customer.getEmail().contains("@")) {
                validationResults.add(EMAIL_NOT_VALID);
            }
            return validationResults;
        };
    }

    static CustomerRegistrationValidator isPhoneNumberValid() {
        return (customer, validationResults) -> {
            if (!customer.getPhoneNumber().startsWith("+0")) {
                validationResults.add(PHONE_NUMBER_NOT_VALID);
            }
            return validationResults;
        };
    }

    static CustomerRegistrationValidator isAnAdult() {
        return (customer, validationResults) -> {
            if(Period.between(customer.getDob(), LocalDate.now()).getYears() < 16) {
                validationResults.add(NOT_AN_ADULT);
            }
            return validationResults;
        };
    }

    default CustomerRegistrationValidator and(CustomerRegistrationValidator other) {
        return (customer, validationResults) -> {
            List<ValidationResult> newValidationResults = this.apply(customer, validationResults);
            return other.apply(customer, newValidationResults);
        };
    }

    enum ValidationResult {
        PHONE_NUMBER_NOT_VALID,
        EMAIL_NOT_VALID,
        NOT_AN_ADULT
    }

}
