package fiap.kciao.gestao_solidaria.gateways.controllers.implementations;

import fiap.kciao.gestao_solidaria.gateways.controllers.interfaces.AbrigadoController;
import fiap.kciao.gestao_solidaria.gateways.dtos.requests.domains.abrigado.AbrigadoCreateRequestDto;
import fiap.kciao.gestao_solidaria.gateways.dtos.requests.domains.abrigado.AbrigadoUpdateRequestDto;
import fiap.kciao.gestao_solidaria.gateways.dtos.responses.domains.abrigado.AbrigadoFullResponseDto;
import fiap.kciao.gestao_solidaria.usecases.enums.ManageAction;
import fiap.kciao.gestao_solidaria.usecases.interfaces.CrudAbrigado;
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
@RequestMapping("/abrigado")
@Tag(name = "Abrigado")
public class AbrigadoControllerImpl implements AbrigadoController {
    private final CrudAbrigado crudAbrigado;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Criar um novo abrigado")
    @Override
    public ResponseEntity<AbrigadoFullResponseDto> save(@RequestBody @Valid AbrigadoCreateRequestDto abrigadoCreateRequestDto) {
        return ResponseEntity.ok(crudAbrigado.create(abrigadoCreateRequestDto));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Edita um abrigado")
    @Override
    public ResponseEntity<AbrigadoFullResponseDto> update(@PathVariable Integer id, @RequestBody @Valid AbrigadoUpdateRequestDto abrigadoUpdateRequestDto) {
        return ResponseEntity.ok(crudAbrigado.update(id, abrigadoUpdateRequestDto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Deleta um abrigado")
    @Override
    public ResponseEntity<AbrigadoFullResponseDto> delete(@PathVariable Integer id) {
        crudAbrigado.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Busca um abrigado")
    @Override
    public ResponseEntity<AbrigadoFullResponseDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(crudAbrigado.findById(id));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Busca todos abrigados")
    @Override
    public ResponseEntity<List<AbrigadoFullResponseDto>> findAll() {
        return ResponseEntity.ok(crudAbrigado.findAll());
    }

    @PostMapping("/gerenciar-doenca")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Adicionar ou remove doença a um abrigado")
    @Override
    public ResponseEntity<AbrigadoFullResponseDto> manageDoenca(@RequestParam Integer doencaId, @RequestParam Integer id, @RequestParam ManageAction action) {
        return ResponseEntity.ok(crudAbrigado.manageDoenca(doencaId, id, action));
    }
}
