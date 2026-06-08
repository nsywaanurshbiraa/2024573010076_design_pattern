package praktikum_5.bagian_1.dengan_ocp;

public class PaymentProcessor {
    public void processPayment(PaymentMethod method, double amount) {
        method.process(amount);
    }
}
