# LAPORAN PRAKTIKUM DESIGN PATTERN

## OPEN-CLOSED PRINCIPLE (OCP) – MODUL 5

**Nama:** Nasywa Nurshabira  
**NIM:** 2024573010076  
**Kelas:** TI 2A
**Mata Kuliah:** Design Pattern

---

# DAFTAR ISI

1. Pendahuluan
2. Dasar Teori
3. Analisis Permasalahan
4. Solusi dan Implementasi
5. Hasil dan Pembahasan
6. Kesimpulan
7. Daftar Pustaka

---

# 1. PENDAHULUAN

Pada praktikum kali ini, dibahas salah satu prinsip dalam SOLID yaitu Open-Closed Principle (OCP). Prinsip ini sangat penting dalam pengembangan perangkat lunak karena berkaitan dengan bagaimana sebuah sistem dapat dikembangkan tanpa harus mengubah kode yang sudah ada.

Dalam latihan yang diberikan, terdapat sebuah program sederhana untuk menghitung pajak kendaraan. Namun, program tersebut belum mengikuti prinsip OCP karena masih menggunakan percabangan (if-else) untuk menentukan jenis kendaraan. Hal ini menyebabkan program sulit dikembangkan ketika ada penambahan jenis kendaraan baru.

Oleh karena itu, dilakukan analisis dan refactoring kode agar sesuai dengan prinsip OCP.

---

# 2. DASAR TEORI

SOLID merupakan kumpulan lima prinsip dasar dalam pemrograman berorientasi objek yang bertujuan untuk menghasilkan kode yang lebih terstruktur, mudah dipahami, dan mudah dikembangkan. Salah satu prinsip tersebut adalah Open-Closed Principle (OCP).

Menurut , Open-Closed Principle menyatakan bahwa:

> "Sebuah entitas perangkat lunak harus terbuka untuk perluasan tetapi tertutup untuk modifikasi."

Artinya, sebuah class atau modul sebaiknya tidak diubah ketika ada kebutuhan baru, tetapi cukup diperluas dengan menambahkan kode baru.

Prinsip ini pertama kali diperkenalkan oleh Bertrand Meyer dan kemudian dipopulerkan oleh Robert C. Martin dalam konsep SOLID.

Dalam implementasinya, OCP biasanya menggunakan beberapa pendekatan seperti:

* Interface atau abstract class
* Polimorfisme
* Strategy pattern

Contoh sederhana pelanggaran OCP adalah penggunaan banyak if-else untuk menentukan perilaku program. Jika ada penambahan fitur baru, maka kode lama harus diubah, yang berpotensi menimbulkan bug.

Dengan menerapkan OCP, kita bisa:

* Mengurangi risiko kesalahan saat perubahan kode
* Membuat sistem lebih fleksibel
* Mempermudah pengembangan fitur baru
* Meningkatkan kualitas desain program

---

# # 3. LANGKAH PRAKTIKUM

## 3.1 Praktikum 1 – Sistem Pembayaran

### A. Tanpa OCP

1. Membuat package:

   ```
   modul_5.praktikum_1.tanpa_ocp
   ```
2. Membuat class `PaymentProcessor`
3. Membuat class `Main`
4. Menjalankan program
5. Mengamati bahwa metode pembayaran menggunakan **if-else**

### Analisa:

* Program masih bergantung pada String ("CreditCard", "EWallet")
* Jika ingin tambah metode baru → harus ubah class PaymentProcessor

---

### B. Dengan OCP

1. Membuat package:

   ```
   modul_5.praktikum_1.dengan_ocp
   ```
2. Membuat interface:

    * `PaymentMethod`
3. Membuat class implementasi:

    * `CreditCardPayment`
    * `EWalletPayment`
4. Memodifikasi `PaymentProcessor` agar menerima object `PaymentMethod`
5. Membuat class `Main`
6. Menjalankan program

### Hasil:

* Tidak perlu ubah PaymentProcessor saat tambah metode baru
* Tinggal buat class baru

---

## 3.2 Praktikum 2 – Sistem Diskon

### A. Tanpa OCP

1. Membuat package:

   ```
   modul_5.praktikum_2.tanpa_ocp
   ```
2. Membuat class `DiscountCalculator`
3. Membuat class `Main`
4. Menjalankan program

### Analisa:

* Menggunakan if-else berdasarkan tipe customer
* Sulit dikembangkan

---

### B. Dengan OCP

1. Membuat package:

   ```
   modul_5.praktikum_2.dengan_ocp
   ```
2. Membuat interface:

    * `Discount`
3. Membuat class:

    * `RegularDiscount`
    * `PremiumDiscount`
4. Mengubah `DiscountCalculator` agar menerima object `Discount`
5. Membuat class `Main`
6. Menjalankan program

### Hasil:

* Bisa tambah diskon baru tanpa ubah kode lama

---

## 3.3 Praktikum 3 – Sistem Notifikasi

### A. Tanpa OCP

1. Membuat package:

   ```
   modul_5.praktikum_3.tanpa_ocp
   ```
2. Membuat class `NotificationService`
3. Membuat class `Main`
4. Menjalankan program

### Analisa:

* Menggunakan if-else (Email / SMS)
* Tidak fleksibel

---

### B. Dengan OCP

1. Membuat package:

   ```
   modul_5.praktikum_3.dengan_ocp
   ```
2. Membuat interface:

    * `Notifier`
3. Membuat class:

    * `EmailNotifier`
    * `SMSNotifier`
4. Mengubah `NotificationService`
5. Membuat class `Main`
6. Menjalankan program

### Hasil:

* Tambah notifikasi baru tanpa ubah service

---

## 3.4 Latihan – Sistem Pengelolaan Pajak

### Langkah:

1. Membuat package:

   ```
   modul_5.latihan
   ```
2. Membuat interface:

    * `TaxStrategy`
3. Membuat class:

    * `CarTax`
    * `MotorcycleTax`
    * `TruckTax`
4. Mengubah `TaxCalculator`

    * Tidak lagi menerima String
    * Tapi menerima object `TaxStrategy`
5. Membuat class `Main`
6. Menjalankan program

### Hasil:

* Program sudah mengikuti OCP
* Penambahan jenis kendaraan tidak perlu ubah class utama

---

# Kesimpulan Langkah Praktikum

Dari semua praktikum:

* Versi tanpa OCP → banyak if-else
* Versi dengan OCP → pakai interface + polymorphism

Ini bikin program:
✔ lebih rapi
✔ lebih mudah dikembangkan
✔ lebih aman dari bug

---
# 4. ANALISA DAN PEMBAHASAN

## 4.1 Praktikum 1 – Sistem Pembayaran

### Analisa

Pada praktikum ini, versi awal program menggunakan percabangan `if-else` untuk menentukan metode pembayaran seperti Credit Card dan E-Wallet. Pendekatan ini terlihat sederhana, tetapi sebenarnya memiliki kelemahan besar.

Masalah utama muncul ketika ingin menambahkan metode pembayaran baru. Misalnya, jika ingin menambahkan pembayaran via Bank Transfer, maka kita harus masuk ke dalam class `PaymentProcessor` dan menambahkan kondisi baru. Hal ini jelas melanggar prinsip Open-Closed Principle karena kita harus memodifikasi kode yang sudah ada.

Selain itu, penggunaan String sebagai parameter juga cukup riskan karena rawan kesalahan penulisan (typo), yang bisa menyebabkan bug.

---

### Pembahasan

Setelah dilakukan refactoring dengan menggunakan interface `PaymentMethod`, setiap metode pembayaran dipisahkan ke dalam class masing-masing.

Dengan cara ini:

* `PaymentProcessor` hanya bertugas memanggil method `process()`
* Logika tiap pembayaran dipisah ke class masing-masing

Keuntungannya:

* Kode jadi lebih rapi dan modular
* Mudah menambahkan metode pembayaran baru tanpa mengubah kode lama
* Lebih aman dan mudah diuji

Pendekatan ini juga menunjukkan penerapan polymorphism yang membuat program lebih fleksibel.

---

## 4.2 Praktikum 2 – Sistem Diskon

### Analisa

Pada versi awal, class `DiscountCalculator` menggunakan `if-else` untuk menentukan diskon berdasarkan tipe customer (Regular dan Premium).

Masalahnya hampir sama dengan praktikum sebelumnya:

* Jika ada tipe customer baru, harus ubah kode
* Logic jadi menumpuk dalam satu method
* Tidak fleksibel untuk pengembangan

Selain itu, kode seperti ini cenderung sulit dirawat jika jumlah kondisi semakin banyak.

---

### Pembahasan

Setelah refactoring, digunakan interface `Discount` sebagai strategi perhitungan diskon.

Setiap jenis diskon dipisahkan:

* `RegularDiscount`
* `PremiumDiscount`

Kemudian `DiscountCalculator` hanya menerima object `Discount`.

Hasilnya:

* Tidak perlu lagi if-else
* Lebih mudah menambah jenis diskon baru
* Kode lebih bersih dan terstruktur

Pendekatan ini juga mirip dengan **Strategy Pattern**, di mana perilaku program bisa diganti secara dinamis.

---

## 4.3 Praktikum 3 – Sistem Notifikasi

### Analisa

Pada versi awal, class `NotificationService` menggunakan if-else untuk menentukan jenis notifikasi (Email atau SMS).

Kelemahannya:

* Setiap penambahan jenis notifikasi harus ubah kode
* Tidak scalable
* Logic tercampur dalam satu class

Hal ini menunjukkan bahwa class memiliki lebih dari satu tanggung jawab, dan juga melanggar OCP.

---

### Pembahasan

Setelah refactoring, dibuat interface `Notifier`.

Kemudian dibuat class:

* `EmailNotifier`
* `SMSNotifier`

Class `NotificationService` hanya menerima object `Notifier`.

Keuntungan:

* Mudah menambah notifikasi baru (misalnya WhatsApp)
* Tidak perlu ubah class utama
* Kode lebih fleksibel

Struktur ini juga membuat program lebih dekat dengan konsep clean architecture.

---

## 4.4 Latihan – Sistem Pengelolaan Pajak

### Analisa

Pada kode awal, `TaxCalculator` menggunakan parameter String (`vehicleType`) untuk menentukan pajak kendaraan.

Masalahnya:

* Menggunakan if-else untuk tiap jenis kendaraan
* Jika ingin tambah jenis baru (misalnya Truck), harus ubah method
* Melanggar prinsip OCP

Selain itu, pendekatan ini tidak scalable jika jumlah kendaraan semakin banyak.

---

### Pembahasan

Solusi yang dilakukan adalah dengan membuat interface `TaxStrategy`.

Kemudian dibuat class:

* `CarTax`
* `MotorcycleTax`
* `TruckTax`

Class `TaxCalculator` diubah agar menerima object `TaxStrategy`.

Hasilnya:

* Penambahan jenis kendaraan tidak perlu ubah kode lama
* Tinggal buat class baru
* Kode jadi lebih modular dan rapi

Pendekatan ini sangat efektif untuk sistem yang kemungkinan besar akan berkembang, seperti sistem pajak yang bisa berubah-ubah.

---

# Kesimpulan Pembahasan

Dari semua praktikum yang dilakukan, dapat dilihat pola yang sama:

* Versi awal selalu menggunakan if-else
* Versi refactoring menggunakan interface dan polymorphism

Dengan menerapkan OCP:

* Kode jadi lebih fleksibel
* Lebih mudah dikembangkan
* Lebih aman dari perubahan

Secara keseluruhan, penerapan OCP sangat membantu dalam membuat sistem yang scalable dan maintainable.

---


# 5. KESIMPULAN

Berdasarkan praktikum yang telah dilakukan, dapat disimpulkan bahwa:

1. Open-Closed Principle (OCP) membantu dalam membuat sistem yang fleksibel dan mudah dikembangkan.
2. Kode yang melanggar OCP biasanya ditandai dengan penggunaan if-else yang berlebihan.
3. Dengan menggunakan interface dan polymorphism, kita dapat menghindari perubahan kode lama.
4. Refactoring yang dilakukan membuat sistem lebih modular dan scalable.
5. Penambahan fitur baru dapat dilakukan tanpa mengganggu sistem yang sudah berjalan.

---

# 6. REFERENSI

1. [Modul 5] SOLID Principle : Open-Close Principle (OCP)
2. Robert C. Martin, *Clean Architecture*
3. Bertrand Meyer, *Object-Oriented Software Construction*
4. Sommerville, Ian. *Software Engineering*

---
