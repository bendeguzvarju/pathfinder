package io.mango.pathfinder.service;

import io.mango.pathfinder.model.map.Node;
import io.mango.pathfinder.model.scenario.Scenario;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class DijkstraService implements PathFinder{

    public Set<Node> findCheapestPath(Scenario scenario) {
        Set<Node> solution = new HashSet<>();


        return solution;
    }
}
