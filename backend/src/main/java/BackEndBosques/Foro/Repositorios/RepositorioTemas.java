package BackEndBosques.Foro.Repositorios;
import BackEndBosques.Foro.Model.TemasForo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioTemas extends MongoRepository<TemasForo,String>{

}
