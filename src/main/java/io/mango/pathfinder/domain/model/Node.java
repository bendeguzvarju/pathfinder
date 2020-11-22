package io.mango.pathfinder.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node {
    private int x;
    private int y;
    private Node parent;
    private int heuristicCost;
    private int finalCost;
    private boolean isClosed;
    private boolean isSolution;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
        this.isSolution = false;

    }

}
