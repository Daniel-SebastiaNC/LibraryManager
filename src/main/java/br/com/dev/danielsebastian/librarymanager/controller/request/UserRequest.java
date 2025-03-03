package br.com.dev.danielsebastian.librarymanager.controller.request;

import jakarta.validation.constraints.NotEmpty;

public record UserRequest(@NotEmpty(message = "required") String name,
                          @NotEmpty(message = "required") String email,
                          @NotEmpty(message = "required") String password) {
}
