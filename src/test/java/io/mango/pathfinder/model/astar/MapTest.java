package io.mango.pathfinder.model.astar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
public class MapTest {

    private Map underTest;

    @Before
    public void setUp() {
        underTest = new Map();
    }

    @Test
    public void testFindNeighboursReturnsAdjacentNodes() {
        //GIVEN
        Node[][] grid = new Node[4][4];
        underTest.setGrid(grid);

        for (int i = 0; i < underTest.getHeight(); i++) {
            for(int j = 0; j < underTest.getWidth(); j++) {
                Node node = new Node();
                node.setY(i);
                node.setX(j);
                underTest.setNode(node);
                node.setMap(underTest);
            }
        }

        Node testNode = underTest.getNode(2, 2);
        Set<Node> expected = new HashSet<Node>();
        expected.add(underTest.getNode(testNode.getX() + -1,testNode.getY() + -1));
        expected.add(underTest.getNode(testNode.getX() + -1, testNode.getY() +0));
        expected.add(underTest.getNode(testNode.getX() + -1, testNode.getY() +1));
        expected.add(underTest.getNode(testNode.getX() + 0, testNode.getY() +-1));
        expected.add(underTest.getNode(testNode.getX() + 0, testNode.getY() +1));
        expected.add(underTest.getNode(testNode.getX() + 1, testNode.getY() +-1));
        expected.add(underTest.getNode(testNode.getX() + 1, testNode.getY() +0));
        expected.add(underTest.getNode(testNode.getX() + 1, testNode.getY() +1));

        //WHEN
        Set<Node> actual = testNode.findNeighbours();
        //THEN
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testFindNeighboursDoesNotReturnOffGridNodes() {
        //GIVEN
        Node[][] grid = new Node[4][4];
        underTest.setGrid(grid);

        for (int i = 0; i < underTest.getHeight(); i++) {
            for(int j = 0; j < underTest.getWidth(); j++) {
                Node node = new Node();
                node.setY(i);
                node.setX(j);
                underTest.setNode(node);
                node.setMap(underTest);
            }
        }

        Node testNode = underTest.getNode(0, 0);
        Set<Node> onGridNodes = new HashSet<Node>();
        onGridNodes.add(underTest.getNode(testNode.getX() + 0, testNode.getY() +1));
        onGridNodes.add(underTest.getNode(testNode.getX() + 1, testNode.getY() +0));
        onGridNodes.add(underTest.getNode(testNode.getX() + 1, testNode.getY() +1));

        Set<Node> offGridNodes = new HashSet<Node>();
        onGridNodes.add(underTest.getNode(testNode.getX() + -1,testNode.getY() + -1));
        onGridNodes.add(underTest.getNode(testNode.getX() + -1, testNode.getY() +0));
        onGridNodes.add(underTest.getNode(testNode.getX() + -1, testNode.getY() +1));
        onGridNodes.add(underTest.getNode(testNode.getX() + 0, testNode.getY() -1));
        onGridNodes.add(underTest.getNode(testNode.getX() + 1, testNode.getY() +-1));
        //WHEN
        Set<Node> actual = testNode.findNeighbours();
        //THEN
        Assert.assertEquals(onGridNodes,actual);
        Assert.assertTrue(CollectionUtils.containsAny(actual, offGridNodes));

    }

    @Test
    public void testTest() {
        Node node = Node.builder()
                .x(1)
                .y(1)
                .build();
        changeNode(node);
        Assert.assertEquals(node.getX(), 1);
        Assert.assertEquals(node.getY(), 1);
    }

    private void changeNode(Node node) {
        node.setX(1);
        node.setY(4);
    }

}
