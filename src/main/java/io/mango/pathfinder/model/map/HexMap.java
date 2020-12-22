package io.mango.pathfinder.model.map;

import io.mango.pathfinder.model.astar.Robot;

import java.util.HashSet;
import java.util.Set;

/*
 h [0][0][0][0]
 e  [0][0][0][0]
 i [0][0][0][0]
 g  [0][0][0][0]
 h [0][0][0][0]
 t  [0][0][0][0]
      width
 */
public class HexMap extends Map {
    private static final int MOVE_COST = 10;

    @Override
    public Node getNode(int x, int y) {
        return grid[y][x];
    }

    @Override
    public void setNode(Node node) {
        grid[node.getY()][node.getX()] = node;
    }

    @Override
    public void addBlock(int x, int y) {

    }

    @Override
    public Set<Node> findNeighbours(Node node) {
        Set<Node> neighbours = new HashSet<>();

        return neighbours;
    }

    @Override
    public boolean areNeighbours(Node node1, Node node2) {
        return findNeighbours(node1).contains(node2);
    }

    @Override
    public int calculateMoveCost(Node node1, Node node2, Robot robot) {
        return MOVE_COST * robot.getHorizontalMoveCoefficient();
    }
}
