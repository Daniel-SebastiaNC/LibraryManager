package br.com.dev.danielsebastian.librarymanager.service;

import br.com.dev.danielsebastian.librarymanager.controller.request.BookRequest;
import br.com.dev.danielsebastian.librarymanager.controller.request.StoreBookReaderRequest;
import br.com.dev.danielsebastian.librarymanager.controller.response.BookResponse;
import br.com.dev.danielsebastian.librarymanager.entity.Book;
import br.com.dev.danielsebastian.librarymanager.entity.Reader;
import br.com.dev.danielsebastian.librarymanager.mapper.BookMapper;
import br.com.dev.danielsebastian.librarymanager.repository.BookRepository;
import br.com.dev.danielsebastian.librarymanager.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final ReaderRepository readerRepository;

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

    public BookResponse changeAvailableTrueBook(Long id){
        Book book = this.bookInDB(id);
        
        book.setAvailable(true);
        book.setReader(null);

        Book saveBook = bookRepository.save(book);

        return BookMapper.toBookResponse(saveBook);
    }
    
    public BookResponse changeAvailableFalseBook(StoreBookReaderRequest storeBookReaderRequest){
        Book book = this.bookInDB(storeBookReaderRequest.bookId());
        Reader reader = this.readerInDb(storeBookReaderRequest.readerId());

        book.setReader(reader);
        book.setAvailable(false);

        Book saveBook = bookRepository.save(book);

        return BookMapper.toBookResponse(saveBook);
    }

    public void deleteBookById(Long id) {
        Book book = this.bookInDB(id);
        bookRepository.delete(book);
    }

    private Book bookInDB(Long bookId){
        return bookRepository.findById(bookId).orElseThrow(IllegalArgumentException::new);
    }

    private Reader readerInDb(Long readerId){
        return readerRepository.findById(readerId).orElseThrow(IllegalAccessError::new);
    }

}
