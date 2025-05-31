package fiap.kciao.apo_ia.gateways.controllers.interfaces;

import fiap.kciao.apo_ia.gateways.dtos.requests.domains.abrigado.AbrigadoCreateRequestDto;
import fiap.kciao.apo_ia.gateways.dtos.requests.domains.abrigado.AbrigadoUpdateRequestDto;
import fiap.kciao.apo_ia.gateways.dtos.responses.domains.abrigado.AbrigadoFullResponseDto;
import fiap.kciao.apo_ia.usecases.enums.ManageAction;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AbrigadoController {
    ResponseEntity<AbrigadoFullResponseDto> save(AbrigadoCreateRequestDto abrigadoCreateRequestDto);
    ResponseEntity<AbrigadoFullResponseDto> update(Integer id, AbrigadoUpdateRequestDto abrigadoUpdateRequestDto);
    ResponseEntity<AbrigadoFullResponseDto> delete(Integer id);
    ResponseEntity<AbrigadoFullResponseDto> findById(Integer id);
    ResponseEntity<List<AbrigadoFullResponseDto>> findAll();
    ResponseEntity<AbrigadoFullResponseDto> manageDoenca(Integer doencaId, Integer abrigadoId, ManageAction action);
}
