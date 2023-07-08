import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import java.awt.image.BufferedImage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

public class ControllerTambahBarang implements Initializable {

    @FXML
    private Button btnInputImage;

    @FXML
    private Button btnJualBarang;

    @FXML
    private Button btnSaveImage;

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

    ArrayList<ModelPenjualan> dataPenjualan = new CSVReaderPenjualan()
            .readCSVFile("C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataPenjualan.csv");
    String[] daftarKategori = new String[] { "Otomotif", "Barang Elektronik", "Barang Rumah Tangga" };
    ArrayList<String> daftarAlamat = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceKategori.getItems().addAll(daftarKategori);
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
            imgBarang.setImage(image);
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

    @FXML
    void jualBarang(ActionEvent event) {
        String nama = tfNama.getText();
        String harga = tfHarga.getText();
        String stok = tfHarga.getText();
        String deskripsi = tfDeskripsi.getText();
        String kategori = choiceKategori.getValue();
        String alamat = choiceAlamat.getValue();

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
}
