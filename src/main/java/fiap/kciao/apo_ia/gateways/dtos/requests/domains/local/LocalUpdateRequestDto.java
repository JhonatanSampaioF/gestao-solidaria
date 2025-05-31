package fiap.kciao.apo_ia.gateways.dtos.requests.domains.local;

import lombok.Data;

@Data
public class LocalUpdateRequestDto {
    private String nome;
    private String endereco;
    private Integer capacidade;
    private Integer qtd_abrigados;
}
