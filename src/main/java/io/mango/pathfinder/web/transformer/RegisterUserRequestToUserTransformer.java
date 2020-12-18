package io.mango.pathfinder.web.transformer;

import io.mango.pathfinder.model.User;
import io.mango.pathfinder.web.request.RegisterUserRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegisterUserRequestToUserTransformer {

    public User transform(RegisterUserRequest source) {
        return User.builder()
                .name(source.getName())
                .email(source.getEmail())
                .build();
    }

    public List<User> transform(List<RegisterUserRequest> source) {
        return source.stream().map(this::transform).collect(Collectors.toList());
    }
}
