package io.mango.pathfinder.web.transformer;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest(AStarMapDtoToMapTransformer.class)
public class AStarMapDtoToMapTransformerTest {
    public static final int height = 4;
    public static final int width = 6;

    private AStarMapDtoToMapTransformer underTest;

    @Before
    public void setUp() {
        underTest = new AStarMapDtoToMapTransformer();
    }

    @Test
    public void testTransform() {
        //GIVEN
        char[][] charGrid = new char[height][width];
        charGrid[1][1] = 'X';
        charGrid[0][1] = 'X';
        //WHEN
        for (char[] row : charGrid) {
            for(char integer : row) {
                if(integer != 0) {
                    System.out.print(integer);
                } else {
                    System.out.print('0');
                }

            }
            System.out.println();
        }

        System.out.println(charGrid.length);
        System.out.println(charGrid[0].length);

        //THEN
        Assert.assertEquals(1,2);
    }
}
