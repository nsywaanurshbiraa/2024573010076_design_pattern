package praktikum_4.bagian_2.dgn_srp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class UserRepository {

    private static final String FOLDER_PATH = "src\\modul_4\\srp\\praktikum_2\\dengan_srp\\";
    private static final String DATABASE_FILE = "user.txt";

    public void save(User user) {
        File file = new File(FOLDER_PATH + DATABASE_FILE);

        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(user.getName() + " - " + user.getEmail() + "\n");
            System.out.println("Pengguna berhasil disimpan: " + user.getName());
        } catch (IOException e) {
            System.out.println("Gagal menyimpan pengguna: " + e.getMessage());
        }
    }
}
