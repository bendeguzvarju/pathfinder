package io.mango.pathfinder.model.map;

import io.mango.pathfinder.model.astar.Robot;
import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.function.ToIntFunction;

@Getter
@Setter
public abstract class Map {
    protected Node[][] grid;
    protected PriorityQueue<Node> openNodes;
    protected Set<Node> closedNodes;
    private int width;
    private int height;

    public Map() {

    }

    public Map(ToIntFunction<Node> compareBy) {
        PriorityQueue<Node> openNodes = new PriorityQueue<Node>(Comparator.comparingInt(compareBy));
        this.openNodes = openNodes;
        this.setClosedNodes(new HashSet<Node>());
    }

    public abstract Node getNode(int x, int y);

    public abstract void setNode(Node node);

    public abstract void addBlock(int x, int y);

    public abstract void setGrid(Node[][] grid);

    public abstract Set<Node> findNeighbours(Node node);

    public abstract boolean areNeighbours(Node node1, Node node2);

    public abstract void setHeuristicCostForNodes(Node endNode);

    public abstract int calculateMoveCost(Node node1, Node node2, Robot robot);

    public abstract void displayHeuristicMap();

    public abstract void displayFinalCosts();

}
