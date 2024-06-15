package BackEndBosques.Foro.Controladores;

import BackEndBosques.Foro.Model.Proyecto;
import BackEndBosques.Foro.Model.Region;
import BackEndBosques.Foro.Repositorios.RepositorioProyecto;
import BackEndBosques.Foro.Repositorios.RepositorioRegion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyectos")
public class ControladorProyecto {
    @Autowired
    private RepositorioProyecto miRepositorioProyecto;

    @Autowired
    private RepositorioRegion miRepositorioRegion;

    // Obtener todos los proyectos
    @GetMapping("")
    public List<Proyecto> index() {
        return this.miRepositorioProyecto.findAll();
    }

    // Crear un nuevo proyecto
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Proyecto create(@RequestBody Proyecto proyecto) {
        // Verificar que la región exista
        Region region = this.miRepositorioRegion.findById(proyecto.getRegion().getId_region())
                .orElseThrow(() -> new RuntimeException("Región no encontrada"));
        proyecto.setRegion(region);
        return this.miRepositorioProyecto.save(proyecto);
    }

    // Obtener un proyecto por su ID
    @GetMapping("/{id_proyecto}")
    public Proyecto show(@PathVariable String id_proyecto) {
        return this.miRepositorioProyecto.findById(id_proyecto)
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));
    }

    // Actualizar un proyecto existente
    @PutMapping("/{id_proyecto}")
    public Proyecto update(@PathVariable String id_proyecto, @RequestBody Proyecto proyecto) {
        Proyecto proyectoActual = this.miRepositorioProyecto.findById(id_proyecto)
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));

        Region region = this.miRepositorioRegion.findById(proyecto.getRegion().getId_region())
                .orElseThrow(() -> new RuntimeException("Región no encontrada"));

        proyectoActual.setLink(proyecto.getLink());
        proyectoActual.setRegion(region);

        return this.miRepositorioProyecto.save(proyectoActual);
    }

    // Eliminar un proyecto por su ID
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id_proyecto}")
    public void delete(@PathVariable String id_proyecto) {
        Proyecto proyectoActual = this.miRepositorioProyecto.findById(id_proyecto)
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));
        this.miRepositorioProyecto.delete(proyectoActual);
    }
}
