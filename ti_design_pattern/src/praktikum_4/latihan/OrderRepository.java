package praktikum_4.latihan;

import praktikum_4.latihan.Order;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OrderRepository {

    private static final String FOLDER_PATH = "src\\modul_4\\latihan\\";
    private static final String FILE_NAME = "order.txt";

    public void save(Order order) {
        File file = new File(FOLDER_PATH + FILE_NAME);

        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(order.getProduct() + " - "
                    + order.getQuantity() + " - "
                    + order.getPrice() + "\n");

            System.out.println("Pesanan berhasil disimpan!");
        } catch (IOException e) {
            System.out.println("Gagal menyimpan: " + e.getMessage());
        }
    }
}