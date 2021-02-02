package io.mango.pathfinder.model.image;

import io.mango.pathfinder.model.Image.Coordinate;
import io.mango.pathfinder.model.Image.MapImage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

@RunWith(SpringRunner.class)
public class MapImageTest {

    private static final String RED_SAMPLE_PATH = "src/main/resources/red.png";
    private static final String GREEN_SAMPLE_PATH = "src/main/resources/green.png";
    private static final String BLUE_SAMPLE_PATH = "src/main/resources/blue.png";
    private static final String MAP_EXAMPLE_PATH = "src/main/resources/map_example2.png";

    private MapImage underTest;

    @Test
    public void testGetRedReturnsCorrectValue(){
        //GIVEN
        File file = new File(RED_SAMPLE_PATH);
        underTest = new MapImage(file);
        int expectedRedValue = 255;
        int expectedGreenValue = 0;
        int expectedBlueValue = 0;
        //WHEN
        int actualRedValue = underTest.getRed(new Coordinate(1,1));
        int actualGreenValue = underTest.getGreen(new Coordinate(1,1));
        int actualBlueValue = underTest.getBlue(new Coordinate(1,1));
        //THEN
        Assert.assertEquals(expectedRedValue, actualRedValue);
        Assert.assertEquals(expectedGreenValue, actualGreenValue);
        Assert.assertEquals(expectedBlueValue, actualBlueValue);
    }

    @Test
    public void testGetGreenReturnsCorrectValue(){
        //GIVEN
        File file = new File(GREEN_SAMPLE_PATH);
        underTest = new MapImage(file);
        int expectedRedValue = 0;
        int expectedGreenValue = 255;
        int expectedBlueValue = 0;
        //WHEN
        int actualRedValue = underTest.getRed(new Coordinate(1,1));
        int actualGreenValue = underTest.getGreen(new Coordinate(1,1));
        int actualBlueValue = underTest.getBlue(new Coordinate(1,1));
        //THEN
        Assert.assertEquals(expectedRedValue, actualRedValue);
        Assert.assertEquals(expectedGreenValue, actualGreenValue);
        Assert.assertEquals(expectedBlueValue, actualBlueValue);
    }

    @Test
    public void testGetBlueReturnsCorrectValue(){
        //GIVEN
        File file = new File(BLUE_SAMPLE_PATH);
        underTest = new MapImage(file);
        int expectedRedValue = 0;
        int expectedGreenValue = 0;
        int expectedBlueValue = 255;
        //WHEN
        int actualRedValue = underTest.getRed(new Coordinate(1,1));
        int actualGreenValue = underTest.getGreen(new Coordinate(1,1));
        int actualBlueValue = underTest.getBlue(new Coordinate(1,1));
        //THEN
        Assert.assertEquals(expectedRedValue, actualRedValue);
        Assert.assertEquals(expectedGreenValue, actualGreenValue);
        Assert.assertEquals(expectedBlueValue, actualBlueValue);
    }

    @Test
    public void test()  {
        File file = new File(MAP_EXAMPLE_PATH);
        underTest = new MapImage(file);
        int redValue = underTest.getRed(new Coordinate(0,0));;
        int greenValue = underTest.getGreen(new Coordinate(0,0));;
        int blueValue = underTest.getBlue(new Coordinate(0,0));

        System.out.println(redValue);
        System.out.println(greenValue);
        System.out.println(blueValue);

        redValue = underTest.getRed(new Coordinate(1,1));;
        greenValue = underTest.getGreen(new Coordinate(1,1));;
        blueValue = underTest.getBlue(new Coordinate(1,1));

        System.out.println();
        System.out.println(redValue);
        System.out.println(greenValue);
        System.out.println(blueValue);

        redValue = underTest.getRed(new Coordinate(7,8));;
        greenValue = underTest.getGreen(new Coordinate(7,8));;
        blueValue = underTest.getBlue(new Coordinate(7,8));

        System.out.println();
        System.out.println(redValue);
        System.out.println(greenValue);
        System.out.println(blueValue);
    }
}
