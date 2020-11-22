package io.mango.pathfinder.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.PriorityQueue;
import java.util.Set;

@Getter
@Setter
public class Map {
    private Node[][] grid;
    private Node startNode;
    private Node endNode;
    private PriorityQueue<Node> openNodes;
    private Set<Node> closedNodes;

    /*
    i = node.getX()

     */

    public Map(Node startNode, Node endNode, Node[][] grid) {
        this.startNode = startNode;
        this.endNode = endNode;
        this.grid = grid;
        this.startNode.setFinalCost(0);



        for(Node[] row : grid) {
            for(Node node : row) {
                node.setHeuristicCost(Math.abs(node.getX() - endNode.getX()) + Math.abs(node.getY() - endNode.getY()));
            }
        }

    }

    public Node getNode(int x, int y) {
        return grid[x][y];
    }

    private void updateCostIfNeeded(Node currentNode, Node targetNode, int cost) {
        if(targetNode == null || targetNode.isClosed()) {
            return;
        }
        int targetFinalCost = targetNode.getFinalCost() + cost;

    }

}
