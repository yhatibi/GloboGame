package control;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.util.Duration;
import sprites.Pilota;
import sprites.Ship;

import java.net.URL;
import java.util.ResourceBundle;

public class Space implements Initializable {
    private Scene scene;
    private GraphicsContext gc;
    private Ship ship;

    @FXML
    Canvas mainCanvas;

    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.0057), new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
            ship.clear(gc);
            ship.move();
            ship.render(gc);

        }
    })
    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ship = new Ship(new Image("images/invaders2.png"));
        gc = mainCanvas.getGraphicsContext2D();

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

    }

    public void setScene(Scene sc) {
        scene = sc;
    }
}
