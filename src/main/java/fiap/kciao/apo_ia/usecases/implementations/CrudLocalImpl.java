package fiap.kciao.apo_ia.usecases.implementations;

import fiap.kciao.apo_ia.domains.Local;
import fiap.kciao.apo_ia.gateways.dtos.requests.domains.local.LocalCreateRequestDto;
import fiap.kciao.apo_ia.gateways.dtos.requests.domains.local.LocalUpdateRequestDto;
import fiap.kciao.apo_ia.gateways.dtos.responses.domains.local.LocalFullResponseDto;
import fiap.kciao.apo_ia.usecases.interfaces.CrudLocal;
import fiap.kciao.apo_ia.usecases.services.query.LocalQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static fiap.kciao.apo_ia.gateways.mappers.local.LocalMapper.*;

@Service
@RequiredArgsConstructor
public class CrudLocalImpl implements CrudLocal {
    private final LocalQueryService localQueryService;

    @Override
    public LocalFullResponseDto create(LocalCreateRequestDto localCreateRequestDto) {
        return toFullResponseDto(localQueryService.save(toEntityCreate(localCreateRequestDto)));
    }

    @Override
    public LocalFullResponseDto update(Integer id, LocalUpdateRequestDto localUpdateRequestDto) {
        Local local = localQueryService.findByIdOrThrow(id);

        local.setNome(localUpdateRequestDto.getNome());
        local.setEndereco(localUpdateRequestDto.getEndereco());
        local.setCapacidade(localUpdateRequestDto.getCapacidade());
        local.setQtd_abrigados(localUpdateRequestDto.getQtd_abrigados());

        return toFullResponseDto(localQueryService.save(local));
    }

    @Override
    public List<LocalFullResponseDto> findAll() {
        return toFullResponseDto(localQueryService.findAll());
    }

    @Override
    public LocalFullResponseDto findById(Integer id) {
        return toFullResponseDto(localQueryService.findByIdOrThrow(id));
    }

    @Override
    public void delete(Integer id) {
        localQueryService.deleteById(id);
    }
}
