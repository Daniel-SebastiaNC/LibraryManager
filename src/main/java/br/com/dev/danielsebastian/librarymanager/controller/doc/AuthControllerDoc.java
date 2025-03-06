package br.com.dev.danielsebastian.librarymanager.controller.doc;

import br.com.dev.danielsebastian.librarymanager.controller.request.UserLoginRequest;
import br.com.dev.danielsebastian.librarymanager.controller.request.UserRequest;
import br.com.dev.danielsebastian.librarymanager.controller.response.UserLoginResponse;
import br.com.dev.danielsebastian.librarymanager.controller.response.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Auth", description = "Recurso responsável pela autenticação e registro de Administrador.")
public interface AuthControllerDoc {
    @Operation(summary = "Registrar Administrador",
            description = "Método responsável por cadastrar o administrador no sistema.")
    @ApiResponse(responseCode = "201",
            description = "Retorna o administrador cadastrado.",
            content = @Content(schema = @Schema(implementation = UserResponse.class)))
    ResponseEntity<UserResponse> registerUser(@Valid @RequestBody UserRequest userRequest);

    @Operation(summary = "Autenticação de Administrador",
            description = "Método responsável por autenticar administrador.")
    @ApiResponse(responseCode = "200",
            description = "Retorna token de acesso.",
            content = @Content(schema = @Schema(implementation = UserLoginResponse.class)))
    ResponseEntity<UserLoginResponse> login(@Valid @RequestBody UserLoginRequest userLoginRequest);
}
