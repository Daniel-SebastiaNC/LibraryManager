package br.com.dev.danielsebastian.librarymanager.controller.response;

import br.com.dev.danielsebastian.librarymanager.entity.Reader;
import lombok.Builder;

@Builder
public record BookResponse(Long id,
                           String title,
                           String author,
                           String description,
                           boolean available,
                           Reader reader
                           ) {
}
