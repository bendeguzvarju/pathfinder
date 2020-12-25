package io.mango.pathfinder.model.astar;

import io.mango.pathfinder.model.map.Map;
import io.mango.pathfinder.model.map.Node;
import io.mango.pathfinder.model.map.SquareMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
public class SquareMapTest {

    private SquareMap underTest;

    @Before
    public void setUp() {
        underTest = new SquareMap();
    }

    @Test
    public void testMapInstantiation(){
        Node[][] nodeGrid = createNodeGrid();
        underTest.setGrid(nodeGrid);
        Assert.assertEquals(underTest.getNode(0,1).getX(), 0);
        Assert.assertEquals(underTest.getNode(0,1).getY(), 1);
        System.out.println("Map width: " + underTest.getWidth());
        System.out.println("Map height: " + underTest.getHeight());
        System.out.println("Node[0][1]: " + underTest.getNode(0,1));
        System.out.println(underTest);
    }

    private Node[][] createNodeGrid() {
        Node[][] nodeGrid = new Node[3][4];
        System.out.println("Grid width: " + nodeGrid.length);
        System.out.println("Grid height: " + nodeGrid[0].length);

        Node node;
        for(int x = 0; x < nodeGrid.length; x++) {
            for(int y = 0;y < nodeGrid[0].length; y++) {
                node = new Node(x,y);
                nodeGrid[x][y] = node;
            }
        }


        return nodeGrid;
    }

    @Test
    public void findNeighboursReturnsCorrectNodes() {
        //GIVEN
        Map underTest = new SquareMap(3,4);
        underTest.addBlock(1,1);
        underTest.addBlock(1,2);
        System.out.println(underTest);
        Set<Node> expected = new HashSet<>();
        expected.add(underTest.getNode(0,0));
        expected.add(underTest.getNode(0,2));
        expected.add(underTest.getNode(1,0));
        //WHEN
        Node target = underTest.getNode(0,1);
        Set<Node> actual = underTest.findNeighbours(target);
        //THEN
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findNeighboursReturnsAllAdjacentNodes() {
        //GIVEN
        Map underTest = new SquareMap(3,4);
        System.out.println(underTest);
        Set<Node> expected = new HashSet<>();
        expected.add(underTest.getNode(0,0));
        expected.add(underTest.getNode(0,1));
        expected.add(underTest.getNode(0,2));
        expected.add(underTest.getNode(1,0));
        expected.add(underTest.getNode(1,2));
        expected.add(underTest.getNode(2,0));
        expected.add(underTest.getNode(2,1));
        expected.add(underTest.getNode(2,2));
        //WHEN
        Node target = underTest.getNode(1,1);
        Set<Node> actual = underTest.findNeighbours(target);
        //THEN
        Assert.assertEquals(expected, actual);
    }
}
