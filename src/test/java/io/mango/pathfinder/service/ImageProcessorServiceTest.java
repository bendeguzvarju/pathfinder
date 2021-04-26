package io.mango.pathfinder.service;

import io.mango.pathfinder.model.Image.MapImage;
import io.mango.pathfinder.model.astar.Robot;
import io.mango.pathfinder.model.map.Node;
import io.mango.pathfinder.model.scenario.Scenario;
import io.mango.pathfinder.web.request.ImageProcessingRequest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.List;

@RunWith(SpringRunner.class)
public class ImageProcessorServiceTest {

    private List<String> PATHS = new ArrayList<>(Arrays.asList(
            "src/main/resources/test-maps/m_05x05_1.png",
            "src/main/resources/test-maps/m_05x05_2.png",
            "src/main/resources/test-maps/m_05x05_3.png",
            "src/main/resources/test-maps/m_05x05_4.png",
            "src/main/resources/test-maps/m_05x05_5.png",
            "src/main/resources/test-maps/m_10x10_1.png",
            "src/main/resources/test-maps/m_10x10_2.png",
            "src/main/resources/test-maps/m_10x10_3.png",
            "src/main/resources/test-maps/m_10x10_4.png",
            "src/main/resources/test-maps/m_10x10_5.png",
            "src/main/resources/test-maps/m_15x15_1.png",
            "src/main/resources/test-maps/m_15x15_2.png",
            "src/main/resources/test-maps/m_15x15_3.png",
            "src/main/resources/test-maps/m_15x15_4.png",
            "src/main/resources/test-maps/m_15x15_5.png",
            "src/main/resources/test-maps/m_20x20_1.png",
            "src/main/resources/test-maps/m_20x20_2.png",
            "src/main/resources/test-maps/m_20x20_3.png",
            "src/main/resources/test-maps/m_20x20_4.png",
            "src/main/resources/test-maps/m_20x20_5.png",
            "src/main/resources/test-maps/m_25x25_1.png",
            "src/main/resources/test-maps/m_25x25_2.png",
            "src/main/resources/test-maps/m_25x25_3.png",
            "src/main/resources/test-maps/m_25x25_4.png",
            "src/main/resources/test-maps/m_25x25_5.png"
    ));

    private static final String EXAMPLE_MAP_PATH = "src/main/resources/map_example2.png";

    private ImageProcessorService underTest;

    private AStarService aStarService;
    private DijkstraService dijkstraService;


    @Before
    public void setUp() {
        underTest = new ImageProcessorService();
        aStarService = new AStarService();
        dijkstraService = new DijkstraService();

    }

    
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
        Scenario actual = underTest.processAsAStarAndSquare(request);
        //THEN
        AStarService aStarService = new AStarService();
        Set<Node> solution = aStarService.findCheapestPath(actual);
        actual.displayHeuristicMap();
        System.out.println(solution.size());
        System.out.println("==========");
        System.out.println(actual.getEndNode());
        System.out.println(actual.getStartNode());
        actual.displayHeuristicMap();
        actual.displayFinalCosts();


        Assert.assertEquals(8,actual.getStartNode().getX());
        Assert.assertEquals(7,actual.getStartNode().getY());

        Assert.assertEquals(0,actual.getEndNode().getX());
        Assert.assertEquals(0,actual.getEndNode().getY());

    }

    @Test
    public void testProcessCreatesCorrectScenarios() {
        for (String path : PATHS) {
            produceAstarSquareData(path);
            produceAStarHexData(path);
            produceDijkstraSquareData(path);
            produceDijkstraHexData(path);
            System.out.println("==========");
        }
        Assert.assertEquals(1,2);
    }

    private void produceAstarSquareData(String path) {
        ImageProcessingRequest request = new ImageProcessingRequest();
        File file = new File(path);
        String mapName = path.replace("src/main/resources/test-maps/", "").replace(".png", "");
        MapImage mapImage = new MapImage(file);
        request.setImage(mapImage);
        request.setRobot(new Robot(1,1));
        request.setWidth(mapImage.getWidth());
        request.setHeight(mapImage.getHeight());
        //WHEN
        Scenario actual = underTest.processAsAStarAndSquare(request);
        //THEN
        Set<Node> aStarSolution = aStarService.findCheapestPath(actual);
        //actual.displayHeuristicMap();

        System.out.println("MapName:" + mapName);
        System.out.println("\t" + "AStar, Square");
        System.out.println("\t" + "\t" + "Solution size: " + aStarSolution.size());
        //System.out.println("\t" + "\t" + "Closed nodes: " + actual.getClosedNodes().size());
        int visitedNodes = actual.getClosedNodes().size() + actual.getOpenNodes().size();
        System.out.println("\t" + "\t" + "Visited nodes: " + visitedNodes);
        //System.out.println("Final Costs");
        //actual.displayFinalCosts();
        //System.out.println("Heuristic Costs");
        //actual.displayHeuristicMap();
    }

    private void produceDijkstraSquareData(String path) {
        ImageProcessingRequest request = new ImageProcessingRequest();
        File file = new File(path);
        String mapName = path.replace("src/main/resources/test-maps/", "").replace(".png", "");
        MapImage mapImage = new MapImage(file);
        request.setImage(mapImage);
        request.setRobot(new Robot(1,1));
        request.setWidth(mapImage.getWidth());
        request.setHeight(mapImage.getHeight());
        //WHEN
        Scenario actual = underTest.processAsDijkstraAndSquare(request);
        //THEN
        Set<Node> dijkstraSolution = dijkstraService.findCheapestPath(actual);

        //actual.displayHeuristicMap();
        //System.out.println("MapName:" + mapName);

        System.out.println("\t" + "Dijkstra, Square");
        System.out.println("\t" + "\t" + "Solution size: " + dijkstraSolution.size());
        //System.out.println("\t" + "\t" +  + actual.getClosedNodes().size());
        int visitedNodes = actual.getClosedNodes().size() + actual.getOpenNodes().size();
        System.out.println("\t" + "\t" + "Visited nodes: " + visitedNodes);
        //System.out.println("Final Costs");
        //actual.displayFinalCosts();
        //System.out.println("Heuristic Costs");
        //actual.displayHeuristicMap();
    }
    private void produceAStarHexData(String path) {
        ImageProcessingRequest request = new ImageProcessingRequest();
        File file = new File(path);
        String mapName = path.replace("src/main/resources/test-maps/", "").replace(".png", "");
        MapImage mapImage = new MapImage(file);
        request.setImage(mapImage);
        request.setRobot(new Robot(1,1));
        request.setWidth(mapImage.getWidth());
        request.setHeight(mapImage.getHeight());
        //WHEN
        Scenario actual = underTest.processAsAStarAndHex(request);
        //THEN
        Set<Node> dijkstraSolution = dijkstraService.findCheapestPath(actual);

        //actual.displayHeuristicMap();
        //System.out.println("MapName:" + mapName);

        System.out.println("\t" + "AStar, Hex");
        System.out.println("\t" + "\t" + "Solution size: " + dijkstraSolution.size());
        //System.out.println("\t" + "\t" + "Closed nodes: " + actual.getClosedNodes().size());
        int visitedNodes = actual.getClosedNodes().size() + actual.getOpenNodes().size();
        System.out.println("\t" + "\t" + "Visited nodes: " + visitedNodes);
        //System.out.println("Final Costs");
        //actual.displayFinalCosts();
        //System.out.println("Heuristic Costs");
        //actual.displayHeuristicMap();
    }
    private void produceDijkstraHexData(String path) {
        ImageProcessingRequest request = new ImageProcessingRequest();
        File file = new File(path);
        String mapName = path.replace("src/main/resources/test-maps/", "").replace(".png", "");
        MapImage mapImage = new MapImage(file);
        request.setImage(mapImage);
        request.setRobot(new Robot(1,1));
        request.setWidth(mapImage.getWidth());
        request.setHeight(mapImage.getHeight());
        //WHEN
        Scenario actual = underTest.processAsDijkstraAndHex(request);
        //THEN
        Set<Node> dijkstraSolution = dijkstraService.findCheapestPath(actual);

        //actual.displayHeuristicMap();
        //System.out.println("MapName:" + mapName);

        System.out.println("\t" + "Dijkstra, Hex");
        System.out.println("\t" + "\t" + "Solution size: " + dijkstraSolution.size());
        //System.out.println("\t" + "\t" + "Closed nodes: " + actual.getClosedNodes().size());
        int visitedNodes = actual.getClosedNodes().size() + actual.getOpenNodes().size();
        System.out.println("\t" + "\t" + "Visited nodes: " + visitedNodes);
        //System.out.println("Final Costs");
        //actual.displayFinalCosts();
        //System.out.println("Heuristic Costs");
        //actual.displayHeuristicMap();
    }

}
