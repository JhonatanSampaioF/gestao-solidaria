package fiap.kciao.apo_ia.gateways.controllers.interfaces;

import fiap.kciao.apo_ia.gateways.dtos.requests.domains.local.LocalCreateRequestDto;
import fiap.kciao.apo_ia.gateways.dtos.requests.domains.local.LocalUpdateRequestDto;
import fiap.kciao.apo_ia.gateways.dtos.responses.domains.local.LocalFullResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LocalController {
    ResponseEntity<LocalFullResponseDto> create(LocalCreateRequestDto localCreateRequestDto);
    ResponseEntity<LocalFullResponseDto> update(Integer id, LocalUpdateRequestDto localUpdateRequestDto);
    ResponseEntity<LocalFullResponseDto> delete(Integer id);
    ResponseEntity<LocalFullResponseDto> findById(Integer id);
    ResponseEntity<List<LocalFullResponseDto>> findAll();
}
