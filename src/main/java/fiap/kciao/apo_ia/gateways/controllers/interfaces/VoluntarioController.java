package fiap.kciao.apo_ia.gateways.controllers.interfaces;

import fiap.kciao.apo_ia.gateways.dtos.requests.domains.voluntario.VoluntarioCreateRequestDto;
import fiap.kciao.apo_ia.gateways.dtos.requests.domains.voluntario.VoluntarioUpdateRequestDto;
import fiap.kciao.apo_ia.gateways.dtos.responses.domains.voluntario.VoluntarioFullResponseDto;
import fiap.kciao.apo_ia.usecases.enums.ManageAction;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface VoluntarioController {
    ResponseEntity<VoluntarioFullResponseDto> create(VoluntarioCreateRequestDto voluntarioCreateRequestDto);
    ResponseEntity<VoluntarioFullResponseDto> update(String id, VoluntarioUpdateRequestDto voluntarioUpdateRequestDto);
    ResponseEntity<VoluntarioFullResponseDto> delete(String id);
    ResponseEntity<VoluntarioFullResponseDto> findById(String id);
    ResponseEntity<List<VoluntarioFullResponseDto>> findAll();
    ResponseEntity<VoluntarioFullResponseDto> manageHabilidade(String voluntarioId, String habilidadeId, ManageAction action);
}
