package fiap.kciao.gestao_solidaria.usecases.implementations;

import fiap.kciao.gestao_solidaria.domains.Doenca;
import fiap.kciao.gestao_solidaria.gateways.dtos.requests.domains.doenca.DoencaCreateRequestDto;
import fiap.kciao.gestao_solidaria.gateways.dtos.requests.domains.doenca.DoencaUpdateRequestDto;
import fiap.kciao.gestao_solidaria.gateways.dtos.responses.domains.doenca.DoencaFullResponseDto;
import fiap.kciao.gestao_solidaria.usecases.interfaces.CrudDoenca;
import fiap.kciao.gestao_solidaria.usecases.services.query.DoencaQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static fiap.kciao.gestao_solidaria.gateways.mappers.doenca.DoencaMapper.*;

@Service
@RequiredArgsConstructor
public class CrudDoencaImpl implements CrudDoenca {
    private final DoencaQueryService doencaQueryService;

    @Override
    public DoencaFullResponseDto create(DoencaCreateRequestDto doencaCreateRequestDto) {
        return toFullResponseDto(doencaQueryService.save(toEntityCreate(doencaCreateRequestDto)));
    }

    @Override
    public DoencaFullResponseDto update(Integer id, DoencaUpdateRequestDto doencaUpdateRequestDto) {
        Doenca doenca = doencaQueryService.findByIdOrThrow(id);

        doenca.setNome(doencaUpdateRequestDto.getNome());
        doenca.setGravidade(doencaUpdateRequestDto.getGravidade());

        return toFullResponseDto(doencaQueryService.save(doenca));
    }

    @Override
    public DoencaFullResponseDto findById(Integer id) {
        return toFullResponseDto(doencaQueryService.findByIdOrThrow(id));
    }

    @Override
    public List<DoencaFullResponseDto> findAll() {
        return toFullResponseDto(doencaQueryService.findAll());
    }

    @Override
    public void delete(Integer id) {
        doencaQueryService.deleteById(id);
    }
}
