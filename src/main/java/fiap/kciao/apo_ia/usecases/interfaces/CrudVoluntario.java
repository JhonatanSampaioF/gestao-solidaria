package fiap.kciao.apo_ia.usecases.interfaces;

import fiap.kciao.apo_ia.gateways.dtos.requests.domains.voluntario.VoluntarioCreateRequestDto;
import fiap.kciao.apo_ia.gateways.dtos.requests.domains.voluntario.VoluntarioUpdateRequestDto;
import fiap.kciao.apo_ia.gateways.dtos.responses.domains.voluntario.VoluntarioFullResponseDto;
import fiap.kciao.apo_ia.usecases.enums.ManageAction;

import java.util.List;

public interface CrudVoluntario {
    public VoluntarioFullResponseDto create(VoluntarioCreateRequestDto voluntarioCreateRequestDto);
    public VoluntarioFullResponseDto update(Integer id, VoluntarioUpdateRequestDto voluntarioUpdateRequestDto);
    public VoluntarioFullResponseDto findById(Integer id);
    public List<VoluntarioFullResponseDto> findAll();
    public void delete(Integer id);
    public VoluntarioFullResponseDto manageHabilidade(Integer voluntarioId, Integer habilidadeId, ManageAction action);
}
