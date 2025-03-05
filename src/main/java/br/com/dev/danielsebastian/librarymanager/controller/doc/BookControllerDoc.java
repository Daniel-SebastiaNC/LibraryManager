package br.com.dev.danielsebastian.librarymanager.controller.doc;

import br.com.dev.danielsebastian.librarymanager.controller.request.BookRequest;
import br.com.dev.danielsebastian.librarymanager.controller.request.StoreBookReaderRequest;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Book", description = "Recurso responsável pelo gerenciamento de livros.")
public interface BookControllerDoc{

    @Operation(summary = "Adiconar Livro",
            description = "Método responsável por cadastrar o livro no sistema.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "201",
            description = "Retorna o livro cadastrado.",
            content = @Content(schema = @Schema(implementation = BookResponse.class)))
    ResponseEntity<BookResponse> addBook(@Valid @RequestBody BookRequest bookRequest);

    @Operation(summary = "Buscar Todos os Livros",
            description = "Método responsável por retornar todos os livros cadastrados.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200",
            description = "Retorna todos os livros cadastrados.",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = BookResponse.class))))
    ResponseEntity<List<BookResponse>> getAllBook();

    @Operation(summary = "Buscar Livro por Id",
            description = "Método responsável por retornar livro cadastrado com Id específico.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200",
            description = "Retorna livro cadastrado com Id específico.",
            content = @Content(schema = @Schema(implementation = BookResponse.class)))
    @ApiResponse(responseCode = "404",
            description = "Livro não encontrado",
            content = @Content(schema = @Schema(implementation = String.class)))
    ResponseEntity<BookResponse> getBookById(@PathVariable Long id);

    @Operation(summary = "Modificar Livro por Id",
            description = "Método responsável por modificar um livro existente no sistema com Id específico.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200",
            description = "Retorna livro modificado.",
            content = @Content(schema = @Schema(implementation = BookResponse.class)))
    @ApiResponse(responseCode = "404",
            description = "Livro não encontrado",
            content = @Content(schema = @Schema(implementation = String.class)))
    ResponseEntity<BookResponse> updateBook(@PathVariable Long id, @Valid @RequestBody BookRequest bookRequest);

    @Operation(summary = "Modificar estado de disponibilidade do Livro para indisponível e adiconar um leitor para o livro",
            description = "Método responsável por modificar a disponibilidade de um livro existente no sistema indisponível e adiciona o leitor que está na posse do livro.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200",
            description = "Retorna livro com disponibilidade modificada e leitor adicionado.",
            content = @Content(schema = @Schema(implementation = BookResponse.class)))
    @ApiResponse(responseCode = "404",
            description = "Livro ou Leitor não encontrado",
            content = @Content(schema = @Schema(implementation = String.class)))
    ResponseEntity<BookResponse> takeBook(@RequestBody StoreBookReaderRequest storeBookReaderRequest);

    @Operation(summary = "Modificar estado de disponibilidade do Livro para disponível e rerirar o leitor",
            description = "Método responsável por modificar a disponibilidade de um livro existente no sistema para disponível e retirar o leitor que está na posse do livro.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200",
            description = "Retorna livro com disponibilidade modificada e leitor vazio.",
            content = @Content(schema = @Schema(implementation = BookResponse.class)))
    @ApiResponse(responseCode = "404",
            description = "Livro não encontrado",
            content = @Content(schema = @Schema(implementation = String.class)))
    ResponseEntity<BookResponse> returnBook(@RequestBody StoreBookReaderRequest storeBookReaderRequest);

    @Operation(summary = "Deletar Livro por Id",
            description = "Método responsável por deletar livro cadastrado com Id específico.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "204",
            description = "livro deletado.",
            content = @Content())
    @ApiResponse(responseCode = "404",
            description = "Livro não encontrado",
            content = @Content(schema = @Schema(implementation = String.class)))
    ResponseEntity<Void> deleteBookById(@PathVariable Long id);
}
