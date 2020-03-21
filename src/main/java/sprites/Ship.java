package sprites;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Ship extends Sprite {
    private Image image;
    private double velX, velY;
    private int dirX, dirY;

    public Ship(Image image) {
        super(image);
        setX(Math.random()*600);
        setY(50);

        this.velX = 1.0f;
        this.velY = 5.0f;
        this.dirX = 1;
        this.dirY = 1;
        //setImage(image);
    }

    /**
     * El moviment de la pilota és gestionat per la mateixa pilota
     * En aquest exemple només cal generalitzar les mides per on es
     * pot moure. En aquest cas en una finestra de 600x400
     */
    @Override
    public void move() {
        if(dirX == 1) {
            setX(getPosX() + velX);
            if(getPosX()>=600-getWidth()) {
                dirX = (-1)*dirX;
                setY(getPosY() + velY);
            }
        }else {
            setX(getPosX() - velX);
            if(getPosX() <= 0) dirX = (-1)*dirX;
        }
    }


   /* public void render(GraphicsContext gc) {
        gc.drawImage(image, posX, posY);
    }
    */


    /* public void setImage(Image i) {
        image = i;
        width = image.getWidth();
        height = image.getHeight();
    }*/

    /**
     * Netejar la zona que ocupa l'objecte dins del graphicsContext
     * Al clearRect li passem la posició i les mides de la imatge.
     *
     * @param gc
     */
    public void clear(GraphicsContext gc) {
        gc.clearRect(getPosX(),getPosY(), getWidth(), getHeight());
    }

   /* public Rectangle2D getBoundary() {
        return new Rectangle2D(posX,posY,width,height);
    }*/

    /*public boolean isClicked(Point2D p) {
        if(getBoundary().contains(p)) return true;
        else return false;
    }

    public void changeDir() {
        double t = Math.random();
        if(0.33 > t) dirX = dirX*(-1);
        if(0.33 < t && 0.66 > t) dirY = dirY*(-1);
        if(0.66 < t) {
            dirY = dirY*(-1);
            dirX = dirX*(-1);
        }

    }

    public void setDirection(String direction) {
        switch (direction) {
            case "RIGHT":
                dirX = 1;
                break;
            case "LEFT":
                dirX = -1;
                break;
            case "DOWN":
                dirY = 1;
                break;
            case "UP":
                dirY = -1;
                break;
        }
    }

     */


}
