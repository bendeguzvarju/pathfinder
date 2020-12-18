package io.mango.pathfinder.persistence.dao;

import io.mango.pathfinder.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    List<UserEntity> findByName(String name);

    long countByNameIs(String name);
}
