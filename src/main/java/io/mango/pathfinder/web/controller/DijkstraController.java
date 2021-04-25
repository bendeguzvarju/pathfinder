package io.mango.pathfinder.web.controller;

import io.mango.pathfinder.model.astar.Robot;
import io.mango.pathfinder.model.map.Node;
import io.mango.pathfinder.service.DijkstraService;
import io.mango.pathfinder.web.request.ImageProcessingRequestView;
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

    private static final String FIND_SQUARE_PATH = "/square";
    private static final String FIND_HEX_PATH = "/hex";
    private static final String FIND_SQUARE_PATH_FROM_IMAGE = "/square/image";
    private static final String FIND_HEX_PATH_FROM_IMAGE = "/hex/image";
    @Autowired
    private DijkstraService dijkstraService;
    @Autowired
    private PathRequestToSquareScenarioTransformer pathRequestToSquareScenarioTransformer;
    @Autowired
    private PathRequestToHexScenarioTransformer pathRequestToHexScenarioTransformer;

    @GetMapping(FIND_SQUARE_PATH)
    public Set<Node> findSquarePath(@RequestBody @Valid PathRequest request) {
        return dijkstraService.findCheapestPath(pathRequestToSquareScenarioTransformer.transform(request));
    }

    @GetMapping(FIND_HEX_PATH)
    public Set<Node> findHexPath(@RequestBody @Valid PathRequest request) {
        return dijkstraService.findCheapestPath(pathRequestToHexScenarioTransformer.transform(request));
    }

    @GetMapping(FIND_SQUARE_PATH_FROM_IMAGE)
    public ImageProcessingRequestView findSquarePathOnImage(@RequestBody @Valid ImageProcessingRequestView request) {
        ImageProcessingRequestView response = new ImageProcessingRequestView();
        response.setHeight(2);
        response.setWidth(3);
        response.setImage("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAoAAAAKCAIAAAACUFjqAAAABGdBTUEAALGPC/xhBQAAAAlwSFlzAAASdAAAEnQB3mYfeAAAAEFJREFUKFN9jQEKACAIA/f/T1tpm2bRETE9hgDsw5Lwv6JN1zPH41hWVQS9t4fskNt5INJynolWlUNnj0cfjcRsAFze9QtX6DSTAAAAAElFTkSuQmCC");
        response.setRobot(new Robot(5,6));
        return response;
    }

    @GetMapping("/square/image2")
    public ImageProcessingRequestView findSquarePathOnImage2() {
        ImageProcessingRequestView response = new ImageProcessingRequestView();
        response.setHeight(2);
        response.setWidth(3);
        response.setImage("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAoAAAAKCAIAAAACUFjqAAAABGdBTUEAALGPC/xhBQAAAAlwSFlzAAASdAAAEnQB3mYfeAAAAEFJREFUKFN9jQEKACAIA/f/T1tpm2bRETE9hgDsw5Lwv6JN1zPH41hWVQS9t4fskNt5INJynolWlUNnj0cfjcRsAFze9QtX6DSTAAAAAElFTkSuQmCC");
        response.setRobot(new Robot(5,6));
        return response;
    }

    @GetMapping(FIND_HEX_PATH_FROM_IMAGE)
    public Set<Node> findHexPathOnImage(@RequestBody @Valid ImageProcessingRequestView request) {
        return null;
    }
}
