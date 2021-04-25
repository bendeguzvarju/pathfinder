package io.mango.pathfinder.service;

import io.mango.pathfinder.model.astar.Robot;
import io.mango.pathfinder.model.map.Map;
import io.mango.pathfinder.model.map.Node;
import io.mango.pathfinder.model.map.SquareMap;
import io.mango.pathfinder.model.scenario.Scenario;
import io.mango.pathfinder.web.response.TestDataResponse;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Stream;

@Service
public class TestDataGeneratorService {

    public TestDataResponse generateRandomSquareDijkstraTestData(int blockPerTenNode) {
        TestDataResponse response = new TestDataResponse();
        Set<Scenario> scenarios = new HashSet<>();
        Random random = new Random();
        for (int i = 56; i < 157; i++) {
            Scenario scenario = new Scenario();
            int width = i / 14 + 1;
            int height = width;
            Map map = new SquareMap(width, height, Map.HEURISTIC_COST);

            setBlocks(map);

            scenario.setMap(map);
            int startX = random.nextInt(width);
            int startY = random.nextInt(width);
            int endX = random.nextInt(width);
            int endY = random.nextInt(width);
            scenario.setStartNode(map.getNode(startX, startY));
            scenario.setEndNode(map.getNode(endX,endY));
            scenario.setRobot(new Robot(1,1));
            scenarios.add(scenario);
        }
        response.setScenarios(scenarios);
        return response;
    }

    private void setBlocks(Map map) {
        Stream.of(map.getGrid())
                .flatMap(Stream::of)
                .forEach(node -> setBlock(node));
    }

    private void setBlock(Node node) {
        Random random = new Random();
        int blockChance = random.nextInt(101);
        if (blockChance < 20) {
            node.setBlock(true);
        }
    }
}
