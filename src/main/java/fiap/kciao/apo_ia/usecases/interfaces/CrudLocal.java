package fiap.kciao.apo_ia.usecases.interfaces;

import fiap.kciao.apo_ia.gateways.dtos.requests.domains.local.LocalCreateRequestDto;
import fiap.kciao.apo_ia.gateways.dtos.requests.domains.local.LocalUpdateRequestDto;
import fiap.kciao.apo_ia.gateways.dtos.responses.domains.local.LocalFullResponseDto;

import java.util.List;

public interface CrudLocal {
    public LocalFullResponseDto create(LocalCreateRequestDto localCreateRequestDto);
    public LocalFullResponseDto update(Integer id, LocalUpdateRequestDto localUpdateRequestDto);
    public List<LocalFullResponseDto> findAll();
    public LocalFullResponseDto findById(Integer id);
    public void delete(Integer id);
}
