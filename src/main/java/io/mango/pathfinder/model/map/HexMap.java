package io.mango.pathfinder.model.map;

import io.mango.pathfinder.model.astar.Robot;

import java.util.HashSet;
import java.util.Set;

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

    public HexMap() {

    }
    public HexMap(int width, int height) {
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

    private boolean isOnGrid(int x, int y) {
        return x >= 0 && y >= 0 && x < getWidth() && y < getHeight();
    }

    @Override
    public int calculateMoveCost(Node node1, Node node2, Robot robot) {
        return MOVE_COST * robot.getHorizontalMoveCoefficient();
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        int count = 0;
        for(int x = 0; x < this.getWidth(); x++) {
            if(count % 2 == 0) {
                result.append("  ");
            }
            for(int y = 0; y < this.getHeight(); y++) {
                result.append(this.getNode(x, y));
            }
            result.append(" end of column \n");
            count++;
        }
        return result.toString();
    }

    private int[][] rotateGrid(int[][] grid) {

        return grid;
    }
}
