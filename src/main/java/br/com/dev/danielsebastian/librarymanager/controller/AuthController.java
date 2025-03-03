package br.com.dev.danielsebastian.librarymanager.controller;

import br.com.dev.danielsebastian.librarymanager.config.TokenService;
import br.com.dev.danielsebastian.librarymanager.controller.request.UserLoginRequest;
import br.com.dev.danielsebastian.librarymanager.controller.request.UserRequest;
import br.com.dev.danielsebastian.librarymanager.controller.response.UserLoginResponse;
import br.com.dev.danielsebastian.librarymanager.controller.response.UserResponse;
import br.com.dev.danielsebastian.librarymanager.entity.User;
import br.com.dev.danielsebastian.librarymanager.exception.UsernameOrPasswordInvaldException;
import br.com.dev.danielsebastian.librarymanager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@RequestBody UserRequest userRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.redisterUser(userRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> login(@RequestBody UserLoginRequest userLoginRequest){
        try {

        UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(userLoginRequest.email(), userLoginRequest.password());
        Authentication authentication = authenticationManager.authenticate(userAndPass);

        User user = (User) authentication.getPrincipal();

        String token = tokenService.generateToken(user);
        return ResponseEntity.ok(new UserLoginResponse(token));

        } catch (BadCredentialsException exception){
            throw new UsernameOrPasswordInvaldException("Usuário ou Senha invalidos");
        }

    }
}
