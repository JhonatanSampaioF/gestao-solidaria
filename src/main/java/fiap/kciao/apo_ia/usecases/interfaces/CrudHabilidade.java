package fiap.kciao.apo_ia.usecases.interfaces;

import fiap.kciao.apo_ia.gateways.dtos.requests.domains.habilidade.HabilidadeCreateRequestDto;
import fiap.kciao.apo_ia.gateways.dtos.requests.domains.habilidade.HabilidadeUpdateRequestDto;
import fiap.kciao.apo_ia.gateways.dtos.responses.domains.habilidade.HabilidadeFullResponseDto;

import java.util.List;

public interface CrudHabilidade {
    public HabilidadeFullResponseDto create(HabilidadeCreateRequestDto habilidadeCreateRequestDto);
    public HabilidadeFullResponseDto update(Integer id, HabilidadeUpdateRequestDto habilidadeUpdateRequestDto);
    public HabilidadeFullResponseDto findById(Integer id);
    public List<HabilidadeFullResponseDto> findAll();
    public void delete(Integer id);
}
