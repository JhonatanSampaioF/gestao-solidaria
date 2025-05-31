package fiap.kciao.apo_ia.gateways.dtos.requests.domains.abrigado;

import lombok.Data;

@Data
public class AbrigadoUpdateRequestDto {
    private String nome;
    private Integer idade;
    private Double altura;
    private Double peso;
    private String cpf;
    private Boolean voluntario;
    private String ferimento;
}
