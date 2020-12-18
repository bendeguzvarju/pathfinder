package io.mango.pathfinder.persistence.entity.astar;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RobotEntity {
    @Id
    @GeneratedValue
    private int id;
    private int diagonalCost;
    private int vHCost;
}
