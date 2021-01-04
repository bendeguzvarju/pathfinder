package io.mango.pathfinder.service;

import io.mango.pathfinder.model.astar.Robot;
import io.mango.pathfinder.model.map.Map;
import io.mango.pathfinder.model.map.Node;
import io.mango.pathfinder.model.scenario.Scenario;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class DijkstraService implements PathFinder{

    public Set<Node> findCheapestPath(Scenario scenario) {
        Set<Node> solution = new HashSet<>();

        Node currentNode;
        while(true) {
            currentNode = scenario.getOpenNodes().poll();
            if(currentNode == null || currentNode.isBlock()) {
                break;
            }

            scenario.getClosedNodes().add(currentNode);

            if(currentNode.equals(scenario.getEndNode())) {

                while(currentNode != null && !currentNode.isBlock() ) {
                    solution.add(currentNode);
                    currentNode.setSolution(true);
                    currentNode = currentNode.getParent();
                }
                return solution ;
            }

            Set<Node> neighbours = scenario.findNeighbours(currentNode);

            for(Node neighbour : neighbours) {
                if(!scenario.getMap().getClosedNodes().contains(neighbour)) {
                    updateCost(currentNode, neighbour, scenario);
                }
            }
            printMapStatus(scenario);
            System.out.println();
        }

        return solution;
    }

    private void printMapStatus(Scenario scenario) {
        Map map = scenario.getMap();
        StringBuilder result = new StringBuilder();
        for(int x = 0; x < map.getWidth(); x++) {
            for(int y = 0; y < map.getHeight(); y++) {
                Node node = map.getNode(x,y);
                String representation;
                if (node.isBlock()) {
                    representation = "[-]";
                } else if (map.getOpenNodes().contains(node)){

                    representation = "[ O ]";
                } else if(map.getClosedNodes().contains(node)) {
                    representation = "[ C ]";
                } else {
                    representation = "[ X ]";
                }
                result.append(representation);
            }
            result.append("\n");
        }
        System.out.println(result.toString());
    }


    private void updateCost(Node current, Node target, Scenario scenario) {
        Map map = scenario.getMap();
        Robot robot = scenario.getRobot();
        if(target.isBlock() || map.getClosedNodes().contains(target)) {
            return;
        }
        int cost= map.calculateMoveCost(current, target, robot) ;

        int potentialCost = target.getHeuristicCost() + cost;
        boolean isOpen = map.getOpenNodes().contains(target);

        if(!isOpen || potentialCost < target.getFinalCost()) {
            target.setFinalCost(potentialCost);
            target.setParent(current);

            if(!isOpen) {
                map.getOpenNodes().add(target);
            }
        }
    }
}
