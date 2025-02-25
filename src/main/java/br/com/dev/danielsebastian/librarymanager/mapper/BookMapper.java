package br.com.dev.danielsebastian.librarymanager.mapper;

import br.com.dev.danielsebastian.librarymanager.controller.request.BookRequest;
import br.com.dev.danielsebastian.librarymanager.controller.response.BookResponse;
import br.com.dev.danielsebastian.librarymanager.entity.Book;
import lombok.experimental.UtilityClass;

@UtilityClass
public class BookMapper {
    public static Book toBook(BookRequest bookRequest){
        return Book.builder()
                .title(bookRequest.title())
                .author(bookRequest.author())
                .description(bookRequest.description())
                .status('t')
                .build();
    }

    public static BookResponse toBookResponse(Book book){
        return BookResponse.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .description(book.getDescription())
                .status(book.getStatus())
                .build();
    }
}
