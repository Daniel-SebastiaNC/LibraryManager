package br.com.dev.danielsebastian.librarymanager.controller.request;

import br.com.dev.danielsebastian.librarymanager.entity.Reader;
import jakarta.validation.constraints.NotEmpty;

public record BookRequest(@NotEmpty(message = "required") String title,
                          @NotEmpty(message = "required") String author,
                          String description,
                          Reader reader) {

}
