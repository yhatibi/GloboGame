package sprites;

import javafx.scene.image.Image;

public class Nau extends Sprite {

    public Nau(Image image) {
        super(image);
        setY(400-getHeight());
    }

    @Override
    public void move(String direction) {
        switch (direction) {
            case "RIGHT":
                setX(getPosX() + 4);
                break;
            case "LEFT":
                setX(getPosX() - 4);
                break;
        }
    }


}
