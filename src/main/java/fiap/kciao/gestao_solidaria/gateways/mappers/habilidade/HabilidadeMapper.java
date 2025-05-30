package fiap.kciao.gestao_solidaria.gateways.mappers.habilidade;

import fiap.kciao.gestao_solidaria.domains.Habilidade;
import fiap.kciao.gestao_solidaria.domains.Voluntario;
import fiap.kciao.gestao_solidaria.gateways.dtos.requests.domains.habilidade.HabilidadeCreateRequestDto;
import fiap.kciao.gestao_solidaria.gateways.dtos.responses.domains.habilidade.HabilidadeFullResponseDto;

import java.util.List;

public class HabilidadeMapper {

    public static Habilidade toEntityCreate(HabilidadeCreateRequestDto habilidadeCreateRequestDto) {
        return Habilidade.builder()
                .nome(habilidadeCreateRequestDto.getNome())
                .prioridade(habilidadeCreateRequestDto.getPrioridade())
                .build();
    }

    public static HabilidadeFullResponseDto toFullResponseDto(Habilidade habilidade) {
        return HabilidadeFullResponseDto.builder()
                .id(habilidade.getId())
                .nome(habilidade.getNome())
                .prioridade(habilidade.getPrioridade())
                .voluntariosId(habilidade.getVoluntarios().stream().map(Voluntario::getId).toList())
                .build();
    }

    public static List<HabilidadeFullResponseDto> toFullResponseDto(List<Habilidade> habilidades) {
        return habilidades.stream().map(HabilidadeMapper::toFullResponseDto).toList();
    }
}
