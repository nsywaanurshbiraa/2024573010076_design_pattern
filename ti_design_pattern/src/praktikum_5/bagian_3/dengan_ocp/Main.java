package praktikum_5.bagian_3.dengan_ocp;

public class Main {

    public static void main(String[] args) {
        NotificationService service = new NotificationService();

        Notifier emailNotifier = new EmailNotifier();
        Notifier smsNotifier = new SMSNotifier();

        service.sendNotification(emailNotifier, "Hello via Email!");
        service.sendNotification(smsNotifier, "Hello via SMS!");
    }
}
