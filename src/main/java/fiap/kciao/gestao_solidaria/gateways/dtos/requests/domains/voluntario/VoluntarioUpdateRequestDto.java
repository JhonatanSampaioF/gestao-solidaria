package fiap.kciao.gestao_solidaria.gateways.dtos.requests.domains.voluntario;

import lombok.Data;

@Data
public class VoluntarioUpdateRequestDto {
    private String alocacao;
    private String capacidade_motora;
    private Integer abrigadoId;
}
