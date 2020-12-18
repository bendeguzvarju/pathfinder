package io.mango.pathfinder.model.astar;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Robot {
    private int id;
    //14
    private int diagonalCost;
    //10
    private int vHCost;
}
