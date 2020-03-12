import control.MainWindow;
import control.Walking;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class MainApp extends Application {
    Scanner sc = new Scanner(System.in);
    String fxml;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        System.out.println("1. Pilota");
        System.out.println("2. Walking");
        int op = sc.nextInt();
        FXMLLoader loader;
        if(op==1) {
            fxml = "fxml/mainWindow.fxml";

        } else {
            fxml = "fxml/walking.fxml";
        }
        loader = new FXMLLoader(getClass().getClassLoader().getResource(fxml));
        loader.setResources(ResourceBundle.getBundle("bundles.mybundle", new Locale("ca")));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene sc = new Scene(root);

        if(op==1){
            MainWindow window = loader.getController();
            window.setScene(sc);
        }else {
            Walking walking = loader.getController();
            walking.setScene(sc);
        }


        stage.setScene(sc);
        stage.setTitle("Rebota");
        stage.show();

    }
}
