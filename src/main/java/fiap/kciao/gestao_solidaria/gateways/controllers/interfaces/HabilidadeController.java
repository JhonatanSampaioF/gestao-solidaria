package fiap.kciao.gestao_solidaria.gateways.controllers.interfaces;

import fiap.kciao.gestao_solidaria.gateways.dtos.requests.domains.habilidade.HabilidadeCreateRequestDto;
import fiap.kciao.gestao_solidaria.gateways.dtos.requests.domains.habilidade.HabilidadeUpdateRequestDto;
import fiap.kciao.gestao_solidaria.gateways.dtos.responses.domains.habilidade.HabilidadeFullResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface HabilidadeController {
    ResponseEntity<HabilidadeFullResponseDto> create(HabilidadeCreateRequestDto habilidadeCreateRequestDto);
    ResponseEntity<HabilidadeFullResponseDto> update(Integer id, HabilidadeUpdateRequestDto habilidadeUpdateRequestDto);
    ResponseEntity<Void> delete(Integer id);
    ResponseEntity<HabilidadeFullResponseDto> findById(Integer id);
    ResponseEntity<List<HabilidadeFullResponseDto>> findAll();
}
