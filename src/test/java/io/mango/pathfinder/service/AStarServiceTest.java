package io.mango.pathfinder.service;

import io.mango.pathfinder.concept.Cell;
import io.mango.pathfinder.model.astar.Map;
import io.mango.pathfinder.model.astar.Node;
import io.mango.pathfinder.model.astar.Robot;
import io.mango.pathfinder.model.astar.Scenario;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

@RunWith(SpringRunner.class)
public class AStarServiceTest {
    private AStarService underTest;

    @Before
    public void setUp() {
        underTest = new AStarService();
    }

    @Test
    public void testFindCheapestPathReturnsCorrectPath() {
        //GIVEN
        Robot robot = Robot.builder()
                .diagonalCost(14)
                .vHCost(10)
                .build();
        Map map = createTestMap();
        Node startNode = map.getNode(0,0);
        map.getOpenNodes().add(startNode);
        Node endNode = map.getNode(3,2);
        Scenario scenario = Scenario.builder()
                .map(map)
                .robot(robot)
                .startNode(startNode)
                .endNode(endNode)
                .build();
        Set<Node> expected = createExpectedSolution();
        //WHEN
        Set<Node> actual = underTest.findCheapestPath(scenario);
        //THEN
        Assert.assertEquals(expected,actual);
    }

    private Map createTestMap() {
        PriorityQueue<Node> openNodes = new PriorityQueue<Node>((Node c1, Node c2) -> Integer.compare(c1.getFinalCost(), c2.getFinalCost()));
        Map map = Map.builder()
                .grid(new Node[5][5])
                .openNodes(openNodes)
                .build();
        for (int i = 0; i < map.getHeight(); i++) {
            for(int j = 0; j < map.getWidth(); j++) {
                Node node = new Node();
                node.setY(i);
                node.setX(j);
                map.setNode(node);
                node.setMap(map);
                node.setOpen(true);
            }
        }
        map.getNode(0,4).close();
        map.getNode(2,2).close();
        map.getNode(3,0).close();
        map.getNode(3,3).close();
        map.getNode(2,1).close();
        map.getNode(2,3).close();
        map.getNode(2,0).close();

        return map;
    }

    private Set<Node> createExpectedSolution() {
        Set<Node> expected = new HashSet<Node>();

        return expected;


    }


}
