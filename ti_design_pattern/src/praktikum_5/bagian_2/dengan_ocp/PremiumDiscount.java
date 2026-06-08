package praktikum_5.bagian_2.dengan_ocp;

public class PremiumDiscount implements Discount {

    @Override
    public double applyDiscount(double price) {
        return price * 0.2;
    }
}
