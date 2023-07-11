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

public class ControllerPenjualan implements Initializable {

    @FXML
    private Button btnBack;

    @FXML
    private TableView<ModelPenjualan> tableView;
    public static String email;
    ArrayList<ModelPenjualan> dataPenjualan = new CSVReaderPenjualan()
            .readCSVFile("C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataPenjualan.csv");

    public void initialize(URL location, ResourceBundle resources) {

        TableColumn<ModelPenjualan, String> column0 = new TableColumn<>("ID");
        column0.setCellValueFactory(
                new PropertyValueFactory<>("ID"));
        TableColumn<ModelPenjualan, String> column1 = new TableColumn<>("kategori");
        column1.setCellValueFactory(
                new PropertyValueFactory<>("kategori"));

        TableColumn<ModelPenjualan, String> column2 = new TableColumn<>("Nama Barang");
        column2.setCellValueFactory(
                new PropertyValueFactory<>("namaBarang"));

        TableColumn<ModelPenjualan, String> column3 = new TableColumn<>("harga");
        column3.setCellValueFactory(
                new PropertyValueFactory<>("harga"));

        TableColumn<ModelPenjualan, String> column4 = new TableColumn<>("stok");
        column4.setCellValueFactory(
                new PropertyValueFactory<>("stok"));

        TableColumn<ModelPenjualan, String> column5 = new TableColumn<>("alamat");
        column5.setCellValueFactory(
                new PropertyValueFactory<>("alamat"));

        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(column3);
        tableView.getColumns().add(column4);
        tableView.getColumns().add(column5);

        refresh();
    }

    @FXML
    void back(ActionEvent event) {
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

    public void refresh() {
        tableView.getItems().clear(); // Menghapus semua item dalam tabel
        for (int i = 0; i < dataPenjualan.size(); i++) {
            String EMAIL = dataPenjualan.get(i).getEmail();
            if (EMAIL.equals(email)) {
                tableView.getItems().add(
                        dataPenjualan.get(i));
            }

        }

    }
}
