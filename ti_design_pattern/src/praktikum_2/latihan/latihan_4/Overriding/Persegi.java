package praktikum_2.latihan.latihan_4.Overriding;

public class Persegi extends BangunDatar{
    int sisi = 4;

    @Override
    double hitungLuas() {
        return sisi * sisi;
    }
}
