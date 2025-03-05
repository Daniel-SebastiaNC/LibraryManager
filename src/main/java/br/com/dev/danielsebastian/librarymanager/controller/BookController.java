package br.com.dev.danielsebastian.librarymanager.controller;

import br.com.dev.danielsebastian.librarymanager.controller.doc.BookControllerDoc;
import br.com.dev.danielsebastian.librarymanager.controller.request.BookRequest;
import br.com.dev.danielsebastian.librarymanager.controller.request.StoreBookReaderRequest;
import br.com.dev.danielsebastian.librarymanager.controller.response.BookResponse;
import br.com.dev.danielsebastian.librarymanager.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController implements BookControllerDoc {

    private final BookService bookService;

    @PostMapping("/add")
    public ResponseEntity<BookResponse> addBook(@Valid @RequestBody BookRequest bookRequest){
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

    @PutMapping("/alter/{id}")
    public ResponseEntity<BookResponse> updateBook(@PathVariable Long id, @Valid @RequestBody BookRequest bookRequest){
        return ResponseEntity.ok(bookService.updateBook(id, bookRequest));
    }

    @PatchMapping("/take")
    public ResponseEntity<BookResponse> takeBook(@RequestBody StoreBookReaderRequest storeBookReaderRequest){
        return ResponseEntity.ok(bookService.changeAvailableFalseBook(storeBookReaderRequest));
    }

    @PatchMapping("/return")
    public ResponseEntity<BookResponse> returnBook(@RequestBody StoreBookReaderRequest storeBookReaderRequest){
        return ResponseEntity.ok(bookService.changeAvailableTrueBook(storeBookReaderRequest.bookId()));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable Long id){
        bookService.deleteBookById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
