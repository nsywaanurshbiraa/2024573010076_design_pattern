package praktikum_7.bagian_1;

// Context
public class Navigator {
    private RouteStrategy strategy;

    public Navigator() {}

    public void setStrategy(RouteStrategy strategy) {
        this.strategy = strategy;
    }

    public void navigate(String from, String to) {
        strategy.buildRoute(from, to);
    }
}