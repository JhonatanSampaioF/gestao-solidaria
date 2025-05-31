package fiap.kciao.gestao_solidaria.usecases.interfaces;

import fiap.kciao.gestao_solidaria.gateways.dtos.requests.domains.usuario.UsuarioCreateRequestDto;
import fiap.kciao.gestao_solidaria.gateways.dtos.requests.domains.usuario.UsuarioUpdateRequestDto;
import fiap.kciao.gestao_solidaria.gateways.dtos.responses.domains.usuario.UsuarioFullResponseDto;

import java.util.List;

public interface CrudUsuario {
    public UsuarioFullResponseDto create(UsuarioCreateRequestDto usuarioCreateRequestDto);
    public UsuarioFullResponseDto update(Integer id, UsuarioUpdateRequestDto usuarioUpdateRequestDto);
    public UsuarioFullResponseDto findById(Integer id);
    public List<UsuarioFullResponseDto> findAll();
    public void delete(Integer id);
}
