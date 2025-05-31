package fiap.kciao.apo_ia.usecases.implementations;

import fiap.kciao.apo_ia.domains.Habilidade;
import fiap.kciao.apo_ia.gateways.dtos.requests.domains.habilidade.HabilidadeCreateRequestDto;
import fiap.kciao.apo_ia.gateways.dtos.requests.domains.habilidade.HabilidadeUpdateRequestDto;
import fiap.kciao.apo_ia.gateways.dtos.responses.domains.habilidade.HabilidadeFullResponseDto;
import fiap.kciao.apo_ia.usecases.interfaces.CrudHabilidade;
import fiap.kciao.apo_ia.usecases.services.query.HabilidadeQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static fiap.kciao.apo_ia.gateways.mappers.habilidade.HabilidadeMapper.*;

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
