package io.mango.pathfinder.web.controller.astar;

import io.mango.pathfinder.model.map.Node;
import io.mango.pathfinder.service.AStarService;
import io.mango.pathfinder.web.request.CheapestPathRequest;
import io.mango.pathfinder.web.transformer.CheapestPathRequestToScenarioTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

import javax.validation.Valid;

@RestController
@RequestMapping("/astar")
public class AStarController {

    @Autowired
    private AStarService aStarService;

    @Autowired
    private CheapestPathRequestToScenarioTransformer cheapestPathRequestToScenarioTransformer;

    public Set<Node> findCheapestPath(@RequestBody @Valid CheapestPathRequest request) {
        return aStarService.findCheapestPath(cheapestPathRequestToScenarioTransformer.transform(request));
    }

}
