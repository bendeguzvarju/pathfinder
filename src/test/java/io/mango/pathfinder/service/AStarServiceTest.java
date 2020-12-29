package io.mango.pathfinder.service;

import io.mango.pathfinder.model.map.HexMap;
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
    public void testFindCheapestPathReturnsCorrectPathForSquareMaps(){
        //GIVEN
        Robot robot = new Robot(1,1);
        Map map = new SquareMap(5,5);
        Node startNode = new Node(0,0);
        Node endNode = new Node(4,3);
        Scenario scenario = new Scenario(map, robot, startNode, endNode);
        map.addBlock(1,2);
        map.addBlock(1,0);
        map.addBlock(1,1);
        map.addBlock(1,3);
        map.addBlock(2,4);
        map.addBlock(3,3);
        map.addBlock(3,4);
        map.addBlock(3,2);
        Set<Node> expected = new HashSet<>();
        expected.add(startNode);
        expected.add(map.getNode(0,1));
        expected.add(map.getNode(0,2));
        expected.add(map.getNode(0,3));
        expected.add(map.getNode(1,4));
        expected.add(map.getNode(2,3));
        expected.add(map.getNode(2,2));
        expected.add(map.getNode(3,1));
        expected.add(map.getNode(4,2));
        expected.add(endNode);
        //WHEN
        Set<Node> actual = underTest.findCheapestPath(scenario);
        //THEN
        System.out.println("Map: ");
        System.out.println(map);
        System.out.println("Final costs: ");
        map.displayFinalCosts();
        System.out.println("Heuristic costs: ");
        map.displayHeuristicMap();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindCheapestPathReturnsCorrectPathForHexMaps(){
        //GIVEN
        Robot robot = new Robot(1,1);
        Map map = new HexMap(5,5);
        Node startNode = new Node(0,0);
        Node endNode = new Node(4,3);
        map.addBlock(2,1);
        Scenario scenario = new Scenario(map, robot, startNode, endNode);
        int expected = 6;
        //WHEN
        Set<Node> actual = underTest.findCheapestPath(scenario);
        //THEN
        System.out.println(map);
        System.out.println("Final costs: ");
        scenario.displayFinalCosts();
        System.out.println("Heuristic map: ");
        scenario.displayHeuristicMap();
        Assert.assertEquals(expected, actual.size());
    }



}
