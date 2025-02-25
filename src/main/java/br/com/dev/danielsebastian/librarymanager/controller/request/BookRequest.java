package br.com.dev.danielsebastian.librarymanager.controller.request;

public record BookRequest(String title,
                          String author,
                          String description) {
}
