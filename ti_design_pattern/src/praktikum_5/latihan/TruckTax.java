package praktikum_5.latihan;

public class TruckTax implements TaxStrategy {

    public double calculateTax(double price) {
        return price * 0.15;
    }
}
