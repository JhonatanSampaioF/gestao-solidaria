package fiap.kciao.gestao_solidaria.gateways.repositories;

import fiap.kciao.gestao_solidaria.domains.Abrigado;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AbrigadoRepository extends MongoRepository<Abrigado, String> {
}
