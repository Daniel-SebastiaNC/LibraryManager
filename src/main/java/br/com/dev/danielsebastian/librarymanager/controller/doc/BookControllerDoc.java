package br.com.dev.danielsebastian.librarymanager.controller.doc;

import br.com.dev.danielsebastian.librarymanager.controller.request.BookRequest;
import br.com.dev.danielsebastian.librarymanager.controller.response.BookResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Book", description = "Recurso responsável pelo gerenciamento de livros.")
public interface BookControllerDoc {

    ResponseEntity<BookResponse> addBook(@Valid @RequestBody BookRequest bookRequest);

    @Operation(summary = "Buscar Livros", description = "Método responsável por retornar todos os livros cadastrados.", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Retorna todos os livros cadastrados.", content = @Content(array = @ArraySchema(schema = @Schema(implementation = BookResponse.class))))
    ResponseEntity<List<BookResponse>> getAllBook();
}
