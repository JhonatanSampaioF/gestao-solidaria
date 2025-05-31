package fiap.kciao.apo_ia.gateways.controllers.implementations;

import fiap.kciao.apo_ia.gateways.controllers.interfaces.DoencaController;
import fiap.kciao.apo_ia.gateways.dtos.requests.domains.doenca.DoencaCreateRequestDto;
import fiap.kciao.apo_ia.gateways.dtos.requests.domains.doenca.DoencaUpdateRequestDto;
import fiap.kciao.apo_ia.gateways.dtos.responses.domains.doenca.DoencaFullResponseDto;
import fiap.kciao.apo_ia.usecases.interfaces.CrudDoenca;
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
@RequestMapping("/doenca")
@Tag(name = "Doença")
public class DoencaControllerImpl implements DoencaController {
    private final CrudDoenca crudDoenca;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Criar uma nova doença")
    @Override
    public ResponseEntity<DoencaFullResponseDto> create(@RequestBody @Valid DoencaCreateRequestDto doencaCreateRequestDto) {
        return ResponseEntity.ok(crudDoenca.create(doencaCreateRequestDto));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Edita uma doença")
    @Override
    public ResponseEntity<DoencaFullResponseDto> update(@PathVariable Integer id, @RequestBody @Valid DoencaUpdateRequestDto doencaUpdateRequestDto) {
        return ResponseEntity.ok(crudDoenca.update(id, doencaUpdateRequestDto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Deleta uma doença")
    @Override
    public ResponseEntity<DoencaFullResponseDto> delete(@PathVariable Integer id) {
        crudDoenca.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Busca uma doença")
    @Override
    public ResponseEntity<DoencaFullResponseDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(crudDoenca.findById(id));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Busca todas doenças")
    @Override
    public ResponseEntity<List<DoencaFullResponseDto>> findAll() {
        return ResponseEntity.ok(crudDoenca.findAll());
    }
}
