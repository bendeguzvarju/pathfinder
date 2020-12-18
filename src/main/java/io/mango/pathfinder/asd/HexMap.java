package io.mango.pathfinder.asd;

import java.util.Set;

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
        return null;
    }

    @Override
    public int calculateMoveCost(Node node1, Node node2, Robot robot) {
        return MOVE_COST * robot.getHorizontalMoveCoefficient();
    }
}
