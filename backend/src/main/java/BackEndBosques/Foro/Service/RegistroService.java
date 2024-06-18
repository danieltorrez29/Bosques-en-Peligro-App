package BackEndBosques.Foro.Service;

import BackEndBosques.Foro.Model.RegistroModel;
import BackEndBosques.Foro.Model.Usuario;
import BackEndBosques.Foro.Repositorios.RegistroRepository;
import BackEndBosques.Foro.Repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistroService {

    @Autowired
    RepositorioUsuario repositorioUsuario;

    public Usuario guardarRegistro(Usuario registro) {
        return repositorioUsuario.save(registro);
    }

    public Optional<Usuario> obtenerRegistroPorId(Integer id) {
        return repositorioUsuario.findById(id);
    }
}
