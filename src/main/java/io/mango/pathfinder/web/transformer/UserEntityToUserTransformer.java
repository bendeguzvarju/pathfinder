package io.mango.pathfinder.web.transformer;

import io.mango.pathfinder.model.User;
import io.mango.pathfinder.persistence.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserEntityToUserTransformer {

    public User transform(UserEntity userEntity){
        User user = User.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .email(userEntity.getEmail())
                .build();
        return user;
    }

    public List<User> transform(List<UserEntity> userEntities) {
        return userEntities.stream().map(this::transform).collect(Collectors.toList());
    }
}
