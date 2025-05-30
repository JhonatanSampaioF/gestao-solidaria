package fiap.kciao.apo_ia.gateways.controllers.interfaces;

import fiap.kciao.apo_ia.gateways.dtos.requests.domains.usuario.UsuarioCreateRequestDto;
import fiap.kciao.apo_ia.gateways.dtos.requests.domains.usuario.UsuarioUpdateRequestDto;
import fiap.kciao.apo_ia.gateways.dtos.responses.domains.usuario.UsuarioFullResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UsuarioController {
    ResponseEntity<UsuarioFullResponseDto> create(UsuarioCreateRequestDto usuarioCreateRequestDto);
    ResponseEntity<UsuarioFullResponseDto> update(Integer id, UsuarioUpdateRequestDto usuarioUpdateRequestDto);
    ResponseEntity<UsuarioFullResponseDto> delete(Integer id);
    ResponseEntity<UsuarioFullResponseDto> findById(Integer id);
    ResponseEntity<List<UsuarioFullResponseDto>> findAll();
}
