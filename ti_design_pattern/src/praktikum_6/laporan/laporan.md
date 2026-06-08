# LAPORAN PRAKTIKUM DESIGN PATTERN

## MODUL 6: LISKOV SUBSTITUTION PRINCIPLE (LSP)

**Nama:** Nasywa Nurshabira
**NIM:** 2024573010076
**Kelas:** TI 2A

---

# 1. Abstrak

Pada praktikum ini dipelajari salah satu prinsip dalam SOLID yaitu Liskov Substitution Principle (LSP). Prinsip ini menjelaskan bahwa subclass harus dapat menggantikan superclass tanpa menyebabkan perubahan perilaku pada program.

Praktikum dilakukan dengan beberapa studi kasus menggunakan bahasa Java. Kasus pertama membahas hubungan antara `Rectangle` dan `Square`, sedangkan kasus kedua membahas sistem posting media sosial. Melalui praktikum ini dapat dipahami bahwa penggunaan inheritance yang tidak tepat dapat menyebabkan program menghasilkan perilaku yang tidak sesuai harapan.

Dengan menerapkan prinsip LSP, struktur program menjadi lebih fleksibel, mudah dipelihara, dan lebih aman untuk dikembangkan di masa depan.

---

# 2. Latar Belakang

Dalam pemrograman berorientasi objek, inheritance digunakan untuk mempermudah pengembangan program dan mengurangi penulisan kode berulang. Namun penggunaan inheritance yang tidak tepat dapat menyebabkan perubahan perilaku program sehingga menghasilkan error atau output yang tidak sesuai harapan.

Salah satu prinsip penting dalam SOLID adalah Liskov Substitution Principle (LSP). Prinsip ini menyatakan bahwa subclass harus dapat menggantikan superclass tanpa mengubah perilaku dasar program.

Pelanggaran terhadap prinsip LSP biasanya terjadi ketika subclass mengubah perilaku utama dari superclass. Hal ini dapat membuat program menjadi tidak stabil dan sulit dikembangkan.

Melalui praktikum ini, mahasiswa mempelajari bagaimana cara mengidentifikasi pelanggaran LSP dan melakukan refactoring agar desain program menjadi lebih baik serta sesuai dengan prinsip OOP yang benar.

---

# 3. Tujuan Praktikum

1. Memahami konsep Liskov Substitution Principle (LSP).
2. Mengidentifikasi pelanggaran LSP pada program Java.
3. Melakukan refactoring program agar sesuai dengan prinsip LSP.
4. Memahami penggunaan inheritance yang tepat dalam OOP.

---

# 4. Praktikum

# 4.1 Praktikum 1 – Rectangle dan Square

## 4.1.1 Langkah Praktikum (tanpa LSP)

1. Membuat package `praktikum_1`.
2. Membuat class `Rectangle`.
3. Membuat class `Square` sebagai turunan dari `Rectangle`.
4. Membuat class `Main`.
5. Menjalankan program dan mengamati hasil output.
6. Menganalisis pelanggaran LSP pada program.

---

## 4.1.2 Kode Program

### Class Rectangle

```java 
public class Rectangle {

    protected int width;
    protected int height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int calculateArea() {
        return width * height;
    }
}
```

---

### Class Square

```java 
public class Square extends Rectangle {

    @Override
    public void setWidth(int width) {
        this.width = width;
        this.height = width;
    }

    @Override
    public void setHeight(int height) {
        this.width = height;
        this.height = height;
    }
}
```

---

### Class Main

```java 
public class Main {

    public static void testRectangle(Rectangle r) {

        r.setWidth(5);
        r.setHeight(4);

        System.out.println("Expected area: 20");
        System.out.println("Actual area: " + r.calculateArea());
    }

    public static void main(String[] args) {

        Rectangle rectangle = new Rectangle();
        Rectangle square = new Square();

        testRectangle(rectangle);
        testRectangle(square);
    }
}
```

---

## 4.1.3 Hasil Output

![hasil](gambar/tanpa_lsp_1.png)

---
## 4.1.4 Langkah Praktikum (dengan LSP)
1. Buat sebuah package baru di dalam praktikum_1 dan beri nama dengan_lsp
2. Buat sebuah interface dengan nama Shape dan isikan kode berikut:
```
package praktikum_6.bagian_1.dengan_lsp;

public interface Shape {
    int calculateArea();
}
```
5. Buat sebuah class dengan nama Rectangle dan isikan kode berikut:
```
package praktikum_6.bagian_1.dengan_lsp;

public class Rectangle implements Shape {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public int calculateArea() {
        return width * height;
    }
}

```
8. Buat sebuah class dengan nama Square dan isikan kode berikut:
```
package praktikum_6.bagian_1.dengan_lsp;

public class Square implements Shape{
    private int side;

    public Square(int side) {
        this.side = side;
    }

    @Override
    public int calculateArea() {
        return side * side;
    }
}

```
11. Buat sebuah class Main dan isikan kode berikut:
```
package praktikum_6.bagian_1.dengan_lsp;

public class Main {
    public static void printArea(Shape shape) {
        System.out.println("Luas: " + shape.calculateArea());
    }

    public static void main(String[] args) {
        Shape rectangle = new Rectangle(5, 4);
        Shape square = new Square(4);

        printArea(rectangle); // Luas: 20
        printArea(square);    // Luas: 16
    }
}

```
14. Jalankan dan lihat hasilnya.
[hasil dengan LSP](gambar/dgn_lsp_1.png)

## 4.1. Analisa

Pada program di atas, class `Square` dibuat sebagai turunan dari `Rectangle`. Secara konsep matematika hal ini memang benar, namun dalam implementasi program menyebabkan masalah.

Class `Rectangle` memungkinkan width dan height diubah secara terpisah. Akan tetapi pada class `Square`, perubahan width otomatis mengubah height, begitu juga sebaliknya.

Akibatnya, ketika object `Square` digunakan sebagai object `Rectangle`, hasil program menjadi tidak sesuai harapan. Hal ini menunjukkan bahwa subclass `Square` tidak dapat menggantikan superclass `Rectangle` secara aman sehingga melanggar prinsip LSP.

---


# 4.2 Praktikum 2 – Sistem Posting Media Sosial

## 4.2.1 Langkah Praktikum

1. Membuat package `praktikum_2`.
2. Membuat class `SocialMediaPost`.
3. Membuat class `InstagramPost`.
4. Membuat class `TwitterPost`.
5. Membuat class `ReadOnlyPost`.
6. Membuat class `Main`.
7. Menjalankan program dan mengamati hasil output.
8. Melakukan analisis pelanggaran LSP pada program.
9. Melakukan refactoring program agar sesuai dengan prinsip LSP.

---

## 4.2.2 Kode Program Tanpa LSP

### Class SocialMediaPost

```java 
public class SocialMediaPost {

    public void createPost() {
        System.out.println("Post created");
    }

    public void editPost() {
        System.out.println("Post edited");
    }

    public void deletePost() {
        System.out.println("Post deleted");
    }
}
```

---

### Class InstagramPost

```java id="9qq0ib"
public class InstagramPost extends SocialMediaPost {

}
```

---

### Class TwitterPost

```java 
public class TwitterPost extends SocialMediaPost {

}
```

---

### Class ReadOnlyPost

```java 
public class ReadOnlyPost extends SocialMediaPost {

    @Override
    public void editPost() {
        throw new UnsupportedOperationException("Cannot edit post");
    }

    @Override
    public void deletePost() {
        throw new UnsupportedOperationException("Cannot delete post");
    }
}
```

---

### Class Main

```java 
public class Main {

    public static void managePost(SocialMediaPost post) {

        post.createPost();
        post.editPost();
        post.deletePost();
    }

    public static void main(String[] args) {

        SocialMediaPost instagram = new InstagramPost();
        SocialMediaPost twitter = new TwitterPost();
        SocialMediaPost readOnly = new ReadOnlyPost();

        managePost(instagram);
        managePost(twitter);
        managePost(readOnly);
    }
}
```

---

## 4.2.3 Hasil Output
[hasil tanpa LSP](gambar/tanpa_lsp_2.png)

---

## 4.2.4 Analisa

Pada program di atas, class `ReadOnlyPost` merupakan turunan dari `SocialMediaPost`. Namun object `ReadOnlyPost` tidak dapat menjalankan semua method yang dimiliki superclass.

Ketika method `editPost()` dan `deletePost()` dipanggil, program menghasilkan exception karena fitur tersebut tidak didukung oleh `ReadOnlyPost`.

Hal ini menunjukkan bahwa subclass `ReadOnlyPost` tidak dapat menggantikan superclass `SocialMediaPost` secara aman. Oleh karena itu program melanggar prinsip LSP.

---

# 4.3 Refactoring Program Sesuai LSP

## 4.3.1 Langkah Praktikum

1. Membuat interface `PostCreator`.
2. Membuat interface `EditablePost`.
3. Memisahkan fitur create, edit, dan delete sesuai kebutuhan.
4. Mengubah struktur inheritance program.
5. Menjalankan kembali program.
6. Mengamati perubahan hasil output.

---

## 4.3.2 Kode Program Refactoring

### Interface PostCreator

```java 
public interface PostCreator {
    void createPost();
}
```

---

### Interface EditablePost

```java
public interface EditablePost {
    void editPost();
    void deletePost();
}
```

---

### Class InstagramPost

```java
public class InstagramPost implements PostCreator, EditablePost {

    @Override
    public void createPost() {
        System.out.println("Instagram post created");
    }

    @Override
    public void editPost() {
        System.out.println("Instagram post edited");
    }

    @Override
    public void deletePost() {
        System.out.println("Instagram post deleted");
    }
}
```

---

### Class ReadOnlyPost

```java 
public class ReadOnlyPost implements PostCreator {

    @Override
    public void createPost() {
        System.out.println("Read only post created");
    }
}
```

---

### Class Main

```java 
public class Main {

    public static void main(String[] args) {

        InstagramPost instagram = new InstagramPost();
        instagram.createPost();
        instagram.editPost();
        instagram.deletePost();

        ReadOnlyPost readOnly = new ReadOnlyPost();
        readOnly.createPost();
    }
}
```

---

## 4.3.3 Hasil Output

[hasil dengan LSP](gambar/dgn_lsp_2.png)

---

## 4.3.4 Analisa

Pada versi refactoring, fitur posting dipisahkan menggunakan interface sesuai kebutuhan masing-masing class.

`InstagramPost` dapat melakukan create, edit, dan delete sehingga mengimplementasikan seluruh interface yang dibutuhkan. Sedangkan `ReadOnlyPost` hanya mengimplementasikan fitur create karena memang tidak mendukung edit dan delete.

Dengan cara ini, setiap class hanya memiliki perilaku yang sesuai dengan kemampuannya. Program menjadi lebih stabil dan tidak lagi menghasilkan exception saat dijalankan.

Selain itu, struktur kode juga menjadi lebih fleksibel dan mudah dikembangkan untuk penambahan jenis posting baru di masa depan.

---

# 4.4 Latihan


## PENJELASAN KONSEP & ANALISIS ARSITEKTUR

Latihan kode ini berfokus pada penyusunan struktur kelas yang baik menggunakan kombinasi konsep **Inheritance (Pewarisan)** dan **Interface**. Desain ini dirancang untuk mengatasi salah satu masalah klasik dalam pengembangan perangkat lunak, yaitu memaksakan suatu perilaku (*behavior*) kepada kelas anak (*subclass*) yang sebenarnya tidak memiliki kemampuan tersebut.

### A. Polimorfisme pada Kelas `Vehicle`
Kelas `Vehicle` bertindak sebagai *parent class* (kelas induk) yang menyediakan kontrak dasar berupa kemampuan navigasi melalui fungsi `MapsTo(String destination)`. 
* Baik mobil (`Car`) maupun sepeda (`Bicycle`) merupakan kendaraan, sehingga keduanya mewarisi kelas `Vehicle`.
* Karena rute sepeda dan rute mobil di dunia nyata sangat berbeda, masing-masing kelas anak melakukan `@Override` pada fungsi tersebut untuk menentukan logika pencarian rute yang spesifik bagi mereka sendiri.

### B. Penerapan Interface Segregation melalui `Motorized`
Tidak semua kendaraan di dunia ini memiliki mesin. Jika fungsi `startEngine()` ditaruh langsung di dalam kelas induk (`Vehicle`), maka kelas `Bicycle` akan dipaksa untuk mengimplementasikan fungsi tersebut. Hal ini akan merusak logika pemrograman dan melanggar prinsip desain SOLID (khususnya *Interface Segregation Principle*).

Solusi yang diterapkan sudah sangat tepat dengan memisahkan kemampuan bermesin ke dalam sebuah *Interface* mandiri bernama `Motorized`:
* Kelas `Car` mengimplementasikan `Motorized` karena mobil memiliki mesin.
* Kelas `Bicycle` cukup mewarisi `Vehicle` tanpa menyentuh `Motorized` karena sepeda murni menggunakan tenaga manusia.

### C. Pengecekan Objek secara Aman dengan `instanceof`
Pada kelas `Main`, tepatnya di dalam fungsi `beginTrip()`, terdapat mekanisme deteksi tipe objek yang sangat krusial:


```java
if (vehicle instanceof Motorized) {
    ((Motorized) vehicle).startEngine();
}

```

Penggunaan operator `instanceof` memastikan bahwa program hanya akan melakukan *type casting* dan menyalakan mesin jika objek kendaraan yang dilewati memang merupakan implementasi dari `Motorized`.

Ketika objek `Bicycle` dimasukkan ke fungsi ini, kondisi `if` akan menghasilkan nilai `false`. Blok kode penyalaan mesin akan dilewati secara otomatis, sehingga program **berjalan dengan aman tanpa memicu `ClassCastException**` (error saat aplikasi berjalan).

---

## PENULISAN ULANG KODE SUMBER (SOURCE CODE)

Berikut adalah seluruh kode program yang digabungkan ke dalam satu kesatuan struktur proyek:

### A. Kelas Induk (`Vehicle.java`)

```java
package praktikum_6.latihan;

public class Vehicle {
    public void navigateTo(String destination) {
        System.out.println("Calculating route to " + destination);
        System.out.println("Following route to " + destination);
    }
}

```

### B. Interface Karakteristik (`Motorized.java`)

```java
package praktikum_6.latihan;

public interface Motorized {
    void startEngine();
}

```

### C. Kelas Anak: Mobil (`Car.java`)

```java
package praktikum_6.latihan;

public class Car extends Vehicle implements Motorized {
    @Override
    public void startEngine() {
        System.out.println("Car starts engine");
    }

    @Override
    public void navigateTo(String destination) {
        System.out.println("Calculating Car route to " + destination);
    }
}

```

### D. Kelas Anak: Sepeda (`Bicycle.java`)

```java
package praktikum_6.latihan;

public class Bicycle extends Vehicle {
    @Override
    public void navigateTo(String destination) {
        System.out.println("Calculating BIKE route to " + destination);
        // Bikes have different route calculation logic
    }
}

```

### E. Kelas Utama (`Main.java`)

```java
package praktikum_6.latihan;

public class Main {
    public static void beginTrip(Vehicle vehicle, String destination) {
        // Jika kendaraan memiliki mesin, hidupkan mesinnya terlebih dahulu secara aman
        if (vehicle instanceof Motorized) {
            ((Motorized) vehicle).startEngine();
        }
        vehicle.navigateTo(destination);
    }

    public static void main(String[] args) {
        Vehicle car = new Car();
        Vehicle bike = new Bicycle();

        System.out.println("Car trip:");
        beginTrip(car, "Central Park");

        System.out.println("\\nBike trip:");
        beginTrip(bike, "Central Park"); // Berjalan aman tanpa memicu exception mesin
    }
}

```

---

## HASIL OUTPUT EKSEKUSI PROGRAM

![hasil latihan](gambar/latihan.png)

---

## KESIMPULAN

Latihan yang telah kamu kerjakan ini menunjukkan contoh penulisan kode yang **bersih (*clean code*) dan aman dari bug**. Dengan memanfaatkan kombinasi *Inheritance*, *Interface*, serta pengecekan tipe menggunakan `instanceof`, struktur program ini menjadi sangat fleksibel. Jika di kemudian hari kamu ingin menambahkan jenis kendaraan baru seperti `ElectricScooter` atau `Skateboard`, kamu cukup menyesuaikan implementasi *interface*-nya tanpa perlu mengubah logika utama pada fungsi `beginTrip()`.

# 5. Kesimpulan

Berdasarkan praktikum yang telah dilakukan, dapat disimpulkan bahwa Liskov Substitution Principle (LSP) merupakan prinsip penting dalam desain perangkat lunak berbasis OOP.

Prinsip ini menekankan bahwa subclass harus dapat menggantikan superclass tanpa menyebabkan perubahan perilaku pada program. Jika prinsip ini dilanggar, maka program dapat menghasilkan output yang tidak sesuai harapan bahkan menyebabkan runtime error.

Melalui studi kasus `Rectangle-Square` dan `Sistem Posting Media Sosial`, dapat dipahami bahwa penggunaan inheritance harus dilakukan dengan tepat. Penggunaan inheritance yang salah dapat menyebabkan program menjadi tidak stabil dan sulit dikembangkan.

Dengan menerapkan LSP, program menjadi lebih fleksibel, mudah dipelihara, stabil, dan lebih aman untuk dikembangkan di masa depan.

---

# 6. Referensi

1. Modul Praktikum Design Pattern – Politeknik Negeri Lhokseumawe.
2. Martin, R. C. (2003). *Agile Software Development: Principles, Patterns, and Practices*.
3. Martin, R. C. (2008). *Clean Code*.
4. Sommerville, I. (2016). *Software Engineering*.
5. Oracle. (2023). *Java Documentation*.

# LAPORAN PRAKTIKUM DESIGN PATTERN

## MODUL 9 – STRATEGY PATTERN

**Nama :** Nasywa Nurshabira
**NIM :** 2024573010076
**Kelas :** TI 2A

---

# 1. Abstrak

Pada praktikum ini dipelajari salah satu design pattern dalam pemrograman berorientasi objek yaitu Strategy Pattern. Pattern ini digunakan untuk memisahkan algoritma ke dalam class yang berbeda sehingga algoritma dapat diganti secara fleksibel tanpa mengubah kode utama program.

Praktikum dilakukan menggunakan beberapa studi kasus seperti program navigasi sederhana, filter foto, sistem notifikasi, dan sistem pembayaran e-commerce. Setiap studi kasus menerapkan konsep Strategy Pattern dengan memanfaatkan interface sebagai strategy dan class lain sebagai implementasi strategi.

Melalui praktikum ini dapat dipahami bahwa Strategy Pattern membantu membuat program menjadi lebih modular, fleksibel, mudah dipelihara, dan lebih mudah dikembangkan ketika terdapat penambahan fitur baru.

---

# 2. Latar Belakang

Dalam pengembangan perangkat lunak, sering ditemukan kasus di mana sebuah program memiliki beberapa algoritma atau metode berbeda untuk menyelesaikan suatu proses. Jika seluruh algoritma tersebut ditulis langsung di dalam satu class menggunakan banyak percabangan seperti if-else atau switch, maka kode program akan menjadi sulit dipahami dan sulit dikembangkan.

Salah satu solusi untuk mengatasi masalah tersebut adalah menggunakan Strategy Pattern. Strategy Pattern merupakan salah satu behavioral design pattern yang memungkinkan algoritma dipisahkan ke dalam class yang berbeda. Dengan cara ini, algoritma dapat dipilih dan diganti saat program berjalan tanpa harus mengubah kode utama.

Penggunaan Strategy Pattern sangat membantu dalam meningkatkan fleksibilitas program. Selain itu, pattern ini juga mendukung prinsip Open/Closed Principle karena penambahan strategi baru dapat dilakukan tanpa mengubah class yang sudah ada.

Melalui praktikum ini mahasiswa mempelajari bagaimana cara mengimplementasikan Strategy Pattern menggunakan bahasa Java serta memahami manfaat penggunaannya dalam pengembangan aplikasi.

---

# 3. Tujuan Praktikum

1. Memahami konsep Strategy Pattern.
2. Mengimplementasikan Strategy Pattern menggunakan Java.
3. Memahami manfaat penggunaan Strategy Pattern dalam pengembangan perangkat lunak.
4. Membuat program yang fleksibel dan mudah dikembangkan.

---

# 4. Praktikum

# 4.1 Praktikum 1 – Program Navigasi Sederhana

## 4.1.1 Langkah Praktikum

1. Membuat package `modul_9`.
2. Membuat package `praktikum_1`.
3. Membuat interface `RouteStrategy`.
4. Membuat class `WalkingRoute`.
5. Membuat class `DrivingRoute`.
6. Membuat class `PublicTransportRoute`.
7. Membuat class `Navigator`.
8. Membuat class `Main`.
9. Menjalankan program dan mengamati hasil output.

---

## 4.1.2 Kode Program

### Interface RouteStrategy

```java
public interface RouteStrategy {
    void buildRoute(String from, String to);
}
```

---

### Class WalkingRoute

```java
public class WalkingRoute implements RouteStrategy {

    @Override
    public void buildRoute(String from, String to) {
        System.out.println("Rute jalan kaki dari " + from + " ke " + to);
    }
}
```

---

### Class DrivingRoute

```java
public class DrivingRoute implements RouteStrategy {

    @Override
    public void buildRoute(String from, String to) {
        System.out.println("Rute berkendara dari " + from + " ke " + to);
    }
}
```

---

### Class PublicTransportRoute

```java
public class PublicTransportRoute implements RouteStrategy {

    @Override
    public void buildRoute(String from, String to) {
        System.out.println("Rute transportasi umum dari " + from + " ke " + to);
    }
}
```

---

### Class Navigator

```java
public class Navigator {

    private RouteStrategy strategy;

    public Navigator(RouteStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(RouteStrategy strategy) {
        this.strategy = strategy;
    }

    public void navigate(String from, String to) {
        strategy.buildRoute(from, to);
    }
}
```

---

### Class Main

```java
public class Main {

    public static void main(String[] args) {

        Navigator navigator = new Navigator(new WalkingRoute());

        navigator.navigate("Rumah", "Kampus");

        navigator.setStrategy(new DrivingRoute());
        navigator.navigate("Rumah", "Mall");

        navigator.setStrategy(new PublicTransportRoute());
        navigator.navigate("Terminal", "Bandara");
    }
}
```

---

## 4.1.3 Hasil Output

![hasil praktikum 1](gambar_laprak_7/hasil_1.png)

---

## 4.1.4 Analisa

Pada praktikum ini digunakan Strategy Pattern untuk menentukan jenis rute navigasi yang digunakan pengguna.

Setiap metode navigasi dipisahkan ke dalam class yang berbeda, yaitu `WalkingRoute`, `DrivingRoute`, dan `PublicTransportRoute`. Semua class tersebut mengimplementasikan interface `RouteStrategy`.

Class `Navigator` bertindak sebagai context class yang menggunakan strategy tertentu sesuai kebutuhan pengguna. Dengan cara ini, jenis rute dapat diganti tanpa perlu mengubah kode utama program.

Penerapan Strategy Pattern membuat program menjadi lebih fleksibel dan mudah dikembangkan. Jika suatu saat ingin menambahkan strategi baru seperti rute sepeda atau rute tercepat, programmer hanya perlu membuat class baru tanpa mengubah class `Navigator`.

---

# 4.2 Praktikum 2 – Program Filter Foto Sederhana

## 4.2.1 Langkah Praktikum

1. Membuat package `praktikum_2`.
2. Membuat interface `FilterStrategy`.
3. Membuat class `BlackWhiteFilter`.
4. Membuat class `SepiaFilter`.
5. Membuat class `BrightFilter`.
6. Membuat class `PhotoEditor`.
7. Membuat class `Main`.
8. Menjalankan program dan mengamati hasil output.

---

## 4.2.2 Kode Program

### Interface FilterStrategy

```java
public interface FilterStrategy {
    void applyFilter(String photo);
}
```

---

### Class BlackWhiteFilter

```java
public class BlackWhiteFilter implements FilterStrategy {

    @Override
    public void applyFilter(String photo) {
        System.out.println("Filter hitam putih diterapkan pada " + photo);
    }
}
```

---

### Class SepiaFilter

```java
public class SepiaFilter implements FilterStrategy {

    @Override
    public void applyFilter(String photo) {
        System.out.println("Filter sepia diterapkan pada " + photo);
    }
}
```

---

### Class BrightFilter

```java
public class BrightFilter implements FilterStrategy {

    @Override
    public void applyFilter(String photo) {
        System.out.println("Filter cerah diterapkan pada " + photo);
    }
}
```

---

### Class PhotoEditor

```java
public class PhotoEditor {

    private FilterStrategy strategy;

    public PhotoEditor(FilterStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(FilterStrategy strategy) {
        this.strategy = strategy;
    }

    public void editPhoto(String photo) {
        strategy.applyFilter(photo);
    }
}
```

---

### Class Main

```java
public class Main {

    public static void main(String[] args) {

        PhotoEditor editor =
                new PhotoEditor(new BlackWhiteFilter());

        editor.editPhoto("foto1.jpg");

        editor.setStrategy(new SepiaFilter());
        editor.editPhoto("foto2.jpg");

        editor.setStrategy(new BrightFilter());
        editor.editPhoto("foto3.jpg");
    }
}
```

---

## 4.2.3 Hasil Output

<br><br><br><br><br><br>

---

## 4.2.4 Analisa

Pada praktikum ini Strategy Pattern digunakan untuk menangani berbagai jenis filter foto.

Setiap filter dipisahkan ke dalam class tersendiri sehingga program menjadi lebih modular dan mudah dipelihara. `PhotoEditor` hanya bertugas menggunakan filter yang dipilih tanpa mengetahui detail proses filter tersebut.

Dengan penggunaan Strategy Pattern, penambahan filter baru dapat dilakukan tanpa mengubah struktur utama program. Hal ini membuat kode lebih fleksibel dan sesuai dengan prinsip Open/Closed Principle.

---

# 4.3 Praktikum 3 – Program Notifikasi

## 4.3.1 Langkah Praktikum

1. Membuat package `praktikum_3`.
2. Membuat interface `NotificationStrategy`.
3. Membuat class `EmailNotification`.
4. Membuat class `SMSNotification`.
5. Membuat class `PushNotification`.
6. Membuat class `NotificationService`.
7. Membuat class `Main`.
8. Menjalankan program dan mengamati hasil output.

---

## 4.3.2 Kode Program

### Interface NotificationStrategy

```java
public interface NotificationStrategy {

    void sendNotification(String message);
}
```

---

### Class EmailNotification

```java
public class EmailNotification implements NotificationStrategy {

    @Override
    public void sendNotification(String message) {
        System.out.println("Mengirim Email: " + message);
    }
}
```

---

### Class SMSNotification

```java
public class SMSNotification implements NotificationStrategy {

    @Override
    public void sendNotification(String message) {
        System.out.println("Mengirim SMS: " + message);
    }
}
```

---

### Class PushNotification

```java
public class PushNotification implements NotificationStrategy {

    @Override
    public void sendNotification(String message) {
        System.out.println("Mengirim Push Notification: " + message);
    }
}
```

---

### Class NotificationService

```java
public class NotificationService {

    private NotificationStrategy strategy;

    public NotificationService(NotificationStrategy strategy) {
        this.strategy = strategy;
    }

    public void send(String message) {
        strategy.sendNotification(message);
    }
}
```

---

### Class Main

```java
public class Main {

    public static void main(String[] args) {

        NotificationService email =
                new NotificationService(new EmailNotification());

        NotificationService sms =
                new NotificationService(new SMSNotification());

        NotificationService push =
                new NotificationService(new PushNotification());

        email.send("Halo pengguna!");
        sms.send("Kode OTP Anda");
        push.send("Ada pesan baru");
    }
}
```

---

## 4.3.3 Hasil Output

![hasil praktikum 2](gambar_laprak_7/hasil_2.png)

---

## 4.3.4 Analisa

Pada praktikum ini digunakan Strategy Pattern untuk menangani berbagai metode pengiriman notifikasi.

Setiap metode notifikasi dipisahkan ke dalam class tersendiri sehingga sistem menjadi lebih fleksibel. `NotificationService` hanya menggunakan strategy yang dipilih tanpa mengetahui detail implementasi notifikasi tersebut.

Penerapan Strategy Pattern membuat penambahan metode notifikasi baru menjadi lebih mudah. Programmer cukup membuat class baru tanpa mengubah class yang sudah ada.

---

# 4.4 Latihan – Program Pembayaran E-Commerce

## 4.4.1 Langkah Praktikum

1. Membuat package `latihan`.
2. Membuat interface `PaymentStrategy`.
3. Membuat class `CreditCardPayment`.
4. Membuat class `EWalletPayment`.
5. Membuat class `BankTransferPayment`.
6. Membuat class `Checkout`.
7. Membuat class `Main`.
8. Menjalankan program dan mengamati hasil output.
9. Menjawab tugas analisis pada file `jawaban.md`.

---

## 4.4.2 Kode Program

### Interface PaymentStrategy

```java
public interface PaymentStrategy {

    void pay(double amount);
}
```

---

### Class CreditCardPayment

```java
public class CreditCardPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("Pembayaran dengan kartu kredit sebesar Rp" + amount);
    }
}
```

---

### Class EWalletPayment

```java
public class EWalletPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("Pembayaran dengan E-Wallet sebesar Rp" + amount);
    }
}
```

---

### Class BankTransferPayment

```java
public class BankTransferPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("Pembayaran dengan transfer bank sebesar Rp" + amount);
    }
}
```

---

### Class Checkout

```java
public class Checkout {

    private PaymentStrategy strategy;

    public Checkout(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void processPayment(double amount) {
        strategy.pay(amount);
    }
}
```

---

### Class Main

```java
public class Main {

    public static void main(String[] args) {

        Checkout creditCard =
                new Checkout(new CreditCardPayment());

        Checkout ewallet =
                new Checkout(new EWalletPayment());

        Checkout transfer =
                new Checkout(new BankTransferPayment());

        creditCard.processPayment(500000);
        ewallet.processPayment(250000);
        transfer.processPayment(1000000);
    }
}
```

---

## 4.4.3 Hasil Output

![hasil praktikum 3](gambar_laprak_7/hasil_3.png)

---

## 4.4.4 Analisa

Pada latihan ini Strategy Pattern digunakan untuk menangani berbagai metode pembayaran dalam sistem e-commerce.

Setiap metode pembayaran dipisahkan ke dalam class yang berbeda sehingga program menjadi lebih fleksibel dan mudah dikembangkan. `Checkout` hanya menggunakan strategy pembayaran tanpa mengetahui detail proses pembayaran tersebut.

Jika suatu saat ingin menambahkan metode pembayaran baru seperti QRIS, programmer hanya perlu membuat class baru yang mengimplementasikan `PaymentStrategy` tanpa mengubah class `Checkout`.

Hal ini membuat program lebih mudah dipelihara dan mengurangi risiko error pada kode yang sudah ada.

---

# Latihan – Sistem Pembayaran E-Commerce

## Langkah Praktikum

1. Membuat package `praktikum_7.latihan`.
2. Membuat interface `PaymentStrategy`.
3. Membuat class `CreditCardPayment`.
4. Membuat class `EWalletPayment`.
5. Membuat class `BankTransferPayment`.
6. Membuat class `Checkout`.
7. Membuat class `Main`.
8. Menjalankan program menggunakan IntelliJ IDEA.
9. Mengamati hasil output dari setiap metode pembayaran.
10. Menganalisis penerapan Strategy Pattern pada sistem pembayaran e-commerce.

---

## Kode Program

### Interface PaymentStrategy

```java
package praktikum_7.latihan;

public interface PaymentStrategy {
    void pay(double amount);
}
```

---

### Class CreditCardPayment

```java
package praktikum_7.latihan;

public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolderName;
    private String cvv;

    public CreditCardPayment(String cardNumber, String cardHolderName, String cvv) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.cvv = cvv;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Pembayaran via Kartu Kredit sebesar Rp" + amount);
        System.out.println("Nomor Kartu: " + cardNumber.substring(cardNumber.length() - 4));
        System.out.println("Pemilik: " + cardHolderName);
        System.out.println("Status: Pembayaran BERHASIL!");
        System.out.println("------------------------------");
    }
}
```

---

### Class EWalletPayment

```java
package praktikum_7.latihan;

public class EWalletPayment implements PaymentStrategy {
    private String phoneNumber;
    private String provider;

    public EWalletPayment(String phoneNumber, String provider) {
        this.phoneNumber = phoneNumber;
        this.provider = provider;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Pembayaran via E-Wallet (" + provider + ") sebesar Rp" + amount);
        System.out.println("Nomor HP: " + phoneNumber);
        System.out.println("Status: Pembayaran BERHASIL!");
        System.out.println("------------------------------");
    }
}
```

---

### Class BankTransferPayment

```java
package praktikum_7.latihan;

public class BankTransferPayment implements PaymentStrategy {
    private String bankName;
    private String accountNumber;
    private String accountName;

    public BankTransferPayment(String bankName, String accountNumber, String accountName) {
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.accountName = accountName;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Pembayaran via Transfer Bank sebesar Rp" + amount);
        System.out.println("Bank: " + bankName);
        System.out.println("Nomor Rekening: " + accountNumber);
        System.out.println("Atas Nama: " + accountName);
        System.out.println("Status: Pembayaran BERHASIL!");
        System.out.println("------------------------------");
    }
}
```

---

### Class Checkout

```java
package praktikum_7.latihan;

public class Checkout {
    private PaymentStrategy paymentStrategy;

    public Checkout() {}

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment(double amount) {
        if (paymentStrategy == null) {
            System.out.println("Error: Belum memilih metode pembayaran!");
            return;
        }
        paymentStrategy.pay(amount);
    }
}
```

---

### Class Main

```java
package praktikum_7.latihan;

public class Main {
    public static void main(String[] args) {
        Checkout checkout = new Checkout();

        System.out.println("========== E-COMMERCE CHECKOUT SYSTEM ==========\n");

        // Contoh 1: Pembayaran dengan Kartu Kredit
        System.out.println("1. Pembayaran dengan Kartu Kredit:");
        checkout.setPaymentStrategy(new CreditCardPayment(
                "1234-5678-9012-3456",
                "Budi Santoso",
                "123"));

        checkout.processPayment(250000);

        // Contoh 2: Pembayaran dengan E-Wallet
        System.out.println("2. Pembayaran dengan E-Wallet:");
        checkout.setPaymentStrategy(new EWalletPayment(
                "081234567890",
                "GoPay"));

        checkout.processPayment(75000);

        // Contoh 3: Pembayaran dengan Transfer Bank
        System.out.println("3. Pembayaran dengan Transfer Bank:");
        checkout.setPaymentStrategy(new BankTransferPayment(
                "BCA",
                "1234567890",
                "Budi Santoso"));

        checkout.processPayment(500000);
    }
}
```

---

## Hasil Output

![hasil latihan](gambar_laprak_7/latihan_7.png)

---

## Analisa

Pada latihan ini digunakan Strategy Pattern untuk menangani berbagai metode pembayaran pada sistem e-commerce. Setiap metode pembayaran dipisahkan ke dalam class yang berbeda agar program menjadi lebih fleksibel dan mudah dikembangkan.

Interface `PaymentStrategy` digunakan sebagai strategy utama yang berisi method `pay()`. Seluruh metode pembayaran seperti `CreditCardPayment`, `EWalletPayment`, dan `BankTransferPayment` mengimplementasikan interface tersebut sehingga memiliki struktur method yang sama.

Class `Checkout` bertindak sebagai context class yang bertugas memilih dan menjalankan metode pembayaran tertentu sesuai kebutuhan pengguna. Dengan penggunaan method `setPaymentStrategy()`, sistem dapat mengganti metode pembayaran secara dinamis saat program berjalan.

Pada pembayaran kartu kredit, program menampilkan informasi nomor kartu, nama pemilik kartu, serta status pembayaran berhasil. Nomor kartu hanya menampilkan empat digit terakhir untuk menjaga keamanan data pengguna.

Pada pembayaran E-Wallet, program menampilkan provider dompet digital yang digunakan serta nomor telepon pengguna. Sedangkan pada pembayaran transfer bank, program menampilkan nama bank, nomor rekening, dan nama pemilik rekening.

Penerapan Strategy Pattern pada program ini membuat struktur kode menjadi lebih rapi karena setiap metode pembayaran memiliki class tersendiri. Selain itu, penambahan metode pembayaran baru seperti QRIS atau Virtual Account dapat dilakukan tanpa mengubah class `Checkout`.

Program juga menjadi lebih mudah dipelihara karena setiap perubahan pada metode pembayaran cukup dilakukan pada class terkait tanpa mempengaruhi class lainnya.

---

## Jawaban Analisis Latihan

### 1. Mengapa Strategy Pattern cocok digunakan pada sistem pembayaran e-commerce?

Strategy Pattern cocok digunakan karena sistem pembayaran biasanya memiliki banyak metode pembayaran dengan proses yang berbeda-beda. Dengan memisahkan setiap metode pembayaran ke dalam class tersendiri, program menjadi lebih fleksibel dan mudah dikembangkan.

---

### 2. Apa keuntungan penggunaan interface `PaymentStrategy`?

Penggunaan interface `PaymentStrategy` membuat seluruh metode pembayaran memiliki struktur method yang sama sehingga dapat digunakan secara bergantian tanpa mengubah kode utama program.

---

### 3. Mengapa class `Checkout` disebut context class?

Karena class `Checkout` bertugas menggunakan strategy tertentu yang dipilih pengguna dan menjalankan proses pembayaran berdasarkan strategy tersebut.

---

### 4. Apa manfaat utama penggunaan Strategy Pattern pada program ini?

Manfaat utamanya adalah:

* Program lebih fleksibel.
* Kode lebih rapi dan modular.
* Penambahan metode pembayaran baru lebih mudah.
* Mengurangi penggunaan percabangan berlebihan.
* Program lebih mudah dipelihara dan dikembangkan.
---

# 5. Kesimpulan

Berdasarkan praktikum yang telah dilakukan, dapat disimpulkan bahwa Strategy Pattern merupakan salah satu design pattern yang sangat berguna dalam pengembangan perangkat lunak.

Dengan memisahkan algoritma ke dalam class tersendiri, program menjadi lebih fleksibel, modular, dan mudah dikembangkan. Selain itu, penambahan fitur baru dapat dilakukan tanpa mengubah struktur utama program.

Penerapan Strategy Pattern juga membantu mengurangi penggunaan percabangan yang berlebihan sehingga kode menjadi lebih rapi dan mudah dipahami.

---

# 6. Referensi

1. Modul Praktikum Design Pattern – Politeknik Negeri Lhokseumawe.
2. Gamma, E., Helm, R., Johnson, R., & Vlissides, J. (1994). *Design Patterns: Elements of Reusable Object-Oriented Software*.
3. Martin, R. C. (2008). *Clean Code*.
4. Oracle Java Documentation.

