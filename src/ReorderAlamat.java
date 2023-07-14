import java.util.ArrayList;

public class ReorderAlamat {
    String email;

    public ReorderAlamat(String email) {
        this.email = email;
    }

    ArrayList<ModelAlamat> dataAlamat = new CSVReaderAlamat()
            .readCSVFile("C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataAlamat.csv", email);
    CSVWriterAlamat writer = new CSVWriterAlamat();

    public void reorderAlamat() {
        for (int i = 0; i < dataAlamat.size(); i++) {
            String eMAIL = dataAlamat.get(i).getEmail();
            if (eMAIL.equals(email)) {
                dataAlamat.get(i).setNomor(i + 1);
            }
        }
        writer.simpanData(dataAlamat, "C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataAlamat.csv");
    }

}
