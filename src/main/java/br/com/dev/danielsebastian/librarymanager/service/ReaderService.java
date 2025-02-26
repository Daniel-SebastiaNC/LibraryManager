package br.com.dev.danielsebastian.librarymanager.service;

import br.com.dev.danielsebastian.librarymanager.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReaderService {

    private final ReaderRepository readerRepository;

}
