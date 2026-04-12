package praktikum_3.bagian_3.pewarisan;

public class Mobil extends Kendaraan{
    int JumlahPintu;

    void displayInfoMobil() {
        displayInfo(); // memanggil metode dari superclass
        System.out.println("Jumlah Pintu :" +JumlahPintu);
    }
}
