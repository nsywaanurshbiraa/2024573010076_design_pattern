package praktikum_7.bagian_3;

public class Main {
    public static void main(String[] args) {
        NotificationService notif = new NotificationService();

        notif.setStrategy(new EmailNotification());
        notif.notifyUser("Selamat, akun Anda berhasil dibuat!");

        notif.setStrategy(new SMSNotification());
        notif.notifyUser("Kode OTP Anda: 123456");

        notif.setStrategy(new PushNotification());
        notif.notifyUser("Ada promo baru menanti Anda!");
    }
}