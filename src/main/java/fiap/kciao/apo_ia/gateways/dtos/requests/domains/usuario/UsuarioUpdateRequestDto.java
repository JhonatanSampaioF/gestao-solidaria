package fiap.kciao.apo_ia.gateways.dtos.requests.domains.usuario;

import lombok.Data;

@Data
public class UsuarioUpdateRequestDto {
    private String name;
    private String email;
    private String senha;
}
