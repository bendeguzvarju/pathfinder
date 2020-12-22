package io.mango.pathfinder.model.astar;

import io.mango.pathfinder.model.map.Node;
import io.mango.pathfinder.model.map.SquareMap;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

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
}
