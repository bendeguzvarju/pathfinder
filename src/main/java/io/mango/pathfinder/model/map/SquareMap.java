package io.mango.pathfinder.model.map;

import io.mango.pathfinder.model.astar.Robot;

import java.util.HashSet;
import java.util.Set;

public class SquareMap extends Map {
    private static final int VERTICAL_MOVE_COST = 10;
    private static final int HORIZONTAL_MOVE_COST = 10;
    private static final int DIAGONAL_MOVE_COST = 14;

    public SquareMap() {

    }
    public SquareMap(int width, int height) {
        Node[][] nodeGrid = new Node[width][height];
        Node node;
        for(int x = 0; x < nodeGrid.length; x++) {
            for(int y = 0;y < nodeGrid[0].length; y++) {
                node = new Node(x,y);
                nodeGrid[x][y] = node;
            }
        }
        this.setGrid(nodeGrid);

    }

    public void setGrid(Node[][] grid) {
        this.grid = grid;
        this.setWidth(grid.length);
        this.setHeight(grid[0].length);
    }

    @Override
    public Node getNode(int x, int y) {
        return grid[x][y];
    }

    @Override
    public void setNode(Node node) {
        grid[node.getX()][node.getY()] = node;
    }

    @Override
    public void addBlock(int x, int y) {
        grid[x][y] = null;
    }

    @Override
    public Set<Node> findNeighbours(Node node) {
        Set<Node> neighbours = new HashSet<>();
        Node neighbour;
        if(node != null) {
            for(int i = -1; i <= 1; i++) {
                for(int j = -1; j <= 1; j++) {
                    int targetX = node.getX() + i;
                    int targetY = node.getY() + j;
                    if (isOnGrid(targetX, targetY)) {
                        neighbour = this.getNode(targetX, targetY);
                        if(neighbour != null && !neighbour.equals(node)) {
                            neighbours.add(neighbour);
                        }
                    }
                }
            }
        }
        return neighbours;
    }

    @Override
    public boolean areNeighbours(Node node1, Node node2) {
        return findNeighbours(node1).contains(node2);
    }

    private boolean isOnGrid(int x, int y) {
        return x >= 0 && y >= 0 && x < getWidth() && y < getHeight();
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

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        for(int x = 0; x < this.getWidth(); x++) {
            for(int y = 0; y < this.getHeight(); y++) {
                result.append(this.getNode(x, y));
            }
            result.append("\n");
        }
        return result.toString();
    }
}
