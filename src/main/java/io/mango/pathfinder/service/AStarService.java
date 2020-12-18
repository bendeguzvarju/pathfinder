package io.mango.pathfinder.service;

import io.mango.pathfinder.model.astar.Node;
import io.mango.pathfinder.model.astar.Robot;
import io.mango.pathfinder.model.astar.Scenario;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AStarService {

    public Set<Node> findCheapestPath(Scenario scenario) {
        Set<Node> solution = new HashSet<>();
        Robot robot = scenario.getRobot();
        if(scenario.getStartNode().isClosed()) {
            scenario.getStartNode().open();
        }
        Node current;

        while(true) {
            current = scenario.getOpenNodes().poll();
            if(current == null) {
                break;
            }

            current.close();

            if(current.equals(scenario.getEndNode())) {
                return solution;
            }

            Node target;

            if (current.getX() - 1 >= 0) {
                target = scenario.getNode(current.getX() - 1, current.getY());
                updateCostIfNeeded(current, target, current.getFinalCost() + robot.getVHCost());

                if (current.getY() - 1 >= 0) {
                    target = scenario.getNode(current.getX() - 1, current.getY() - 1);
                    updateCostIfNeeded(current, target, current.getFinalCost() + robot.getDiagonalCost());
                }

                if(current.getY() + 1 < scenario.getMapHeight()) {
                    target = scenario.getNode(current.getX() - 1, current.getY() + 1);
                    updateCostIfNeeded(current, target, current.getFinalCost() + robot.getDiagonalCost());
                }
            }

            if(current.getY() - 1 >= 0) {
                target = scenario.getNode(current.getX(), current.getY() - 1);
                updateCostIfNeeded(current, target, current.getFinalCost() + robot.getVHCost());
            }

            if(current.getY() + 1 < scenario.getMapHeight()) {
                target = scenario.getNode(current.getX(), current.getY() + 1);
                updateCostIfNeeded(current, target, current.getFinalCost() + robot.getVHCost());
            }

            if (current.getX() + 1 < scenario.getMapWidth()) {
                target = scenario.getNode(current.getX() + 1, current.getY());
                updateCostIfNeeded(current, target, current.getFinalCost() + robot.getVHCost());

                if (current.getY() - 1 >= 0) {
                    target = scenario.getNode(current.getX() + 1, current.getY() - 1);
                    updateCostIfNeeded(current, target, current.getFinalCost() + robot.getDiagonalCost());
                }

                if(current.getY() + 1 < scenario.getMapHeight()) {
                    target = scenario.getNode(current.getX() + 1, current.getY() + 1);
                    updateCostIfNeeded(current, target, current.getFinalCost() + robot.getDiagonalCost());
                }
            }

        }

        if (scenario.getEndNode().isClosed()) {
            Node currentNode = scenario.getEndNode();

            while(currentNode != null) {
                solution.add(currentNode);
                currentNode = currentNode.getParent();
            }
        }

        return solution;
    }

    private void updateCostIfNeeded(Node current, Node target, int cost) {
        if (target == null || target.isClosed()) {
            return;
        }

        int projectedCost = target.getHeuristicCost() + cost;
        if (target.isClosed() || projectedCost < target.getFinalCost()) {
            target.setFinalCost(projectedCost);
            target.setParent(current);

            if(target.isClosed()) {
                target.open();
            }
        }
    }
}
