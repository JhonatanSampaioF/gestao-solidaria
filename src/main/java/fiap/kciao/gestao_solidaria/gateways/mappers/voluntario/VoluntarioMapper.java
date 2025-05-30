package fiap.kciao.gestao_solidaria.gateways.mappers.voluntario;

import fiap.kciao.gestao_solidaria.domains.Habilidade;
import fiap.kciao.gestao_solidaria.domains.Voluntario;
import fiap.kciao.gestao_solidaria.gateways.dtos.requests.domains.voluntario.VoluntarioCreateRequestDto;
import fiap.kciao.gestao_solidaria.gateways.dtos.responses.domains.voluntario.VoluntarioFullResponseDto;

import java.util.List;

public class VoluntarioMapper {
    public static Voluntario toEntityCreate(VoluntarioCreateRequestDto voluntarioCreateRequestDto) {
        return Voluntario.builder()
                .alocacao(voluntarioCreateRequestDto.getAlocacao())
                .capacidade_motora(voluntarioCreateRequestDto.getCapacidade_motora())
                .build();
    }

    public static VoluntarioFullResponseDto toFullResponseDto(Voluntario voluntario) {
        return VoluntarioFullResponseDto.builder()
                .id(voluntario.getId())
                .alocacao(voluntario.getAlocacao())
                .capacidade_motora(voluntario.getCapacidade_motora())
                .habilidadesId(voluntario.getHabilidades().stream().map(Habilidade::getId).toList())
                .abrigadoId(voluntario.getAbrigado() != null
                        ? voluntario.getAbrigado().getId()
                        : null)
                .build();
    }

    public static List<VoluntarioFullResponseDto> toFullResponseDto(List<Voluntario> voluntarios) {
        return voluntarios.stream().map(VoluntarioMapper::toFullResponseDto).toList();
    }
}
