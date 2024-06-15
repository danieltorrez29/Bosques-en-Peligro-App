package BackEndBosques.Foro.Controladores;

import BackEndBosques.Foro.Model.Region;
import BackEndBosques.Foro.Model.SuperficieDeforestada;
import BackEndBosques.Foro.Repositorios.RepositorioRegion;
import BackEndBosques.Foro.Repositorios.RepositorioSuperficie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/superficie")
public class ControladorSuperficie {
    @Autowired
    private RepositorioSuperficie miRepositorioSuperficie;

    @Autowired
    private RepositorioRegion miRepositorioRegion;

    // Obtener todas las superficies deforestadas
    @GetMapping("")
    public List<SuperficieDeforestada> index() {
        return this.miRepositorioSuperficie.findAll();
    }

    // Crear una nueva superficie deforestada
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public SuperficieDeforestada create(@RequestBody SuperficieDeforestada superficieDeforestada) {
        // Verificar que la región exista
        Region region = this.miRepositorioRegion.findById(superficieDeforestada.getRegion().getId_region())
                .orElseThrow(() -> new RuntimeException("Región no encontrada"));
        superficieDeforestada.setRegion(region);
        return this.miRepositorioSuperficie.save(superficieDeforestada);
    }

    // Obtener una superficie deforestada por su ID
    @GetMapping("/{id_superficie}")
    public SuperficieDeforestada show(@PathVariable String id_superficie) {
        return this.miRepositorioSuperficie.findById(id_superficie)
                .orElseThrow(() -> new RuntimeException("Superficie deforestada no encontrada"));
    }

    // Actualizar una superficie deforestada existente
    @PutMapping("/{id_superficie}")
    public SuperficieDeforestada update(@PathVariable String id_superficie, @RequestBody SuperficieDeforestada superficieDeforestada) {
        SuperficieDeforestada superficieActual = this.miRepositorioSuperficie.findById(id_superficie)
                .orElseThrow(() -> new RuntimeException("Superficie deforestada no encontrada"));

        Region region = this.miRepositorioRegion.findById(superficieDeforestada.getRegion().getId_region())
                .orElseThrow(() -> new RuntimeException("Región no encontrada"));

        superficieActual.setSuperficie(superficieDeforestada.getSuperficie());
        superficieActual.setAno(superficieDeforestada.getAno());
        superficieActual.setRegion(region);

        return this.miRepositorioSuperficie.save(superficieActual);
    }

    // Eliminar una superficie deforestada por su ID
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id_superficie}")
    public void delete(@PathVariable String id_superficie) {
        SuperficieDeforestada superficieActual = this.miRepositorioSuperficie.findById(id_superficie)
                .orElseThrow(() -> new RuntimeException("Superficie deforestada no encontrada"));
        this.miRepositorioSuperficie.delete(superficieActual);
    }
}
