package praktikum_6.latihan;

public class Main {
    public static void beginTrip(Vehicle vehicle, String destination) {
        // Jika kendaraan memiliki mesin, hidupkan mesinnya terlebih dahulu secara aman
        if (vehicle instanceof Motorized) {
            ((Motorized) vehicle).startEngine();
        }
        vehicle.navigateTo(destination);
    }

    public static void main(String[] args) {
        Vehicle car = new Car();
        Vehicle bike = new Bicycle();

        System.out.println("Car trip:");
        beginTrip(car, "Central Park");

        System.out.println("\nBike trip:");
        beginTrip(bike, "Central Park"); // Berjalan aman tanpa memicu exception mesin
    }
}