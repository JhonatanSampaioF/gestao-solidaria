package fiap.kciao.gestao_solidaria.usecases.interfaces;

import fiap.kciao.gestao_solidaria.gateways.dtos.requests.domains.abrigado.AbrigadoCreateRequestDto;
import fiap.kciao.gestao_solidaria.gateways.dtos.requests.domains.abrigado.AbrigadoUpdateRequestDto;
import fiap.kciao.gestao_solidaria.gateways.dtos.responses.domains.abrigado.AbrigadoFullResponseDto;
import fiap.kciao.gestao_solidaria.usecases.enums.ManageAction;

import java.util.List;

public interface CrudAbrigado {
    public AbrigadoFullResponseDto create(AbrigadoCreateRequestDto abrigadoCreateRequestDto);
    public AbrigadoFullResponseDto update(Integer id, AbrigadoUpdateRequestDto abrigadoUpdateRequestDto);
    public AbrigadoFullResponseDto findById(Integer id);
    public List<AbrigadoFullResponseDto> findAll();
    public void delete(Integer id);
    public AbrigadoFullResponseDto manageDoenca(Integer doencaId, Integer abrigadoId, ManageAction action);
}
