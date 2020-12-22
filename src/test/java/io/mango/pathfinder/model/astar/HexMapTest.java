package io.mango.pathfinder.model.astar;

import io.mango.pathfinder.model.map.HexMap;
import io.mango.pathfinder.model.map.Map;
import io.mango.pathfinder.model.map.Node;
import io.mango.pathfinder.web.transformer.GridToHexMapTransformer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void findNeighboursReturnsNeighbours() {
        //GIVEN
        Node targetNode = new Node();
        underTest = createTestMap1();
        Set<Node> expected = new HashSet<>();
        //WHEN
        Set<Node> actual = underTest.findNeighbours(targetNode);
        //THEN
        Assert.assertEquals(expected, actual);



    }

    private HexMap createTestMap1() {
        Map hexMap = new HexMap();
        Node[][] grid = createTestGrid1();
        hexMap.setGrid(grid);

        return null;
    }

    private Node[][] createTestGrid1() {
        return null;
    }
}
