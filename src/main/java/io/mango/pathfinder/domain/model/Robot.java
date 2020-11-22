package io.mango.pathfinder.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Robot {
    private String name;
    private int diagonalCost;
    private int vhCost;

}
