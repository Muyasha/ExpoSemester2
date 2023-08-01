import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReaderKonfirmasi {
    public ArrayList<ModelKonfirmasiPembelian> readCSVFile(String file) {
        String csvFile = file;
        String delimiter = ";"; // Pemisah dalam file CSV

        ArrayList<ModelKonfirmasiPembelian> dataKonfirmasiPembelian = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(csvFile)));
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(delimiter);
                if (data.length == 8) {
                    String emailPembeli = data[0].trim();
                    String namaBarang = data[1].trim();
                    String hargaAsli = data[2].trim();
                    String hargaNego = data[3].trim();
                    int jumlahBeliBarang = Integer.parseInt(data[4].trim());
                    int biayaBayar = Integer.parseInt(data[5].trim());
                    String metodeBayar = data[6].trim();
                    String emailPenjual = data[7].trim();
                    ModelKonfirmasiPembelian konfirmasiPembelian = new ModelKonfirmasiPembelian(emailPembeli,
                            namaBarang,
                            hargaAsli, hargaNego, jumlahBeliBarang, biayaBayar, metodeBayar, emailPenjual);
                    dataKonfirmasiPembelian.add(konfirmasiPembelian);
                }
            }
        } catch (IOException e) {
            System.out.println("Fail tidak ditemukan");
            e.printStackTrace();
            // return;
        }

        return dataKonfirmasiPembelian;
    }
}