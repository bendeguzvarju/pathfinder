package io.mango.pathfinder.web.controller.astar;

import io.mango.pathfinder.model.map.HexMap;
import io.mango.pathfinder.model.map.Node;
import io.mango.pathfinder.service.AStarService;
import io.mango.pathfinder.web.request.MapRequest;
import io.mango.pathfinder.web.request.PathRequest;
import io.mango.pathfinder.web.response.MapResponse;
import io.mango.pathfinder.web.transformer.PathRequestToHexScenarioTransformer;
import io.mango.pathfinder.web.transformer.PathRequestToSquareScenarioTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    private PathRequestToSquareScenarioTransformer pathRequestToSquareScenarioTransformer;
    @Autowired
    private PathRequestToHexScenarioTransformer pathRequestToHexScenarioTransformer;

    @GetMapping("/square-map")
    public Set<Node> findSquarePath(@RequestBody @Valid PathRequest request) {
        return aStarService.findCheapestPath(pathRequestToSquareScenarioTransformer.transform(request));
    }

    public MapResponse findSquarePath(@RequestBody @Valid MapRequest request) {
        return null;
    }

    @GetMapping("/hex-map")
    public Set<Node> findHexPath(@RequestBody @Valid PathRequest request) {
        return aStarService.findCheapestPath(pathRequestToHexScenarioTransformer.transform(request));
    }

}
