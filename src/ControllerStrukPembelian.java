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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ControllerStrukPembelian implements Initializable {

    @FXML
    private Button btnHome;

    @FXML
    private ImageView imgBarang;

    @FXML
    private Label lblAlamat;

    @FXML
    private Label lblDeskripsi;

    @FXML
    private Label lblHargaAsli;

    @FXML
    private Label lblHargaTotal;

    @FXML
    private Label lblJumlahBeli;

    @FXML
    private Label lblNama;

    public ControllerStrukPembelian() {

    }

    public static String hargaTotal;
    public static int iD;
    public static int stokFinal;
    public static String EMAIL;

    ModelBarang barang;
    ArrayList<ModelBarang> dataInfoBarang = new CSVReaderBarang()
            .readCSVFile("C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataBarang.csv");
    public static String harga;

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
                barangtemp.setImage(dataInfoBarang.get(i).getImage());
                barangtemp.setAlamat(dataInfoBarang.get(i).getAlamat());

                String stok = Integer.toString(stokFinal);

                // dataInfoBarang.add(new ModelBarang(id, kategori, nama, harga, stok,
                // deskripsi, image));
                lblNama.setText(barangtemp.getNamaBarang());
                lblHargaAsli.setText(barangtemp.getHarga());
                lblDeskripsi.setText(barangtemp.getDeskripsi());
                lblAlamat.setText(barangtemp.getAlamat());
                lblJumlahBeli.setText(stok);
                lblHargaTotal.setText(hargaTotal);
                try {
                    File file = new File(barangtemp.getImage());
                    FileInputStream file1;
                    file1 = new FileInputStream(file);
                    Image image1 = new Image(file1);
                    imgBarang.setImage(image1);
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                barang = barangtemp;
            }
        }
    }

    public static int stokSisa;
    ArrayList<ModelBarang> dataBarang = new CSVReaderBarang()
            .readCSVFile("C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataBarang.csv");

    @FXML
    void BacktoHome(ActionEvent event) {
        for (int i = 0; i < dataBarang.size(); i++) {
            int identitas = dataBarang.get(i).getID();
            if (stokSisa == 0) {
                if (iD == identitas) {
                    dataBarang.remove(i);
                }
            }
        }

        Parent root;

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TampilanHome.fxml"));
            ControllerHome.email = EMAIL;
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
