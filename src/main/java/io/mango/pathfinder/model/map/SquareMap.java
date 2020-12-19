package io.mango.pathfinder.model.map;

import io.mango.pathfinder.model.astar.Robot;

import java.util.HashSet;
import java.util.Set;

public class SquareMap extends Map {
    private static final int VERTICAL_MOVE_COST = 10;
    private static final int HORIZONTAL_MOVE_COST = 10;
    private static final int DIAGONAL_MOVE_COST = 14;

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
        Node neighbour;
        if(node != null) {
            for(int i = -1; i <= 1; i++) {
                for(int j = -1; j <= 1; j++) {
                    int columnIndex = node.getX() + i;
                    int rowIndex = node.getY() + j;
                    if (isOnGrid(columnIndex, rowIndex)) {
                        neighbour = this.getNode(columnIndex, rowIndex);
                        if(neighbour != null && !neighbour.equals(node)) {
                            neighbours.add(neighbour);
                        }
                    }
                }
            }
        }
        return neighbours;
    }

    private boolean isOnGrid(int columnIndex, int rowIndex) {
        return columnIndex >= 0 && rowIndex >= 0;
    }

    @Override
    public int calculateMoveCost(Node current, Node target, Robot robot) {
        int cost;
        if(verticalNeighbours(current, target)) {
            cost = VERTICAL_MOVE_COST * robot.getVerticalMoveCoefficient();
        } else if(horizontalNeighbours(current, target)) {
            cost = HORIZONTAL_MOVE_COST * robot.getHorizontalMoveCoefficient();
        } else if(current.equals(target)) {
            cost = 0;
        } else {
            cost = DIAGONAL_MOVE_COST * robot.getHorizontalMoveCoefficient();
        }
        return cost + current.getFinalCost();
    }

    private boolean verticalNeighbours(Node node1, Node node2) {
        return node1.getY() == node2.getY();
    }

    private boolean horizontalNeighbours(Node node1, Node node2) {
        return node1.getX() == node2.getX();

    }
}
