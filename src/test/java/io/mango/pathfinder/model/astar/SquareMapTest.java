package io.mango.pathfinder.model.astar;

import io.mango.pathfinder.model.map.SquareMap;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class SquareMapTest {

    private SquareMap underTest;

    @Before
    public void setUp() {
        underTest = new SquareMap();
    }
}
