package modul_2.latihan.latihan_5;

public class Barang {
    String namaBarang;
    double harga;

    // 1. Default Constructor (Tanpa Parameter)
    public Barang() {
        this.namaBarang = "Unknown";
        this.harga = 0;
        System.out.println("Default constructor dipanggil.");
    }

    // 2. Parameterized Constructor (Dengan Parameter)
    public Barang(String namaBarang, double harga) {
        this.namaBarang = namaBarang;
        this.harga = harga;
        System.out.println("Parameterized constructor dipanggil.");
    }

    // Method untuk menampilkan detail barang
    public void tampilkanInfo() {
        System.out.println("Nama Barang: " + namaBarang);
        System.out.println("Harga      : Rp" + harga);
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {
        // 3. Membuat object menggunakan Default Constructor
        Barang barang1 = new Barang();
        barang1.tampilkanInfo();

        // 4. Membuat object menggunakan Parameterized Constructor
        Barang barang2 = new Barang("Laptop Lenovo LOQ", 12000000);
        barang2.tampilkanInfo();
    }
}