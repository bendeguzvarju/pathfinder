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
import java.util.stream.Stream;

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
        map.setNode(startNode);
        this.startNode = startNode;
        map.setNode(endNode);
        this.endNode = endNode;
        this.map = map;
        this.robot = robot;
        this.setupGrid();
    }

    public PriorityQueue<Node> getOpenNodes() {
        return map.getOpenNodes();
    }

    public void setNode(Node node) {
        this.map.setNode(node);
    }

    public Node getNode(int x, int y) {
        return this.map.getNode(x,y);
    }

    public Set<Node> getClosedNodes() {
        return map.getClosedNodes();
    }

    private void setupGrid() {
        startNode.setFinalCost(0);
        Stream.of(map.getGrid())
                .flatMap(Stream::of)
                .forEach(this::setInitialState);
    }

    private void setInitialState(Node node) {
        if(node != null) {
            node.setHeuristicCost(Math.abs(node.getX() - endNode.getX()) + Math.abs(node.getY() - endNode.getY()));
            node.setSolution(false);
        }
    }

    public Set<Node> findNeighbours(Node currentNode) {
        return map.findNeighbours(currentNode);
    }

    public void displayMap() {
        Node node;
        for (int x = 0; x < map.getWidth(); x++) {
            for(int y = 0; y < map.getHeight(); y++) {
                node = getNode(x,y);
                if (node == null) {
                    System.out.print("B ");
                } else if (node.equals(startNode)) {
                    System.out.print("S ");
                } else if (node.equals(endNode)){
                    System.out.print("E ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }

    public void displaySolution() {

    }
}
