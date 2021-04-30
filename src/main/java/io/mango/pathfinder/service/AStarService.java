package io.mango.pathfinder.service;


import io.mango.pathfinder.model.map.Map;
import io.mango.pathfinder.model.map.Node;
import io.mango.pathfinder.model.astar.Robot;
import io.mango.pathfinder.model.scenario.Scenario;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AStarService implements PathFinder{

    public Set<Node> findCheapestPath(Scenario scenario) {
        Set<Node> solution = new HashSet<>();

        Node currentNode;
        while(true) {
            currentNode = scenario.getOpenNodes().poll();
            if(isNotEligible(currentNode)) {
                break;
            }
            scenario.getClosedNodes().add(currentNode);
            if(isEndNode(scenario, currentNode)) {
                while(isEligible(currentNode)) {
                    currentNode = addNodeToSolution(solution, currentNode);
                }
                return solution ;
            }
            Set<Node> neighbours = scenario.findNeighbours(currentNode);
            calculateMoveCosts(scenario, currentNode, neighbours);
        }
        return solution;
    }

    private boolean isNotEligible(Node currentNode) {
        return currentNode == null || currentNode.isBlock();
    }

    private boolean isEndNode(Scenario scenario, Node currentNode) {
        return currentNode.equals(scenario.getEndNode());
    }

    private boolean isEligible(Node currentNode) {
        return currentNode != null && !currentNode.isBlock();
    }

    private Node addNodeToSolution(Set<Node> solution, Node currentNode) {
        solution.add(currentNode);
        currentNode.setSolution(true);
        currentNode = currentNode.getParent();
        return currentNode;
    }

    private void calculateMoveCosts(Scenario scenario, Node currentNode, Set<Node> neighbours) {
        for(Node neighbour : neighbours) {
            calculateMoveCosts(currentNode, neighbour, scenario);
        }
    }

    private void calculateMoveCosts(Node current, Node target, Scenario scenario) {
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
