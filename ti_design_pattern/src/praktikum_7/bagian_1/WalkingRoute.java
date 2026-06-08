package praktikum_7.bagian_1;

// Strategy
public class WalkingRoute implements RouteStrategy {
    @Override
    public void buildRoute(String from, String to) {
        System.out.println("Membuat rute jalan kaki dari " + from + " ke " + to);
    }
}