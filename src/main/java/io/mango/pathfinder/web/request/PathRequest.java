package io.mango.pathfinder.web.request;

import io.mango.pathfinder.web.dto.MapDto;
import io.mango.pathfinder.web.dto.NodeDto;
import io.mango.pathfinder.web.dto.RobotDto;
import lombok.Data;

@Data
public class PathRequest {
    private NodeDto startNode;
    private NodeDto endNode;
    private MapDto map;
    private RobotDto robot;
}
