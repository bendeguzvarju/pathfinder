package io.mango.pathfinder.service;


import io.mango.pathfinder.model.map.Map;
import io.mango.pathfinder.model.map.Node;
import io.mango.pathfinder.model.astar.Robot;
import io.mango.pathfinder.model.scenario.Scenario;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AStarService {

    public Set<Node> findCheapestPath(Scenario scenario) {
        Set<Node> solution = new HashSet<>();
        scenario.setNode(scenario.getStartNode());
        scenario.setNode(scenario.getEndNode());
        scenario.getOpenNodes().add(scenario.getStartNode());

        Node currentNode;

        while(true) {
            currentNode = scenario.getOpenNodes().poll();
            if(currentNode == null) {
                break;
            }

            scenario.getClosedNodes().add(currentNode);

            if(currentNode.equals(scenario.getEndNode())) {

                while(currentNode != null) {
                    solution.add(currentNode);
                    currentNode = currentNode.getParent();
                }
                return solution ;
            }

            Set<Node> neighbours = scenario.findNeighbours(currentNode);
            for(Node neighbour : neighbours) {
                updateCost(currentNode, neighbour, scenario);
            }
        }

        return solution;
    }

    private void updateCost(Node current, Node target, Scenario scenario) {
        Map map = scenario.getMap();
        Robot robot = scenario.getRobot();
        if(target == null || map.getClosedNodes().contains(target)) {
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
