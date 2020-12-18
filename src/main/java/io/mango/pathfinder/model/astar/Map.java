package io.mango.pathfinder.model.astar;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.PriorityQueue;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Map {
    private int id;
    private Node[][] grid; //[height=y][width=x]
    PriorityQueue<Node> openNodes;

    public Node getNode(int x, int y) {
        return grid[y][x];
    }
    public void setNode(Node node) {
        grid[node.getY()][node.getX()] = node;
    }

    public Node poll() {
        Node node = openNodes.poll();
        if (node != null) {
            node.close();
        }
        return node;
    }

    public int getWidth(){
        return grid.length;
    }

    public int getHeight(){
        return grid[0].length;
    }

    public Set<Node> findNeighbours(Node node) {
        return node.findNeighbours();
    }
}

