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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ControllerSearch implements Initializable {

    @FXML
    private Button btnBack;

    @FXML
    private Button btnPick;

    @FXML
    private Button btnSearch;

    @FXML
    private ChoiceBox<String> choiceKategori;

    @FXML
    private TableView<ModelBarang> tableView;

    String[] kategori = new String[] { "Barang Elektronik", "Otomotif", "Barang Rumah tangga" };
    ArrayList<ModelBarang> dataBarang = new CSVReaderBarang()
            .readCSVFile("C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataBarang.csv");

    public void initialize(URL location, ResourceBundle resources) {

        TableColumn<ModelBarang, String> column0 = new TableColumn<>("ID");
        column0.setCellValueFactory(
                new PropertyValueFactory<>("ID"));
        TableColumn<ModelBarang, String> column1 = new TableColumn<>("kategori");
        column1.setCellValueFactory(
                new PropertyValueFactory<>("kategori"));

        TableColumn<ModelBarang, String> column2 = new TableColumn<>("Nama Barang");
        column2.setCellValueFactory(
                new PropertyValueFactory<>("namaBarang"));

        TableColumn<ModelBarang, String> column3 = new TableColumn<>("harga");
        column3.setCellValueFactory(
                new PropertyValueFactory<>("harga"));

        TableColumn<ModelBarang, String> column4 = new TableColumn<>("stok");
        column4.setCellValueFactory(
                new PropertyValueFactory<>("stok"));

        TableColumn<ModelBarang, String> column5 = new TableColumn<>("alamat");
        column5.setCellValueFactory(
                new PropertyValueFactory<>("alamat"));

        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(column3);
        tableView.getColumns().add(column4);
        tableView.getColumns().add(column5);
        refresh();

        choiceKategori.getItems().addAll(kategori);
    }

    public static String email;

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

    public void refresh() {
        tableView.getItems().clear(); // Menghapus semua item dalam tabel
        for (int i = 0; i < dataBarang.size(); i++) {
            tableView.getItems().add(
                    dataBarang.get(i));
        }

    }

    @FXML
    void pick(ActionEvent event) {
        int selectedID = tableView.getSelectionModel().getSelectedIndex();
        int id = dataBarang.get(selectedID).getID();

        for (int i = 0; i < dataBarang.size(); i++) {
            int identitas = dataBarang.get(i).getID();
            if (id == identitas) {
                Parent root;
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("TampilanInfoBarang.fxml"));
                    ControllerInfoBarang info = new ControllerInfoBarang();
                    info.email = email;
                    info.iD = id;
                    // loader.setController(info);
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
    }

    @FXML
    void search(ActionEvent event) {
        String katag = choiceKategori.getValue();
        if (katag.equalsIgnoreCase("Barang Elektronik")) {
            tableView.getItems().clear(); // Menghapus semua item dalam tabel
            for (int i = 0; i < dataBarang.size(); i++) {
                if (katag.equalsIgnoreCase(dataBarang.get(i).getKategori())) {
                    tableView.getItems().add(
                            dataBarang.get(i));
                }

            }

        } else if (katag.equalsIgnoreCase("Otomotif")) {
            tableView.getItems().clear(); // Menghapus semua item dalam tabel
            for (int i = 0; i < dataBarang.size(); i++) {
                if (katag.equalsIgnoreCase(dataBarang.get(i).getKategori())) {
                    tableView.getItems().add(
                            dataBarang.get(i));
                }
            }
        } else {
            tableView.getItems().clear(); // Menghapus semua item dalam tabel
            for (int i = 0; i < dataBarang.size(); i++) {
                if (katag.equalsIgnoreCase(dataBarang.get(i).getKategori())) {
                    tableView.getItems().add(
                            dataBarang.get(i));
                }
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
