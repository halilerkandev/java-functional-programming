package functionalinterface;

import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        String num1 = "07000000003";
        String num2 = "09000425030";
        String num3 = "070000000000";

        System.out.println("Without Predicate: ");
        System.out.println(isPhoneNumberValid(num1));
        System.out.println(isPhoneNumberValid(num2));
        System.out.println(isPhoneNumberValid(num3));

        System.out.println("With Predicate: ");
        System.out.println(isPhoneNumberValidPredicate.test(num1));
        System.out.println(isPhoneNumberValidPredicate.test(num2));
        System.out.println(isPhoneNumberValidPredicate.test(num3));

        System.out.println(
                "Is phone number valid and contains number 3 = " +
                        isPhoneNumberValidPredicate
                                .and(containsNumber3)
                                .test(num1));
        System.out.println(
                "Is phone number valid or contains number 3 = " +
                        isPhoneNumberValidPredicate
                                .or(containsNumber3)
                                .test(num2));
        System.out.println(
                "Is phone number valid and contains number 3 = " +
                        isPhoneNumberValidPredicate
                                .and(containsNumber3)
                                .test(num3));

    }

    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }

    static Predicate<String> isPhoneNumberValidPredicate =
            phoneNumber ->
                    phoneNumber.startsWith("07") &&
                            phoneNumber.length() == 11;

    static Predicate<String> containsNumber3 = phoneNumber ->
            phoneNumber.contains("3");

    // interface Predicate<T> {
    //  boolean test(T t);
    // }
}
