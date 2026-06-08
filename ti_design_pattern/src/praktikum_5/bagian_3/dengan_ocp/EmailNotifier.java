package praktikum_5.bagian_3.dengan_ocp;

public class EmailNotifier implements Notifier {

    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}
