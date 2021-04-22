package io.mango.pathfinder.service;

import io.mango.pathfinder.model.map.Node;
import io.mango.pathfinder.model.scenario.Scenario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PathfinderServiceFacade {
    @Autowired
    private AStarService aStarService;
    @Autowired
    private DijkstraService dijkstraService;

    public Set<Node> findAStarPath(Scenario scenario) {
        return aStarService.findCheapestPath(scenario);
    }

    public Set<Node> findDijkstraPath(Scenario scenario) {
        return dijkstraService.findCheapestPath(scenario);
    }
}
