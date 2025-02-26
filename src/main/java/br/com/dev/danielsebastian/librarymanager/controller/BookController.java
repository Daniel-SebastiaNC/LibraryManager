package br.com.dev.danielsebastian.librarymanager.controller;

import br.com.dev.danielsebastian.librarymanager.controller.request.AvailableRequest;
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

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getBookById(@PathVariable Long id){
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @PatchMapping("/alter/{id}")
    public ResponseEntity<BookResponse> updateBook(@PathVariable Long id, @RequestBody BookRequest bookRequest){
        return ResponseEntity.ok(bookService.updateBook(id, bookRequest));
    }

    @PatchMapping("/alter/available/{id}")
    public ResponseEntity<BookResponse> changeAvailableBook(@PathVariable Long id, @RequestBody AvailableRequest availableRequest){
        return ResponseEntity.ok(bookService.changeAvailableBook(id, availableRequest));
    }

}
