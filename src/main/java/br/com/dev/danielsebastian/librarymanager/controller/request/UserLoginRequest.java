package br.com.dev.danielsebastian.librarymanager.controller.request;

import jakarta.validation.constraints.NotEmpty;

public record UserLoginRequest(@NotEmpty(message = "required") String email,
                               @NotEmpty(message = "required") String password) {
}
