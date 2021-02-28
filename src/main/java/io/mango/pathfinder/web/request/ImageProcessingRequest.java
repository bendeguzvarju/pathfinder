package io.mango.pathfinder.web.request;

import io.mango.pathfinder.model.Image.MapImage;
import io.mango.pathfinder.model.astar.Robot;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageProcessingRequest {
    private int height;
    private int width;
    private MapImage image;
    private Robot robot;

}
