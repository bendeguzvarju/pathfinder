package io.mango.pathfinder.persistence.dao.astar;

import io.mango.pathfinder.persistence.entity.astar.RobotEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RobotRepository extends JpaRepository<RobotEntity, Integer> {
}
