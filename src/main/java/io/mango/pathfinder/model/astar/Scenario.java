package io.mango.pathfinder.model.astar;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.PriorityQueue;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Scenario {
    private Map map;
    private Node startNode;
    private Node endNode;
    private Robot robot;

    public PriorityQueue<Node> getOpenNodes() {
        return map.getOpenNodes();
    }

    public Node getNode(int x, int y) {
        return map.getNode(x, y);
    }

    public int getMapWidth() {
        return map.getWidth();
    }

    public int getMapHeight() {
        return map.getHeight();
    }
}
