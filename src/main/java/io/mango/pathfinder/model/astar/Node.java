package io.mango.pathfinder.model.astar;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Node {
    private int x;
    private int y;
    private Map map;
    private Node parent;
    private int heuristicCost;
    private int finalCost;
    private boolean solution;
    private boolean isOpen;

    public void open() {
        setOpen(true);
        map.getOpenNodes().add(this);
    }

    public void close() {
        setOpen(false);
        map.getOpenNodes().remove(this);
    }

    public boolean isClosed() {
        return !isOpen;
    }

    public Set<Node> findNeighbours() {
        Set<Node> neighbours = new HashSet<Node>();

        for(int x = -1; x <= 1; x++) {
            for(int y = -1; y <= 1; y++) {
                if(!(x == 0 && y ==0)) {
                    neighbours.add(map.getNode(this.getX() + x, this.getY() + y));
                }
            }
        }

        return neighbours;
    }

    @Override
    public String toString() {
        return "[" + x + "," + y +"]";
    }
}
