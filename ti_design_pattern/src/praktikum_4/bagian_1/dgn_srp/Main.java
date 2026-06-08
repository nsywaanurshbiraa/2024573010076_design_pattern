package praktikum_4.bagian_1.dgn_srp;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan isi laporan: ");
        String reportText = scanner.nextLine();

        System.out.print("Masukkan nama file laporan: ");
        String reportFileName = scanner.nextLine();

        ReportGenerator report = new ReportGenerator(reportText);
        String reportContent = report.generateReport();

        ReportSaver saver = new ReportSaver();
        saver.saveToFile(reportFileName + ".txt", reportContent);

        ReportPrinter printer = new ReportPrinter();
        printer.printReport(reportContent);
    }
}
