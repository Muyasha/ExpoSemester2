import java.io.IOException;
import java.util.ArrayList;

import javax.swing.text.StringContent;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerChangePass {

    CSVWriter writer = new CSVWriter();
    ArrayList<ModelUser> dataUser = new CSVReader()
            .readCSVFile("C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataLogin.csv");

    @FXML
    private Button btnLogin;

    @FXML
    private Hyperlink linkLogin;

    @FXML
    private Hyperlink linkSignIn;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfPassword;

    private boolean isChangingPass(String email, String pass) {
        for (int i = 0; i < dataUser.size(); i++) {
            String eMAIL = dataUser.get(i).getEmail();
            if (eMAIL.equals(email)) {
                dataUser.get(i).setPassword(pass);
                return true;
            }
        }
        return false;

    }

    @FXML
    void changePassword(ActionEvent event) {
        Parent root;
        String email = tfEmail.getText();
        String newPass = tfPassword.getText();

        if (isChangingPass(email, newPass)) {
            writer.simpanData(dataUser, "C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataLogin.csv");
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TampilanLogin.fxml"));
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
    void SignIn(ActionEvent event) {
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
    void toLogin(ActionEvent event) {
        Parent root;

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TampilanLogin.fxml"));
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
        ((Parent) event.getSource()).getScene().getWindow().hide();// close currentstage
    }

}
