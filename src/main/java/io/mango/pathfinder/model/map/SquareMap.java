package io.mango.pathfinder.model.map;

import io.mango.pathfinder.model.astar.Robot;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class SquareMap extends Map {
    private static final int VERTICAL_MOVE_COST = 10;
    private static final int HORIZONTAL_MOVE_COST = 10;
    private static final int DIAGONAL_MOVE_COST = 14;
    public static final int FORMATTED_FINAL_COST_LENGTH = 3;

    public SquareMap() {

    }
    public SquareMap(int width, int height, String compareBy) {
        super(compareBy);
        Node[][] nodeGrid = new Node[width][height];
        Node node;
        for(int x = 0; x < width; x++) {
            for(int y = 0;y < height; y++) {
                node = new Node(x,y);
                nodeGrid[x][y] = node;
            }
        }
        this.setGrid(nodeGrid);
    }

    @Override
    public void setHeuristicCostForNodes(Node endNode) {
        Stream.of(this.getGrid())
                .flatMap(Stream::of)
                .forEach(node -> setHeuristicCost(node, endNode));
    }

    private void setHeuristicCost(Node node, Node endNode) {
        if(node != null) {
            node.setHeuristicCost(Math.abs(node.getX() - endNode.getX()) + Math.abs(node.getY() - endNode.getY()));
            node.setSolution(false);
        }
    }

    @Override
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
        getNode(x,y).setBlock(true);
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
                        if(!neighbour.isBlock() && !neighbour.equals(node)) {
                            neighbours.add(neighbour);
                        }
                    }
                }
            }
        }
        return neighbours;
    }

    private boolean isOnGrid(int x, int y) {
        return x >= 0 && y >= 0 && x < getWidth() && y < getHeight();
    }

    @Override
    public boolean areNeighbours(Node node1, Node node2) {
        return findNeighbours(node1).contains(node2);
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
    public void displayHeuristicMap() {
        StringBuilder result = new StringBuilder();
        for(int x = 0; x < this.getWidth(); x++) {
            for(int y = 0; y < this.getHeight(); y++) {
                String representation;
                if (this.getNode(x,y).isBlock()) {
                    representation = "[-]";
                } else {
                    representation = "[" + this.getNode(x, y).getHeuristicCost() + "]";
                }
                result.append(representation);
            }
            result.append("\n");
        }
        System.out.println(result.toString());
    }

    @Override
    public void displayFinalCosts() {
        StringBuilder result = new StringBuilder();
        for(int x = 0; x < this.getWidth(); x++) {
            for(int y = 0; y < this.getHeight(); y++) {
                String formattedString = formatToFixedLengthString(String.valueOf(this.getNode(x, y).getFinalCost()));
                result.append("[").append(formattedString).append("]");
            }
            result.append("\n");
        }
        System.out.println(result.toString());
    }

    private String formatToFixedLengthString(String string) {
        return String.format("%1$"+ FORMATTED_FINAL_COST_LENGTH + "s", string);
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        Node node;
        for(int x = 0; x < this.getWidth(); x++) {
            for(int y = 0; y < this.getHeight(); y++) {
                node = this.getNode(x, y);
                if (node.isSolution()) {
                    result.append("[ X ]");
                } else if(node.isBlock()){
                    result.append("[ B ]");
                } else {
                    result.append(node);
                }
            }
            result.append("\n");
        }
        return result.toString();
    }
}
