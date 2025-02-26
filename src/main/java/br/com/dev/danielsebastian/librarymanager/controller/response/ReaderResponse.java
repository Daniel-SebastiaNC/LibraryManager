package br.com.dev.danielsebastian.librarymanager.controller.response;

import lombok.Builder;

import java.util.List;

@Builder
public record ReaderResponse(Long id,
                             String name,
                             List<BookResponse> books) {
}
