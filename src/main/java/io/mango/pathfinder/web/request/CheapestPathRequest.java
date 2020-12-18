package io.mango.pathfinder.web.request;

import io.mango.pathfinder.web.dto.AStarMapDto;
import io.mango.pathfinder.web.dto.AStarNodeDto;
import io.mango.pathfinder.web.dto.AStarRobotDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CheapestPathRequest {
    private AStarNodeDto startNode;
    private AStarNodeDto endNode;
    private AStarMapDto map;
    private AStarRobotDto robot;
}
