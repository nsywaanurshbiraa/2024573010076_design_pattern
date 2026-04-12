package praktikum_3.latihan.latihan_2;

public class Main {
    public static void main(String[] args) {
        Motor m = new Motor();

        m.setMerk("Honda");
        m.setTahun(2022);

        System.out.println("Merk: " + m.getMerk());
        System.out.println("Tahun: " + m.getTahun());
    }
}
