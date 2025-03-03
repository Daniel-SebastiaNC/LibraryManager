package br.com.dev.danielsebastian.librarymanager.controller.request;

public record UserLoginRequest(String email,
                               String password) {
}
