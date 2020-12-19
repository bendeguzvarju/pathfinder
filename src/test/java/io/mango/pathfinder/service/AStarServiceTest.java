package io.mango.pathfinder.service;

import io.mango.pathfinder.model.map.Map;
import io.mango.pathfinder.model.map.Node;
import io.mango.pathfinder.model.astar.Robot;
import io.mango.pathfinder.model.scenario.Scenario;
import io.mango.pathfinder.model.map.SquareMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
public class AStarServiceTest {
    private AStarService underTest;

    @Before
    public void setUp(){
        underTest = new AStarService();
    }

    @Test
    public void testFindCheapestPathReturnsCorrectPath(){
        //GIVEN
        Robot robot = new Robot(1,1);
        Map map = createTestMap();
        Node startNode = new Node(0,0);
        Node endNode = new Node(3,2);
        Scenario scenario = new Scenario(map, robot, startNode, endNode);

        Set<Node> expected = new HashSet<>();
        //WHEN
        Set<Node> actual = underTest.findCheapestPath(scenario);
        //THEN
        Assert.assertEquals(expected, actual);
    }

    private Map createTestMap() {
        Map squareMap = new SquareMap();
        squareMap.setGrid(new Node[5][5]);
        for (int x = 0; x < squareMap.getHeight(); x++) {
            for(int y = 0; y < squareMap.getWidth(); y++) {
                Node node = new Node(x,y);
                squareMap.setNode(node);
            }
        }
        squareMap.setClosedNodes(new HashSet<Node>());

        return squareMap;
    }

}
