import control.MainWindow;
import control.Space;
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
        System.out.println("3. SpaceShip");

        int op = sc.nextInt();
        FXMLLoader loader;
        switch (op) {
            case 1: fxml = "fxml/mainWindow.fxml"; break;
            case 2: fxml = "fxml/walking.fxml"; break;
            case 3: fxml = "fxml/space.fxml"; break;
            default: fxml = "fxml/mainWindow.fxml";
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

        switch (op) {
            case 1: MainWindow window = loader.getController();
                    window.setScene(sc);
                    break;
            case 2: Walking walking = loader.getController();
                    walking.setScene(sc);
                    break;
            case 3: Space space = loader.getController();
                    space.setScene(sc);
                    break;
            default: fxml = "fxml/mainWindow.fxml";
        }

        stage.setScene(sc);
        stage.setTitle("Exemple " + op);
        stage.show();

    }
}
