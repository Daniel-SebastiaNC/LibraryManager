package br.com.dev.danielsebastian.librarymanager.controller;

import br.com.dev.danielsebastian.librarymanager.controller.request.ReaderRequest;
import br.com.dev.danielsebastian.librarymanager.controller.response.ReaderResponse;
import br.com.dev.danielsebastian.librarymanager.service.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reader")
@RequiredArgsConstructor
public class ReaderController {

    private final ReaderService readerService;

    @PostMapping("/add")
    public ResponseEntity<ReaderResponse> addReader(@RequestBody ReaderRequest readerRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(readerService.addReader(readerRequest));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ReaderResponse>> getAllReader(){
        return ResponseEntity.ok(readerService.getAllReader());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReaderResponse> getReaderById(@PathVariable Long id){
        return ResponseEntity.ok(readerService.getReaderById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteReaderById(@PathVariable Long id){
        readerService.deleteReaderById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
