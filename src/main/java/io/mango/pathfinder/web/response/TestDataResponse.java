package io.mango.pathfinder.web.response;

import io.mango.pathfinder.model.scenario.Scenario;
import lombok.Data;

import java.util.Set;


@Data
public class TestDataResponse {
    private Set<Scenario> scenarios;

}
