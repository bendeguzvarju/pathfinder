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
    public void findNeighboursReturnsCorrectNodes() {
        //GIVEN
        underTest = new HexMap(4,4);
        Node targetNode = underTest.getNode(2,2);
        Set<Node> expected = new HashSet<>();
        //WHEN
        Set<Node> actual = underTest.findNeighbours(targetNode);
        //THEN
        System.out.println(underTest);
        System.out.println("asd");
        Assert.assertEquals(expected, actual);



    }

}
