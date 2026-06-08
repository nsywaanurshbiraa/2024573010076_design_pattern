package praktikum_7.bagian_3;

public class NotificationService {
    private NotificationStrategy strategy;

    public NotificationService() {}

    public void setStrategy(NotificationStrategy strategy) {
        this.strategy = strategy;
    }

    public void notifyUser(String message) {
        strategy.send(message);
    }
}