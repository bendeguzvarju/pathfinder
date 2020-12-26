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
        //GIVEN
        underTest = new SquareMap(4,3);
        //WHEN
        //THEN
        Assert.assertEquals(underTest.getWidth(), 4);
        Assert.assertEquals(underTest.getHeight(), 3);
    }

    @Test
    public void testMapAddBlockPutsBlockAtExpectedPosition(){
        //GIVEN
        underTest = new SquareMap(4,3);
        //WHEN
        underTest.addBlock(2,1);
        //THEN
        Assert.assertTrue(underTest.getNode(2,1).isBlock());
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
