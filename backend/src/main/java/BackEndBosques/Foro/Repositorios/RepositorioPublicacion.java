package BackEndBosques.Foro.Repositorios;
import BackEndBosques.Foro.Model.Publicacion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioPublicacion extends MongoRepository<Publicacion,String> {
}
