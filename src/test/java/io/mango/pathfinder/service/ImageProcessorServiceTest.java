package io.mango.pathfinder.service;

import io.mango.pathfinder.concept.AStar;
import io.mango.pathfinder.model.Image.MapImage;
import io.mango.pathfinder.model.astar.Robot;
import io.mango.pathfinder.model.scenario.Scenario;
import io.mango.pathfinder.web.request.ImageProcessingRequest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

@RunWith(SpringRunner.class)
public class ImageProcessorServiceTest {

    private static final String EXAMPLE_MAP_PATH = "src/main/resources/map_example2.png";

    ImageProcessorService underTest;


    @Before
    public void setUp() {
        underTest = new ImageProcessorService();
    }

    /*
    @Test
    public void testProcessCreatesCorrectScenario() {
        //GIVEN
        ImageProcessingRequest request = new ImageProcessingRequest();
        File file = new File(EXAMPLE_MAP_PATH);
        MapImage mapImage = new MapImage(file);
        request.setImage(mapImage);
        request.setRobot(new Robot(1,1));
        request.setWidth(10);
        request.setHeight(10);
        //WHEN
        cenario actual = underTest.process(request);
        //THEN
        AStarService aStarService = new AStarService();
        aStarService.findCheapestPath(actual);
        actual.displayHeuristicMap();

        Assert.assertEquals(8,actual.getStartNode().getX());
        Assert.assertEquals(7,actual.getStartNode().getY());

        Assert.assertEquals(0,actual.getEndNode().getX());
        Assert.assertEquals(0,actual.getEndNode().getY());

    }

    */
}
