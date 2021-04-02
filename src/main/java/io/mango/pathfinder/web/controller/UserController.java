package io.mango.pathfinder.web.controller;

import io.mango.pathfinder.service.UserService;
import io.mango.pathfinder.web.request.RegisterUserRequest;
import io.mango.pathfinder.web.response.CountUsersByNameResponse;
import io.mango.pathfinder.web.response.GetAllUsersResponse;
import io.mango.pathfinder.web.transformer.RegisterUserRequestToUserTransformer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final String GET_ALL_USERS = "/get-all-users";
    private static final String COUNT_USERS_BY_NAME_NAME = "/count-users-by-name/{name}";
    private static final String DELETE_USER = "/delete-user/{id}";
    private static final String REGISTER = "/register";

    @Autowired
    private UserService userService;
    @Autowired
    private RegisterUserRequestToUserTransformer registerUserRequestToUserTransformer;

    @GetMapping(GET_ALL_USERS)
    public GetAllUsersResponse getAllUsers() {
        GetAllUsersResponse response = new GetAllUsersResponse();
        response.setUsers(userService.findAllUsers());
        return response;
    }

    @GetMapping(COUNT_USERS_BY_NAME_NAME)
    public CountUsersByNameResponse countUsersByName(@PathVariable String name) {
        CountUsersByNameResponse response = new CountUsersByNameResponse();
        response.setNumberOfUsers(userService.countByNameIs(name));
        return response;
    }

    @GetMapping(DELETE_USER)
    public void deleteUser(@PathVariable int id) {
        userService.deleteById(id);
    }

    @GetMapping(REGISTER)
    public void registerUser(@RequestBody @Valid RegisterUserRequest user) {
        userService.register(registerUserRequestToUserTransformer.transform(user));
    }
}
