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
