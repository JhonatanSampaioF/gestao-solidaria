package fiap.kciao.gestao_solidaria.gateways.mappers.doenca;

import fiap.kciao.gestao_solidaria.domains.Abrigado;
import fiap.kciao.gestao_solidaria.domains.Doenca;
import fiap.kciao.gestao_solidaria.gateways.dtos.requests.domains.doenca.DoencaCreateRequestDto;
import fiap.kciao.gestao_solidaria.gateways.dtos.responses.domains.doenca.DoencaFullResponseDto;

import java.util.List;

public class DoencaMapper {

    public static Doenca toEntityCreate(DoencaCreateRequestDto doencaCreateRequestDto) {
        return Doenca.builder()
                .nome(doencaCreateRequestDto.getNome())
                .gravidade(doencaCreateRequestDto.getGravidade())
                .build();
    }

    public static DoencaFullResponseDto toFullResponseDto(Doenca doenca) {
        return DoencaFullResponseDto.builder()
                .id(doenca.getId())
                .nome(doenca.getNome())
                .gravidade(doenca.getGravidade())
                .abrigadosId(doenca.getAbrigados().stream().map(Abrigado::getId).toList())
                .build();
    }

    public static List<DoencaFullResponseDto> toFullResponseDto(List<Doenca> doencas) {
        return doencas.stream().map(DoencaMapper::toFullResponseDto).toList();
    }
}
