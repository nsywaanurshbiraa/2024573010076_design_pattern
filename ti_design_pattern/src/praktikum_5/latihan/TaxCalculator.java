package praktikum_5.latihan;

public class TaxCalculator {
    public double calculateTax(TaxStrategy strategy, double price) {
        return strategy.calculateTax(price);
    }
}
