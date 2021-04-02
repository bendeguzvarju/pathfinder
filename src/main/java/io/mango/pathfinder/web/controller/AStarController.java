package io.mango.pathfinder.web.controller;

import io.mango.pathfinder.model.map.Node;
import io.mango.pathfinder.service.AStarService;
import io.mango.pathfinder.web.request.ImageProcessingRequest;
import io.mango.pathfinder.web.request.PathRequest;
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

    @GetMapping("/square")
    public Set<Node> findSquarePath(@RequestBody @Valid PathRequest request) {
        return aStarService.findCheapestPath(pathRequestToSquareScenarioTransformer.transform(request));
    }

    @GetMapping("/hex")
    public Set<Node> findHexPath(@RequestBody @Valid PathRequest request) {
        return aStarService.findCheapestPath(pathRequestToHexScenarioTransformer.transform(request));
    }

    @GetMapping("/square/image")
    public Set<Node> findSquarePathOnImage(@RequestBody @Valid ImageProcessingRequest request) {
        return null;
    }

    @GetMapping("/hex/image")
    public Set<Node> findHexPathOnImage(@RequestBody @Valid ImageProcessingRequest request) {
        return null;
    }


}
