import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReaderPembelian {
    public ArrayList<ModelPembelian> readCSVFile(String file) {
        String csvFile = file;
        String delimiter = ";"; // Pemisah dalam file CSV

        ArrayList<ModelPembelian> dataPembelian = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(csvFile)));
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(delimiter);
                if (data.length == 5) {
                    String id = data[0].trim();
                    String nama = data[1].trim();
                    String harga = data[2].trim();
                    String jumlah = data[3].trim();
                    String asal = data[4].trim();
                    ModelPembelian pembelian = new ModelPembelian(id, nama, harga, jumlah, asal);
                    dataPembelian.add(pembelian);
                }
            }
        } catch (IOException e) {
            System.out.println("Fail tidak ditemukan");
            e.printStackTrace();
            // return;
        }

        return dataPembelian ;
    }
}