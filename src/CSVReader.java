import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {
    public ArrayList<ModelUser> readCSVFile(String file) {
        String csvFile = file;
        String delimiter = ";"; // Pemisah dalam file CSV

        ArrayList<ModelUser> dataLogin = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(csvFile)));
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(delimiter);
                if (data.length == 5) {
                    String email = data[0].trim();
                    String nama = data[1].trim();
                    String noHP = data[2].trim();
                    String password = data[3].trim();
                    int saldo = Integer.parseInt(data[4].trim());
                    ModelUser user = new ModelUser(email, nama, noHP, password, saldo);
                    dataLogin.add(user);
                }
            }
        } catch (IOException e) {
            System.out.println("Fail tidak ditemukan");
            e.printStackTrace();
            // return;
        }

        return dataLogin;
    }
}