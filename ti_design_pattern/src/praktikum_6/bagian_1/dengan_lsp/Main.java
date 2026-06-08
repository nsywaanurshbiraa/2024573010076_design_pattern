package praktikum_6.bagian_1.dengan_lsp;

public class Main {
    public static void printArea(Shape shape) {
        System.out.println("Luas: " + shape.calculateArea());
    }

    public static void main(String[] args) {
        Shape rectangle = new Rectangle(5, 4);
        Shape square = new Square(4);

        printArea(rectangle); // Luas: 20
        printArea(square);    // Luas: 16
    }
}
