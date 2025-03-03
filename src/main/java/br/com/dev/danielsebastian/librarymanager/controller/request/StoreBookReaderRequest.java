package br.com.dev.danielsebastian.librarymanager.controller.request;

import jakarta.validation.constraints.NotEmpty;

public record StoreBookReaderRequest(Long bookId,
                                     Long readerId) {
}
