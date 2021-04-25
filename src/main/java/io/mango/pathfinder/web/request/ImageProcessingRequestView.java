package io.mango.pathfinder.web.request;

import io.mango.pathfinder.model.astar.Robot;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageProcessingRequestView {
    private int height;
    private int width;
    private String image;
    private Robot robot;
}
