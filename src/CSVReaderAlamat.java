import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReaderAlamat {
    public ArrayList<ModelAlamat> readCSVFile(String file, String EMAIL) {
        String csvFile = file;
        String delimiter = ";"; // Pemisah dalam file CSV

        ArrayList<ModelAlamat> dataAlamat = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(csvFile)));
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(delimiter);
                if (data.length == 3) {
                    String email = data[0].trim();
                    int nomor = Integer.parseInt(data[1].trim());
                    String alamat = data[2].trim();
                    ModelAlamat user = new ModelAlamat(email, nomor, alamat);

                    dataAlamat.add(user);

                }
            }
        } catch (IOException e) {
            System.out.println("Fail tidak ditemukan");
            e.printStackTrace();
            // return;
        }

        return dataAlamat;
    }
}