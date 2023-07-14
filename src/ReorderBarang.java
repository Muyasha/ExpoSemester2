import java.util.ArrayList;

public class ReorderBarang {
    ArrayList<ModelBarang> dataBarang = new CSVReaderBarang()
            .readCSVFile("C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataBarang.csv");
    CSVWriterBarang writerBarang = new CSVWriterBarang();

    public void reorderBarang() {
        for (int i = 0; i < dataBarang.size(); i++) {
            int identitas = i + 1;
            dataBarang.get(i).setID(identitas);
        }
        writerBarang.simpanData(dataBarang, "C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataBarang.csv");
    }

}
