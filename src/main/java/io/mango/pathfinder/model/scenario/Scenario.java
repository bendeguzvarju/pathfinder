package io.mango.pathfinder.model.scenario;

import io.mango.pathfinder.model.astar.Robot;
import io.mango.pathfinder.model.map.Map;
import io.mango.pathfinder.model.map.Node;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.PriorityQueue;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class Scenario {
    private Map map;
    private Robot robot;
    private Node startNode;
    private Node endNode;

    public Scenario(Map map, Robot robot, Node startNode, Node endNode) {
        startNode.setFinalCost(0);
        map.setNode(startNode);
        this.startNode = startNode;
        map.setNode(endNode);
        this.endNode = endNode;
        this.map = map;
        this.robot = robot;
    }

    public PriorityQueue<Node> getOpenNodes() {
        return map.getOpenNodes();
    }

    public void setNode(Node node) {
        map.setNode(node);
    }

    public Node getNode(int x, int y) {
        return map.getNode(x,y);
    }

    public Set<Node> getClosedNodes() {
        return map.getClosedNodes();
    }

    public void setHeuristicCostForNodes(Node endNode) {
        map.setHeuristicCostForNodes(endNode);
    }

    public Set<Node> findNeighbours(Node currentNode) {
        return map.findNeighbours(currentNode);
    }

    public void displayHeuristicMap() {
        map.displayHeuristicMap();
    }

    public void displayFinalCosts() {
        map.displayFinalCosts();
    }
}
