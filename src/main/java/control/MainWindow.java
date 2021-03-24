package control;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import sprites.Globo;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

public class MainWindow implements Initializable {
    private Scene scene;
    private GraphicsContext gc;
    private Globo globo = new Globo(new Image("images/globo.png", 100, 100, false, false));
    private Globo globo1 = new Globo(new Image("images/globo.png", 100, 100, false, false));
    private Image fons;
    SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
    int contadorGlobos;
    ArrayList<Globo> globos = new ArrayList<>();

    /**
     * Opció 1: Animationtimer
     * Controlar la velocitat de moviment no és tant fàcil
     */
    private AnimationTimer animationTimer = new AnimationTimer() {
        @Override
        public void handle(long l) {
            /*globo.clear(gc);*/
            globo.move();
            globo.render(gc);
        }
    };

    /**
     * Opció 2: TimeLine
     * Controlem la velocitat de refresc amb KeyFrame.
     * Aquesta opció és molt més flexible que l'AnimationTimer
     */
    /*Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.0057), new EventHandler<>() {*/
    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.05), new EventHandler<>() {
        @Override
        public void handle(ActionEvent event) {


            if (Math.random() < 0.2)  {

                Globo globo = new Globo(new Image("images/globo.png", 100, 100, false, false));
                globos.add(globo);
            }

            gc.drawImage(fons, 0,0,1200,800);;
            Date date = new Date(System.currentTimeMillis());
            System.out.println(formatter.format(date));
            for (int i = 0; i < globos.size(); i++) {

                globos.get(i).move();
                globos.get(i).render(gc);
            }

            /*globo.move();
            globo.render(gc);

            globo1.move();
            globo1.render(gc);*/








        }
    })
    );

    @FXML
    Label lblInfo;
    @FXML
    Canvas mainCanvas;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println(url);
        System.out.println(resourceBundle.getString("key2"));

        /*globo = new Globo(new Image("images/globo.png"));*/
        fons = new Image("images/city.jpg");
        gc = mainCanvas.getGraphicsContext2D();
        //gc.drawImage(fons, 1200,800);

        // Opció 1
        //animationTimer.start();
        // Opció 2
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

    }

    public void setScene(Scene sc) {
        scene = sc;
        scene.setOnMouseClicked(mouseEvent -> {
            Point2D point = new Point2D(mouseEvent.getX(),mouseEvent.getY());
            if(globo.isClicked(point)) globo.changeDir();
            System.out.println("click");
        });

        scene.setOnKeyPressed(keyEvent -> {
            System.out.println(keyEvent.getCode().toString());
            globo.setDirection(keyEvent.getCode().toString());

        });
    }
}
