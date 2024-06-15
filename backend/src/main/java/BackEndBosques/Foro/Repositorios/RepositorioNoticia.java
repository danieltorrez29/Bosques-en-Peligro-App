package BackEndBosques.Foro.Repositorios;
import BackEndBosques.Foro.Model.Noticia;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioNoticia extends MongoRepository<Noticia, String> {
}
