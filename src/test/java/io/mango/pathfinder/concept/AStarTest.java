package io.mango.pathfinder.concept;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest(AStarTest.class)
public class AStarTest {

    private AStar underTest;

    @Before
    public void setUp() {
        underTest = new AStar();
    }

    @Test
    public void testAStar1(){
        //GIVEN
        int[][] blocks = new int[][] {
                {0,4}, {2,2}, {3,0}, {3,3}, {2,1}, {2,3}
        };

        underTest = new AStar(5,5,0,0,3,2,blocks);
        underTest.display();
        underTest.process();
        underTest.displayScores();
        underTest.displaySolution();
        //WHEN

        //THEN

    }

}
