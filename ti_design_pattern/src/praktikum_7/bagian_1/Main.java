package praktikum_7.bagian_1;

public class Main {
    public static void main(String[] args) {
        Navigator nav = new Navigator();

        nav.setStrategy(new WalkingRoute());
        nav.navigate("Kampus", "Kos");

        nav.setStrategy(new DrivingRoute());
        nav.navigate("Kampus", "Mall");

        nav.setStrategy(new PublicTransportRoute());
        nav.navigate("Kampus", "Stasiun");
    }
}