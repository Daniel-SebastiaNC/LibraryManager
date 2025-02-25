package br.com.dev.danielsebastian.librarymanager.controller;

import br.com.dev.danielsebastian.librarymanager.controller.request.BookRequest;
import br.com.dev.danielsebastian.librarymanager.controller.response.BookResponse;
import br.com.dev.danielsebastian.librarymanager.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping("/add")
    public ResponseEntity<BookResponse> addBook(@RequestBody BookRequest bookRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.addBook(bookRequest));
    }

    @GetMapping("/all")
    public ResponseEntity<List<BookResponse>> getAllBook(){
        return ResponseEntity.ok(bookService.getAllBook());
    }

}
