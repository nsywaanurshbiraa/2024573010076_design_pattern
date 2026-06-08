package praktikum_7.bagian_3;

public class PushNotification implements NotificationStrategy {
    public void send(String message) {
        System.out.println("Mengirim notifikasi push: " + message);
    }
}