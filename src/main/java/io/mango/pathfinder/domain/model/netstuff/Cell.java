package io.mango.pathfinder.domain.model.netstuff;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cell {
    public int i;
    public int j;
    public Cell parent;
    public int heuristicCost;
    public int finalCost;
    public boolean solution;

    public Cell(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public String toString() {
        return "[" + i + "," + j +"]";
    }
}
