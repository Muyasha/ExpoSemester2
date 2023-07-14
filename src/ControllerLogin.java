import java.io.IOException;
import java.util.ArrayList;

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

public class ControllerLogin {

    ArrayList<ModelUser> dataUser = new CSVReader()
            .readCSVFile("C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataLogin.csv");

    @FXML
    private Button btnLogin;

    @FXML
    private Hyperlink linkChangePass;

    @FXML
    private Hyperlink linkSignIn;

    @FXML
    private TextField tfEmail;
    String email;

    @FXML
    private PasswordField tfPassword;
    String password;

    @FXML
    void Login(ActionEvent event) {
        Parent root;
        password = tfPassword.getText();
        email = tfEmail.getText();

        try {
            if (validateLogin(email, password)) {
                System.out.println("login berhasil");
                ControllerHome.email = email;

                FXMLLoader loader = new FXMLLoader(getClass().getResource("TampilanHome.fxml"));
                root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = new Stage();

                stage.setScene(scene);
                stage.show();

                nonBtnClick(event);
            } else {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("TampilanLoginGagal.fxml"));
                root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = new Stage();

                stage.setScene(scene);
                stage.show();

                System.out.println("login gagal");
            }
        }

        catch (IOException e) {
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
    void changePass(ActionEvent event) {
        Parent root;

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TampilanChangePass.fxml"));
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

    // Untuk mengecek inputan login dengan data login
    private boolean validateLogin(String email, String password) {
        for (int i = 0; i < dataUser.size(); i++) {
            String eMAIL = dataUser.get(i).getEmail();
            String pass = dataUser.get(i).getPassword();
            if (eMAIL.equals(email) && pass.equals(password)) {
                return true;
            }
        }
        return false;
    }

    @FXML
    private void nonBtnClick(ActionEvent event) {
        ((Parent) event.getSource()).getScene().getWindow().hide();// closecurrentstage
    }

}
