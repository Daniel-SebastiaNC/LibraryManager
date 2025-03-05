package br.com.dev.danielsebastian.librarymanager.controller.doc;

import br.com.dev.danielsebastian.librarymanager.controller.request.ReaderRequest;
import br.com.dev.danielsebastian.librarymanager.controller.response.ReaderResponse;
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

@Tag(name = "Reader", description = "Recurso responsável pelo gerenciamento de leitores.")
public interface ReaderControllerDoc {

    @Operation(summary = "Adiconar Leitor",
            description = "Método responsável por cadastrar o leitor no sistema.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "201",
            description = "Retorna o leitor cadastrado.",
            content = @Content(schema = @Schema(implementation = ReaderResponse.class)))
    ResponseEntity<ReaderResponse> addReader(@Valid @RequestBody ReaderRequest readerRequest);

    @Operation(summary = "Buscar Todos os Leitores",
            description = "Método responsável por retornar todos os leitores cadastrados.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200",
            description = "Retorna todos os leitores cadastrados.",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = ReaderResponse.class))))
    ResponseEntity<List<ReaderResponse>> getAllReader();

    @Operation(summary = "Buscar Leitor por Id",
            description = "Método responsável por retornar leitor cadastrado com Id específico.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200",
            description = "Retorna leitor cadastrado com Id específico.",
            content = @Content(schema = @Schema(implementation = ReaderResponse.class)))
    @ApiResponse(responseCode = "404",
            description = "Leitor não encontrado",
            content = @Content(schema = @Schema(implementation = String.class)))
    ResponseEntity<ReaderResponse> getReaderById(@PathVariable Long id);

    @Operation(summary = "Deletar Leitor por Id",
            description = "Método responsável por deletar leitor cadastrado com Id específico.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "204",
            description = "Leitor deletado.",
            content = @Content())
    @ApiResponse(responseCode = "404",
            description = "Livro não encontrado",
            content = @Content(schema = @Schema(implementation = String.class)))
    ResponseEntity<Void> deleteReaderById(@PathVariable Long id);
}
