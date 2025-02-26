package br.com.dev.danielsebastian.librarymanager.mapper;

import br.com.dev.danielsebastian.librarymanager.controller.request.ReaderRequest;
import br.com.dev.danielsebastian.librarymanager.controller.response.BookResponse;
import br.com.dev.danielsebastian.librarymanager.controller.response.ReaderResponse;
import br.com.dev.danielsebastian.librarymanager.entity.Reader;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class ReaderMapper {
    public static Reader toReader(ReaderRequest readerRequest){
        return Reader.builder()
                .name(readerRequest.name())
                .build();
    }

    public static ReaderResponse toReaderResponse(Reader reader){
        List<BookResponse> books = new ArrayList<>();
        if (reader.getBooks() != null){
            books = reader.getBooks().stream().map(BookMapper::toBookResponse).toList();
        }


        return ReaderResponse.builder()
                .id(reader.getId())
                .name(reader.getName())
                .books(books)
                .build();
    }
}
