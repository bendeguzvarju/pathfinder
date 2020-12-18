package io.mango.pathfinder.asd;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.PriorityQueue;
import java.util.Set;

@Getter
@Setter
public abstract class Map {
    protected Node[][] grid;
    protected PriorityQueue<Node> openNodes;
    protected Set<Node> closedNodes;

    public Map() {
        PriorityQueue<Node> openNodes = new PriorityQueue<Node>((Node node1, Node node2) -> Integer.compare(node1.getFinalCost(), node2.getFinalCost()));
        this.openNodes = openNodes;
    }

    public abstract Node getNode(int x, int y);

    public abstract void setNode(Node node);

    public abstract int getWidth();

    public abstract int getHeight();

    public abstract Set<Node> findNeighbours(Node node);

    public abstract int calculateMoveCost(Node node1, Node node2, Robot robot);

}
