package praktikum_4.bagian_2.tanpa_srp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class UserManager {

    private final String name;
    private final String email;

    public UserManager(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Menyimpan pengguna ke database (Seharusnya tugas kelas lain)
    public void saveToDatabase() {
        String folderPath = "src\\modul_4\\srp\\praktikum_2\\tanpa_srp\\";
        String filename = "user.txt";

        File file = new File(folderPath + filename);

        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(name + " - " + email + "\n");
            System.out.println("Pengguna berhasil disimpan: " + name);
        } catch (IOException e) {
            System.out.println("Gagal menyimpan pengguna: " + e.getMessage());
        }
    }

    // Mengirim email selamat datang (Seharusnya tugas kelas lain)
    public void sendWelcomeEmail() {
        System.out.println("\nMengirim email ke " + email + "...");
        System.out.println("Halo " + name + ", selamat datang di sistem kami!\n");
    }
}
