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
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ControllerProfil implements Initializable {

    @FXML
    private Button btnAlamat;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnLihatPembelian;

    @FXML
    private Button btnLihatPenjualan;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblNama;

    @FXML
    private Label lblNomor;

    @FXML
    private Label lblSaldo;

    public static String email;
    ArrayList<ModelUser> dataUser = new CSVReader()
            .readCSVFile("C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataLogin.csv");
    private String nama;
    private String noHP;
    int saldo;

    public void initialize(URL location, ResourceBundle resources) {
        for (int i = 0; i < dataUser.size(); i++) {
            ModelUser usertemp = new ModelUser();
            String eMail = dataUser.get(i).getEmail();
            if (eMail.equals(email)) {
                usertemp.setUsername(dataUser.get(i).getUsername());
                usertemp.setNoHP(dataUser.get(i).getNoHP());
                usertemp.setSaldo(dataUser.get(i).getSaldo());
                saldo = usertemp.getSaldo();
                String saldoSt = Integer.toString(saldo);
                noHP = usertemp.getNoHP();
                nama = usertemp.getUsername();

                lblEmail.setText(eMail);
                lblNama.setText(nama);
                lblNomor.setText(noHP);
                lblSaldo.setText(saldoSt);

            }
        }
    }

    @FXML
    void LihatPenjualan(ActionEvent event) {
        Parent root;

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TampilanPenjualan.fxml"));
            ControllerPenjualan.email = email;
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
    void lihatPembelian(ActionEvent event) {
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TampilanPembelian.fxml"));
            ControllerPembelian.email = email;

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
    void toAlamat(ActionEvent event) {
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TampilanTambahAlamat.fxml"));
            ControllerTambahAlamat.email = email;

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

}
