package BackEndBosques.Foro.Controladores;

import BackEndBosques.Foro.Model.Noticia;
import BackEndBosques.Foro.Model.Proyecto;
import BackEndBosques.Foro.Repositorios.RepositorioNoticia;
import BackEndBosques.Foro.Repositorios.RepositorioProyecto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/noticia")
public class ControladorNoticia {
    @Autowired
    private RepositorioNoticia miRepositorioNoticia;

    @Autowired
    private RepositorioProyecto miRepositorioProyecto;

    // Obtener todas las noticias
    @GetMapping("")
    public List<Noticia> index() {
        return this.miRepositorioNoticia.findAll();
    }

    // Crear una nueva noticia
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Noticia create(@RequestBody Noticia noticia) {
        // Verificar que el proyecto exista
        Proyecto proyecto = this.miRepositorioProyecto.findById(noticia.getProyecto().getId_proyecto())
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));
        noticia.setProyecto(proyecto);
        return this.miRepositorioNoticia.save(noticia);
    }

    // Obtener una noticia por su ID
    @GetMapping("/{id_noticias}")
    public Noticia show(@PathVariable String id_noticias) {
        return this.miRepositorioNoticia.findById(id_noticias)
                .orElseThrow(() -> new RuntimeException("Noticia no encontrada"));
    }

    // Actualizar una noticia existente
    @PutMapping("/{id_noticias}")
    public Noticia update(@PathVariable String id_noticias, @RequestBody Noticia noticia) {
        Noticia noticiaActual = this.miRepositorioNoticia.findById(id_noticias)
                .orElseThrow(() -> new RuntimeException("Noticia no encontrada"));

        Proyecto proyecto = this.miRepositorioProyecto.findById(noticia.getProyecto().getId_proyecto())
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));

        noticiaActual.setTitulo(noticia.getTitulo());
        noticiaActual.setFecha(noticia.getFecha());
        noticiaActual.setContenido(noticia.getContenido());
        noticiaActual.setProyecto(proyecto);

        return this.miRepositorioNoticia.save(noticiaActual);
    }

    // Eliminar una noticia por su ID
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id_noticias}")
    public void delete(@PathVariable String id_noticias) {
        Noticia noticiaActual = this.miRepositorioNoticia.findById(id_noticias)
                .orElseThrow(() -> new RuntimeException("Noticia no encontrada"));
        this.miRepositorioNoticia.delete(noticiaActual);
    }
}
