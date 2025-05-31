package fiap.kciao.gestao_solidaria.gateways.repositories;

import fiap.kciao.gestao_solidaria.domains.Habilidade;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HabilidadeRepository extends MongoRepository<Habilidade, String> {
}
