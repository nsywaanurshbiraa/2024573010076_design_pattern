package praktikum_7.bagian_3;

public class SMSNotification implements NotificationStrategy {
    public void send(String message) {
        System.out.println("Mengirim SMS: " + message);
    }
}