# Tugas Analisis - Strategy Pattern pada Sistem Pembayaran E-Commerce

## Soal 1
Jelaskan mengapa Strategy Pattern cocok digunakan dalam kasus pembayaran e-commerce.

## Jawaban

Strategy Pattern sangat cocok digunakan dalam kasus pembayaran e-commerce karena beberapa alasan berikut:

### 1. **Banyaknya Metode Pembayaran**
E-commerce modern memiliki berbagai metode pembayaran seperti Kartu Kredit, Debit, E-Wallet (GoPay, OVO, Dana), Transfer Bank, QRIS, Cash on Delivery (COD), hingga pembayaran cicilan. Strategy Pattern memungkinkan setiap metode pembayaran dienkapsulasi dalam class terpisah.

### 2. **Prinsip Open/Closed (OCP)**
Class `Checkout` tetap tertutup untuk modifikasi tetapi terbuka untuk ekstensi. Jika ada metode pembayaran baru, kita cukup membuat class baru tanpa mengubah kode yang sudah ada.

### 3. **Menghindari Conditional Statements yang Panjang**
Tanpa Strategy Pattern, kita akan menggunakan if-else atau switch-case yang panjang:
```java
if (metode.equals("KARTU_KREDIT")) {
    // proses kartu kredit
} else if (metode.equals("EWALLET")) {
    // proses e-wallet
} else if (metode.equals("TRANSFER")) {
    // proses transfer
}