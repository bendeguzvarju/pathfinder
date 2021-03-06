package io.mango.pathfinder.web.transformer;

import io.mango.pathfinder.model.scenario.Scenario;
import io.mango.pathfinder.web.request.PathRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PathRequestToSquareScenarioTransformer {

    @Autowired
    private GridToSquareMapTransformer gridToSquareMapTransformer;

    public Scenario transform(PathRequest request) {
        Scenario scenario = new Scenario();
        scenario.setMap(null);

        return scenario;
    }
}
