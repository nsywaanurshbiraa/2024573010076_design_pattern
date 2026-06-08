package praktikum_7.latihan;

public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolderName;
    private String cvv;

    public CreditCardPayment(String cardNumber, String cardHolderName, String cvv) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.cvv = cvv;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Pembayaran via Kartu Kredit sebesar Rp" + amount);
        System.out.println("Nomor Kartu: " + cardNumber.substring(cardNumber.length() - 4));
        System.out.println("Pemilik: " + cardHolderName);
        System.out.println("Status: Pembayaran BERHASIL!");
        System.out.println("------------------------------");
    }
}
