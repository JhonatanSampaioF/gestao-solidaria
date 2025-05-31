package fiap.kciao.gestao_solidaria.gateways.repositories;

import fiap.kciao.gestao_solidaria.domains.Voluntario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VoluntarioRepository extends MongoRepository<Voluntario, String> {
}
