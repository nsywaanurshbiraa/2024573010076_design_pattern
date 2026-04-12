package modul_2.latihan.latihan_1;

// Class Buku menjadi PUBLIC karena nama filenya adalah Buku.java
public class Buku {
    String judul;
    String pengarang;

    // Method main dipindahkan ke dalam class Buku
    public static void main(String[] args) {
        // 1. Membuat object dari class Buku
        Buku buku1 = new Buku();

        // 2. Mengisi nilai atributnya
        buku1.judul = "Pemrograman Java Dasar";
        buku1.pengarang = "Teuku Alam Faziansyah";

        // 3. Menampilkan nilai atribut tersebut
        System.out.println("=== Detail Buku ===");
        System.out.println("Judul Buku: " + buku1.judul);
        System.out.println("Pengarang : " + buku1.pengarang);
    }
}