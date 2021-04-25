package io.mango.pathfinder.web.controller;

import io.mango.pathfinder.model.astar.Robot;
import io.mango.pathfinder.service.TestDataGeneratorService;
import io.mango.pathfinder.web.request.ImageProcessingRequestView;
import io.mango.pathfinder.web.response.TestDataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test-data")
public class TestDataController {
    @Autowired
    private TestDataGeneratorService testDataGeneratorService;

    private static final String GENERATE_TEST_DATA = "/generate-test-data";

    @GetMapping(GENERATE_TEST_DATA)
    public TestDataResponse generateTestData() {
        ImageProcessingRequestView response = new ImageProcessingRequestView();
        response.setHeight(2);
        response.setWidth(3);
        response.setImage("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAoAAAAKCAIAAAACUFjqAAAABGdBTUEAALGPC/xhBQAAAAlwSFlzAAASdAAAEnQB3mYfeAAAAEFJREFUKFN9jQEKACAIA/f/T1tpm2bRETE9hgDsw5Lwv6JN1zPH41hWVQS9t4fskNt5INJynolWlUNnj0cfjcRsAFze9QtX6DSTAAAAAElFTkSuQmCC");
        response.setRobot(new Robot(5,6));
        return testDataGeneratorService.generateRandomSquareDijkstraTestData(1);
    }
}
