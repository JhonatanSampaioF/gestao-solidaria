package fiap.kciao.gestao_solidaria.usecases.implementations;

import fiap.kciao.gestao_solidaria.domains.Habilidade;
import fiap.kciao.gestao_solidaria.gateways.dtos.requests.domains.habilidade.HabilidadeCreateRequestDto;
import fiap.kciao.gestao_solidaria.gateways.dtos.requests.domains.habilidade.HabilidadeUpdateRequestDto;
import fiap.kciao.gestao_solidaria.gateways.dtos.responses.domains.habilidade.HabilidadeFullResponseDto;
import fiap.kciao.gestao_solidaria.usecases.interfaces.CrudHabilidade;
import fiap.kciao.gestao_solidaria.usecases.services.query.HabilidadeQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static fiap.kciao.gestao_solidaria.gateways.mappers.habilidade.HabilidadeMapper.*;

@Service
@RequiredArgsConstructor
public class CrudHabilidadeImpl implements CrudHabilidade {
    private final HabilidadeQueryService habilidadeQueryService;

    @Override
    public HabilidadeFullResponseDto create(HabilidadeCreateRequestDto habilidadeCreateRequestDto) {
        return toFullResponseDto(habilidadeQueryService.save(toEntityCreate(habilidadeCreateRequestDto)));
    }

    @Override
    public HabilidadeFullResponseDto update(Integer id, HabilidadeUpdateRequestDto habilidadeUpdateRequestDto) {
        Habilidade habilidade = habilidadeQueryService.findByIdOrThrow(id);

        habilidade.setNome(habilidadeUpdateRequestDto.getNome());
        habilidade.setPrioridade(habilidadeUpdateRequestDto.getPrioridade());

        return toFullResponseDto(habilidadeQueryService.save(habilidade));
    }

    @Override
    public HabilidadeFullResponseDto findById(Integer id) {
        return toFullResponseDto(habilidadeQueryService.findByIdOrThrow(id));
    }

    @Override
    public List<HabilidadeFullResponseDto> findAll() {
        return toFullResponseDto(habilidadeQueryService.findAll());
    }

    @Override
    public void delete(Integer id) {
        habilidadeQueryService.deleteById(id);
    }
}
