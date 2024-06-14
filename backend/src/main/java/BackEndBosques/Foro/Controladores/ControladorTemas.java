package BackEndBosques.Foro.Controladores;

import BackEndBosques.Foro.Model.TemasForo;
import BackEndBosques.Foro.Model.Usuario;
import BackEndBosques.Foro.Repositorios.RepositorioTemas;
import BackEndBosques.Foro.Repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/temas")
public class ControladorTemas {
    @Autowired
    private RepositorioTemas miRepositorioTemas;
    @Autowired
    private RepositorioUsuario miRepositorioUsuario;
    @GetMapping("")
    public List<TemasForo> index(){
        return this.miRepositorioTemas.findAll();
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public TemasForo create(@RequestBody TemasForo infoTema) {
        if (infoTema.getUsuario() != null) {
            String idUsuario = infoTema.getUsuario().getId_usuario();
            Usuario usuario = miRepositorioUsuario.findById(idUsuario).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
            infoTema.setUsuario(usuario);
        }
        return this.miRepositorioTemas.save(infoTema);
    }
    @GetMapping("{id_temas}")
    public TemasForo show(@PathVariable String id_temas){
        TemasForo TemaActual=this.miRepositorioTemas.findById(id_temas).orElse(null);
        return TemaActual;
    }
    @PutMapping("{id_temas}/usuario/{id_usuario}")
    public TemasForo asignarUsuarioATema(@PathVariable String id_temas,@PathVariable
    String id_usuario){
        TemasForo temaActual=this.miRepositorioTemas.findById(id_temas).orElseThrow(() -> new RuntimeException("Tema no encontrado"));
        Usuario usuarioActual=this.miRepositorioUsuario.findById(id_usuario).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        temaActual.setUsuario(usuarioActual);
        return this.miRepositorioTemas.save(temaActual);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id_temas}")
    public void delete(@PathVariable String id_temas){
        TemasForo temaActual=this.miRepositorioTemas
                .findById(id_temas)
                .orElse(null);
        if (temaActual!=null){
            this.miRepositorioTemas.delete(temaActual);
        }
    }
}
