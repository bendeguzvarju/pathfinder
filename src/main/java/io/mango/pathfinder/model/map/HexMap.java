package io.mango.pathfinder.model.map;

import io.mango.pathfinder.model.astar.Robot;

import java.util.HashSet;
import java.util.Set;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

public class HexMap extends Map {
    private static final int MOVE_COST = 10;
    private static final Node[] ODD_COLUMN_RELATIVE_NEIGHBOUR_CANDIDATES = {
            new Node(-1,0),
            new Node(0,-1),
            new Node(1,0),
            new Node(-1,1),
            new Node(0,1),
            new Node(1,1)
    };

    private static final Node[] EVEN_COLUMN_RELATIVE_NEIGHBOUR_CANDIDATES = {
            new Node(-1,-1),
            new Node(-1,0),
            new Node(1,-1),
            new Node(0,1),
            new Node(0,-1),
            new Node(1,0)
    };
    private static final int FORMATTED_FINAL_COST_LENGTH = 3;

    public HexMap() {

    }
    public HexMap(int width, int height, ToIntFunction<Node> compareBy) {
        super(compareBy);
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
        Node[] relativeNeighbourCandidates;
        if(isOddColumnNode(node)) {
            relativeNeighbourCandidates = ODD_COLUMN_RELATIVE_NEIGHBOUR_CANDIDATES;
        } else {
            relativeNeighbourCandidates = EVEN_COLUMN_RELATIVE_NEIGHBOUR_CANDIDATES;
        }

        for(Node relativeNeighbourCandidate : relativeNeighbourCandidates) {
            int candidateX = node.getX() + relativeNeighbourCandidate.getX();
            int candidateY = node.getY() + relativeNeighbourCandidate.getY();
            if(isOnGrid(candidateX,candidateY)) {
                Node candidate = getNode(candidateX, candidateY);
                if(candidate != null || !candidate.isBlock()) {
                    neighbours.add(candidate);
                }
            }

        }
        return neighbours;
    }

    private boolean isOddColumnNode(Node node) {
        return node.getX() % 2 == 0;
    }

    @Override
    public boolean areNeighbours(Node node1, Node node2) {
        return findNeighbours(node1).contains(node2);
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

    private boolean isOnGrid(int x, int y) {
        return x >= 0 && y >= 0 && x < getWidth() && y < getHeight();
    }

    @Override
    public int calculateMoveCost(Node node1, Node node2, Robot robot) {
        return MOVE_COST * robot.getHorizontalMoveCoefficient();
    }

    @Override
    public void displayHeuristicMap() {
        StringBuilder result = new StringBuilder();
        int currentColumn = 0;
        for(int x = 0; x < this.getWidth(); x++) {
            if(currentColumn % 2 == 0) {
                result.append("  ");
            }
            for(int y = 0; y < this.getHeight(); y++) {
                String formattedString = formatToFixedLengthString(String.valueOf(this.getNode(x, y).getHeuristicCost()));
                result.append("[").append(formattedString).append("]");
            }
            result.append("\n");
            currentColumn++;
        }
        System.out.println(result.toString());
    }

    private String formatToFixedLengthString(String string) {
        return String.format("%1$"+ FORMATTED_FINAL_COST_LENGTH + "s", string);
    }

    @Override
    public void displayFinalCosts() {
        StringBuilder result = new StringBuilder();
        int currentColumn = 0;
        for(int x = 0; x < this.getWidth(); x++) {
            if(currentColumn % 2 == 0) {
                result.append("  ");
            }
            for(int y = 0; y < this.getHeight(); y++) {
                String formattedString = formatToFixedLengthString(String.valueOf(this.getNode(x, y).getFinalCost()));
                result.append("[").append(formattedString).append("]");
            }
            result.append("\n");
            currentColumn++;
        }
        System.out.println(result.toString());
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        int currentColumn = 0;
        for(int x = 0; x < this.getWidth(); x++) {
            if(currentColumn % 2 == 0) {
                result.append("  ");
            }
            for(int y = 0; y < this.getHeight(); y++) {
                Node node = this.getNode(x, y);
                if(node.isBlock()){
                    result.append("[ B ]");
                } else if (node.isSolution()) {
                    result.append("[ X ]");
                } else {
                    result.append(node);
                }
            }
            result.append("\n");
            currentColumn++;
        }
        return result.toString();
    }

}
