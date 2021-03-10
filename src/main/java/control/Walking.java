package control;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import sprites.Ninot;

import java.net.URL;
import java.util.ResourceBundle;

public class Walking implements Initializable {
    @FXML
    Canvas mainCanvas;

    private Scene scene;
    private Ninot ninot;
    private GraphicsContext gc;
    private String s = getClass().getClassLoader().getResource("sounds/pssst.wav").toExternalForm();
    private Media sound = new Media(s);
    private MediaPlayer audioClip = new MediaPlayer(sound);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gc = mainCanvas.getGraphicsContext2D();
        gc.setFill(Color.RED);

        System.out.println("duració:" + sound.getDuration().toString() + " loc:" + sound.getSource());
        audioClip.setCycleCount(MediaPlayer.INDEFINITE);


        ninot = new Ninot();
        ninot.setImage(new Image("images/walking.png"));


    }
    public void setScene(Scene sc) {
        scene = sc;
        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Point2D point = new Point2D(mouseEvent.getX(), mouseEvent.getY());
                System.out.println("click");
            }
        });

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                System.out.println(keyEvent.getCode().toString());
                ninot.clear(gc);
                ninot.setDirection(keyEvent.getCode().toString());
                ninot.render(gc);
                audioClip.play();

            }
        });

        scene.setOnKeyReleased(keyEvent -> audioClip.stop());
    }
}
