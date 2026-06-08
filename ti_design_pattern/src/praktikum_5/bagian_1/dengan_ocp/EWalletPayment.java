package praktikum_5.bagian_1.dengan_ocp;

public class EWalletPayment implements PaymentMethod {

    public void process(double amount) {
        System.out.println("Processing E-Wallet payment of " + amount);
    }
}
