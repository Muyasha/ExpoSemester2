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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ControllerTambahAlamat implements Initializable {

    @FXML
    private Button btnBack;

    @FXML
    private Button btnHapus;

    @FXML
    private Button btnTambah;

    @FXML
    private Button btnSave;

    @FXML
    private TableColumn<ModelAlamat, String> tabelAlamat;

    @FXML
    private TableColumn<ModelAlamat, String> tabelNomor;

    @FXML
    private TableView<ModelAlamat> tabelView;

    @FXML
    private TextField tfAddAlamat;

    @FXML
    private TextField tfHapusAlamat;

    int nomor = 0;

    ArrayList<ModelAlamat> daftarAlamat = new CSVReaderAlamat()
            .readCSVFile("C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataAlamat.csv", email);

    ArrayList<ModelUser> daftarUser = new CSVReader()
            .readCSVFile("C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataLogin.csv");

    public void initialize(URL location, ResourceBundle resources) {

        tabelNomor.setCellValueFactory(new PropertyValueFactory<>("nomor"));
        tabelAlamat.setCellValueFactory(new PropertyValueFactory<>("alamat"));
        for (int i = 0; i < daftarAlamat.size(); i++) {

            String EMAIL = daftarAlamat.get(i).getEmail();

            if (EMAIL.equals(email)) {
                String alamat = tfAddAlamat.getText();
                nomor = nomor + 1;

                tabelView.getItems()
                        .add(new ModelAlamat(daftarAlamat.get(i).getNomor(), daftarAlamat.get(i).getAlamat()));
            }

        }

    }

    public static String email;
    CSVWriterAlamat writer = new CSVWriterAlamat();

    public ControllerTambahAlamat() {

    }

    @FXML
    void AddAlamat(ActionEvent event) {
        String eMail = email;
        String alamat = tfAddAlamat.getText();

        for (int i = 0; i <= daftarAlamat.size(); i++) {
            if (daftarAlamat.isEmpty()) {
                nomor += 1;
                daftarAlamat.add(new ModelAlamat(eMail, nomor, alamat));
                writer.simpanData(daftarAlamat,
                        "C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataAlamat.csv");
                tfAddAlamat.setText("");
                break;
            }
            if (daftarAlamat.get(i).getAlamat().equalsIgnoreCase(alamat)) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Peringatan");
                alert.setHeaderText(null);
                alert.setContentText("Alamat telah ada di daftar");
                alert.showAndWait();
                break;
            } else {
                nomor += 1;
                daftarAlamat.add(new ModelAlamat(eMail, nomor, alamat));
                writer.simpanData(daftarAlamat,
                        "C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataAlamat.csv");

                break;
            }
        }

        if (daftarAlamat.isEmpty()) {
            nomor += 1;
            daftarAlamat.add(new ModelAlamat(eMail, nomor, alamat));
        }

        refresh();
    }

    @FXML
    void HapusAlamat(ActionEvent event) {
        int nomorHapus = Integer.parseInt(tfHapusAlamat.getText());
        for (int i = 0; i <=daftarAlamat.size(); i++) {
            if (nomorHapus == daftarAlamat.get(i).getNomor()) {
                nomor = cariMahasiswa(nomorHapus);

                // daftarMahasiswa.hapusMahasiswa(indexHapus);
                hapusMahasiswa(nomorHapus-1);
                refresh();
                break;
            }
        }

    }

    @FXML
    void Save(ActionEvent event) {

    }

    public void refresh() {
        int nomor = 0;
        tabelView.getItems().clear(); // Menghapus semua item dalam tabel
        for (int i = 0; i < daftarAlamat.size(); i++) {

            String EMAIL = daftarAlamat.get(i).getEmail();

            if (EMAIL.equals(email)) {
                nomor += 1;
                String alamat = tfAddAlamat.getText();
                tabelView.getItems()
                        .add(new ModelAlamat(daftarAlamat.get(i).getNomor(), daftarAlamat.get(i).getAlamat()));
            }
        }

    }

    public void hapusMahasiswa(int index) {
        daftarAlamat.remove(index);
        writer.simpanData(daftarAlamat, "C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataAlamat.csv");
        // TODO Auto-generated method stub

    }

    public int cariMahasiswa(int no) {
        int indexKetemu = 0;
        for (int i = 0; i < daftarAlamat.size(); i++) {
            if (daftarAlamat.get(i).getNomor() == no)
                indexKetemu = daftarAlamat.indexOf(daftarAlamat.get(i));

        }
        return indexKetemu;
    }

    @FXML
    void Back(ActionEvent event) throws IOException {
        Parent root;
        ControllerHome.email = email;
        // loader.setController(home);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("TampilanHome.fxml"));
        root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.show();

        nonBtnClick(event);
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
