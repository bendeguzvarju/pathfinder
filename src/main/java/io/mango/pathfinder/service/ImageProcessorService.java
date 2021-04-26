package io.mango.pathfinder.service;

import io.mango.pathfinder.model.Image.Coordinate;
import io.mango.pathfinder.model.astar.Robot;
import io.mango.pathfinder.model.map.HexMap;
import io.mango.pathfinder.model.map.Map;
import io.mango.pathfinder.model.map.Node;
import io.mango.pathfinder.model.map.SquareMap;
import io.mango.pathfinder.model.scenario.Scenario;
import io.mango.pathfinder.web.request.ImageProcessingRequest;
import org.springframework.stereotype.Service;


@Service
public class ImageProcessorService {

    private static final int BYTE_RANGE_OF_EIGHT_BITS = 255;
    private static final int NUMBER_OF_RGB_COLORS = 3;
    private static int minGrayScaleValue = 0;
    private static int maxGrayScaleValue = BYTE_RANGE_OF_EIGHT_BITS * NUMBER_OF_RGB_COLORS;

    public Scenario processAsAStarAndSquare(ImageProcessingRequest request) {
        Map map = new SquareMap(request.getWidth(), request.getHeight(), Map.FINAL_COST);
        Robot robot = new Robot(1,1);
        Node startNode = new Node();
        Node endNode = new Node();
        for(int y = 0; y < request.getImage().getHeight(); y++) {
            for(int x = 0; x < request.getImage().getWidth(); x++) {
                Node node = new Node(x,y);
                Coordinate coordinate = new Coordinate(y,x);
                if (request.getImage().isRed(coordinate)) {
                    startNode = node;
                } else if(request.getImage().isBlue(coordinate)){
                    endNode = node;
                }
            }
        }
        Scenario scenario = new Scenario(map, robot, startNode, endNode);
        for(int y = 0; y < request.getImage().getHeight(); y++) {
            for(int x = 0; x < request.getImage().getWidth(); x++) {
                Node node = new Node(x,y);
                Coordinate coordinate = new Coordinate(y,x);
                if (request.getImage().isGreen(coordinate)) {
                    scenario.addBlock(node);
                }
            }
        }
        return scenario;
    }

    public Scenario processAsAStarAndHex(ImageProcessingRequest request) {
        Map map = new HexMap(request.getWidth(), request.getHeight(), Map.FINAL_COST);
        Robot robot = new Robot(1,1);
        Node startNode = new Node();
        Node endNode = new Node();
        for(int y = 0; y < request.getImage().getHeight(); y++) {
            for(int x = 0; x < request.getImage().getWidth(); x++) {
                Node node = new Node(x,y);
                Coordinate coordinate = new Coordinate(y,x);
                if (request.getImage().isRed(coordinate)) {
                    startNode = node;
                } else if(request.getImage().isBlue(coordinate)){
                    endNode = node;
                }
            }
        }
        Scenario scenario = new Scenario(map, robot, startNode, endNode);
        for(int y = 0; y < request.getImage().getHeight(); y++) {
            for(int x = 0; x < request.getImage().getWidth(); x++) {
                Node node = new Node(x,y);
                Coordinate coordinate = new Coordinate(y,x);
                if (request.getImage().isGreen(coordinate)) {
                    scenario.addBlock(node);
                }
            }
        }
        return scenario;
    }

    public Scenario processAsDijkstraAndSquare(ImageProcessingRequest request) {
        Map map = new SquareMap(request.getWidth(), request.getHeight(), Map.HEURISTIC_COST);
        Robot robot = new Robot(1,1);
        Node startNode = new Node();
        Node endNode = new Node();
        for(int y = 0; y < request.getImage().getHeight(); y++) {
            for(int x = 0; x < request.getImage().getWidth(); x++) {
                Node node = new Node(x,y);
                Coordinate coordinate = new Coordinate(y,x);
                if (request.getImage().isRed(coordinate)) {
                    startNode = node;
                } else if(request.getImage().isBlue(coordinate)){
                    endNode = node;
                }
            }
        }
        Scenario scenario = new Scenario(map, robot, startNode, endNode);
        for(int y = 0; y < request.getImage().getHeight(); y++) {
            for(int x = 0; x < request.getImage().getWidth(); x++) {
                Node node = new Node(x,y);
                Coordinate coordinate = new Coordinate(y,x);
                if (request.getImage().isGreen(coordinate)) {
                    scenario.addBlock(node);
                }
            }
        }
        return scenario;
    }

    public Scenario processAsDijkstraAndHex(ImageProcessingRequest request) {

        Map map = new HexMap(request.getWidth(), request.getHeight(), Map.HEURISTIC_COST);
        Robot robot = new Robot(1,1);
        Node startNode = new Node();
        Node endNode = new Node();
        for(int y = 0; y < request.getImage().getHeight(); y++) {
            for(int x = 0; x < request.getImage().getWidth(); x++) {
                Node node = new Node(x,y);
                Coordinate coordinate = new Coordinate(y,x);
                if (request.getImage().isRed(coordinate)) {
                    startNode = node;
                } else if(request.getImage().isBlue(coordinate)){
                    endNode = node;
                }
            }
        }
        Scenario scenario = new Scenario(map, robot, startNode, endNode);
        for(int y = 0; y < request.getImage().getHeight(); y++) {
            for(int x = 0; x < request.getImage().getWidth(); x++) {
                Node node = new Node(x,y);
                Coordinate coordinate = new Coordinate(y,x);
                if (request.getImage().isGreen(coordinate)) {
                    scenario.addBlock(node);
                }
            }
        }
        return scenario;
    }

    public Scenario processImage(ImageProcessingRequest request) {
        Scenario scenario = new Scenario();
        int sampleBlockHeight = request.getImage().getHeight() / request.getHeight();
        int sampleBlockWidth = request.getImage().getWidth() / request.getWidth();
        for(int y = 0; y < sampleBlockHeight - sampleBlockHeight; y += sampleBlockHeight) {
            for(int x = 0; x < sampleBlockWidth - sampleBlockWidth; x += sampleBlockWidth) {

            }
        }

        return scenario;
    }
}
