package br.com.dev.danielsebastian.librarymanager.config;

import lombok.Builder;

@Builder
public record JWTUserData(Long id,
                          String name,
                          String email) {
}
