package fiap.kciao.gestao_solidaria.gateways.mappers.local;

import fiap.kciao.gestao_solidaria.domains.Local;
import fiap.kciao.gestao_solidaria.gateways.dtos.requests.domains.local.LocalCreateRequestDto;
import fiap.kciao.gestao_solidaria.gateways.dtos.responses.domains.local.LocalFullResponseDto;

import java.util.List;

public class LocalMapper {
    public static Local toEntityCreate(LocalCreateRequestDto localCreateRequestDto) {
        return Local.builder()
                .nome(localCreateRequestDto.getNome())
                .endereco(localCreateRequestDto.getEndereco())
                .capacidade(localCreateRequestDto.getCapacidade())
                .qtd_abrigados(localCreateRequestDto.getQtd_abrigados())
                .build();
    }

    public static LocalFullResponseDto toFullResponseDto(Local local) {
        return LocalFullResponseDto.builder()
                .id(local.getId())
                .nome(local.getNome())
                .endereco(local.getEndereco())
                .capacidade(local.getCapacidade())
                .qtd_abrigados(local.getQtd_abrigados())
                .build();
    }

    public static List<LocalFullResponseDto> toFullResponseDto(List<Local> locais) {
        return locais.stream().map(LocalMapper::toFullResponseDto).toList();
    }
}
