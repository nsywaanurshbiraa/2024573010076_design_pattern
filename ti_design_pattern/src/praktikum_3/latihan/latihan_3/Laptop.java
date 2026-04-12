package praktikum_3.latihan.latihan_3;

public class Laptop {
    private Processor processor;
    private RAM ram;

    public Laptop() {
        processor = new Processor();
        ram = new RAM();
    }

    void nyalakan() {
        processor.jalankan();
        ram.baca();
        ram.tulis();
        System.out.println("Laptop menyala.");
    }
}
