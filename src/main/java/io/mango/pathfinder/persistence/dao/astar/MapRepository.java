package io.mango.pathfinder.persistence.dao.astar;

import io.mango.pathfinder.persistence.entity.astar.MapEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MapRepository extends JpaRepository<MapEntity, Integer> {
}
