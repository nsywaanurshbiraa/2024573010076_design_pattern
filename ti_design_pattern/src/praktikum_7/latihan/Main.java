package praktikum_7.latihan;

public class Main {
    public static void main(String[] args) {
        Checkout checkout = new Checkout();

        System.out.println("========== E-COMMERCE CHECKOUT SYSTEM ==========\n");

        // Contoh 1: Pembayaran dengan Kartu Kredit
        System.out.println("1. Pembayaran dengan Kartu Kredit:");
        checkout.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456", "Budi Santoso", "123"));
        checkout.processPayment(250000);

        // Contoh 2: Pembayaran dengan E-Wallet
        System.out.println("2. Pembayaran dengan E-Wallet:");
        checkout.setPaymentStrategy(new EWalletPayment("081234567890", "GoPay"));
        checkout.processPayment(75000);

        // Contoh 3: Pembayaran dengan Transfer Bank
        System.out.println("3. Pembayaran dengan Transfer Bank:");
        checkout.setPaymentStrategy(new BankTransferPayment("BCA", "1234567890", "Budi Santoso"));
        checkout.processPayment(500000);
    }
}