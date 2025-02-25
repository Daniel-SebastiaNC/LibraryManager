package br.com.dev.danielsebastian.librarymanager.controller;

import br.com.dev.danielsebastian.librarymanager.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

}
