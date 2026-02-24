import java.util.Scanner;

public class Driver1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        final int BERAT_UCOK = 100;
        final int BERAT_BUTET = 50;

        int rasio = BERAT_UCOK / BERAT_BUTET;

        String kode;
        int porsiButet;
        int totalPembayaran = 0;

        System.out.println("Menu\t\t\tPorsi\tHarga\tTotal");
        System.out.println("============================================================");

        while (true) {

            kode = sc.nextLine();

            if (kode.equalsIgnoreCase("END")) {
                break;
            }

            porsiButet = Integer.parseInt(sc.nextLine());

            int totalPorsi = porsiButet + (porsiButet * rasio);

            String nama = "";
            int harga = 0;

            switch (kode.toUpperCase()) {
                case "NGS": nama = "Nasi Goreng Spesial"; harga = 15000; break;
                case "AP": nama = "Ayam Penyet"; harga = 20000; break;
                case "SA": nama = "Sate Ayam (10 Tusuk)"; harga = 25000; break;
                case "BU": nama = "Bakso Urat"; harga = 18000; break;
                case "MAP": nama = "Mie Ayam Pangsit"; harga = 15000; break;
                case "GG": nama = "Gado-Gado"; harga = 15000; break;
                case "SAM": nama = "Soto Ayam"; harga = 17000; break;
                case "RD": nama = "Rendang Daging"; harga = 25000; break;
                case "IB": nama = "Ikan Bakar"; harga = 35000; break;
                case "NUK": nama = "Nasi Uduk Komplit"; harga = 20000; break;
                default:
                    System.out.println("Kode tidak valid!");
                    continue;
            }

            int total = harga * totalPorsi;
            totalPembayaran += total;

            System.out.printf("%-25s %d\t%d\t%d\n",
                    nama, totalPorsi, harga, total);
        }

        System.out.println("============================================================");
        System.out.printf("Total Pembayaran\t\t\t\t%d\n", totalPembayaran);

        String kupon = "Tidak Ada";
        int diskonPersen = 0;

        if (totalPembayaran >= 500000) {
            kupon = "Kupon Hitam"; diskonPersen = 25;
        } else if (totalPembayaran >= 400000) {
            kupon = "Kupon Hijau"; diskonPersen = 20;
        } else if (totalPembayaran >= 300000) {
            kupon = "Kupon Merah"; diskonPersen = 15;
        } else if (totalPembayaran >= 200000) {
            kupon = "Kupon Kuning"; diskonPersen = 10;
        } else if (totalPembayaran >= 100000) {
            kupon = "Kupon Biru"; diskonPersen = 5;
        }

        int diskon = totalPembayaran * diskonPersen / 100;
        int totalAkhir = totalPembayaran - diskon;

        System.out.println("Kupon Didapat : " + kupon);
        System.out.println("Diskon        : " + diskon);
        System.out.println("Total Bayar   : " + totalAkhir);
    }
}
