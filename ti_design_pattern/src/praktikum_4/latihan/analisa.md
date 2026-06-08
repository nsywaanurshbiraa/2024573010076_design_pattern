## Analisis Percobaan

Pada percobaan ini dibuat sebuah program sederhana untuk mengelola pesanan (order management). Program ini awalnya menggunakan satu kelas utama yaitu `OrderManager` untuk menangani semua proses, mulai dari menyimpan data pesanan hingga mencetak struk.

Kalau diperhatikan, `OrderManager` punya banyak tugas sekaligus, seperti:
- menyimpan data pesanan ke file
- mengolah data pesanan (produk, jumlah, harga)
- mencetak struk ke layar

Nah, di sini terlihat jelas kalau satu kelas melakukan lebih dari satu tanggung jawab. Hal ini sebenarnya melanggar prinsip **Single Responsibility Principle (SRP)**, yang menyatakan bahwa satu kelas seharusnya hanya punya satu alasan untuk berubah.

Dampak dari pelanggaran ini adalah:
- kode jadi lebih sulit dipahami karena terlalu banyak fungsi dalam satu tempat
- kalau ada perubahan di satu bagian (misalnya format struk), bisa mempengaruhi bagian lain
- sulit untuk dikembangkan ke depannya

Setelah itu, program diperbaiki dengan cara memisahkan tanggung jawab ke beberapa kelas yang berbeda, yaitu:
- `Order` → hanya untuk menyimpan data pesanan
- `OrderRepository` → khusus untuk menyimpan data ke file
- `ReceiptPrinter` → hanya untuk mencetak struk
- `Main` → mengatur jalannya program

Dengan pemisahan ini, setiap kelas jadi lebih fokus dan punya satu tugas saja. Jadi kalau ada perubahan, misalnya ingin ubah cara menyimpan data, cukup ubah di `OrderRepository` tanpa mengganggu bagian lain.

Dari percobaan ini bisa dilihat bahwa penerapan SRP membuat kode jadi:
- lebih rapi dan terstruktur
- lebih mudah dibaca
- lebih gampang dikembangkan dan diperbaiki

Kesimpulannya, penggunaan SRP sangat membantu dalam membuat program yang lebih baik dan terorganisir, terutama ketika program mulai berkembang menjadi lebih besar.