package fiap.kciao.gestao_solidaria.gateways.dtos.requests.domains.voluntario;

import lombok.Data;

@Data
public class VoluntarioUpdateRequestDto {
    private String capacidade_motora;
    private Integer abrigadoId;
}
