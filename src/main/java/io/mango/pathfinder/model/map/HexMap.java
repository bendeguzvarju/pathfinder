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
 t     width
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
    public int getWidth() {
        return grid.length;
    }

    @Override
    public int getHeight() {
        return grid[0].length;
    }

    @Override
    public Set<Node> findNeighbours(Node node) {
        Set<Node> neighbours = new HashSet<>();

        return neighbours;
    }

    @Override
    public int calculateMoveCost(Node node1, Node node2, Robot robot) {
        return MOVE_COST * robot.getHorizontalMoveCoefficient();
    }
}
