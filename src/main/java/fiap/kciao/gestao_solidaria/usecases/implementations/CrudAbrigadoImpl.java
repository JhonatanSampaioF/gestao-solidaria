package fiap.kciao.gestao_solidaria.usecases.implementations;

import fiap.kciao.gestao_solidaria.domains.Abrigado;
import fiap.kciao.gestao_solidaria.domains.Doenca;
import fiap.kciao.gestao_solidaria.domains.Local;
import fiap.kciao.gestao_solidaria.gateways.dtos.requests.domains.abrigado.AbrigadoCreateRequestDto;
import fiap.kciao.gestao_solidaria.gateways.dtos.requests.domains.abrigado.AbrigadoUpdateRequestDto;
import fiap.kciao.gestao_solidaria.gateways.dtos.responses.domains.abrigado.AbrigadoFullResponseDto;
import fiap.kciao.gestao_solidaria.usecases.enums.ManageAction;
import fiap.kciao.gestao_solidaria.usecases.interfaces.CrudAbrigado;
import fiap.kciao.gestao_solidaria.usecases.services.query.AbrigadoQueryService;
import fiap.kciao.gestao_solidaria.usecases.services.query.DoencaQueryService;
import fiap.kciao.gestao_solidaria.usecases.services.query.LocalQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static fiap.kciao.gestao_solidaria.gateways.mappers.abrigado.AbrigadoMapper.*;

@Service
@RequiredArgsConstructor
public class CrudAbrigadoImpl implements CrudAbrigado {
    private final AbrigadoQueryService abrigadoQueryService;
    private final LocalQueryService localQueryService;
    private final DoencaQueryService doencaQueryService;

    @Override
    public AbrigadoFullResponseDto create(AbrigadoCreateRequestDto abrigadoCreateRequestDto) {
        Local local = localQueryService.findByIdOrThrow(abrigadoCreateRequestDto.getLocalId());

        Abrigado abrigado = toEntityCreate(abrigadoCreateRequestDto);

        abrigado.setLocal(local);

        return toFullResponseDto(abrigadoQueryService.save(abrigado));
    }

    @Override
    public AbrigadoFullResponseDto update(Integer id, AbrigadoUpdateRequestDto abrigadoUpdateRequestDto) {
        Abrigado abrigado = abrigadoQueryService.findByIdOrThrow(id);

        abrigado.setNome(abrigadoUpdateRequestDto.getNome());
        abrigado.setIdade(abrigadoUpdateRequestDto.getIdade());
        abrigado.setAltura(abrigadoUpdateRequestDto.getAltura());
        abrigado.setPeso(abrigadoUpdateRequestDto.getPeso());
        abrigado.setCpf(abrigadoUpdateRequestDto.getCpf());
        abrigado.setVoluntario(abrigadoUpdateRequestDto.getVoluntario());
        abrigado.setFerimento(abrigadoUpdateRequestDto.getFerimento());

        return toFullResponseDto(abrigadoQueryService.save(abrigado));
    }

    @Override
    public AbrigadoFullResponseDto findById(Integer id) {
        return toFullResponseDto(abrigadoQueryService.findByIdOrThrow(id));
    }

    @Override
    public List<AbrigadoFullResponseDto> findAll() {
        return toFullResponseDto(abrigadoQueryService.findAll());
    }

    @Override
    public void delete(Integer id) {
        abrigadoQueryService.deleteById(id);
    }

    @Override
    public AbrigadoFullResponseDto manageDoenca(Integer doencaId, Integer abrigadoId, ManageAction action) {
        Abrigado abrigado = abrigadoQueryService.findByIdOrThrow(abrigadoId);

        Doenca doenca = doencaQueryService.findByIdOrThrow(doencaId);

        switch (action) {
            case ADD -> abrigado.getDoencas().add(doenca);
            case REMOVE -> abrigado.getDoencas().remove(doenca);
        }

        return toFullResponseDto(abrigadoQueryService.save(abrigado));
    }
}
