package fiap.kciao.apo_ia.usecases.interfaces;

import fiap.kciao.apo_ia.gateways.dtos.requests.domains.usuario.UsuarioCreateRequestDto;
import fiap.kciao.apo_ia.gateways.dtos.requests.domains.usuario.UsuarioUpdateRequestDto;
import fiap.kciao.apo_ia.gateways.dtos.responses.domains.usuario.UsuarioFullResponseDto;

import java.util.List;

public interface CrudUsuario {
    public UsuarioFullResponseDto create(UsuarioCreateRequestDto usuarioCreateRequestDto);
    public UsuarioFullResponseDto update(Integer id, UsuarioUpdateRequestDto usuarioUpdateRequestDto);
    public UsuarioFullResponseDto findById(Integer id);
    public List<UsuarioFullResponseDto> findAll();
    public void delete(Integer id);
}
