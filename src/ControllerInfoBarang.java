import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ControllerInfoBarang {

    ArrayList<ModelBarang> dataInfoBarang = new CSVReaderBarang()
            .readCSVFile("C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataBarang.csv");
    @FXML
    private Button btnBeli;

    @FXML
    private Button btnNego;

    @FXML
    private ImageView imageBarang;

    @FXML
    private Label labelAlamatPenjual;

    @FXML
    private Label labelHarga;

    @FXML
    private Label labelNamaBarang;

    @FXML
    private Label lblDeskripsi;

    @FXML
    void Beli(ActionEvent event) {

    }

    @FXML
    void Nego(ActionEvent event) {

    }

    public ControllerInfoBarang(String iD) {
        for (int i = 0; i < dataInfoBarang.size(); i++) {
            String id = dataInfoBarang.get(i).getID();
            if (id.equalsIgnoreCase(iD)) {
                String kategori = dataInfoBarang.get(i).getKategori();
                String nama = dataInfoBarang.get(i).getNamaBarang();
                String harga = dataInfoBarang.get(i).getHarga();
                String deskripsi = dataInfoBarang.get(i).getDeskripsi();
                String stok = dataInfoBarang.get(i).getStok();
                String image = dataInfoBarang.get(i).getImage();

                dataInfoBarang.add(new ModelBarang(id, kategori, nama, harga, stok, deskripsi, image));
            }
        }

    }

    public void initialize() {
        labelNamaBarang.setText(dataInfoBarang.get(0).getNamaBarang());
        labelHarga.setText(dataInfoBarang.get(0).getHarga());
        lblDeskripsi.setText(dataInfoBarang.get(0).getDeskripsi());

        try {
            File a = new File(dataInfoBarang.get(0).getImage());
            FileInputStream file1;
            file1 = new FileInputStream(a);
            Image image1 = new Image(file1);
            imageBarang.setImage(image1);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
