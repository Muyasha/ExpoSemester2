import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReaderNego {
    public ArrayList<ModelNego> readCSVFile(String file) {
        String csvFile = file;
        String delimiter = ";"; // Pemisah dalam file CSV

        ArrayList<ModelNego> dataNego = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(csvFile)));
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(delimiter);
                if (data.length == 3) {
                    String emailPengirim = data[0].trim();
                    int nego = Integer.parseInt(data[1].trim());
                    String emailPenerima = data[2].trim();
                    ModelNego negoBarang = new ModelNego(emailPengirim, nego, emailPenerima);
                    dataNego.add(negoBarang);
                }
            }
        } catch (IOException e) {
            System.out.println("Fail tidak ditemukan");
            e.printStackTrace();
            // return;
        }

        return dataNego;
    }
}