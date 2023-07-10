import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.awt.image.BufferedImage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ControllerTambahBarang implements Initializable {

    @FXML
    private Button btnInputImage;

    @FXML
    private Button btnJualBarang;

    @FXML
    private Button btnSaveImage;

    @FXML
    private Button btnTambahAlamat;

    @FXML
    private Label pathImage;

    @FXML
    private ChoiceBox<String> choiceKategori;

    @FXML
    private ChoiceBox<String> choiceAlamat;

    @FXML
    private ImageView imgBarang;

    @FXML
    private TextField tfDeskripsi;

    @FXML
    private TextField tfHarga;

    @FXML
    private TextField tfNama;

    @FXML
    private TextField tfStok;

    private File selectedImageFile;

    public static String email;

    String[] daftarKategori = new String[] { "Otomotif", "Barang Elektronik", "Barang Rumah Tangga" };
    ArrayList<ModelAlamat> daftarAlamat = new CSVReaderAlamat().readCSVFile(
            "C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataAlamat.csv",
            email);
    ArrayList<ModelBarang> daftarBarang = new CSVReaderBarang()
            .readCSVFile("C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataBarang.csv");
    ArrayList<String> dataAlamat = new ArrayList<>();

    public ControllerTambahBarang() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int i = 0; i < daftarAlamat.size(); i++) {
            dataAlamat.add(daftarAlamat.get(i).getAlamat());
        }
        choiceKategori.getItems().addAll(daftarKategori);
        choiceAlamat.getItems().addAll(dataAlamat);
    }

    @FXML
    void InputImage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Pilih Gambar");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
        selectedImageFile = fileChooser.showOpenDialog(imgBarang.getScene().getWindow());
        if (selectedImageFile != null) {
            Image image = new Image(selectedImageFile.toURI().toString());
            imagePath = selectedImageFile.getAbsolutePath();
            imagePath = imagePath.replace("\\", "/");
            imgBarang.setImage(image);
            pathImage.setText(imagePath);
        }
    }

    @FXML
    void SaveImage(ActionEvent event) {
        if (imgBarang.getImage() != null) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Simpan Gambar");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("PNG", "*.png"),
                    new FileChooser.ExtensionFilter("JPEG", "*.jpg", "*.jpeg"));
            File outputFile = fileChooser.showSaveDialog(imgBarang.getScene().getWindow());
            if (outputFile != null) {
                try {
                    BufferedImage bufferedImage = SwingFXUtils.fromFXImage(imgBarang.getImage(), null);
                    ImageIO.write(bufferedImage, "png", outputFile);
                    showSuccessDialog("Gambar berhasil disimpan.");
                } catch (IOException e) {
                    showErrorDialog("Terjadi kesalahan saat menyimpan gambar.");
                }
            }
        } else {
            showErrorDialog("Tidak ada gambar yang dipilih.");
        }
    }

    ArrayList<ModelPenjualan> dataPenjualan = new CSVReaderPenjualan()
            .readCSVFile("C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataPenjualan.csv");
    CSVWriterBarang writerBarang = new CSVWriterBarang();
    CSVWriterPenjualan writerPenjualan = new CSVWriterPenjualan();

    @FXML
    void jualBarang(ActionEvent event) {

        String EMAIL = email;
        String nama = tfNama.getText();
        String harga = tfHarga.getText();
        String stok = tfHarga.getText();
        String deskripsi = tfDeskripsi.getText();
        String kategori = choiceKategori.getValue();
        String alamat = choiceAlamat.getValue();
        String image = imagePath;

        int nomor = 0;

        int jumlahJual = dataPenjualan.size();
        int jumlahBarang = daftarBarang.size();
        int IDBarang = jumlahBarang + 1;
        int ID = jumlahJual + 1;

        if (nama == null || harga == null || stok == null || deskripsi == null || kategori == null || alamat == null
                || image == null || email == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Peringatan");
            alert.setHeaderText(null);
            alert.setContentText("Mohon Isi data dengan lengkap");
            alert.showAndWait();
        } else {

            dataPenjualan.add(new ModelPenjualan(EMAIL, ID, kategori, nama, harga, stok, deskripsi, alamat, image));
            writerPenjualan.simpanData(dataPenjualan,
                    "C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataPenjualan.csv");

            int Identitas = nomor + 1;
            daftarBarang.add(new ModelBarang(IDBarang, kategori, nama, harga, stok, deskripsi, image, alamat));
            writerBarang.simpanData(daftarBarang,
                    "C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataBarang.csv");

            Parent root;
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("TampilanInfoBarang.fxml"));
                ControllerInfoBarang info = new ControllerInfoBarang();
                info.email = email;
                info.iD = IDBarang;

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

    private void showSuccessDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sukses");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showErrorDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private String imagePath;

    public String getImagePath() {
        return imagePath;
    }

    @FXML
    void toTambahAlamat(ActionEvent event) {
        Parent root;

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TampilanTambahAlamat.fxml"));
            ControllerTambahAlamat.email = email;
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
