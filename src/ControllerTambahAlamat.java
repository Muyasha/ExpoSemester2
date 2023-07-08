import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControllerTambahAlamat implements Initializable {

    @FXML
    private Button btnBack;

    @FXML
    private Button btnHapus;

    @FXML
    private Button btnTambah;

    @FXML
    private Button btnTambahAlamat;

    @FXML
    private TableColumn<ModelAlamat, String> tabelAlamat;

    @FXML
    private TableColumn<ModelAlamat, String> tabelEmail;

    @FXML
    private TableView<ModelAlamat> tabelView;

    @FXML
    private TextField tfAddAlamat;

    @FXML
    private TextField tfHapusAlamat;

    ArrayList<ModelAlamat> daftarAlamat = new CSVReaderAlamat()
            .readCSVFile("C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataAlamat.csv");

    ArrayList<ModelUser> daftarUser = new CSVReader()
            .readCSVFile("C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataLogin.csv");

    public void initialize(URL location, ResourceBundle resources) {
        tabelEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tabelAlamat.setCellValueFactory(new PropertyValueFactory<>("alamat"));

        for (int i = 0; i < daftarAlamat.size(); i++) {
            tabelView.getItems().add(new ModelAlamat(daftarAlamat.get(i).getEmail(), daftarAlamat.get(i).getAlamat()));
        }

    }

    public static String email;

    public ControllerTambahAlamat() {

    }

    @FXML
    void AddAlamat(ActionEvent event) {
        String eMail = email;
        String alamat = tfAddAlamat.getText();

    }

    @FXML
    void HapusAlamat(ActionEvent event) {

    }

    @FXML
    void toTambahAlamat(ActionEvent event) {

    }
}
