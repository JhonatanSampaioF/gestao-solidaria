package fiap.kciao.gestao_solidaria.usecases.interfaces;

import fiap.kciao.gestao_solidaria.gateways.dtos.requests.domains.doenca.DoencaCreateRequestDto;
import fiap.kciao.gestao_solidaria.gateways.dtos.requests.domains.doenca.DoencaUpdateRequestDto;
import fiap.kciao.gestao_solidaria.gateways.dtos.responses.domains.doenca.DoencaFullResponseDto;

import java.util.List;

public interface CrudDoenca {
    public DoencaFullResponseDto create(DoencaCreateRequestDto doencaCreateRequestDto);
    public DoencaFullResponseDto update(Integer id, DoencaUpdateRequestDto doencaUpdateRequestDto);
    public DoencaFullResponseDto findById(Integer id);
    public List<DoencaFullResponseDto> findAll();
    public void delete(Integer id);
}
