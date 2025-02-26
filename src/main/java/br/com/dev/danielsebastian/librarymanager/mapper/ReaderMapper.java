package br.com.dev.danielsebastian.librarymanager.mapper;

import br.com.dev.danielsebastian.librarymanager.controller.request.ReaderRequest;
import br.com.dev.danielsebastian.librarymanager.controller.response.ReaderResponse;
import br.com.dev.danielsebastian.librarymanager.entity.Reader;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ReaderMapper {
    public static Reader toReader(ReaderRequest readerRequest){
        return Reader.builder()
                .name(readerRequest.name())
                .build();
    }

    public static ReaderResponse toReaderResponse(Reader reader){
        return ReaderResponse.builder()
                .id(reader.getId())
                .name(reader.getName())
                .bookResponse(reader.getBooks().stream().map(BookMapper::toBookResponse).toList())
                .build();
    }
}
