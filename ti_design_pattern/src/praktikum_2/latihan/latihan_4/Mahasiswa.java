package modul_2.latihan.latihan_4;

public class Mahasiswa {
    // 1. Atribut nama dan nim diset sebagai PRIVATE
    private String nama;
    private String nim;

    // 2. Setter untuk atribut nama
    public void setNama(String nama) {
        this.nama = nama;
    }

    // Getter untuk atribut nama
    public String getNama() {
        return nama;
    }

    // Setter untuk atribut nim
    public void setNim(String nim) {
        this.nim = nim;
    }

    // Getter untuk atribut nim
    public String getNim() {
        return nim;
    }

    public static void main(String[] args) {
        // 3. Membuat object dari class Mahasiswa
        Mahasiswa mhs = new Mahasiswa();

        // 4. Gunakan setter untuk mengisi nilai atribut
        mhs.setNama("Teuku Alam Faziansyah");
        mhs.setNim("2024573010068");

        // Menampilkan nilai menggunakan getter
        System.out.println("=== Data Mahasiswa ===");
        System.out.println("Nama : " + mhs.getNama());
        System.out.println("NIM  : " + mhs.getNim());
    }
}