package br.com.dev.danielsebastian.librarymanager.mapper;

import br.com.dev.danielsebastian.librarymanager.controller.request.UserRequest;
import br.com.dev.danielsebastian.librarymanager.controller.response.UserResponse;
import br.com.dev.danielsebastian.librarymanager.entity.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {
    public static User toUser(UserRequest userRequest){
        return User.builder()
                .name(userRequest.name())
                .email(userRequest.email())
                .password(userRequest.password())
                .build();
    }

    public static UserResponse toUserResponse(User user){
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
