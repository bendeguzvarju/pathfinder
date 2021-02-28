package io.mango.pathfinder.web.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MapResponse {
    NodeResponse startNode;
    NodeResponse endNode;
    NodeResponse[][] nodeGrid;
    String stringGrid;

}
