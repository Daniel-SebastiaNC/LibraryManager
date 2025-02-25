package br.com.dev.danielsebastian.librarymanager.service;

import br.com.dev.danielsebastian.librarymanager.controller.request.BookRequest;
import br.com.dev.danielsebastian.librarymanager.controller.response.BookResponse;
import br.com.dev.danielsebastian.librarymanager.entity.Book;
import br.com.dev.danielsebastian.librarymanager.mapper.BookMapper;
import br.com.dev.danielsebastian.librarymanager.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
