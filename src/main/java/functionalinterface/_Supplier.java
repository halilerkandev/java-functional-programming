package functionalinterface;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {
    public static void main(String[] args) {
        System.out.println(getDBConnectionURL());

        System.out.println(getDBConnectionURLSupplier.get());
    }

    static String getDBConnectionURL() {
        return "jdbc://localhost:5432/users";
    }

    static Supplier<List<String>> getDBConnectionURLSupplier =
            () -> List.of(
                    "jdbc://localhost:5432/users",
                    "jdbc://localhost:5432/users"
            );
}
