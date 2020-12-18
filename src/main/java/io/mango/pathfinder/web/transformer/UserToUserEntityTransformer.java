package io.mango.pathfinder.web.transformer;

import io.mango.pathfinder.model.User;
import io.mango.pathfinder.persistence.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserToUserEntityTransformer {
    public UserEntity transform(User user) {
        return UserEntity.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

    public List<UserEntity> transform(List<User> users) {
        return users.stream().map(this::transform).collect(Collectors.toList());
    }
}
