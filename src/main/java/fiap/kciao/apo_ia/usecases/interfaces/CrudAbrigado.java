package fiap.kciao.apo_ia.usecases.interfaces;

import fiap.kciao.apo_ia.gateways.dtos.requests.domains.abrigado.AbrigadoCreateRequestDto;
import fiap.kciao.apo_ia.gateways.dtos.requests.domains.abrigado.AbrigadoUpdateRequestDto;
import fiap.kciao.apo_ia.gateways.dtos.responses.domains.abrigado.AbrigadoFullResponseDto;
import fiap.kciao.apo_ia.usecases.enums.ManageAction;

import java.util.List;

public interface CrudAbrigado {
    public AbrigadoFullResponseDto create(AbrigadoCreateRequestDto abrigadoCreateRequestDto);
    public AbrigadoFullResponseDto update(Integer id, AbrigadoUpdateRequestDto abrigadoUpdateRequestDto);
    public AbrigadoFullResponseDto findById(Integer id);
    public List<AbrigadoFullResponseDto> findAll();
    public void delete(Integer id);
    public AbrigadoFullResponseDto manageDoenca(Integer doencaId, Integer abrigadoId, ManageAction action);
}
