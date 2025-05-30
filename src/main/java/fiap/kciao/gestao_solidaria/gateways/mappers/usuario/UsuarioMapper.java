package fiap.kciao.gestao_solidaria.gateways.mappers.usuario;

import fiap.kciao.gestao_solidaria.domains.Usuario;
import fiap.kciao.gestao_solidaria.gateways.dtos.requests.domains.usuario.UsuarioCreateRequestDto;
import fiap.kciao.gestao_solidaria.gateways.dtos.responses.domains.usuario.UsuarioFullResponseDto;

import java.util.List;

public class UsuarioMapper {
    public static Usuario toEntityCreate(UsuarioCreateRequestDto usuarioCreateRequestDto) {
        return Usuario.builder()
                .nome(usuarioCreateRequestDto.getName())
                .email(usuarioCreateRequestDto.getEmail())
                .build();
    }

    public static UsuarioFullResponseDto toFullResponseDto(Usuario usuario) {
        return UsuarioFullResponseDto.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .build();
    }

    public static List<UsuarioFullResponseDto> toFullResponseDto(List<Usuario> usuarios) {
        return usuarios.stream().map(UsuarioMapper::toFullResponseDto).toList();
    }
}
