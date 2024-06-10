package Repositorios;
import Model.TemasForo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioTemas extends MongoRepository<TemasForo,String>{
}
