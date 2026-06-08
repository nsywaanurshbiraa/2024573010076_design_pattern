package praktikum_6.bagian_1.tanpa_lsp;

public class Main {
    public static void testRectangle(Rectangle r) {
        r.setWidth(5);
        r.setHeight(4);
        System.out.println("Hasil yang diharapkan: 20, Hasil output: " + r.calculateArea());
    }

    public static void main(String[] args) {
        Rectangle rect = new Rectangle();
        testRectangle(rect); // Hasilnya benar

        Rectangle square = new Square();
        testRectangle(square); // Gagal! Nilai yang dioutputkan 16, seharusnya 20
    }
}
