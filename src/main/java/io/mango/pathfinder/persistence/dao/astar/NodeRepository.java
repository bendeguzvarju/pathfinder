package io.mango.pathfinder.persistence.dao.astar;

import io.mango.pathfinder.persistence.entity.astar.NodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NodeRepository extends JpaRepository<NodeEntity, Integer> {
}
