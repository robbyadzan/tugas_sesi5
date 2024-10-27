// Robby_TI24G

import java.util.ArrayList;
import java.util.Scanner;

class Buah {
    String nama;
    int harga;

    public Buah(String nama, int harga) {
        this.nama = nama;
        this.harga = harga;
    }
}

class Belanja {
    Buah buah;
    int jumlah;

    public Belanja(Buah buah, int jumlah) {
        this.buah = buah;
        this.jumlah = jumlah;
    }

    public int subtotal() {
        return buah.harga * jumlah;
    }
}

public class BelanjaBuah_Robby {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        ArrayList<Buah> buahList = new ArrayList<>();
        buahList.add(new Buah("apel", 35000));
        buahList.add(new Buah("jeruk", 50000));
        buahList.add(new Buah("mangga" 25000));
        buahList.add(new Buah("duku", 15000));
        buahList.add(new Buah("semangka", 20000));

        ArrayList<Belanja> daftarBelanja = new ArrayList<>();
        boolean running = true;

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Beli Buah");
            System.out.println("2. Struk Belanja");
            System.out.println("3. Keluar");
            System.out.print("Masukkan pilihan: ");
            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1: 
                    System.out.print("Pilih Buah (0-4): ");
                    int pilihBuah = scanner.nextInt();
                    if (pilihBuah < 0 || pilihBuah >= buahList.size()) {
                        System.out.println("Buah tidak ditemukan.");
                        break;
                    }
                    System.out.print("Masukkan jumlah: ");
                    int jumlah = scanner.nextInt();

                    daftarBelanja.add(new Belanja(buahList.get(pilihBuah), jumlah));
                    System.out.print("Input lagi? (y/n): ");
                    String lagi = scanner.next();
                    if (!lagi.equalsIgnoreCase("y")) {
                        running = false;
                    }
                    break;

                case 2: 
                    System.out.println("\nDaftar Belanja:");
                    System.out.printf("%-5s %-15s %-10s %-10s %-10s%n", "No.", "Nama Buah", "Jumlah", "Harga", "Subtotal");

                    int total = 0;
                    for (int i = 0; i < daftarBelanja.size(); i++) {
                        Belanja belanja = daftarBelanja.get(i);
                        int subtotal = belanja.subtotal();
                        total += subtotal;

                        System.out.printf("%-5d %-15s %-10d %-10d %-10d%n", i + 1, belanja.buah.nama, belanja.jumlah, belanja.buah.harga, subtotal);
                    }

                    System.out.println("\n===");
                    System.out.println("Total: " + total);

                    int discount = (int) (total * 0.15);
                    System.out.println("Discount (15%): " + discount);

                    int totalBayar = total - discount;
                    System.out.println("Total bayar: " + totalBayar);
                    break;

                case 3:
                    running = false;
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
        
        scanner.close();
    }
}
