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
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ControllerBeli implements Initializable {

    @FXML
    private Rectangle JenisPengiriman;
    @FXML
    private Pane alamatPengiriman;
    @FXML
    private Button btnBayar;
    @FXML
    private Button btnSetStok;
    @FXML
    private ImageView imgBack;
    @FXML
    private Label lblAlamat1;
    @FXML
    private Label lblAlamat2;
    @FXML
    private Label lblAlamatPengiriman;
    @FXML
    private Label lblBiayaPengiriman;
    @FXML
    private Label lblHarga;
    @FXML
    private Label lblHargaTotal;
    @FXML
    private Label lblJenisPengiriman;
    @FXML
    private Label lblNama;
    @FXML
    private Label lblRinciBiayaPengiriman;
    @FXML
    private Label lblTotalBayar;
    @FXML
    private Label lblTotalHarga;
    @FXML
    private TextField tfStok;
    @FXML
    private ImageView imgBarang;

    ArrayList<ModelBarang> dataInfoBarang = new CSVReaderBarang()
            .readCSVFile("C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataBarang.csv");

    public ControllerBeli() {
    }

    public static int iD;
    private ModelBarang barang;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
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

                lblNama.setText(barangtemp.getNamaBarang());
                lblHarga.setText(barangtemp.getHarga());
                lblHarga.setText(barangtemp.getHarga());
                lblAlamat1.setText(barangtemp.getAlamat());
                lblAlamat2.setText(barangtemp.getAlamat());

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

    @FXML
    void Back(MouseEvent event) {
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TampilanInfoBarang.fxml"));
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
    void Bayar(ActionEvent event) {
        Parent root;

        try {
            if (hargaFinal != null) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("TampilanMetodePembayaran.fxml"));
                ControllerMetodePembayaran bayar = new ControllerMetodePembayaran();
                bayar.stokFinal = stokFinal;
                bayar.iD = iD;
                bayar.hargaTotal = hargaFinal;
                root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = new Stage();

                stage.setScene(scene);
                stage.show();

                nonBtnClick(event);
            } else {
                // peringatan bahwa harga final belum ada
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    void pickAlamatPengiriman(MouseEvent event) {

    }

    @FXML
    void pickJenisPengiriman(MouseEvent event) {

    }

    private int stokFinal;
    private String hargaFinal;

    @FXML
    void SetStok(ActionEvent event) {
        String angka = tfStok.getText();
        String angkaData = dataInfoBarang.get(iD - 1).getStok();
        int stok = Integer.parseInt(angka);
        int stokData = Integer.parseInt(angkaData);

        if (stok <= stokData && stok > 0) {
            stokFinal = stok;
            String hargaString = dataInfoBarang.get(iD - 1).getHarga();
            int hargaint = Integer.parseInt(hargaString);
            long hargaTotal = stokFinal * hargaint;

            String totalString = Long.toString(hargaTotal);
            hargaFinal = totalString;
            lblTotalHarga.setText(totalString);
        } else {
            // kode gagal di set karena stok nggak ada
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
