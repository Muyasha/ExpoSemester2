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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ControllerMetodePembayaran implements Initializable {

    @FXML
    private Button btnBack;

    @FXML
    private Button btnBayar;

    @FXML
    private CheckBox checkAlfamart;

    @FXML
    private CheckBox checkBRI;

    @FXML
    private CheckBox checkIndomaret;

    @FXML
    private CheckBox checkJago;

    @FXML
    private Label lblBiayaPengiriman;

    @FXML
    private Label lblHarga;

    @FXML
    private Label lblTotalBiaya;

    public ControllerMetodePembayaran() {

    }

    public static String hargaTotal;
    public static int iD;
    public static int stokFinal;
    public static String nama;
    public static String alamat;

    CSVWriterPembelian writer = new CSVWriterPembelian();
    ArrayList<ModelPembelian> dataPembelian = new CSVReaderPembelian()
            .readCSVFile("C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataPembelian.csv");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String harga = "Rp " + hargaTotal;
        lblHarga.setText(harga);
    }

    @FXML
    void Bayar(ActionEvent event) {
        Parent root;
        String id = Integer.toString(dataPembelian.size() + 1);
        String name = nama;
        String biaya = hargaTotal;
        String jumlah = Integer.toString(stokFinal);
        String asal = alamat;

        dataPembelian.add(new ModelPembelian(id, name, biaya, jumlah, asal));
        writer.simpanData(dataPembelian, "C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataPembelian.csv");

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TampilanStrukPembelian.fxml"));
            ControllerStrukPembelian struk = new ControllerStrukPembelian();
            struk.stokFinal = stokFinal;
            struk.hargaTotal = hargaTotal;
            struk.iD = iD;
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
    void back(ActionEvent event) {

    }

    @FXML
    private void nonBtnClick(ActionEvent event) {
        ((Parent) event.getSource()).getScene().getWindow().hide();// close currentstage
    }
}
