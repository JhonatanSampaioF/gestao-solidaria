package fiap.kciao.gestao_solidaria.gateways.controllers.implementations;

import fiap.kciao.gestao_solidaria.gateways.controllers.interfaces.LocalController;
import fiap.kciao.gestao_solidaria.gateways.dtos.requests.domains.local.LocalCreateRequestDto;
import fiap.kciao.gestao_solidaria.gateways.dtos.requests.domains.local.LocalUpdateRequestDto;
import fiap.kciao.gestao_solidaria.gateways.dtos.responses.domains.local.LocalFullResponseDto;
import fiap.kciao.gestao_solidaria.usecases.interfaces.CrudLocal;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/local")
@Tag(name = "Local")
public class LocalControllerImpl implements LocalController {
    private final CrudLocal crudLocal;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Criar um novo local")
    @Override
    public ResponseEntity<LocalFullResponseDto> create(@RequestBody @Valid LocalCreateRequestDto localCreateRequestDto) {
        return ResponseEntity.ok(crudLocal.create(localCreateRequestDto));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Edita um local")
    @Override
    public ResponseEntity<LocalFullResponseDto> update(@PathVariable Integer id, @RequestBody @Valid LocalUpdateRequestDto localUpdateRequestDto) {
        return ResponseEntity.ok(crudLocal.update(id, localUpdateRequestDto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Deleta um local")
    @Override
    public ResponseEntity<LocalFullResponseDto> delete(@PathVariable Integer id) {
        crudLocal.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Busca um local")
    @Override
    public ResponseEntity<LocalFullResponseDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(crudLocal.findById(id));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Busca todos endereços")
    @Override
    public ResponseEntity<List<LocalFullResponseDto>> findAll() {
        return ResponseEntity.ok(crudLocal.findAll());
    }
}
