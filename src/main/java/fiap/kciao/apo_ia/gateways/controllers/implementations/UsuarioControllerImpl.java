package fiap.kciao.apo_ia.gateways.controllers.implementations;

import fiap.kciao.apo_ia.gateways.controllers.interfaces.UsuarioController;
import fiap.kciao.apo_ia.gateways.dtos.requests.domains.usuario.UsuarioCreateRequestDto;
import fiap.kciao.apo_ia.gateways.dtos.requests.domains.usuario.UsuarioUpdateRequestDto;
import fiap.kciao.apo_ia.gateways.dtos.responses.domains.usuario.UsuarioFullResponseDto;
import fiap.kciao.apo_ia.usecases.interfaces.CrudUsuario;
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
@RequestMapping("/usuario")
@Tag(name = "Usuário")
public class UsuarioControllerImpl implements UsuarioController {
    private final CrudUsuario crudUsuario;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Criar um novo usuário")
    @Override
    public ResponseEntity<UsuarioFullResponseDto> create(@RequestBody @Valid UsuarioCreateRequestDto usuarioCreateRequestDto) {
        return ResponseEntity.ok(crudUsuario.create(usuarioCreateRequestDto));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Edita um usuário")
    @Override
    public ResponseEntity<UsuarioFullResponseDto> update(@PathVariable Integer id, @RequestBody @Valid UsuarioUpdateRequestDto usuarioUpdateRequestDto) {
        return ResponseEntity.ok(crudUsuario.update(id, usuarioUpdateRequestDto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Deleta um usuário")
    @Override
    public ResponseEntity<UsuarioFullResponseDto> delete(@PathVariable Integer id) {
        crudUsuario.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Busca um usuário")
    @Override
    public ResponseEntity<UsuarioFullResponseDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(crudUsuario.findById(id));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Busca todos usuários")
    @Override
    public ResponseEntity<List<UsuarioFullResponseDto>> findAll() {
        return ResponseEntity.ok(crudUsuario.findAll());
    }
}
