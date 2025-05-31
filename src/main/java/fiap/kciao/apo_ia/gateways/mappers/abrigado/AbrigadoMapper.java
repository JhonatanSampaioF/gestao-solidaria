package fiap.kciao.apo_ia.gateways.mappers.abrigado;

import fiap.kciao.apo_ia.domains.Abrigado;
import fiap.kciao.apo_ia.domains.Doenca;
import fiap.kciao.apo_ia.gateways.dtos.requests.domains.abrigado.AbrigadoCreateRequestDto;
import fiap.kciao.apo_ia.gateways.dtos.responses.domains.abrigado.AbrigadoFullResponseDto;

import java.util.List;

public class AbrigadoMapper {

    public static Abrigado toEntityCreate(AbrigadoCreateRequestDto abrigadoCreateRequestDto) {
        return Abrigado.builder()
                .nome(abrigadoCreateRequestDto.getNome())
                .idade(abrigadoCreateRequestDto.getIdade())
                .altura(abrigadoCreateRequestDto.getAltura())
                .peso(abrigadoCreateRequestDto.getPeso())
                .cpf(abrigadoCreateRequestDto.getCpf())
                .voluntario(abrigadoCreateRequestDto.getVoluntario())
                .build();
    }

    public static AbrigadoFullResponseDto toFullResponseDto(Abrigado abrigado) {
        return AbrigadoFullResponseDto.builder()
                .id(abrigado.getId())
                .nome(abrigado.getNome())
                .idade(abrigado.getIdade())
                .altura(abrigado.getAltura())
                .peso(abrigado.getPeso())
                .cpf(abrigado.getCpf())
                .voluntario(abrigado.getVoluntario())
                .localId(abrigado.getLocalId())
                .doencaIds(abrigado.getDoencaIds())
                .build();
    }

    public static List<AbrigadoFullResponseDto> toFullResponseDto(List<Abrigado> abrigados) {
        return abrigados.stream().map(AbrigadoMapper::toFullResponseDto).toList();
    }
}
