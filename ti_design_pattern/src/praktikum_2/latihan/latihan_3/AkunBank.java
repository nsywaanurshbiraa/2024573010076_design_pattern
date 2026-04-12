package modul_2.latihan.latihan_3;

// Jika nama file tetap AkunBank.java, maka class ini yang harus PUBLIC
public class AkunBank {
    private double saldo;

    public AkunBank(double saldoAwal) {
        this.saldo = saldoAwal;
    }

    public void tampilkanSaldo() {
        System.out.println("Saldo saat ini: Rp" + saldo);
    }

    // Pindahkan method main ke sini agar bisa dijalankan dari file AkunBank.java
    public static void main(String[] args) {
        AkunBank akunSaya = new AkunBank(500000);
        akunSaya.tampilkanSaldo();
    }
}