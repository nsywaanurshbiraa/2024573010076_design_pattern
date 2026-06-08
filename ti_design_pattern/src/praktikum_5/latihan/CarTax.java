package praktikum_5.latihan;

public class CarTax implements TaxStrategy {

    public double calculateTax(double price) {
        return price * 0.1;
    }
}
