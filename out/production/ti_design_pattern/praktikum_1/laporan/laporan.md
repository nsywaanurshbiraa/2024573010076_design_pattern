# Laporan Modul 1: Review Dasar Pemrograman Java

**Mata Kuliah:** Praktikum Design Pattern\
**Nama:** Nasywa Nurshabira\
**NIM:** 2024573010076\
**Kelas:** TI 2A

------------------------------------------------------------------------

# 1. Abstrak

Praktikum ini bertujuan untuk memahami dasar-dasar pemrograman
menggunakan bahasa Java. Mahasiswa mempelajari konsep dasar seperti
sintaks Java, variabel, tipe data, operator, percabangan, dan
perulangan.

Melalui praktikum ini mahasiswa membuat beberapa program sederhana
seperti program Hello World, penggunaan variabel, operasi aritmatika,
percabangan genap ganjil, perulangan bilangan, serta program latihan
seperti faktorial, bilangan prima, dan pola segitiga.

Pemahaman konsep dasar ini menjadi pondasi penting untuk mempelajari
konsep pemrograman yang lebih kompleks pada modul selanjutnya.

**Kata kunci:** Java, variabel, operator, percabangan, perulangan.

------------------------------------------------------------------------

# 2. Praktikum

## Pengenalan Java

Java adalah bahasa pemrograman berorientasi objek yang banyak digunakan
untuk pengembangan aplikasi desktop, web, dan mobile.

Untuk menjalankan program Java diperlukan:

-   **JDK (Java Development Kit)** -- untuk compile dan menjalankan
    program.
-   **IDE** seperti IntelliJ IDEA untuk menulis dan menjalankan kode.

------------------------------------------------------------------------

# Program Hello World

``` java
package modul_1;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
```
![HelloWorld](gambar/HelloWorld.png)
------------------------------------------------------------------------

# Variabel dan Tipe Data

Tipe Data   Fungsi
  ----------- ------------------
int         bilangan bulat
double      bilangan desimal
boolean     true / false
char        karakter
String      teks

``` java
package modul_1;

public class Variable {
    public static void main(String[] args) {

        String nama = "Nasywa";
        int umur = 19;
        double tinggi = 160.5;

        System.out.println("Nama: " + nama);
        System.out.println("Umur: " + umur);
        System.out.println("Tinggi: " + tinggi);
    }
}
```
![VariabelDanTipedata](gambar/Variabel.png)
------------------------------------------------------------------------

# Operator

``` java
public class Operator {

    public static void main(String[] args) {

        int a = 10;
        int b = 5;

        System.out.println("Tambah: " + (a + b));
        System.out.println("Kurang: " + (a - b));
        System.out.println("Kali: " + (a * b));
        System.out.println("Bagi: " + (a / b));
    }
}
```
![operator](gambar/Operator.png)
------------------------------------------------------------------------

# Percabangan

``` java
public class GenapGanjil {

    public static void main(String[] args) {

        int angka = 7;

        if (angka % 2 == 0) {
            System.out.println("Bilangan Genap");
        } else {
            System.out.println("Bilangan Ganjil");
        }
    }
}
```
![Percabangan](gambar/Percabangan.png)
------------------------------------------------------------------------

# Perulangan

``` java
public class Perulangan {

    public static void main(String[] args) {

        for (int i = 1; i <= 20; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }

    }
}
```
![Perulangan](gambar/Perulangan.png)
------------------------------------------------------------------------

# Program Faktorial

``` java
public class Factorial {

    public static void main(String[] args) {

        int angka = 5;
        int hasil = 1;

        for (int i = 1; i <= angka; i++) {
            hasil *= i;
        }

        System.out.println("Faktorial: " + hasil);
    }
}
```
![Factorial](gambar/Factorial.png)
------------------------------------------------------------------------

# Program Bilangan Prima

``` java
public class Prima {

    public static void main(String[] args) {

        int angka = 7;
        boolean prima = true;

        for (int i = 2; i < angka; i++) {
            if (angka % i == 0) {
                prima = false;
                break;
            }
        }

        if (prima) {
            System.out.println("Bilangan Prima");
        } else {
            System.out.println("Bukan Bilangan Prima");
        }
    }
}
```
![Prima](gambar/Prima.png)
------------------------------------------------------------------------

# Program Segitiga

``` java
public class Segitiga {

    public static void main(String[] args) {

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
```

Output:

    *
    **
    ***
    ****
    *****
![Segitiga](gambar/Segitiga.png)
------------------------------------------------------------------------

# 3. Kesimpulan

1.  Java memiliki struktur dasar berupa class dan method.
2.  Variabel digunakan untuk menyimpan data dengan tipe tertentu.
3.  Operator digunakan untuk melakukan operasi matematika dan logika.
4.  Percabangan digunakan untuk pengambilan keputusan.
5.  Perulangan digunakan untuk menjalankan kode secara berulang.

------------------------------------------------------------------------

# 4. Referensi

1.  Oracle Java Documentation
2.  https://www.w3schools.com/java/
3.  Modul Praktikum Design Pattern -- Politeknik Negeri Lhokseumawe
