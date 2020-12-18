package io.mango.pathfinder.service;

import io.mango.pathfinder.model.User;
import io.mango.pathfinder.persistence.dao.UserRepository;
import io.mango.pathfinder.persistence.entity.UserEntity;
import io.mango.pathfinder.web.transformer.UserEntityToUserTransformer;
import io.mango.pathfinder.web.transformer.UserToUserEntityTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserEntityToUserTransformer userEntityToUserTransformer;
    @Autowired
    private UserToUserEntityTransformer userToUserEntityTransformer;

    @PostConstruct
    public void initUsers() {
        List<UserEntity> users = new ArrayList<>();
        UserEntity user1 = UserEntity.builder()
                .name("Jane")
                .email("jane@doe.com")
                .build();
        users.add(user1);
        UserEntity user2 = UserEntity.builder()
                .name("John")
                .email("john@doe.com")
                .build();
        users.add(user2);
        userRepository.saveAll(users);
    }

    public List<User> findAllUsers() {
        return userEntityToUserTransformer.transform(userRepository.findAll());
    }

    public long countByNameIs(String name){
        return userRepository.countByNameIs(name);
    }

    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    public void register(User user) {
        userRepository.save(userToUserEntityTransformer.transform(user));
    }
}
