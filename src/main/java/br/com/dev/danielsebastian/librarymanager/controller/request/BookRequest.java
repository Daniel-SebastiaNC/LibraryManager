package br.com.dev.danielsebastian.librarymanager.controller.request;

import br.com.dev.danielsebastian.librarymanager.entity.Reader;

public record BookRequest(String title,
                          String author,
                          String description,
                          Reader reader) {

}
