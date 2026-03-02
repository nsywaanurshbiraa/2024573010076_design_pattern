package praktikum_1.latihan;

public class GanjilWhile {
    public static void main(String[] args) {
        int i = 1;
        while (i <= 20) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
            i++;
        }
    }
}
