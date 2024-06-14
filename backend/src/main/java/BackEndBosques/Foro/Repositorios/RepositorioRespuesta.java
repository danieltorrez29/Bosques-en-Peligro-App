package BackEndBosques.Foro.Repositorios;
import BackEndBosques.Foro.Model.RespuetasForo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioRespuesta extends MongoRepository<RespuetasForo,String>{
}
