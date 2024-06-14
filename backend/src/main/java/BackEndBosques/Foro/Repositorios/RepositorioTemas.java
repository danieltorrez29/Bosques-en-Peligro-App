package BackEndBosques.Foro.Repositorios;
import BackEndBosques.Foro.Model.TemasForo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioTemas extends MongoRepository<TemasForo,String>{
}
