package fiap.kciao.gestao_solidaria.gateways.repositories;

import fiap.kciao.gestao_solidaria.domains.Doenca;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DoencaRepository extends MongoRepository<Doenca, String> {
}
