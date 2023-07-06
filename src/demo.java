import java.util.ArrayList;

public class demo {
    public static void main(String[] args) {
        CSVWriterBarang writer = new CSVWriterBarang();
        ArrayList<ModelBarang> dataBarang = new CSVReaderBarang()
                .readCSVFile("C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataBarang.csv");

        for (ModelBarang i : dataBarang) {
            System.out.println(i.toString());
            System.out.println(i.getNamaBarang());
        }

        // ModelBarang newBarang = new ModelBarang();
        // ModelBarang.setID("2");
        // dataBarang.add(new ModelBarang("3", "otomotif", "motor", "Rp 70.000.000", "1", "gedhe"));
        // writer.simpanData(dataBarang, "C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataBarang.csv");
    }
}
