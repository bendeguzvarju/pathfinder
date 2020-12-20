package io.mango.pathfinder.web.controller.astar;

import io.mango.pathfinder.model.map.Node;
import io.mango.pathfinder.service.DijkstraService;
import io.mango.pathfinder.web.request.PathRequest;
import io.mango.pathfinder.web.transformer.PathRequestToHexScenarioTransformer;
import io.mango.pathfinder.web.transformer.PathRequestToSquareScenarioTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/dijkstra")
public class DijkstraController {

    @Autowired
    private DijkstraService dijkstraService;
    @Autowired
    private PathRequestToSquareScenarioTransformer pathRequestToSquareScenarioTransformer;
    @Autowired
    private PathRequestToHexScenarioTransformer pathRequestToHexScenarioTransformer;

    @GetMapping("/square-map")
    public Set<Node> findSquarePath(@RequestBody @Valid PathRequest request) {
        return dijkstraService.findCheapestPath(pathRequestToSquareScenarioTransformer.transform(request));
    }

    @GetMapping("/hex-map")
    public Set<Node> findHexPath(@RequestBody @Valid PathRequest request) {
        return dijkstraService.findCheapestPath(pathRequestToHexScenarioTransformer.transform(request));
    }
}
