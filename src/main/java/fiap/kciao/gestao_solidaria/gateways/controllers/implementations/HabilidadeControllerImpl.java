package fiap.kciao.gestao_solidaria.gateways.controllers.implementations;

import fiap.kciao.gestao_solidaria.gateways.controllers.interfaces.HabilidadeController;
import fiap.kciao.gestao_solidaria.gateways.dtos.requests.domains.habilidade.HabilidadeCreateRequestDto;
import fiap.kciao.gestao_solidaria.gateways.dtos.requests.domains.habilidade.HabilidadeUpdateRequestDto;
import fiap.kciao.gestao_solidaria.gateways.dtos.responses.domains.habilidade.HabilidadeFullResponseDto;
import fiap.kciao.gestao_solidaria.usecases.interfaces.CrudHabilidade;
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
@RequestMapping("/habilidade")
@Tag(name = "Habilidade")
public class HabilidadeControllerImpl implements HabilidadeController {
    private final CrudHabilidade crudHabilidade;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Criar uma nova habilidade")
    @Override
    public ResponseEntity<HabilidadeFullResponseDto> create(@RequestBody @Valid HabilidadeCreateRequestDto habilidadeCreateRequestDto) {
        return ResponseEntity.ok(crudHabilidade.create(habilidadeCreateRequestDto));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Edita uma habilidade")
    @Override
    public ResponseEntity<HabilidadeFullResponseDto> update(@PathVariable Integer id, @RequestBody @Valid HabilidadeUpdateRequestDto habilidadeUpdateRequestDto) {
        return ResponseEntity.ok(crudHabilidade.update(id, habilidadeUpdateRequestDto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Deleta uma habilidade")
    @Override
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        crudHabilidade.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Busca uma habilidade")
    @Override
    public ResponseEntity<HabilidadeFullResponseDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(crudHabilidade.findById(id));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Busca todas habilidades")
    @Override
    public ResponseEntity<List<HabilidadeFullResponseDto>> findAll() {
        return ResponseEntity.ok(crudHabilidade.findAll());
    }
}
