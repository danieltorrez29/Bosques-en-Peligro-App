package BackEndBosques.Foro.Controladores;
import BackEndBosques.Foro.Model.Publicacion;
import BackEndBosques.Foro.Model.RespuestasForo;
import BackEndBosques.Foro.Repositorios.RepositorioPublicacion;
import BackEndBosques.Foro.Repositorios.RepositorioRespuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/respuestas")
public class ControladorRespuestasForo {

    @Autowired
    private RepositorioRespuesta miRepositorioRespuestasForo;

    @Autowired
    private RepositorioPublicacion miRepositorioPublicacion;

    @GetMapping("")
    public List<RespuestasForo> index() {
        return this.miRepositorioRespuestasForo.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public RespuestasForo create(@RequestBody Map<String, Object> body) {
        String idPublicacion = (String) body.get("id_publicacion");
        String contenido = (String) body.get("contenido");
        String fechaStr = (String) body.get("fecha");

        if (idPublicacion == null || idPublicacion.isEmpty()) {
            throw new IllegalArgumentException("El ID de la publicación no puede ser nulo o vacío");
        }
        if (contenido == null || contenido.isEmpty()) {
            throw new IllegalArgumentException("El contenido no puede ser nulo o vacío");
        }

        Publicacion publicacion = miRepositorioPublicacion.findById(idPublicacion).orElseThrow(() -> new RuntimeException("Publicación no encontrada"));

        Date fecha = null;
        if (fechaStr != null && !fechaStr.isEmpty()) {
            try {
                fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaStr);
            } catch (ParseException e) {
                throw new IllegalArgumentException("Fecha en formato incorrecto. Debe ser dd/MM/yyyy");
            }
        }

        RespuestasForo nuevaRespuesta = new RespuestasForo(publicacion, contenido, fecha);
        return this.miRepositorioRespuestasForo.save(nuevaRespuesta);
    }

    @GetMapping("{id_respuesta}")
    public RespuestasForo show(@PathVariable String id_respuesta) {
        return this.miRepositorioRespuestasForo.findById(id_respuesta).orElseThrow(() -> new RuntimeException("Respuesta no encontrada"));
    }

    @PutMapping("{id_respuesta}")
    public RespuestasForo update(@PathVariable String id_respuesta, @RequestBody Map<String, Object> body) {
        RespuestasForo respuestaActual = this.miRepositorioRespuestasForo.findById(id_respuesta).orElseThrow(() -> new RuntimeException("Respuesta no encontrada"));
        String contenido = (String) body.get("contenido");
        String fechaStr = (String) body.get("fecha");

        if (contenido == null || contenido.isEmpty()) {
            throw new IllegalArgumentException("El contenido no puede ser nulo o vacío");
        }

        respuestaActual.setContenido(contenido);

        if (fechaStr != null && !fechaStr.isEmpty()) {
            try {
                Date fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaStr);
                respuestaActual.setFecha(fecha);
            } catch (ParseException e) {
                throw new IllegalArgumentException("Fecha en formato incorrecto. Debe ser dd/MM/yyyy");
            }
        }

        return this.miRepositorioRespuestasForo.save(respuestaActual);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id_respuesta}")
    public void delete(@PathVariable String id_respuesta) {
        RespuestasForo respuestaActual = this.miRepositorioRespuestasForo.findById(id_respuesta).orElseThrow(() -> new RuntimeException("Respuesta no encontrada"));
        this.miRepositorioRespuestasForo.delete(respuestaActual);
    }
}
