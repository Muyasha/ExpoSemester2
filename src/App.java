import java.io.IOException;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class App extends Application {
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        showSplash();

        // showNextScene();
    }

    private void showSplash() {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("TampilanSplash.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("THRIFTSHOP");
            primaryStage.setScene(scene);
            primaryStage.show();

            PauseTransition splashScreenDelay = new PauseTransition(Duration.seconds(2)); // Mengatur durasi
            // tampilan splash screen
            // selama 3 detik
            splashScreenDelay.setOnFinished(event -> showNextScene());
            splashScreenDelay.play();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void showNextScene() {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("TampilanLogin.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("THRIFTSHOP");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
