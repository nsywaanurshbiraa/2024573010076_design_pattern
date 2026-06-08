package praktikum_4.latihan;

import praktikum_4.latihan.Order;

public class ReceiptPrinter {

    public void print(Order order) {
        System.out.println("\n=== STRUK PESANAN ===");
        System.out.println("Produk  : " + order.getProduct());
        System.out.println("Jumlah  : " + order.getQuantity());
        System.out.println("Harga   : " + order.getPrice());
        System.out.println("Total   : " + order.getTotal());
        System.out.println("=====================");
    }
}