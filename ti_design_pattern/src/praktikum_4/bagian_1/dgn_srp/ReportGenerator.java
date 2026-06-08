package praktikum_4.bagian_1.dgn_srp;

public class ReportGenerator {

    private final String content;

    public ReportGenerator(String content) {
        this.content = content;
    }

    public String generateReport() {
        return "=== LAPORAN ===\n" + content + "\n====================";
    }
}
