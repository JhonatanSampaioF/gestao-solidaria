package fiap.kciao.gestao_solidaria.usecases.implementations;

import fiap.kciao.gestao_solidaria.domains.Usuario;
import fiap.kciao.gestao_solidaria.gateways.dtos.requests.domains.usuario.UsuarioCreateRequestDto;
import fiap.kciao.gestao_solidaria.gateways.dtos.requests.domains.usuario.UsuarioUpdateRequestDto;
import fiap.kciao.gestao_solidaria.gateways.dtos.responses.domains.usuario.UsuarioFullResponseDto;
import fiap.kciao.gestao_solidaria.usecases.interfaces.CrudUsuario;
import fiap.kciao.gestao_solidaria.usecases.services.query.UsuarioQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static fiap.kciao.gestao_solidaria.gateways.mappers.usuario.UsuarioMapper.*;

@Service
@RequiredArgsConstructor
public class CrudUsuarioImpl implements CrudUsuario {
    private final UsuarioQueryService usuarioQueryService;

    @Override
    public UsuarioFullResponseDto create(UsuarioCreateRequestDto usuarioCreateRequestDto) {
        Usuario usuario = toEntityCreate(usuarioCreateRequestDto);

        usuario.setSenha(usuarioCreateRequestDto.getSenha());

        return toFullResponseDto(usuarioQueryService.save(usuario));
    }

    @Override
    public UsuarioFullResponseDto update(Integer id, UsuarioUpdateRequestDto usuarioUpdateRequestDto) {
        Usuario usuario = usuarioQueryService.findByIdOrThrow(id);

        usuario.setNome(usuarioUpdateRequestDto.getName());
        usuario.setEmail(usuarioUpdateRequestDto.getEmail());
        usuario.setSenha(usuarioUpdateRequestDto.getSenha());

        return toFullResponseDto(usuarioQueryService.save(usuario));
    }

    @Override
    public UsuarioFullResponseDto findById(Integer id) {
        return toFullResponseDto(usuarioQueryService.findByIdOrThrow(id));
    }

    @Override
    public List<UsuarioFullResponseDto> findAll() {
        return toFullResponseDto(usuarioQueryService.findAll());
    }

    @Override
    public void delete(Integer id) {
        usuarioQueryService.deleteById(id);
    }
}
