import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReaderPenjualan {
    public ArrayList<ModelPenjualan> readCSVFile(String file) {
        String csvFile = file;
        String delimiter = ";"; // Pemisah dalam file CSV

        ArrayList<ModelPenjualan> dataPenjualan = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(csvFile)));
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(delimiter);
                if (data.length == 9) {
                    String email = data[0].trim();
                    int ID = Integer.parseInt(data[1].trim());
                    String kategori = data[2].trim();
                    String namaBarang = data[3].trim();
                    String harga = data[4].trim();
                    String stok = data[5].trim();
                    String deskripsi = data[6].trim();
                    String alamat = data[7].trim();
                    String image = data[8].trim();
                    ModelPenjualan penjualan = new ModelPenjualan(email, ID, kategori, namaBarang, harga, stok,
                            deskripsi, alamat, image);
                    dataPenjualan.add(penjualan);
                }
            }
        } catch (IOException e) {
            System.out.println("Fail tidak ditemukan");
            e.printStackTrace();
            // return;
        }

        return dataPenjualan;
    }
}