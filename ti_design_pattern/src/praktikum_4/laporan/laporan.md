# LAPORAN PRAKTIKUM DESIGN PATTERN
## MODUL 4: SINGLE RESPONSIBILITY PRINCIPLE (SRP)

**Nama:** Nasywa Nurshabira  
**NIM:** 2024573010076  
**Kelas:** TI 2A

---

## 1. Abstrak
Pada praktikum ini dibahas salah satu prinsip penting dalam SOLID, yaitu Single Responsibility Principle (SRP). Prinsip ini menekankan bahwa setiap class dalam program sebaiknya hanya memiliki satu tanggung jawab utama atau satu alasan untuk berubah.

Dalam praktikum ini, dilakukan percobaan dengan membuat program yang awalnya melanggar prinsip SRP, kemudian dilakukan refactoring agar sesuai dengan prinsip tersebut. Melalui proses ini, dapat dilihat perbedaan antara kode yang belum terstruktur dengan kode yang sudah menerapkan SRP.

Hasil dari praktikum menunjukkan bahwa penerapan SRP dapat membuat kode menjadi lebih rapi, mudah dipahami, serta lebih mudah dikembangkan. Selain itu, perubahan pada satu bagian program tidak akan mempengaruhi bagian lainnya secara langsung.

---

## 2. Praktikum

### 2.1 Praktikum 1: Report Manager

#### Percobaan (Tanpa SRP)
```java
public class ReportManager {
    public void generateReport() {
        System.out.println("Laporan dibuat");
    }

    public void saveReport() {
        System.out.println("Laporan disimpan");
    }

    public void printReport() {
        System.out.println("Laporan dicetak");
    }
}
```
Main
```java
package praktikum_4.bagian_1.tanpa_srp;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan isi laporan: ");
        String reportText = scanner.nextLine();

        System.out.print("Masukkan nama file laporan: ");
        String reportFileName = scanner.nextLine();

        ReportManager reportManager = new ReportManager(reportText);
        String report = reportManager.generateReport();

        reportManager.saveToFile(reportFileName + ".txt");
        reportManager.printReport();
    }
}

```

#### Analisa
Pada kode di atas, satu class menangani tiga hal sekaligus, yaitu membuat, menyimpan, dan mencetak laporan. Hal ini membuat class menjadi terlalu “berat” karena memiliki banyak tanggung jawab.

Jika suatu saat ada perubahan, misalnya cara penyimpanan laporan diubah, maka class ini harus ikut diubah. Ini berpotensi menyebabkan error di bagian lain yang sebenarnya tidak berkaitan. Selain itu, kode juga menjadi kurang fleksibel karena semua fungsi digabung dalam satu tempat.

---

#### Perbaikan (Dengan SRP)
```java
class ReportGenerator {
    public String generateReport() {
        return "Laporan dibuat";
    }
}

class ReportSaver {
    public void saveToFile(String report) {
        System.out.println("Laporan disimpan: " + report);
    }
}

class ReportPrinter {
    public void print(String report) {
        System.out.println("Laporan dicetak: " + report);
    }
}
```
Report Saver
```java
package praktikum_4.bagian_1.dgn_srp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReportSaver {

    public void saveToFile(String filename, String content) {
        String folderPath = "src\\modul_4\\srp\\praktikum_1\\dengan_srp\\";

        File file = new File(folderPath + filename);

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(content);
            System.out.println("Laporan disimpan ke file: " + filename);
        } catch (IOException e) {
            System.out.println("Gagal menyimpan laporan: " + e.getMessage());
        }
    }
}
```
Report Printer
```java
package praktikum_4.bagian_1.dgn_srp;

public class ReportPrinter {

    public void printReport(String content) {
        System.out.println("\nLaporan yang dicetak:\n" + content);
    }
}

```
Main
```java
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

```
#### Analisa
Setelah dipisahkan, setiap class hanya memiliki satu tugas. Hal ini membuat struktur program menjadi lebih jelas. Jika terjadi perubahan pada bagian penyimpanan, maka hanya class `ReportSaver` yang perlu diubah.

Kode juga menjadi lebih mudah dibaca karena setiap class memiliki fungsi yang spesifik. Selain itu, masing-masing class bisa diuji secara terpisah tanpa bergantung pada bagian lain.

---

### 2.2 Praktikum 2: User Manager

#### Percobaan (Tanpa SRP)
```java
public class UserManager {
    public void registerUser(String name) {
        System.out.println("User terdaftar: " + name);
        System.out.println("Data disimpan");
        System.out.println("Email dikirim");
    }
}
```
Main
```java
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

```

#### Analisa
Class ini menangani beberapa proses sekaligus, yaitu registrasi user, penyimpanan data, dan pengiriman email. Hal ini membuat class menjadi tidak fokus pada satu tugas saja.

Jika ada perubahan pada sistem database atau sistem email, maka class ini harus ikut diubah. Ini menunjukkan bahwa class tersebut memiliki lebih dari satu alasan untuk berubah, sehingga tidak sesuai dengan prinsip SRP.

---

#### Perbaikan (Dengan SRP)
```java
class User {
    String name;

    User(String name) {
        this.name = name;
    }
}

class UserRepository {
    public void save(User user) {
        System.out.println("Data disimpan: " + user.name);
    }
}

class UserService {
    public void register(User user) {
        System.out.println("User terdaftar: " + user.name);
    }
}
```
User Repository
```java
package praktikum_4.bagian_2.dgn_srp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class UserRepository {

    private static final String FOLDER_PATH = "src\\modul_4\\srp\\praktikum_2\\dengan_srp\\";
    private static final String DATABASE_FILE = "user.txt";

    public void save(User user) {
        File file = new File(FOLDER_PATH + DATABASE_FILE);

        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(user.getName() + " - " + user.getEmail() + "\n");
            System.out.println("Pengguna berhasil disimpan: " + user.getName());
        } catch (IOException e) {
            System.out.println("Gagal menyimpan pengguna: " + e.getMessage());
        }
    }
}

```
Email Service
```java
package praktikum_4.bagian_2.dgn_srp;

public class EmailService {

    public void sendWelcomeEmail(User user) {
        System.out.println("\nMengirim email ke " + user.getEmail() + "...");
        System.out.println("Halo " + user.getName() + ", selamat datang di sistem kami!\n");
    }
}

```
Main
```java
package praktikum_4.bagian_2.dgn_srp;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nama pengguna: ");
        String name = scanner.nextLine();

        System.out.print("Masukkan email pengguna: ");
        String email = scanner.nextLine();

        User user = new User(name, email);

        UserRepository userRepository = new UserRepository();
        EmailService emailService = new EmailService();

        userRepository.save(user);
        emailService.sendWelcomeEmail(user);
    }
}

```

#### Analisa
Setelah dilakukan pemisahan, setiap class memiliki tanggung jawab masing-masing. `User` hanya menyimpan data, `UserRepository` menangani penyimpanan, dan `UserService` menangani proses registrasi.

Dengan struktur ini, program menjadi lebih mudah dikembangkan. Misalnya, jika ingin menambahkan fitur pengiriman email, cukup menambahkan class baru tanpa mengubah class yang sudah ada.

---

### 2.3 Latihan: Order Management

#### Solusi
```java
package praktikum_4.latihan;

public class Order {

    private String product;
    private int quantity;
    private double price;

    public Order(String product, int quantity, double price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getTotal() {
        return quantity * price;
    }
}
```
```java
package praktikum_4.latihan;

import praktikum_4.latihan.Order;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OrderRepository {

    private static final String FOLDER_PATH = "src\\modul_4\\latihan\\";
    private static final String FILE_NAME = "order.txt";

    public void save(Order order) {
        File file = new File(FOLDER_PATH + FILE_NAME);

        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(order.getProduct() + " - "
                    + order.getQuantity() + " - "
                    + order.getPrice() + "\n");

            System.out.println("Pesanan berhasil disimpan!");
        } catch (IOException e) {
            System.out.println("Gagal menyimpan: " + e.getMessage());
        }
    }
}
```
```java
package praktikum_4.latihan;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nama produk: ");
        String product = scanner.nextLine();

        System.out.print("Masukkan jumlah: ");
        int quantity = scanner.nextInt();

        System.out.print("Masukkan harga satuan: ");
        double price = scanner.nextDouble();

        Order order = new Order(product, quantity, price);

        OrderRepository repository = new OrderRepository();
        ReceiptPrinter printer = new ReceiptPrinter();

        repository.save(order);
        printer.print(order);
    }
}

```
## Identifikasi Pelanggaran Single Responsibility Principle (SRP)

Pada program awal (sebelum diperbaiki), terdapat pelanggaran terhadap prinsip Single Responsibility Principle (SRP) pada kelas `OrderManager`.

### Bagian yang Melanggar SRP

Kelas `OrderManager` memiliki beberapa tanggung jawab sekaligus, yaitu:

1. **Mengelola data pesanan**
    - Menyimpan informasi seperti nama produk, jumlah, dan harga

2. **Menyimpan data ke file**
    - Method `saveOrder()` digunakan untuk menulis data pesanan ke dalam file

3. **Mencetak struk pesanan**
    - Method `printReceipt()` digunakan untuk menampilkan detail pesanan ke console

### Penjelasan

Seharusnya, satu kelas hanya memiliki satu tanggung jawab. Namun pada kasus ini, `OrderManager` menangani tiga hal berbeda dalam satu tempat. Hal ini menyebabkan kelas tersebut memiliki lebih dari satu alasan untuk berubah.

Contohnya:
- Jika format penyimpanan file berubah → harus ubah `OrderManager`
- Jika tampilan struk berubah → tetap harus ubah `OrderManager`
- Jika struktur data pesanan berubah → juga ubah `OrderManager`

Akibatnya, perubahan kecil bisa berdampak ke banyak bagian, dan kode jadi lebih sulit untuk dirawat.

### Kesimpulan

Pelanggaran SRP terjadi karena `OrderManager` tidak fokus pada satu tugas saja. Oleh karena itu, perlu dilakukan pemisahan menjadi beberapa kelas seperti:
- `Order` untuk data
- `OrderRepository` untuk penyimpanan
- `ReceiptPrinter` untuk pencetakan

Dengan begitu, setiap kelas hanya memiliki satu tanggung jawab dan kode menjadi lebih terstruktur.
#### Analisa
Pada solusi ini, setiap bagian dipisahkan sesuai tugasnya. Hal ini membuat program lebih terstruktur dan mudah dipahami. Selain itu, jika ada perubahan pada salah satu bagian, tidak akan mempengaruhi bagian lainnya.

---

## 3. Kesimpulan
Dari praktikum yang telah dilakukan, dapat disimpulkan bahwa Single Responsibility Principle (SRP) merupakan prinsip yang sangat penting dalam pengembangan perangkat lunak berbasis OOP.

Dengan menerapkan SRP, setiap class hanya memiliki satu tanggung jawab sehingga kode menjadi lebih terorganisir dan mudah dipahami. Selain itu, perubahan pada satu bagian tidak akan berdampak besar pada bagian lain, sehingga risiko terjadinya error dapat dikurangi.

Penerapan SRP juga membuat proses pengembangan menjadi lebih fleksibel. Programmer dapat menambahkan atau mengubah fitur tanpa harus mengubah keseluruhan program. Hal ini sangat membantu terutama dalam pengembangan aplikasi yang kompleks.

Namun, perlu diperhatikan bahwa penggunaan SRP juga harus seimbang. Jika terlalu banyak pemisahan class, maka program bisa menjadi terlalu kompleks. Oleh karena itu, penerapan SRP harus disesuaikan dengan kebutuhan program.

---

## 4. Referensi
1. Modul Praktikum Design Pattern – Politeknik Negeri Lhokseumawe
2. Martin, R. C. (2003). Agile Software Development
3. Martin, R. C. (2008). Clean Code  
