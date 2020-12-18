package io.mango.pathfinder.web.transformer;

import io.mango.pathfinder.model.astar.Scenario;
import io.mango.pathfinder.web.request.CheapestPathRequest;
import org.springframework.stereotype.Service;

@Service
public class CheapestPathRequestToScenarioTransformer {

    public Scenario transform(CheapestPathRequest request) {
        Scenario scenario = Scenario.builder()
                .build();

        return scenario;
    }
}
