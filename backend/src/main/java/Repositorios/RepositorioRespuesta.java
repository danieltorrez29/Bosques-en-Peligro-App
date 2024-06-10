package Repositorios;
import Model.RespuetasForo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioRespuesta extends MongoRepository<RespuetasForo,String>{
}
