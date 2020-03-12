package sprites;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Ninot  {
    private final int NUM_SPRITES = 7;
    private Image image;
    private double posX, posY, velX, velY, width, height;
    private int dirX, dirY;
    private int index = 0;

    public Ninot() {
        this.posX = 0.0f;
        this.posY = 0.0f;
        this.velX = 2.0f;
        this.velY = 2.0f;
        this.dirX = 1;
        this.dirY = 1;
    }

    public void moveRight() {
        posX += velX;
        index++;
    }

    public void moveLeft() {
        posX -= velX;
    }

    public void moveDown() {
        posY += velY;
    }


    public void moveUp() {
        posY -= velY;
    }

    public void render(GraphicsContext gc) {
        gc.drawImage(image, (index%NUM_SPRITES)*(width/NUM_SPRITES), 0, (width/NUM_SPRITES), height, posX,posY,(width/NUM_SPRITES),height ); //, CANVAS_WIDTH/2 - WIDTH/2, CANVAS_HEIGHT/2 - HEIGHT/2, WIDTH, HEIGHT);
    }

    public void setImage(Image i) {
        image = i;
        width = image.getWidth();
        height = image.getHeight();
    }

    public void clear(GraphicsContext gc) {
        gc.clearRect(posX,posY, width/4, height);
    }

    public Rectangle2D getBoundary() {
        return new Rectangle2D(posX,posY,width,height);
    }

    public boolean isClicked(Point2D p) {
        if(getBoundary().contains(p)) return true;
        else return false;
    }

    public void setDirection(String direction) {
        switch (direction) {
            case "RIGHT":
                moveRight();  break;
            case "LEFT":
                moveLeft();
                break;
            case "DOWN":
                moveDown();
                break;
            case "UP":
                moveUp();
                break;
        }
    }
}
