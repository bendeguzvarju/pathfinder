package io.mango.pathfinder.model.astar;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Robot {
    private int verticalMoveCoefficient;
    private int horizontalMoveCoefficient;
}
