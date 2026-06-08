package praktikum_7.latihan;

public class Checkout {
    private PaymentStrategy paymentStrategy;

    public Checkout() {}

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment(double amount) {
        if (paymentStrategy == null) {
            System.out.println("Error: Belum memilih metode pembayaran!");
            return;
        }
        paymentStrategy.pay(amount);
    }
}