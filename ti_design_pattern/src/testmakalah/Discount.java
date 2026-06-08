package testmakalah;
abstract class Discount {
    abstract double calculate(double price);
}

class RegularDiscount extends Discount {
    double calculate(double price) {
        return price * 0.1;
    }
}

class VIPDiscount extends Discount {
    double calculate(double price) {
        return price * 0.2;
    }
}
