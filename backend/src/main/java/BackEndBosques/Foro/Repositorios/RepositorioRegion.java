package BackEndBosques.Foro.Repositorios;

import BackEndBosques.Foro.Model.Region;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioRegion extends MongoRepository<Region, String> {
}
