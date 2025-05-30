package fiap.kciao.gestao_solidaria.gateways.dtos.requests.domains.habilidade;

import lombok.Data;

@Data
public class HabilidadeUpdateRequestDto {
    private String nome;
    private Integer prioridade;
}
