package br.com.dev.danielsebastian.librarymanager.service;

import br.com.dev.danielsebastian.librarymanager.controller.request.UserRequest;
import br.com.dev.danielsebastian.librarymanager.controller.response.UserResponse;
import br.com.dev.danielsebastian.librarymanager.entity.User;
import br.com.dev.danielsebastian.librarymanager.mapper.UserMapper;
import br.com.dev.danielsebastian.librarymanager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserResponse redisterUser(UserRequest userRequest){
        User user = UserMapper.toUser(userRequest);

        //Encode password
        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));

        User saveUser = userRepository.save(user);

        return UserMapper.toUserResponse(saveUser);

    }
}
