# Swag Labs - Test Automation Project

Project ini berisi serangkaian skenario pengujian otomatis untuk situs web demo e-commerce [Sauce Demo (Swag Labs)](https://www.saucedemo.com/). Proyek ini dirancang untuk menunjukkan keahlian dalam otomatisasi pengujian web menggunakan Java, Selenium, dan TestNG, yang menjadi portofolio saya sebagai seorang QA Engineer.

## Fitur Utama

- **Page Object Model (POM):** Arsitektur pengujian yang bersih dan dapat dipelihara dengan memisahkan logika halaman dari logika pengujian.
- **Laporan TestNG:** Menghasilkan laporan pengujian HTML yang terperinci setelah eksekusi.
- **Pengambilan Screenshot Otomatis:** Secara otomatis mengambil screenshot ketika sebuah pengujian gagal untuk membantu proses debug.
- **Notifikasi Email:** Mengirimkan ringkasan laporan pengujian melalui email setelah seluruh suite pengujian selesai dijalankan.
- **Manajemen Proyek dengan Maven:** Menggunakan Maven untuk mengelola dependensi dan siklus build proyek.

---

## Teknologi yang Digunakan

- **Java:** Bahasa pemrograman utama yang digunakan untuk menulis skrip pengujian.
- **Selenium WebDriver:** Alat utama untuk otomatisasi interaksi dengan browser web.
- **TestNG:** Kerangka kerja pengujian untuk mengelola dan menjalankan skenario pengujian.
- **Maven:** Alat untuk manajemen dependensi dan build proyek.
- **SLF4J:** Kerangka kerja logging untuk mencatat aktivitas selama eksekusi pengujian.
- **Jakarta Mail:** Digunakan untuk fungsionalitas pengiriman laporan melalui email.

---

## Skenario Pengujian

Proyek ini mencakup skenario pengujian untuk fungsionalitas-fungsionalitas utama dari situs Swag Labs.

### 🧪 Fungsionalitas Login
- `loginSuccessWithValidCredentialTest`: Memverifikasi bahwa pengguna dapat berhasil login dengan kredensial yang valid.
- `loginFailedWithInvalidUsernameTest`: Memverifikasi bahwa pesan kesalahan yang sesuai ditampilkan saat login dengan username yang salah.
- `loginFailedWithInvalidPasswordTest`: Memverifikasi bahwa pesan kesalahan yang sesuai ditampilkan saat login dengan password yang salah.

### 🧪 Fungsionalitas Inventaris
- `addSingleProductToChartTest`: Memverifikasi bahwa satu produk dapat ditambahkan ke keranjang belanja.
- `addMultipleProdductToChartTest`: Memverifikasi bahwa beberapa produk dapat ditambahkan ke keranjang belanja.
- `deleteProductFromInventariesPageTest`: Memverifikasi bahwa produk dapat dihapus dari keranjang belanja melalui halaman inventaris.
- `orderLowToHighBasePriceTest`: Memverifikasi fungsionalitas pengurutan produk dari harga terendah ke tertinggi.
- `forbidenAccessToInventoryPageWithoutLoginTest`: Memastikan pengguna yang belum login tidak dapat mengakses halaman inventaris secara langsung.
- `resetApplicationSateAfterProductAddTest`: Memverifikasi bahwa status aplikasi (misalnya, keranjang belanja) dapat direset.

---

## Struktur Proyek

```
swaglabs-test/
├── pom.xml                 # File konfigurasi Maven untuk dependensi dan build
├── src/
│   ├── main/java/          # (Kosong, karena fokus pada pengujian)
│   └── test/
│       ├── java/
│       │   └── com/juaracoding/swaglabs/
│       │       ├── BaseTest.java               # Kelas dasar untuk setup dan teardown WebDriver
│       │       ├── LoginTest.java              # Skenario pengujian untuk halaman Login
│       │       ├── InventoryTest.java          # Skenario pengujian untuk halaman Inventaris
│       │       ├── listeners/
│       │       │   ├── ScreenshotListener.java # Listener TestNG untuk screenshot saat gagal
│       │       │   └── SendEmailReporter.java  # Listener TestNG untuk laporan via email
│       │       ├── pages/                      # Implementasi Page Object Model (POM)
│       │       │   ├── LoginPage.java
│       │       │   └── InventoryPage.java
│       │       └── utils/                      # Kelas utilitas
│       │           ├── MailUtil.java           # Utilitas untuk mengirim email
│       │           └── MiscUtil.java           # Utilitas lain-lain
│       └── resources/
│           ├── mailtrap.properties     # Konfigurasi untuk layanan email
│           └── testng.xml              # File konfigurasi suite TestNG
└── target/                     # Direktori output build, termasuk laporan
    ├── screenshots/            # Screenshot dari pengujian yang gagal
    └── surefire-reports/       # Laporan pengujian yang dihasilkan TestNG
```

---

## Cara Menjalankan Pengujian

**Prasyarat:**
- Java Development Kit (JDK) terinstal
- Apache Maven terinstal

**Langkah-langkah:**

1.  **Clone Repositori**
    ```bash
    git clone <URL_REPOSITORI_ANDA>
    cd swaglabs-test
    ```

2.  **Konfigurasi Email (Opsional)**
    Jika Anda ingin mengaktifkan notifikasi email, perbarui file `src/test/resources/mailtrap.properties` dengan kredensial SMTP Anda.

3.  **Jalankan Pengujian menggunakan Maven**
    Buka terminal atau command prompt di direktori root proyek dan jalankan perintah berikut:
    ```bash
    mvn clean test
    ```
    Maven akan secara otomatis mengunduh semua dependensi yang diperlukan dan menjalankan suite pengujian yang didefinisikan dalam `testng.xml`.

---

## Melihat Laporan Hasil Pengujian

Setelah eksekusi selesai, laporan pengujian dapat ditemukan di direktori `target/surefire-reports/`.

- **Laporan Utama TestNG:** Buka file `emailable-report.html` atau `index.html` di browser Anda untuk melihat ringkasan hasil pengujian.
- **Screenshot Kegagalan:** Jika ada pengujian yang gagal, screenshot akan disimpan di direktori `target/screenshots/`.
