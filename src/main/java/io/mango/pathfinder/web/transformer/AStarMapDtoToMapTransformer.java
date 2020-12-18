package io.mango.pathfinder.web.transformer;

import io.mango.pathfinder.model.astar.Map;
import io.mango.pathfinder.model.astar.Node;
import io.mango.pathfinder.web.dto.AStarMapDto;
import org.springframework.stereotype.Service;

@Service
public class AStarMapDtoToMapTransformer {
    public Map transform(AStarMapDto dto) {
        Node[][] nodeGrid = createGrid(dto);
        Map map = Map.builder()
                .grid(nodeGrid)
                .build();

        addNodesToMap(nodeGrid, map);



        return map;
    }

    private void addNodesToMap(Node[][] nodeGrid, Map map) {
        for(Node[] row : nodeGrid) {
            for(Node node : row) {
                node.setMap(map);
                node.open();
            }
        }
    }

    private Node[][] createGrid(AStarMapDto dto) {
        int width = dto.getGrid().length;
        int height = dto.getGrid()[0].length;
        return new Node[width][height];
    }



}
