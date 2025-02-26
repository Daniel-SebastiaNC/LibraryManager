package br.com.dev.danielsebastian.librarymanager.service;

import br.com.dev.danielsebastian.librarymanager.controller.request.BookRequest;
import br.com.dev.danielsebastian.librarymanager.controller.response.BookResponse;
import br.com.dev.danielsebastian.librarymanager.entity.Book;
import br.com.dev.danielsebastian.librarymanager.mapper.BookMapper;
import br.com.dev.danielsebastian.librarymanager.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public BookResponse addBook(BookRequest bookRequest){
        Book book = BookMapper.toBook(bookRequest);
        Book saveBook = bookRepository.save(book);
        return BookMapper.toBookResponse(saveBook);
    }

    public List<BookResponse> getAllBook(){
        List<Book> allBooks = bookRepository.findAll();
        return allBooks.stream().map(BookMapper::toBookResponse).toList();
    }

    public BookResponse getBookById(Long id){
        return bookRepository.findById(id).map(BookMapper::toBookResponse).orElseThrow(IllegalArgumentException::new);
    }
}
