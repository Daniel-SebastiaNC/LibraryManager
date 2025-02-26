package br.com.dev.danielsebastian.librarymanager.controller.response;

import lombok.Builder;

@Builder
public record BookResponse(Long id,
                           String title,
                           String author,
                           String description,
                           boolean available) {
}
