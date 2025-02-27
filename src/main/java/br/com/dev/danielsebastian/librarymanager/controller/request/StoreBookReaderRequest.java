package br.com.dev.danielsebastian.librarymanager.controller.request;

public record StoreBookReaderRequest(Long bookId,
                                     Long readerId) {
}
