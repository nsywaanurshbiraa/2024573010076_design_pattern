package praktikum_4.bagian_2.tanpa_srp;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nama pengguna: ");
        String name = scanner.nextLine();

        System.out.print("Masukkan email pengguna: ");
        String email = scanner.nextLine();

        UserManager userManager = new UserManager(name, email);
        userManager.saveToDatabase();
        userManager.sendWelcomeEmail();
    }
}
