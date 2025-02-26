package br.com.dev.danielsebastian.librarymanager.service;

import br.com.dev.danielsebastian.librarymanager.controller.request.ReaderRequest;
import br.com.dev.danielsebastian.librarymanager.controller.response.ReaderResponse;
import br.com.dev.danielsebastian.librarymanager.entity.Reader;
import br.com.dev.danielsebastian.librarymanager.mapper.ReaderMapper;
import br.com.dev.danielsebastian.librarymanager.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReaderService {

    private final ReaderRepository readerRepository;

    public ReaderResponse addReader(ReaderRequest readerRequest){
        Reader reader = ReaderMapper.toReader(readerRequest);
        reader.setBooks(null);
        Reader saveReader = readerRepository.save(reader);

        return ReaderMapper.toReaderResponse(saveReader);
    }

    public List<ReaderResponse> getAllReader(){
        return readerRepository.findAll().stream().map(ReaderMapper::toReaderResponse).toList();
    }

}
