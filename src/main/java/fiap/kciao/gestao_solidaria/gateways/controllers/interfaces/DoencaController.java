package fiap.kciao.gestao_solidaria.gateways.controllers.interfaces;

import fiap.kciao.gestao_solidaria.gateways.dtos.requests.domains.doenca.DoencaCreateRequestDto;
import fiap.kciao.gestao_solidaria.gateways.dtos.requests.domains.doenca.DoencaUpdateRequestDto;
import fiap.kciao.gestao_solidaria.gateways.dtos.responses.domains.doenca.DoencaFullResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DoencaController {
    ResponseEntity<DoencaFullResponseDto> create(DoencaCreateRequestDto doencaCreateRequestDto);
    ResponseEntity<DoencaFullResponseDto> update(Integer id, DoencaUpdateRequestDto doencaUpdateRequestDto);
    ResponseEntity<DoencaFullResponseDto> delete(Integer id);
    ResponseEntity<DoencaFullResponseDto> findById(Integer id);
    ResponseEntity<List<DoencaFullResponseDto>> findAll();
}
