package optionals;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Supplier<Object> supplyDefaultValue = () -> "default value";

//        Object value = Optional.ofNullable(null)
//                .orElseGet(supplyDefaultValue);
//
//        System.out.println(value);

        Supplier<IllegalStateException> exception = () -> new IllegalStateException("exception");

        Optional<Object> optionalOfNullable = Optional.ofNullable(null);

        Consumer<Object> printSuccessMessage =
                email -> System.out.println("Sending email to " + email);

        Runnable printErrorMessage = () -> System.out.println("No email found");
        optionalOfNullable.ifPresentOrElse(
                printSuccessMessage,
                printErrorMessage
        );
        //System.out.println(optionalOfNullable.orElseGet(supplyDefaultValue));
        optionalOfNullable.orElseThrow(exception);

        //Optional.ofNullable(null).ifPresent(System.out::println);

//        Optional<String> optional = Optional.of("Hello");
//        System.out.println(optional.get());
//        System.out.println(optional.orElse("World"));
//        System.out.println(optional.orElseGet(() -> "World"));
//        System.out.println(optional.orElseThrow(() -> new RuntimeException("No value")));
//        System.out.println(optional.map(s -> s.toUpperCase()).orElse("World"));
//        System.out.println(optional.flatMap(s -> Optional.of(s.toUpperCase())).orElse("World"));
//        System.out.println(optional.filter(s -> s.equals("Hello")).orElse("World"));
    }
}
