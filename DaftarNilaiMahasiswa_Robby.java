
// Robby_TI24G

import java.util.Scanner;

class Mahasiswa {
    String nama;
    int nilai;
    String status;

    public Mahasiswa(String nama, int nilai) {
        this.nama = nama;
        this.nilai = nilai;
        this.status = (nilai >= 60) ? "Lulus" : "Tidak Lulus";
    }
}

public class DaftarNilaiMahasiswa_Robby{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan jumlah data: ");
        int jumlahData = scanner.nextInt();
        scanner.nextLine();

        Mahasiswa[] mahasiswaArr = new Mahasiswa[jumlahData];
        int totalNilai = 0;

       
        for (int i = 0; i < jumlahData; i++) {
            System.out.println("Mahasiswa Ke: " + (i + 1));

            System.out.print("Nama: ");
            String nama = scanner.nextLine();

            System.out.print("Nilai: ");
            int nilai = scanner.nextInt();
            scanner.nextLine(); 

            mahasiswaArr[i] = new Mahasiswa(nama, nilai);
            totalNilai += nilai;
        }

      
        System.out.println("\nDAFTAR NILAI MAHASISWA");
        System.out.printf("%-5s %-15s %-10s %-10s%n", "No", "Nama", "Nilai", "Status");

        for (int i = 0; i < jumlahData; i++) {
            System.out.printf("%-5d %-15s %-10d %-10s%n", i + 1, mahasiswaArr[i].nama, mahasiswaArr[i].nilai, mahasiswaArr[i].status);
        }

      
        double rataRata = (double) totalNilai / jumlahData;
        System.out.println("\n==");
        System.out.println("Jumlah: " + totalNilai);
        System.out.printf("Nilai Rata-rata: %.1f%n", rataRata);
        
        scanner.close();
    }
}
