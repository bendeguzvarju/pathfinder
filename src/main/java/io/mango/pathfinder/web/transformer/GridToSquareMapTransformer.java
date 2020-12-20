package io.mango.pathfinder.web.transformer;

import io.mango.pathfinder.model.map.Map;
import io.mango.pathfinder.model.map.Node;
import io.mango.pathfinder.model.map.SquareMap;
import io.mango.pathfinder.web.dto.MapDto;
import org.springframework.stereotype.Service;

@Service
public class GridToSquareMapTransformer {
    public Map transform(MapDto dto) {
        Map map = new SquareMap();
        map.setGrid(createGrid(dto));
        Node node;
        for(int i = 0; i < map.getWidth(); i++) {
            for(int j = 0; j < map.getWidth(); j++) {
                node = map.getNode(i,j);
                if(dto.getGrid()[i][j] == 's') {
                    node = null;
                }
            }
        }
        return map;
    }

    private Node[][] createGrid(MapDto dto) {
        int width = dto.getGrid().length;
        int height = dto.getGrid()[0].length;
        return new Node[width][height];
    }



}
