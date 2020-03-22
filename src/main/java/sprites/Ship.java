package sprites;

import javafx.scene.image.Image;

public class Ship extends Sprite {
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
    }

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


}
