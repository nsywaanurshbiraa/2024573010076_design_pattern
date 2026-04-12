package modul_2.latihan.latihan_2;

// Nama class diubah menjadi Lingkaran agar sama dengan nama file Lingkaran.java
public class Lingkaran {
    // Atribut jari-jari
    double jariJari;

    // Method untuk menghitung luas lingkaran
    double hitungLuas() {
        return Math.PI * jariJari * jariJari;
    }

    // Method main dipindahkan ke dalam class Lingkaran
    public static void main(String[] args) {
        // 1. Membuat object dari class Lingkaran
        Lingkaran bundar = new Lingkaran();

        // 2. Mengisi nilai atribut jariJari
        bundar.jariJari = 7;

        // 3. Memanggil method hitungLuas() dan menampilkan hasilnya
        double luas = bundar.hitungLuas();

        System.out.println("=== Perhitungan Luas Lingkaran ===");
        System.out.println("Jari-jari : " + bundar.jariJari);
        System.out.println("Hasil Luas: " + luas);
    }
}