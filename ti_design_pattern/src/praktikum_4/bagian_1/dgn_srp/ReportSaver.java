package praktikum_4.bagian_1.dgn_srp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReportSaver {

    public void saveToFile(String filename, String content) {
        String folderPath = "src\\modul_4\\srp\\praktikum_1\\dengan_srp\\";

        File file = new File(folderPath + filename);

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(content);
            System.out.println("Laporan disimpan ke file: " + filename);
        } catch (IOException e) {
            System.out.println("Gagal menyimpan laporan: " + e.getMessage());
        }
    }
}