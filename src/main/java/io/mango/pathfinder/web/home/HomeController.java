package io.mango.pathfinder.web.home;

import io.mango.pathfinder.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
    /login
    /home
        /robots
        /maps
        /new-path
        /new-algorithm
    /create-robot
    /register
    /create-map
    /

 */

@RestController
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/user-home")
    public String valamit() {
        userService.aStarMutyi();
        return userService.getUserName();
    }
}
