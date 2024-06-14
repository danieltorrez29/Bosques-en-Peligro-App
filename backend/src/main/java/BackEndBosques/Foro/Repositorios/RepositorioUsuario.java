package BackEndBosques.Foro.Repositorios;
import BackEndBosques.Foro.Model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioUsuario extends MongoRepository<Usuario,String> {
}
