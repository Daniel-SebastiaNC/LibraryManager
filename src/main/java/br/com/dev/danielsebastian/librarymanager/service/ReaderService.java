package br.com.dev.danielsebastian.librarymanager.service;

import br.com.dev.danielsebastian.librarymanager.controller.request.ReaderRequest;
import br.com.dev.danielsebastian.librarymanager.controller.response.ReaderResponse;
import br.com.dev.danielsebastian.librarymanager.entity.Reader;
import br.com.dev.danielsebastian.librarymanager.exception.DataNotFoundException;
import br.com.dev.danielsebastian.librarymanager.mapper.ReaderMapper;
import br.com.dev.danielsebastian.librarymanager.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReaderService {

    private final ReaderRepository readerRepository;
    private final BookService bookService;

    public ReaderResponse addReader(ReaderRequest readerRequest){
        Reader reader = ReaderMapper.toReader(readerRequest);
        reader.setBooks(null);
        Reader saveReader = readerRepository.save(reader);

        return ReaderMapper.toReaderResponse(saveReader);
    }

    public List<ReaderResponse> getAllReader(){
        return readerRepository.findAll().stream().map(ReaderMapper::toReaderResponse).toList();
    }

    public ReaderResponse getReaderById(Long id) {
        return ReaderMapper.toReaderResponse(this.readerInDb(id));
    }

    public void deleteReaderById(Long id) {
        Reader reader = this.readerInDb(id);
        if (reader.getBooks() != null) {
            reader.getBooks().stream().forEach(book -> bookService.changeAvailableTrueBook(book.getId()));
        }

        readerRepository.delete(reader);
    }

    private Reader readerInDb(Long id){
        return readerRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Reader not found"));
    }
}
