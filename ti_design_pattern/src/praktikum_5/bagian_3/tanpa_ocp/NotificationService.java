package praktikum_5.bagian_3.tanpa_ocp;

public class NotificationService {
    public void sendNotification(String type, String message) {
        if (type.equals("Email")) {
            System.out.println("Sending Email: " + message);
        } else if (type.equals("SMS")) {
            System.out.println("Sending SMS: " + message);
        } else {
            System.out.println("Invalid notification type");
        }
    }
}
