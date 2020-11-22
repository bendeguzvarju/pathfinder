package io.mango.pathfinder.domain.service;

import io.mango.pathfinder.domain.model.Map;
import io.mango.pathfinder.domain.model.Node;
import io.mango.pathfinder.domain.model.Robot;

import java.util.LinkedList;

public interface PathCalculator {

    public LinkedList<Node> getShortestPath(Map map, Robot robot);
}
