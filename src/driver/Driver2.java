import java.util.Scanner;

public class Driver2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input jumlah total data
        int N = sc.nextInt();

        // Array untuk menyimpan nilai
        int[] nilai = new int[N];

        for (int i = 0; i < N; i++) {
            nilai[i] = sc.nextInt();
        }

        // Input kode kelompok
        int k = sc.nextInt();

        // Mencari index awal kelompok
        int start = k * (k - 1) / 2;

        int total = 0;

        // Menjumlahkan nilai kelompok yang diminta
        for (int i = start; i < start + k && i < N; i++) {
            total += nilai[i];
        }

        // Output hasil
        System.out.println(total);

        sc.close();
    }
}

