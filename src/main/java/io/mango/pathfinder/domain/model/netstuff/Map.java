package io.mango.pathfinder.domain.model.netstuff;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Map {
    private Cell[][] grid;

    public Cell getCell(int i, int j) {
        return grid[i][j];
    }

}
