package io.mango.pathfinder.web.response;

import io.mango.pathfinder.model.User;
import lombok.Data;

import java.util.List;

@Data
public class GetAllUsersResponse {
    private List<User> users;
}
