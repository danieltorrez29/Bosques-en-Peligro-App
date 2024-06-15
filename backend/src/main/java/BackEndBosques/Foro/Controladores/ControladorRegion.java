package BackEndBosques.Foro.Controladores;

import BackEndBosques.Foro.Model.Region;
import BackEndBosques.Foro.Repositorios.RepositorioRegion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/region")
public class ControladorRegion {
    @Autowired
    private RepositorioRegion miRepositorioRegion;
    // Obtener todas las regiones
    @GetMapping("")
    public List<Region> index() {
        return this.miRepositorioRegion.findAll();
    }

    // Crear una nueva región
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Region create(@RequestBody Region region) {
        return this.miRepositorioRegion.save(region);
    }

    // Obtener una región por su ID
    @GetMapping("/{id_region}")
    public Region show(@PathVariable String id_region) {
        return this.miRepositorioRegion.findById(id_region)
                .orElseThrow(() -> new RuntimeException("Región no encontrada"));
    }

    // Actualizar una región existente
    @PutMapping("/{id_region}")
    public Region update(@PathVariable String id_region, @RequestBody Region region) {
        Region regionActual = this.miRepositorioRegion.findById(id_region)
                .orElseThrow(() -> new RuntimeException("Región no encontrada"));
        regionActual.setNombre(region.getNombre());
        return this.miRepositorioRegion.save(regionActual);
    }

    // Eliminar una región por su ID
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id_region}")
    public void delete(@PathVariable String id_region) {
        Region regionActual = this.miRepositorioRegion.findById(id_region)
                .orElseThrow(() -> new RuntimeException("Región no encontrada"));
        this.miRepositorioRegion.delete(regionActual);
    }
}
