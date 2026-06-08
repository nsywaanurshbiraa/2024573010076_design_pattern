package praktikum_7.bagian_2;

public class BlackWhiteFilter implements FilterStrategy {
    public void apply(String fileName) {
        System.out.println("Menerapkan filter hitam-putih pada " + fileName);
    }
}