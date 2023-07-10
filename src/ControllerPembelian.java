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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ControllerPembelian implements Initializable {

        @FXML
        private Button btnBack;

        @FXML
        private Button btnKonfirmasi;

        @FXML
        private TableView<ModelPembelian> tableView;

        @FXML
        private TextField tfKonfirmasi;

        public static String email;

        ArrayList<ModelPembelian> dataPembelian = new CSVReaderPembelian()
                        .readCSVFile("C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataPembelian.csv");

        public void initialize(URL location, ResourceBundle resources) {
                refresh();
                TableColumn<ModelPembelian, String> column0 = new TableColumn<>("Email");
                column0.setCellValueFactory(
                                new PropertyValueFactory<>("email"));
                TableColumn<ModelPembelian, String> column1 = new TableColumn<>("Nomor");
                column1.setCellValueFactory(
                                new PropertyValueFactory<>("iD"));

                TableColumn<ModelPembelian, String> column2 = new TableColumn<>("Nama Barang");
                column2.setCellValueFactory(
                                new PropertyValueFactory<>("namaBarang"));

                TableColumn<ModelPembelian, String> column3 = new TableColumn<>("Biaya");
                column3.setCellValueFactory(
                                new PropertyValueFactory<>("biayaPembelian"));

                TableColumn<ModelPembelian, String> column4 = new TableColumn<>("Jumlah");
                column4.setCellValueFactory(
                                new PropertyValueFactory<>("jumlahBeliBarang"));

                TableColumn<ModelPembelian, String> column5 = new TableColumn<>("asal");
                column5.setCellValueFactory(
                                new PropertyValueFactory<>("asalBarang"));

                tableView.getColumns().add(column0);
                tableView.getColumns().add(column1);
                tableView.getColumns().add(column2);
                tableView.getColumns().add(column3);
                tableView.getColumns().add(column4);
                tableView.getColumns().add(column5);

                refresh();

        }

        @FXML
        void Konfirmasi(ActionEvent event) {

        }

        @FXML
        void back(ActionEvent event) {
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

        public void refresh() {
                tableView.getItems().clear(); // Menghapus semua item dalam tabel
                for (int i = 0; i < dataPembelian.size(); i++) {
                        String EMAIL = dataPembelian.get(i).getEmail();
                        if (EMAIL.equals(email)) {
                                tableView.getItems().add(
                                                dataPembelian.get(i));
                        }

                }

        }

        public int cariBarang(String namaBarang) {
                int indexKetemu = -1;
                for (ModelPembelian i : dataPembelian) {
                        if (namaBarang.equals(i.getNamaBarang())) {
                                indexKetemu = dataPembelian.indexOf(i);
                        }
                }
                return indexKetemu;
        }

        // public void hapusMahasiswa(int idMahasiswa) {
        // daftarMahasiswa.remove(cariMahasiswa(idMahasiswa));
        // // TODO Auto-generated method stub

        // }

        @FXML
        private void nonBtnClick(ActionEvent event) {
                ((Parent) event.getSource()).getScene().getWindow().hide();// closecurrentstage
        }

        @FXML
        private void nonBtnClick(MouseEvent event) {
                ((Parent) event.getSource()).getScene().getWindow().hide();// closecurrentstage
        }

}
