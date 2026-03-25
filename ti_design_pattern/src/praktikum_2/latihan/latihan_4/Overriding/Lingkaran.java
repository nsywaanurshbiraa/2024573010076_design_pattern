package praktikum_2.latihan.latihan_4.Overriding;

public class Lingkaran extends BangunDatar{
    double r = 7;

    @Override
    double hitungLuas() {
        return Math.PI * r * r;
    }
}
