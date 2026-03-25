// Class untuk Composition
class Mesin {
    void hidupkan() {
        System.out.println("Mesin menyala.");
    }

    void matikan() {
        System.out.println("Mesin dimatikan.");
    }
}

// Superclass untuk Inheritance
class Kendaraan {
    void bergerak() {
        System.out.println("Kendaraan sedang bergerak.");
    }
}

// Subclass yang menggunakan Composition dan Inheritance
class Mobil extends Kendaraan {
    private Mesin mesin; // Composition

    public Mobil() {
        this.mesin = new Mesin(); // Membuat objek Mesin
    }

    void mulai() {
        mesin.hidupkan();
        System.out.println("Mobil siap digunakan.");
    }

    void berhenti() {
        mesin.matikan();
        System.out.println("Mobil berhenti.");
    }
}

public class Main {
    public static void main(String[] args) {
        Mobil mobil = new Mobil();

        mobil.mulai();     // Method dari Composition
        mobil.bergerak();  // Method dari Inheritance
        mobil.berhenti();  // Method dari Composition
    }
}