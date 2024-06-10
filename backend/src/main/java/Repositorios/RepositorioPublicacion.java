package Repositorios;
import Model.Publicacion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioPublicacion extends MongoRepository<Publicacion,String> {
}
