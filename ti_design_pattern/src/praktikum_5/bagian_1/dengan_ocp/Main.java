package praktikum_5.bagian_1.dengan_ocp;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter payment type (CreditCard/EWallet): ");
        String type = scanner.next();
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();

        PaymentProcessor processor = new PaymentProcessor();
        PaymentMethod paymentMethod;

        if (type.equalsIgnoreCase("CreditCard")) {
            paymentMethod = new CreditCardPayment();
        } else if (type.equalsIgnoreCase("EWallet")) {
            paymentMethod = new EWalletPayment();
        } else {
            System.out.println("Invalid payment method");
            return;
        }

        processor.processPayment(paymentMethod, amount);
    }
}