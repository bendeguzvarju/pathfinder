package io.mango.pathfinder.asd;

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
                    if (node.getX() + i >= 0 && node.getY() + j >= 0) {
                        if(!(i == 0 && j ==0)) {
                            neighbour = this.getNode(node.getX() + i, node.getY() + j);
                            if(neighbour != null) {
                                neighbours.add(neighbour);
                            }
                        }
                    }
                }
            }
        }
        return neighbours;
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
