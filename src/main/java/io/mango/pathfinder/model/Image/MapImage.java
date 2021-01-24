package io.mango.pathfinder.model.Image;

import lombok.Getter;
import lombok.Setter;

import java.awt.image.BufferedImage;

@Getter
@Setter
public class MapImage {

    private static final int LAST_BYTE = 0xFF;
    private static final int BYTE = 8;
    private static final int TWO_BYTES = 16;
    private BufferedImage image;

    public MapImage(BufferedImage bufferedImage) {
        this.image = bufferedImage;
    }

    public int getHeight() {
        return image.getHeight();
    }

    public int getWidth() {
        return image.getWidth();
    }

    public int getRed(Coordinate coordinate) {
        int rgbValue = getRgbValue(coordinate);
        return (rgbValue >> TWO_BYTES) & LAST_BYTE;
    }

    public int getGreen(Coordinate coordinate) {
        int rgbValue = getRgbValue(coordinate);
        return (rgbValue >> BYTE) & LAST_BYTE;
    }

    public int getBlue(Coordinate coordinate) {
        int rgbValue = getRgbValue(coordinate);
        return rgbValue & LAST_BYTE;
    }

    private int getRgbValue(Coordinate coordinate) {
        if (xPositionIsValid(coordinate)) {
            throw new RuntimeException("Coordinate x out of range: 0.." + image.getWidth());
        } else if (yPositionIsValid(coordinate)) {
            throw new RuntimeException("Coordinate y out of range: 0.." + image.getHeight());
        }
        return image.getRGB(coordinate.getX(), coordinate.getY());
    }

    private boolean xPositionIsValid(Coordinate coordinate) {
        return coordinate.getX() < 0 || coordinate.getX() > image.getWidth();
    }

    private boolean yPositionIsValid(Coordinate coordinate) {
        return coordinate.getY() < 0 || coordinate.getY() > image.getHeight();
    }



}
