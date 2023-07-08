import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ControllerStrukPembelian implements Initializable {

    @FXML
    private Button btnBarangSampai;

    @FXML
    private ImageView imgBarang;
    @FXML
    private ImageView imgBacktoHome;

    @FXML
    private Label lblAlamat;

    @FXML
    private Label lblDeskripsi;

    @FXML
    private Label lblHargaAsli;

    @FXML
    private Label lblHargaTotal;

    @FXML
    private Label lblJumlahBeli;

    @FXML
    private Label lblNama;

    public ControllerStrukPembelian() {

    }

    public static String hargaTotal;
    public static int iD;
    public static int stokFinal;
    ModelBarang barang;
    ArrayList<ModelBarang> dataInfoBarang = new CSVReaderBarang()
            .readCSVFile("C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataBarang.csv");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        ModelBarang barangtemp = new ModelBarang();

        for (int i = 0; i < dataInfoBarang.size(); i++) {
            int id = dataInfoBarang.get(i).getID();

            if (id == iD) {
                barangtemp.setKategori(dataInfoBarang.get(i).getKategori());
                barangtemp.setNamaBarang(dataInfoBarang.get(i).getNamaBarang());
                barangtemp.setHarga("Rp " + dataInfoBarang.get(i).getHarga());
                barangtemp.setDeskripsi(dataInfoBarang.get(i).getDeskripsi());
                barangtemp.setStok(dataInfoBarang.get(i).getStok());
                barangtemp.setImage(dataInfoBarang.get(i).getImage());
                barangtemp.setAlamat(dataInfoBarang.get(i).getAlamat());

                String stok = Integer.toString(stokFinal);

                // dataInfoBarang.add(new ModelBarang(id, kategori, nama, harga, stok,
                // deskripsi, image));
                lblNama.setText(barangtemp.getNamaBarang());
                lblHargaAsli.setText(barangtemp.getHarga());
                lblDeskripsi.setText(barangtemp.getDeskripsi());
                lblAlamat.setText(barangtemp.getAlamat());
                lblJumlahBeli.setText(stok);
                lblHargaTotal.setText(hargaTotal);
                try {
                    File file = new File(barangtemp.getImage());
                    FileInputStream file1;
                    file1 = new FileInputStream(file);
                    Image image1 = new Image(file1);
                    imgBarang.setImage(image1);
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                barang = barangtemp;
            }
        }
    }

    @FXML
    void KonfirmasiBarangSampai(ActionEvent event) {

    }

    @FXML
    void BacktoHome(MouseEvent event) {

    }

}
