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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ControllerKonfirmasiPembelian implements Initializable {

    @FXML
    private Button btnBack;

    @FXML
    private Button btnSetuju;

    @FXML
    private Button btnTolak;

    @FXML
    private TableView<ModelKonfirmasiPembelian> tabelView;

    public static String email;
    public static int hargaNego;
    ArrayList<ModelKonfirmasiPembelian> dataKonfirmasi = new CSVReaderKonfirmasi()
            .readCSVFile("C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataKonfirmasi.csv");

    public ControllerKonfirmasiPembelian() {

    }

    public void initialize(URL location, ResourceBundle resources) {

        refresh();
        TableColumn<ModelKonfirmasiPembelian, String> column1 = new TableColumn<>("Pembeli");
        column1.setCellValueFactory(
                new PropertyValueFactory<>("emailPembeli"));
        TableColumn<ModelKonfirmasiPembelian, String> column2 = new TableColumn<>("nama Barang");
        column2.setCellValueFactory(
                new PropertyValueFactory<>("namaBarang"));
        TableColumn<ModelKonfirmasiPembelian, String> column3 = new TableColumn<>("Harga Asli");
        column3.setCellValueFactory(
                new PropertyValueFactory<>("hargaAsli"));
        TableColumn<ModelKonfirmasiPembelian, String> column4 = new TableColumn<>("Nego");
        column4.setCellValueFactory(
                new PropertyValueFactory<>("hargaNego"));
        TableColumn<ModelKonfirmasiPembelian, String> column5 = new TableColumn<>("Jumlah beli");
        column5.setCellValueFactory(
                new PropertyValueFactory<>("jumlahBeliBarang"));
        TableColumn<ModelKonfirmasiPembelian, String> column6 = new TableColumn<>("Biaya");
        column6.setCellValueFactory(
                new PropertyValueFactory<>("biayaBayar"));
        TableColumn<ModelKonfirmasiPembelian, String> column7 = new TableColumn<>("Metode Bayar");
        column7.setCellValueFactory(
                new PropertyValueFactory<>("metodeBayar"));
        TableColumn<ModelKonfirmasiPembelian, String> column8 = new TableColumn<>("emailmu");
        column8.setCellValueFactory(
                new PropertyValueFactory<>("emailPenjual"));

        tabelView.getColumns().add(column1);
        tabelView.getColumns().add(column2);
        tabelView.getColumns().add(column3);
        tabelView.getColumns().add(column4);
        tabelView.getColumns().add(column5);
        tabelView.getColumns().add(column6);
        tabelView.getColumns().add(column7);

        refresh();
    }

    @FXML
    void BacktoProfile(ActionEvent event) {
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TampilanProfil.fxml"));
            ControllerProfil.email = email;
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

    ArrayList<ModelUser> dataUser = new CSVReader()
            .readCSVFile("C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataLogin.csv");
    ArrayList<ModelPenjualan> dataPenjualan = new CSVReaderPenjualan()
            .readCSVFile("C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataPenjualan.csv");
    ArrayList<ModelBarang> dataBarang = new CSVReaderBarang()
            .readCSVFile("C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataBarang.csv");
    ArrayList<ModelPembelian> dataPembelian = new CSVReaderPembelian()
            .readCSVFile("C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataPembelian.csv");

    @FXML
    void Setuju(ActionEvent event) {
        int selectedIndex = tabelView.getSelectionModel().getSelectedIndex();
        writer.simpanData(dataKonfirmasi, "C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataKonfirmasi.csv");
        int stokBarang = 0;
        String emailPembeliBarang = dataKonfirmasi.get(selectedIndex).getEmailPembeli();
        int totalBiaya = dataKonfirmasi.get(selectedIndex).getBiayaBayar();
        String namaBarangKonfirmasi = dataKonfirmasi.get(selectedIndex).getNamaBarang();
        int stokSisa;

        for (int index = 0; index < dataPenjualan.size(); index++) {
            String EMAIL = dataPenjualan.get(index).getEmail();
            if (EMAIL.equals(email)) {
                String namaBarang = dataPenjualan.get(index).getNamaBarang();
                if (namaBarang.equals(namaBarangKonfirmasi)) {
                    stokBarang = Integer.parseInt(dataPenjualan.get(index).getStok());
                }
            }
        }

        int stokBeli = dataKonfirmasi.get(selectedIndex).getJumlahBeliBarang();
        int uang = 0;

        for (int i = 0; i < dataUser.size(); i++) {
            String eMail = dataUser.get(i).getEmail();
            if (eMail.equals(email)) {
                uang = dataUser.get(i).getSaldo();
            }
        }

        // Set kembalian pembeli
        int kembalian = uang - totalBiaya;
        stokSisa = stokBarang - stokBeli;
        for (int index = 0; index < dataUser.size(); index++) {
            String emailPembeli = dataUser.get(index).getEmail();
            if (emailPembeli.equals(emailPembeliBarang)) {
                dataUser.get(index).setSaldo(kembalian);
                writerUser.simpanData(dataUser,
                        "C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataLogin.csv");
            }
        }

        // set stok setelah barang dibeli di data barang
        String asalBarang = "";
        for (int index = 0; index < dataBarang.size(); index++) {
            String emailPenjual = dataBarang.get(index).getEmailPenjual();
            String namaBarang = dataBarang.get(index).getNamaBarang();
            asalBarang = dataBarang.get(index).getAlamat();
            if (emailPenjual.equals(email) && namaBarang.equals(namaBarangKonfirmasi)) {
                dataBarang.get(index).setStok(String.valueOf(stokSisa));
                if (stokSisa == 0) {
                    dataBarang.remove(index);
                }
                writerBarang.simpanData(dataBarang,
                        "C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataBarang.csv");

            }
        }

        // set stok setelah barang dibeli di data barang
        for (int index = 0; index < dataPenjualan.size(); index++) {
            String emailPenjual = dataPenjualan.get(index).getEmail();
            String namaBarang = dataPenjualan.get(index).getNamaBarang();
            asalBarang = dataPenjualan.get(index).getAlamat();
            if (emailPenjual.equals(email) && namaBarang.equals(namaBarangKonfirmasi)) {
                dataPenjualan.get(index).setStok(String.valueOf(stokSisa));
                if (stokSisa == 0) {
                    dataPenjualan.remove(index);
                }
                writerPenjualan.simpanData(dataPenjualan,
                        "C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataPenjualan.csv");

            }
        }

        String metodeBayar;
        metodeBayar = dataKonfirmasi.get(selectedIndex).getMetodeBayar();
        selectedIndex = tabelView.getSelectionModel().getSelectedIndex();
        dataKonfirmasi.remove(selectedIndex);
        tabelView.getItems().remove(selectedIndex);
        writer.simpanData(dataKonfirmasi, "C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataKonfirmasi.csv");

        int nomor = 0;
        for (int index = 0; index <= dataPembelian.size(); index++) {
            nomor += 1;
        }

        dataPembelian.add(new ModelPembelian(emailPembeliBarang, String.valueOf(nomor), namaBarangKonfirmasi,
                String.valueOf(totalBiaya), String.valueOf(stokBeli),
                asalBarang, metodeBayar));
        writerPembelian.simpanData(dataPembelian,
                "C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataPembelian.csv");

        refresh();

        // for (int j = 0; j < dataBarang.size(); j++) {
        // String namaBarang = dataBarang.get(j).getNamaBarang();
        // if (namaBarang.equals(name)) {
        // dataBarang.get(j).setStok(String.valueOf(stokSisa));
        // writerBarang.simpanData(dataBarang,
        // "C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataBarang.csv");
        // }

        // dataPembelian.add(new ModelPembelian(EMAIL, id, name, biaya, jumlah, asal,
        // metodePembayaran));
        // writer.simpanData(dataPembelian,
        // "C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataPembelian.csv");
    }

    CSVWriterKonfirmasi writer = new CSVWriterKonfirmasi();
    CSVWriter writerUser = new CSVWriter();
    CSVWriterBarang writerBarang = new CSVWriterBarang();
    CSVWriterPembelian writerPembelian = new CSVWriterPembelian();
    CSVWriterPenjualan writerPenjualan = new CSVWriterPenjualan();
    int identitas = 0;

    @FXML
    void Tolak(ActionEvent event) {
        int selectedIndex = tabelView.getSelectionModel().getSelectedIndex();
        dataKonfirmasi.remove(selectedIndex);
        tabelView.getItems().remove(selectedIndex);
        writer.simpanData(dataKonfirmasi, "C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataKonfirmasi.csv");
    }

    public void refresh() {
        tabelView.getItems().clear(); // Menghapus semua item dalam tabel
        for (int i = 0; i < dataKonfirmasi.size(); i++) {
            String EMAIL = dataKonfirmasi.get(i).getEmailPenjual();
            if (EMAIL.equals(email)) {
                tabelView.getItems().add(
                        dataKonfirmasi.get(i));
            }

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
