package praktikum_5.latihan;

public class MotorcycleTax implements TaxStrategy {

    public double calculateTax(double price) {
        return price * 0.05;
    }
}
