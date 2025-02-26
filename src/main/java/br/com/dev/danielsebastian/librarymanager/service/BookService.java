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
        book.setAvailable(true);
        Book saveBook = bookRepository.save(book);
        return BookMapper.toBookResponse(saveBook);
    }

    public List<BookResponse> getAllBook(){
        List<Book> allBooks = bookRepository.findAll();
        return allBooks.stream().map(BookMapper::toBookResponse).toList();
    }

    public BookResponse getBookById(Long id){
        return BookMapper.toBookResponse(this.bookInDB(id));
    }

    public BookResponse updateBook(Long id, BookRequest bookRequest){
        Book book = this.bookInDB(id);

        if(bookRequest.title() != null) {
            book.setTitle(bookRequest.title());
        }
        if (bookRequest.author() != null){
            book.setAuthor(bookRequest.author());
        }
        if (bookRequest.description() != null){
            book.setDescription(bookRequest.description());
        }

        Book saveBook = bookRepository.save(book);
        return BookMapper.toBookResponse(saveBook);
    }

    private Book bookInDB(Long id){
        return bookRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }
}
