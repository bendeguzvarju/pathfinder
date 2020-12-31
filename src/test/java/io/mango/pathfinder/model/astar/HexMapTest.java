package io.mango.pathfinder.model.astar;

import io.mango.pathfinder.model.map.HexMap;
import io.mango.pathfinder.model.map.Node;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
public class HexMapTest {

    private HexMap underTest;

    @Before
    public void setUp() {
        underTest = new HexMap();
    }

    @Test
    public void findNeighboursReturnsCorrectNodesForOddColumn() {
        //GIVEN
        underTest = new HexMap(5,5,Node::getFinalCost);
        Node target = new Node(2,3);
        underTest.setNode(target);
        Set<Node> expected = new HashSet<>();
        expected.add(underTest.getNode(1,3));
        expected.add(underTest.getNode(1,4));
        expected.add(underTest.getNode(2,2));
        expected.add(underTest.getNode(2,4));
        expected.add(underTest.getNode(3,3));
        expected.add(underTest.getNode(3,4));
        //WHEN
        Set<Node> actual = underTest.findNeighbours(target);
        //THEN
        System.out.println(underTest);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findNeighboursReturnsCorrectNodesForOddColumn2() {
        //GIVEN
        underTest = new HexMap(5,5,Node::getFinalCost);
        Node target = new Node(2,2);
        underTest.setNode(target);
        Set<Node> expected = new HashSet<>();
        expected.add(underTest.getNode(1,2));
        expected.add(underTest.getNode(1,3));
        expected.add(underTest.getNode(2,1));
        expected.add(underTest.getNode(2,3));
        expected.add(underTest.getNode(3,2));
        expected.add(underTest.getNode(3,3));
        //WHEN
        Set<Node> actual = underTest.findNeighbours(target);
        //THEN
        System.out.println(underTest);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findNeighboursDoesNotCheckOutOfBoundNodes() {
        //GIVEN
        underTest = new HexMap(5,5,Node::getFinalCost);
        Node target = new Node(0,0);
        underTest.setNode(target);
        Set<Node> expected = new HashSet<>();
        expected.add(underTest.getNode(1,0));
        expected.add(underTest.getNode(0,1));
        expected.add(underTest.getNode(1,1));
        //WHEN
        Set<Node> actual = underTest.findNeighbours(target);
        //THEN
        System.out.println(underTest);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findNeighboursDoesNotCheckOutOfBoundNodes2() {
        //GIVEN
        underTest = new HexMap(5,5,Node::getFinalCost);
        Node target = new Node(0,4);
        underTest.setNode(target);
        Set<Node> expected = new HashSet<>();
        expected.add(underTest.getNode(0,3));
        expected.add(underTest.getNode(1,4));
        //WHEN
        Set<Node> actual = underTest.findNeighbours(target);
        //THEN
        System.out.println(underTest);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findNeighboursReturnsCorrectNodes() {
        //GIVEN
        underTest = new HexMap(5,5,Node::getFinalCost);
        Node target = new Node(1,1);
        underTest.setNode(target);
        Set<Node> expected = new HashSet<>();
        expected.add(underTest.getNode(0,0));
        expected.add(underTest.getNode(0,1));
        expected.add(underTest.getNode(1,0));
        expected.add(underTest.getNode(2,0));
        expected.add(underTest.getNode(2,1));
        expected.add(underTest.getNode(1,2));
        //WHEN
        Set<Node> actual = underTest.findNeighbours(target);
        //THEN
        System.out.println(underTest);
        Assert.assertEquals(expected, actual);
    }

}
