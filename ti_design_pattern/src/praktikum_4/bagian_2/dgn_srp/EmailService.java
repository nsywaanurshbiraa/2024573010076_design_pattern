package praktikum_4.bagian_2.dgn_srp;

public class EmailService {

    public void sendWelcomeEmail(User user) {
        System.out.println("\nMengirim email ke " + user.getEmail() + "...");
        System.out.println("Halo " + user.getName() + ", selamat datang di sistem kami!\n");
    }
}
