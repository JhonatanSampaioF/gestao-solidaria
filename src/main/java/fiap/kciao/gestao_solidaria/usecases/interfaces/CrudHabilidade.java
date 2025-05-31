package fiap.kciao.gestao_solidaria.usecases.interfaces;

import fiap.kciao.gestao_solidaria.gateways.dtos.requests.domains.habilidade.HabilidadeCreateRequestDto;
import fiap.kciao.gestao_solidaria.gateways.dtos.requests.domains.habilidade.HabilidadeUpdateRequestDto;
import fiap.kciao.gestao_solidaria.gateways.dtos.responses.domains.habilidade.HabilidadeFullResponseDto;

import java.util.List;

public interface CrudHabilidade {
    public HabilidadeFullResponseDto create(HabilidadeCreateRequestDto habilidadeCreateRequestDto);
    public HabilidadeFullResponseDto update(Integer id, HabilidadeUpdateRequestDto habilidadeUpdateRequestDto);
    public HabilidadeFullResponseDto findById(Integer id);
    public List<HabilidadeFullResponseDto> findAll();
    public void delete(Integer id);
}
