package io.mango.pathfinder.service;

import io.mango.pathfinder.model.map.Node;
import io.mango.pathfinder.model.scenario.Scenario;

import java.util.Set;

public interface PathFinder {
    Set<Node> findCheapestPath(Scenario scenario);
}
