package io.mango.pathfinder.service;

import io.mango.pathfinder.model.astar.Robot;
import io.mango.pathfinder.model.map.HexMap;
import io.mango.pathfinder.model.map.Map;
import io.mango.pathfinder.model.map.Node;
import io.mango.pathfinder.model.map.SquareMap;
import io.mango.pathfinder.model.scenario.Scenario;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
public class DijkstraServiceTest {
    private DijkstraService underTest;

    @Before
    public void setUp(){
        underTest = new DijkstraService();
    }


    @Test
    public void dijkstra(){
        underTest = new DijkstraService();

        Robot robot = new Robot(1,1);
        Map map = new SquareMap(5,5, Map.HEURISTIC_COST);
        Node startNode = new Node(0,0);
        Node endNode = new Node(4,3);
        Scenario scenario = new Scenario(map, robot, startNode, endNode);
        //WHEN
        Set<Node> actual = underTest.findCheapestPath(scenario);
        scenario.displayHeuristicMap();
        Set<Node> expected = new HashSet<>();
        Assert.assertEquals(actual, expected);

    }



}
