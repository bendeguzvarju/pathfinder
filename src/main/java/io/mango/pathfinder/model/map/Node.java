package io.mango.pathfinder.model.map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Node {
    private int x;
    private int y;
    private Node parent;
    private int heuristicCost;
    private int finalCost;
    private boolean solution;
    private boolean block;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
        this.block = false;
        this.solution = false;
    }

    @Override
    public String toString() {

        String result = "[" + this.x + ";" + this.y + "]";

        return result;
    }

}
