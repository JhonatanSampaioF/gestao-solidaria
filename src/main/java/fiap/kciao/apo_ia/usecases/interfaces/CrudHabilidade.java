package fiap.kciao.apo_ia.usecases.interfaces;

import fiap.kciao.apo_ia.gateways.dtos.requests.domains.habilidade.HabilidadeCreateRequestDto;
import fiap.kciao.apo_ia.gateways.dtos.requests.domains.habilidade.HabilidadeUpdateRequestDto;
import fiap.kciao.apo_ia.gateways.dtos.responses.domains.habilidade.HabilidadeFullResponseDto;

import java.util.List;

public interface CrudHabilidade {
    public HabilidadeFullResponseDto create(HabilidadeCreateRequestDto habilidadeCreateRequestDto);
    public HabilidadeFullResponseDto update(String id, HabilidadeUpdateRequestDto habilidadeUpdateRequestDto);
    public HabilidadeFullResponseDto findById(String id);
    public List<HabilidadeFullResponseDto> findAll();
    public void delete(String id);
}
