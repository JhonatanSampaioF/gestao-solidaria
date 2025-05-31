package fiap.kciao.gestao_solidaria.gateways.controllers.implementations;

import fiap.kciao.gestao_solidaria.gateways.controllers.interfaces.VoluntarioController;
import fiap.kciao.gestao_solidaria.gateways.dtos.requests.domains.voluntario.VoluntarioCreateRequestDto;
import fiap.kciao.gestao_solidaria.gateways.dtos.requests.domains.voluntario.VoluntarioUpdateRequestDto;
import fiap.kciao.gestao_solidaria.gateways.dtos.responses.domains.voluntario.VoluntarioFullResponseDto;
import fiap.kciao.gestao_solidaria.usecases.enums.ManageAction;
import fiap.kciao.gestao_solidaria.usecases.interfaces.CrudVoluntario;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/voluntario")
@Tag(name = "Vountário")
public class VoluntarioControllerImpl implements VoluntarioController {
    private final CrudVoluntario crudVoluntario;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Criar um novo voluntário")
    @Override
    public ResponseEntity<VoluntarioFullResponseDto> create(VoluntarioCreateRequestDto voluntarioCreateRequestDto) {
        return ResponseEntity.ok(crudVoluntario.create(voluntarioCreateRequestDto));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Edita um voluntário")
    @Override
    public ResponseEntity<VoluntarioFullResponseDto> update(Integer id, VoluntarioUpdateRequestDto voluntarioUpdateRequestDto) {
        return ResponseEntity.ok(crudVoluntario.update(id, voluntarioUpdateRequestDto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Deleta um voluntário")
    @Override
    public ResponseEntity<VoluntarioFullResponseDto> delete(Integer id) {
        crudVoluntario.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Busca um voluntário")
    @Override
    public ResponseEntity<VoluntarioFullResponseDto> findById(Integer id) {
        return ResponseEntity.ok(crudVoluntario.findById(id));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Busca todos voluntários")
    @Override
    public ResponseEntity<List<VoluntarioFullResponseDto>> findAll() {
        return ResponseEntity.ok(crudVoluntario.findAll());
    }

    @PostMapping("/gerenciar-habilidade")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Adicionar ou remove habilidade a um voluntário")
    @Override
    public ResponseEntity<VoluntarioFullResponseDto> manageHabilidade(Integer voluntarioId, Integer habilidadeId, ManageAction action) {
        return ResponseEntity.ok(crudVoluntario.manageHabilidade(voluntarioId, habilidadeId, action));
    }
}
