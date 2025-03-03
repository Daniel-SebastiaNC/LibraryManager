package br.com.dev.danielsebastian.librarymanager.controller.request;

import jakarta.validation.constraints.NotEmpty;

public record ReaderRequest(@NotEmpty(message = "required") String name) {
}
