package functionalinterface;

import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {
        Customer customerJohn = new Customer(
                "John",
                "123456789");
        greetCustomer(customerJohn);
        greetCustomerConsumer.accept(customerJohn);
    }

    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.println("Hello " + customer.getName() +
                    ", thanks for registering phone number " +
                    customer.getPhoneNumber());

    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.getName() + ", thanks for registering phone number " + customer.getPhoneNumber());
    }

    static class Customer {
        private final String customerName;
        private final String customerPhoneNumber;

        public Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }

        public String getName() {
            return customerName;
        }

        public String getPhoneNumber() {
            return customerPhoneNumber;
        }
    }
}
