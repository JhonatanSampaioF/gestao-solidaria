package fiap.kciao.apo_ia.usecases.implementations;

import fiap.kciao.apo_ia.domains.Abrigado;
import fiap.kciao.apo_ia.domains.Habilidade;
import fiap.kciao.apo_ia.domains.Voluntario;
import fiap.kciao.apo_ia.gateways.dtos.requests.domains.voluntario.VoluntarioCreateRequestDto;
import fiap.kciao.apo_ia.gateways.dtos.requests.domains.voluntario.VoluntarioUpdateRequestDto;
import fiap.kciao.apo_ia.gateways.dtos.responses.domains.voluntario.VoluntarioFullResponseDto;
import fiap.kciao.apo_ia.usecases.enums.ManageAction;
import fiap.kciao.apo_ia.usecases.interfaces.CrudVoluntario;
import fiap.kciao.apo_ia.usecases.services.query.AbrigadoQueryService;
import fiap.kciao.apo_ia.usecases.services.query.HabilidadeQueryService;
import fiap.kciao.apo_ia.usecases.services.query.VoluntarioQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static fiap.kciao.apo_ia.gateways.mappers.voluntario.VoluntarioMapper.*;

@Service
@RequiredArgsConstructor
public class CrudVoluntarioImpl implements CrudVoluntario {
    private final AbrigadoQueryService abrigadoQueryService;
    private final VoluntarioQueryService voluntarioQueryService;
    private final HabilidadeQueryService habilidadeQueryService;

    @Override
    public VoluntarioFullResponseDto create(VoluntarioCreateRequestDto voluntarioCreateRequestDto) {
        Voluntario voluntario = toEntityCreate(voluntarioCreateRequestDto);

        Abrigado abrigado = abrigadoQueryService.findByIdOrThrow(voluntarioCreateRequestDto.getAbrigadoId());

        voluntario.setAbrigado(abrigado);

        return toFullResponseDto(voluntarioQueryService.save(voluntario));
    }

    @Override
    public VoluntarioFullResponseDto update(Integer id, VoluntarioUpdateRequestDto voluntarioUpdateRequestDto) {
        Voluntario voluntario = voluntarioQueryService.findByIdOrThrow(id);

        voluntario.setCapacidade_motora(voluntarioUpdateRequestDto.getCapacidade_motora());

        return toFullResponseDto(voluntarioQueryService.save(voluntario));
    }

    @Override
    public VoluntarioFullResponseDto findById(Integer id) {
        return toFullResponseDto(voluntarioQueryService.findByIdOrThrow(id));
    }

    @Override
    public List<VoluntarioFullResponseDto> findAll() {
        return toFullResponseDto(voluntarioQueryService.findAll());
    }

    @Override
    public void delete(Integer id) {
        voluntarioQueryService.deleteById(id);
    }

    @Override
    public VoluntarioFullResponseDto manageHabilidade(Integer voluntarioId, Integer habilidadeId, ManageAction action) {
        Voluntario voluntario = voluntarioQueryService.findByIdOrThrow(voluntarioId);

        Habilidade habilidade = habilidadeQueryService.findByIdOrThrow(habilidadeId);

        switch (action) {
            case ADD -> voluntario.getHabilidades().add(habilidade);
            case REMOVE -> voluntario.getHabilidades().remove(habilidade);
        }

        return toFullResponseDto(voluntarioQueryService.save(voluntario));
    }
}
