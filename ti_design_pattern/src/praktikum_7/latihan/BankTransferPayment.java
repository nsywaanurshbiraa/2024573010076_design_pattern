package praktikum_7.latihan;

public class BankTransferPayment implements PaymentStrategy {
    private String bankName;
    private String accountNumber;
    private String accountName;

    public BankTransferPayment(String bankName, String accountNumber, String accountName) {
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.accountName = accountName;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Pembayaran via Transfer Bank sebesar Rp" + amount);
        System.out.println("Bank: " + bankName);
        System.out.println("Nomor Rekening: " + accountNumber);
        System.out.println("Atas Nama: " + accountName);
        System.out.println("Status: Pembayaran BERHASIL!");
        System.out.println("------------------------------");
    }
}