package praktikum_7.latihan;

public class EWalletPayment implements PaymentStrategy {
    private String phoneNumber;
    private String provider; // misal: OVO, GoPay, Dana

    public EWalletPayment(String phoneNumber, String provider) {
        this.phoneNumber = phoneNumber;
        this.provider = provider;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Pembayaran via E-Wallet (" + provider + ") sebesar Rp" + amount);
        System.out.println("Nomor HP: " + phoneNumber);
        System.out.println("Status: Pembayaran BERHASIL!");
        System.out.println("------------------------------");
    }
}