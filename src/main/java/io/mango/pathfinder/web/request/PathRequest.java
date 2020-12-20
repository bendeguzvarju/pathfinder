package io.mango.pathfinder.web.request;

import io.mango.pathfinder.web.dto.MapDto;
import io.mango.pathfinder.web.dto.NodeDto;
import io.mango.pathfinder.web.dto.RobotDto;
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
public class PathRequest {
    private NodeDto startNode;
    private NodeDto endNode;
    private MapDto map;
    private RobotDto robot;
}
