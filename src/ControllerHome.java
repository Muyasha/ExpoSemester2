import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ControllerHome {

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
    private Pane paneBecomePenjual;
    @FXML
    private Pane paneBrng1;
    @FXML
    private Pane paneBrng2;
    @FXML
    private Pane paneBrng3;
    @FXML
    private Pane paneBrng4;
    @FXML
    private Pane paneBrng5;

    ArrayList<ModelBarang> dataBarang = new CSVReaderBarang()
            .readCSVFile("C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataBarang.csv");
    ArrayList<String> dataNamaBarang = new ArrayList<>();
    ArrayList<String> dataHargaBarang = new ArrayList<>();
    ArrayList<String> dataImageBarang = new ArrayList<>();
    ArrayList<Integer> dataIdBarang = new ArrayList<>();

    private int iD;
    private String nama;
    private String namaBarang;
    private String harga;

    ModelUser user;
    public static String email;

    ArrayList<ModelUser> dataUser = new CSVReader()
            .readCSVFile("C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataLogin.csv");

    @FXML
    void becomePenjual(MouseEvent event) {
        Parent root;

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TampilanTambahBarang.fxml"));
            ControllerTambahBarang.email = email;
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
    void toBrngRT(MouseEvent event) {

    }

    public ControllerHome() {
        for (int i = 0; i < dataUser.size(); i++) {
            String eMAIL = dataUser.get(i).getEmail();

            if (eMAIL.equals(email)) {
                nama = dataUser.get(i).getUsername();
            }
        }

        for (ModelBarang i : dataBarang) {
            dataNamaBarang.add(i.getNamaBarang());
            dataHargaBarang.add("Rp " + i.getHarga());
            dataImageBarang.add(i.getImage());
            dataIdBarang.add(i.getID());
        }

    }

    public void initialize() {
        for (int i = 0; i < dataUser.size(); i++) {
            ModelUser usertemp = new ModelUser();
            String eMail = dataUser.get(i).getEmail();
            if (eMail.equals(email)) {
                usertemp.setUsername(dataUser.get(i).getUsername());
                nama = usertemp.getUsername();

                labelUsername.setText("Welcome, " + nama + "!");
            }
            user = usertemp;
        }

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
            Image image1 = new Image(file1);
            imgBrng1.setImage(image1);

            File b = new File(dataBarang.get(1).getImage());
            FileInputStream file2 = new FileInputStream(b);
            Image image2 = new Image(file2);
            imgBrng2.setImage(image2);

            File c = new File(dataBarang.get(2).getImage());
            FileInputStream file3 = new FileInputStream(c);
            Image image3 = new Image(file3);
            imgBrng3.setImage(image3);

            File d = new File(dataBarang.get(3).getImage());
            FileInputStream file4 = new FileInputStream(d);
            Image image4 = new Image(file4);
            imgBrng4.setImage(image4);

            File e = new File(dataBarang.get(4).getImage());
            FileInputStream file5 = new FileInputStream(e);
            Image image5 = new Image(file5);
            imgBrng5.setImage(image5);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    void showBrng1(MouseEvent event) {
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TampilanInfoBarang.fxml"));
            ControllerInfoBarang info = new ControllerInfoBarang();
            info.email = email;
            info.iD = 1;

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

    @FXML
    void showBrng2(MouseEvent event) {
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TampilanInfoBarang.fxml"));
            ControllerInfoBarang info = new ControllerInfoBarang();
            info.email = email;
            info.iD = 2;
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

    @FXML
    void showBrng3(MouseEvent event) {
        Parent root;

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TampilanInfoBarang.fxml"));
            ControllerInfoBarang info = new ControllerInfoBarang();
            info.email = email;
            info.iD = 3;
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

    @FXML
    void showBrng4(MouseEvent event) {
        Parent root;

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TampilanInfoBarang.fxml"));
            ControllerInfoBarang info = new ControllerInfoBarang();
            info.email = email;
            info.iD = 4;
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

    @FXML
    void showBrng5(MouseEvent event) {
        Parent root;

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TampilanInfoBarang.fxml"));
            ControllerInfoBarang info = new ControllerInfoBarang();
            info.email = email;
            info.iD = 5;
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

    @FXML
    private void nonBtnClick(ActionEvent event) {
        ((Parent) event.getSource()).getScene().getWindow().hide();// closecurrentstage
    }

    @FXML
    private void nonBtnClick(MouseEvent event) {
        ((Parent) event.getSource()).getScene().getWindow().hide();// closecurrentstage
    }
}
