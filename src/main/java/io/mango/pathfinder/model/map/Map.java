package io.mango.pathfinder.model.map;

import io.mango.pathfinder.model.astar.Robot;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

@Getter
@Setter
public abstract class Map {
    protected Node[][] grid;
    protected PriorityQueue<Node> openNodes;
    protected Set<Node> closedNodes;
    private int width;
    private int height;

    public Map() {
        PriorityQueue<Node> openNodes = new PriorityQueue<Node>((Node node1, Node node2) -> Integer.compare(node1.getFinalCost(), node2.getFinalCost()));
        this.openNodes = openNodes;
        this.setClosedNodes(new HashSet<Node>());
    }

    public abstract Node getNode(int x, int y);

    public abstract void setNode(Node node);

    public abstract Set<Node> findNeighbours(Node node);

    public abstract int calculateMoveCost(Node node1, Node node2, Robot robot);

}
