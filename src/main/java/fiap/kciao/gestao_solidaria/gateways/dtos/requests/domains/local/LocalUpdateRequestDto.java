package fiap.kciao.gestao_solidaria.gateways.dtos.requests.domains.local;

import lombok.Data;

@Data
public class LocalUpdateRequestDto {
    private String nome;
    private String endereco;
    private Integer capacidade;
    private Integer qtd_abrigados;
}
