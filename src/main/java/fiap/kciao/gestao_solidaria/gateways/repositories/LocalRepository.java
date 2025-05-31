package fiap.kciao.gestao_solidaria.gateways.repositories;

import fiap.kciao.gestao_solidaria.domains.Local;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LocalRepository extends MongoRepository<Local, String> {
}
