package BackEndBosques.Foro.Repositorios;
import BackEndBosques.Foro.Model.SuperficieDeforestada;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface RepositorioSuperficie extends MongoRepository<SuperficieDeforestada, String> {
}
