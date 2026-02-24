import java.util.ArrayList;
import java.util.Scanner;

public class Driver3 {

    // ===== Class Layanan =====
    static class Layanan {
        String kode;
        String nama;
        int hargaPerKg;

        Layanan(String kode, String nama, int hargaPerKg) {
            this.kode = kode;
            this.nama = nama;
            this.hargaPerKg = hargaPerKg;
        }
    }

    // ===== Class Transaksi =====
    static class Transaksi {
        String namaPelanggan;
        String namaLayanan;
        double berat;
        double subtotal;
        double diskon;
        double totalAkhir;

        Transaksi(String namaPelanggan, String namaLayanan,
                  double berat, double subtotal,
                  double diskon, double totalAkhir) {

            this.namaPelanggan = namaPelanggan;
            this.namaLayanan = namaLayanan;
            this.berat = berat;
            this.subtotal = subtotal;
            this.diskon = diskon;
            this.totalAkhir = totalAkhir;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Transaksi> daftarTransaksi = new ArrayList<>();

        // ===== Database Layanan =====
        Layanan[] daftarLayanan = {
                new Layanan("C", "Cuci", 7000),
                new Layanan("CS", "Cuci + Setrika", 10000),
                new Layanan("S", "Setrika", 5000)
        };

        System.out.println("===== SISTEM LAUNDRY DEL =====");

        while (true) {

            System.out.print("\nNama Pelanggan (ketik END untuk selesai): ");
            String nama = sc.nextLine();

            if (nama.equalsIgnoreCase("END")) {
                break;
            }

            System.out.print("Berat Cucian (kg): ");
            double berat = Double.parseDouble(sc.nextLine());

            System.out.print("Kode Layanan (C / CS / S): ");
            String kode = sc.nextLine();

            System.out.print("Express? (Y/N): ");
            String express = sc.nextLine();

            Layanan layananDipilih = null;

            for (Layanan l : daftarLayanan) {
                if (l.kode.equalsIgnoreCase(kode)) {
                    layananDipilih = l;
                    break;
                }
            }

            if (layananDipilih == null) {
                System.out.println("Kode layanan tidak valid!");
                continue;
            }

            double subtotal = berat * layananDipilih.hargaPerKg;

            if (express.equalsIgnoreCase("Y")) {
                subtotal += 5000;
            }

            double diskon = 0;

            if (subtotal >= 100000) {
                diskon = subtotal * 0.10;
            }

            double totalAkhir = subtotal - diskon;

            daftarTransaksi.add(new Transaksi(
                    nama,
                    layananDipilih.nama,
                    berat,
                    subtotal,
                    diskon,
                    totalAkhir
            ));

            // ===== Cetak Struk Per Pelanggan =====
            System.out.println("\n========= STRUK LAUNDRY DEL =========");
            System.out.println("Nama Pelanggan : " + nama);
            System.out.println("Layanan        : " + layananDipilih.nama);
            System.out.println("Berat          : " + berat + " kg");
            System.out.println("Subtotal       : " + subtotal);
            System.out.println("Diskon         : " + diskon);
            System.out.println("Total Bayar    : " + totalAkhir);
            System.out.println("=====================================");
        }

        System.out.println("\nTotal Transaksi Hari Ini: " + daftarTransaksi.size());
        System.out.println("===== TERIMA KASIH TELAH MENGGUNAKAN LAUNDRY DEL =====");

        sc.close();
    }
}

