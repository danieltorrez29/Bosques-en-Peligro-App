package BackEndBosques.Foro.Repositorios;
import BackEndBosques.Foro.Model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioUsuario extends MongoRepository<Usuario,String> {
}
