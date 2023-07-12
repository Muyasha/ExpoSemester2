import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ControllerNegoBarang implements Initializable {

    @FXML
    private Button btnAjukan;

    @FXML
    private Button btnBeli;

    @FXML
    private Button btnHome;

    @FXML
    private ImageView imageBarang;

    @FXML
    private Label labelAlamatPenjual;
    @FXML
    private Label lblKategori;

    @FXML
    private Label lblStok;

    @FXML
    private Label labelHarga;

    @FXML
    private Label labelNamaBarang;

    @FXML
    private Label lblDeskripsi;

    @FXML
    private TextField tfNego;

    public static String email;
    public static int iD;
    ArrayList<ModelBarang> dataInfoBarang = new CSVReaderBarang()
            .readCSVFile("C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataBarang.csv");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        ModelBarang barangtemp = new ModelBarang();

        for (int i = 0; i < dataInfoBarang.size(); i++) {
            int id = dataInfoBarang.get(i).getID();

            if (id == iD) {
                barangtemp.setKategori(dataInfoBarang.get(i).getKategori());
                barangtemp.setNamaBarang(dataInfoBarang.get(i).getNamaBarang());
                barangtemp.setHarga("Rp " + dataInfoBarang.get(i).getHarga());
                barangtemp.setDeskripsi(dataInfoBarang.get(i).getDeskripsi());
                barangtemp.setStok(dataInfoBarang.get(i).getStok());
                barangtemp.setAlamat(dataInfoBarang.get(i).getAlamat());
                barangtemp.setImage(dataInfoBarang.get(i).getImage());

                // dataInfoBarang.add(new ModelBarang(id, kategori, nama, harga, stok,
                // deskripsi, image));
                labelNamaBarang.setText(barangtemp.getNamaBarang());
                labelHarga.setText(barangtemp.getHarga());
                lblKategori.setText(barangtemp.getKategori());
                lblStok.setText(barangtemp.getStok());
                lblDeskripsi.setText(barangtemp.getDeskripsi());

                labelAlamatPenjual.setText(barangtemp.getAlamat());
                try {
                    File file = new File(barangtemp.getImage());
                    FileInputStream file1;
                    file1 = new FileInputStream(file);
                    Image image1 = new Image(file1);
                    imageBarang.setImage(image1);
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    public ControllerNegoBarang() {

    }
    CSVWriterNego writerNego = new CSVWriterNego();
    ArrayList<ModelNego> dataNego = new CSVReaderNego().readCSVFile("C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataNego.csv");
    @FXML
    void AjukanNego(ActionEvent event) {
        String hargaNegoS= tfNego.getText();
        int hargaNegoInt= Integer.parseInt(hargaNegoS);

    }

    @FXML
    void Beli(ActionEvent event) {
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TampilanBeli.fxml"));
            ControllerBeli beli = new ControllerBeli();
            beli.email = email;
            beli.iD = iD;
            root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

            nonBtnClick(event);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    void toHome(ActionEvent event) {
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TampilanHome.fxml"));
            ControllerHome.email = email;
            root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

            nonBtnClick(event);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    private void nonBtnClick(ActionEvent event) {
        ((Parent) event.getSource()).getScene().getWindow().hide();// closecurrentstage
    }

    @FXML
    private void nonBtnClick(MouseEvent event) {
        ((Parent) event.getSource()).getScene().getWindow().hide();// closecurrentstage
    }
}
