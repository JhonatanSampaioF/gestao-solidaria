package fiap.kciao.apo_ia.gateways.dtos.requests.domains.doenca;

import lombok.Data;

@Data
public class DoencaUpdateRequestDto {
    private String nome;
    private String gravidade;
}
