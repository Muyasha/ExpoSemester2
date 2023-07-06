import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ControllerHome {

    ArrayList<ModelBarang> dataBarang = new CSVReaderBarang()
            .readCSVFile("C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataBarang.csv");
    ArrayList<String> dataNamaBarang = new ArrayList<>();
    ArrayList<String> dataHargaBarang = new ArrayList<>();
    ArrayList<String> dataImageBarang = new ArrayList<>();

    @FXML
    private Label hargaBrng1;

    @FXML
    private Label hargaBrng2;

    @FXML
    private Label hargaBrng3;

    @FXML
    private Label hargaBrng4;

    @FXML
    private Label hargaBrng5;

    @FXML
    private ImageView imgBrng1;

    @FXML
    private ImageView imgBrng2;

    @FXML
    private ImageView imgBrng3;

    @FXML
    private ImageView imgBrng4;

    @FXML
    private ImageView imgBrng5;

    @FXML
    private Label labelUsername;

    @FXML
    private Label lblBrngElektronik;

    @FXML
    private Label lblBrngOtomotif;

    @FXML
    private Label lblBrngRT;

    @FXML
    private Label nameBrng1;

    @FXML
    private Label nameBrng2;

    @FXML
    private Label nameBrng3;

    @FXML
    private Label nameBrng4;

    @FXML
    private Label nameBrng5;

    @FXML
    private TextField tfSearch;

    @FXML
    void toBrngELektronik(MouseEvent event) {
        Parent root;

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TampilanSignIn.fxml"));
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
    void toBrngOtomotif(MouseEvent event) {

    }

    @FXML
    void toBrngRT(MouseEvent event) {

    }

    private String nama;
    private String namaBarang;
    private String harga;

    ArrayList<ModelUser> dataUser = new CSVReader()
            .readCSVFile("C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataLogin.csv");

    public ControllerHome(String email) {
        for (int i = 0; i < dataUser.size(); i++) {
            String eMAIL = dataUser.get(i).getEmail();

            if (eMAIL.equals(email)) {
                nama = dataUser.get(i).getUsername();
            }
        }

        for (ModelBarang i : dataBarang) {
            dataNamaBarang.add(i.getNamaBarang());
            dataHargaBarang.add(i.getHarga());
            dataImageBarang.add(i.getImage());
        }

    }

    public void initialize() {
        labelUsername.setText("Welcome, " + nama + "!");

        nameBrng1.setText(dataNamaBarang.get(0));
        nameBrng2.setText(dataNamaBarang.get(1));
        nameBrng3.setText(dataNamaBarang.get(2));
        nameBrng4.setText(dataNamaBarang.get(3));
        nameBrng5.setText(dataNamaBarang.get(4));

        hargaBrng1.setText(dataHargaBarang.get(0));
        hargaBrng2.setText(dataHargaBarang.get(1));
        hargaBrng3.setText(dataHargaBarang.get(2));
        hargaBrng4.setText(dataHargaBarang.get(3));
        hargaBrng5.setText(dataHargaBarang.get(4));

        try {
            File a = new File(dataBarang.get(0).getImage());
            FileInputStream file1 = new FileInputStream(a);
            Image image = new Image(file1);
            imgBrng1.setImage(image);

            File a = new File(dataBarang.get(0).getImage());
            FileInputStream file1 = new FileInputStream(a);
            Image image = new Image(file1);
            imgBrng1.setImage(image);
            // "C:/Users/Yasir/OneDrive/Pictures/Saved Pictures/homer-simpson-homer.gif"
            // "C:/Users\Yasir\OneDrive\Pictures\Saved Pictures\homer-simpson-homer.gif"

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Image x = new Image(dataImageBarang.get(0));
        // String File = "\"C:\\Kuliah\\Semester 2\\FPA\\THRIFTSHOP\\Screenshot
        // 2023-06-30 201301.png\"";
        // InputStream is = new FileInputStream("C:\\Kuliah\\Semester
        // 2\\FPA\\THRIFTSHOP\\Screenshot 2023-06-30 201301.png");
        // String md5;
        // try {
        // md5 = UTILS.getMD5Info(is);
        // } finally {
        // is.close();
        // }

        // File file = new File("\"C:\\Kuliah\\Semester 2\\FPA\\THRIFTSHOP\\Screenshot
        // 2023-06-30 201301.png\"");

        // ImageView image = new ImageView(file.toURI().toString());

        // Image a = new Image();

        // imgBrng1.setImage(a);

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
