package BackEndBosques.Foro.Repositorios;

import java.util.ArrayList;
import BackEndBosques.Foro.Model.RegistroModel;
import BackEndBosques.Foro.Model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroRepository extends CrudRepository<Usuario, Integer> {
    // Vacía porque los métodos ya están implementados
    ArrayList<Usuario> findBynombreCompleto(String nombreCompleto);
    ArrayList<Usuario> findBytelefono(Integer telefono);
    ArrayList<Usuario> findBycorreo(String correo);
    ArrayList<Usuario> findBycontrasena(String contrasena);
}
