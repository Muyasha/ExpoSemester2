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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
    private CheckBox checkSaldo;

    @FXML
    private CheckBox checkCOD;

    @FXML
    private Label lblBiayaPengiriman;

    @FXML
    private Label lblHarga;

    @FXML
    private Label lblTotalBiaya;

    public ControllerMetodePembayaran() {

    }

    public static String hargaTotal;
    public static String biayaPengiriman;
    public static String totalBayar;
    public static int iD;
    public static int stokBeli;
    public static String nama;
    public static String alamat;

    CSVWriterPembelian writer = new CSVWriterPembelian();
    ArrayList<ModelPembelian> dataPembelian = new CSVReaderPembelian()
            .readCSVFile("C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataPembelian.csv");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String harga = "Rp " + hargaTotal;
        lblHarga.setText(harga);
        lblBiayaPengiriman.setText("Rp " + biayaPengiriman);
        lblTotalBiaya.setText("Rp " + totalBayar);
    }

    public static String email;
    public static int stokSisa;
    String iniEmail;

    String metodePembayaran;
    ArrayList<ModelUser> dataUser = new CSVReader()
            .readCSVFile("C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataLogin.csv");
    ArrayList<ModelBarang> dataBarang = new CSVReaderBarang()
            .readCSVFile("C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataBarang.csv");

    @FXML
    void Bayar(ActionEvent event) {
        Parent root;
        String EMAIL = email;
        iniEmail = email;
        String id = Integer.toString(dataPembelian.size() + 1);
        String name = nama;
        String biaya = totalBayar;
        String jumlah = Integer.toString(stokBeli);
        String asal = alamat;
        int stokBarang = 0;

        int uang = 0;
        int totalBiaya = Integer.parseInt(biaya);

        for (int i = 0; i < dataUser.size(); i++) {
            String eMail = dataUser.get(i).getEmail();
            if (eMail.equals(email)) {
                uang = dataUser.get(i).getSaldo();
            }
        }

        for (int i = 0; i < dataBarang.size(); i++) {
            String namaBarang = dataBarang.get(i).getNamaBarang();

            if (namaBarang.equals(name)) {
                stokBarang = Integer.parseInt(dataBarang.get(i).getStok());
            }
        }

        boolean saldo = checkSaldo.isSelected();
        boolean COD = checkCOD.isSelected();
        CSVWriter writerUser = new CSVWriter();
        CSVWriterBarang writerBarang = new CSVWriterBarang();

        if (saldo) {
            metodePembayaran = "Saldo";

            if (uang > totalBiaya) {
                int kembalian = uang - totalBiaya;
                stokSisa = stokBarang - stokBeli;

                for (int i = 0; i < dataUser.size(); i++) {
                    String eMAIL = dataUser.get(i).getEmail();

                    if (eMAIL.equals(email)) {
                        dataUser.get(i).setSaldo(kembalian);
                        writerUser.simpanData(dataUser,
                                "C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataLogin.csv");

                        for (int j = 0; j < dataBarang.size(); j++) {
                            String namaBarang = dataBarang.get(j).getNamaBarang();
                            if (namaBarang.equals(name)) {
                                dataBarang.get(j).setStok(String.valueOf(stokSisa));
                                writerBarang.simpanData(dataBarang,
                                        "C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataBarang.csv");
                            }
                        }

                        dataPembelian.add(new ModelPembelian(EMAIL, id, name, biaya, jumlah, asal, metodePembayaran));
                        writer.simpanData(dataPembelian,
                                "C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataPembelian.csv");
                        try {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("TampilanStrukPembelian.fxml"));
                            ControllerStrukPembelian struk = new ControllerStrukPembelian();
                            struk.stokSisa = stokSisa;
                            struk.EMAIL = iniEmail;
                            struk.stokFinal = stokBeli;
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
                }
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Peringatan");
                alert.setHeaderText(null);
                alert.setContentText("Uang tidak cukup, isi kembali saldo anda");
                alert.showAndWait();
            }

        } else if (COD) {
            metodePembayaran = "COD";
            dataPembelian.add(new ModelPembelian(EMAIL, id, name, biaya, jumlah, asal, metodePembayaran));
            writer.simpanData(dataPembelian,
                    "C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataPembelian.csv");
            try {
                System.out.println(iniEmail);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("TampilanStrukPembelian.fxml"));
                ControllerStrukPembelian struk = new ControllerStrukPembelian();
                struk.stokSisa = stokSisa;
                struk.EMAIL = iniEmail;
                struk.stokFinal = stokBeli;
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
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Peringatan");
            alert.setHeaderText(null);
            alert.setContentText("Pilih salah satu dari metode pembayaran");
            alert.showAndWait();
        }
    }

    @FXML
    void back(ActionEvent event) {
        Parent root;

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TampilanBeli.fxml"));
            ControllerBeli.email = email;
            ControllerBeli.iD = iD;
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
        ((Parent) event.getSource()).getScene().getWindow().hide();// close currentstage
    }
}
