package io.mango.pathfinder.web.transformer;

import io.mango.pathfinder.model.map.Map;
import io.mango.pathfinder.model.map.Node;
import io.mango.pathfinder.model.map.SquareMap;
import io.mango.pathfinder.web.dto.AStarMapDto;
import org.springframework.stereotype.Service;

@Service
public class AStarMapDtoToSquareMapTransformer {
    public Map transform(AStarMapDto dto) {
        Node[][] nodeGrid = createGrid(dto);
        Map map = new SquareMap();
        map.setGrid(nodeGrid);
        return map;
    }

    private Node[][] createGrid(AStarMapDto dto) {
        int width = dto.getGrid().length;
        int height = dto.getGrid()[0].length;
        return new Node[width][height];
    }



}
