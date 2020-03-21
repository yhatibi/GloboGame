package sprites;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class Sprite {
    private Image image;
    private double width, height, posX, posY;

    public void setX(double x) {
        posX = x;
    }
    public void setY(double y) {
        posY = y;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public Sprite(Image image) {
        setImage(image);
    }

    private void setImage(Image image) {
        this.image = image;
        width = image.getWidth();
        height = image.getHeight();
    }

    public abstract void move();

    public void render(GraphicsContext gc) {
        gc.drawImage(image, posX, posY);
    }
}
