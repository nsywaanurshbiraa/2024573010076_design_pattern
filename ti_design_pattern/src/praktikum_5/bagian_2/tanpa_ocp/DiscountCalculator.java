package praktikum_5.bagian_2.tanpa_ocp;

public class DiscountCalculator {
    public double calculateDiscount(String customerType, double price) {
        if (customerType.equals("Regular")) {
            return price * 0.1;
        } else if (customerType.equals("Premium")) {
            return price * 0.2;
        } else {
            return 0;
        }
    }
}
