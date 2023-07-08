import java.util.ArrayList;

public class demo {
    public static void main(String[] args) {
        CSVWriterBarang writer = new CSVWriterBarang();
        ArrayList<ModelAlamat> dataAlamat = new CSVReaderAlamat()
                .readCSVFile("C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataAlamat.csv");

        for (ModelAlamat i : dataAlamat) {
            System.out.println(i.toString());
        }

        // ModelBarang newBarang = new ModelBarang();
        // ModelBarang.setID("2");
        // dataBarang.add(new ModelBarang("3", "otomotif", "motor", "Rp 70.000.000",
        // "1", "gedhe", null));
        // writer.simpanData(dataBarang, "C://Kuliah//Semester
        // 2//FPA//THRIFTSHOP//Aplikasi//src//dataBarang.csv");
    }
}
