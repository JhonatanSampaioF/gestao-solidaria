package fiap.kciao.gestao_solidaria.gateways.repositories;

import fiap.kciao.gestao_solidaria.domains.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
}
