package BackEndBosques.Foro.Repositorios;
import BackEndBosques.Foro.Model.Proyecto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioProyecto extends MongoRepository<Proyecto, String > {
}
