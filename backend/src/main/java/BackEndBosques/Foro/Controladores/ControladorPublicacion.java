package BackEndBosques.Foro.Controladores;
import BackEndBosques.Foro.Model.Publicacion;
import BackEndBosques.Foro.Model.Usuario;
import BackEndBosques.Foro.Model.TemasForo;
import BackEndBosques.Foro.Repositorios.RepositorioPublicacion;
import BackEndBosques.Foro.Repositorios.RepositorioTemas;
import BackEndBosques.Foro.Repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
@CrossOrigin
@RestController
@RequestMapping("/publicaciones")
public class ControladorPublicacion {

    @Autowired
    private RepositorioPublicacion miRepositorioPublicacion;

    @Autowired
    private RepositorioUsuario miRepositorioUsuario;

    @Autowired
    private RepositorioTemas miRepositorioTemas;

    @GetMapping("")
    public List<Publicacion> index() {
        return this.miRepositorioPublicacion.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Publicacion create(@RequestBody Map<String, String> body) {
        String idUsuario = body.get("id_usuario");
        String idTema = body.get("id_tema");
        String contenido = body.get("contenido");
        String fechaStr = (String) body.get("fecha");

        if (idUsuario == null || idUsuario.isEmpty()) {
            throw new IllegalArgumentException("El ID del usuario no puede ser nulo o vacío");
        }
        if (idTema == null || idTema.isEmpty()) {
            throw new IllegalArgumentException("El ID del tema no puede ser nulo o vacío");
        }

        Usuario usuario = miRepositorioUsuario.findById(idUsuario).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        TemasForo tema = miRepositorioTemas.findById(idTema).orElseThrow(() -> new RuntimeException("Tema no encontrado"));

        Date fecha;
        try {
            fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaStr);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Fecha en formato incorrecto. Debe ser dd/MM/yyyy");
        }

        Publicacion nuevaPublicacion = new Publicacion(usuario, tema, contenido, fecha);
        return this.miRepositorioPublicacion.save(nuevaPublicacion);
    }

    @GetMapping("{id_publicacion}")
    public Publicacion show(@PathVariable String id_publicacion) {
        return this.miRepositorioPublicacion.findById(id_publicacion).orElseThrow(() -> new RuntimeException("Publicación no encontrada"));
    }

    @PutMapping("{id_publicacion}")
    public Publicacion update(@PathVariable String id_publicacion, @RequestBody Map<String, String> body) {
        Publicacion publicacionActual = this.miRepositorioPublicacion.findById(id_publicacion).orElseThrow(() -> new RuntimeException("Publicación no encontrada"));
        String contenido = body.get("contenido");
        String fechaStr = (String) body.get("fecha");

        if (contenido == null || contenido.isEmpty()) {
            throw new IllegalArgumentException("El contenido no puede ser nulo o vacío");
        }

        publicacionActual.setContenido(contenido);
        if (fechaStr != null && !fechaStr.isEmpty()) {
            try {
                Date fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaStr);
                publicacionActual.setFecha(fecha);
            } catch (ParseException e) {
                throw new IllegalArgumentException("Fecha en formato incorrecto. Debe ser dd/MM/yyyy");
            }
        }
        return this.miRepositorioPublicacion.save(publicacionActual);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id_publicacion}")
    public void delete(@PathVariable String id_publicacion) {
        Publicacion publicacionActual = this.miRepositorioPublicacion.findById(id_publicacion).orElseThrow(() -> new RuntimeException("Publicación no encontrada"));
        this.miRepositorioPublicacion.delete(publicacionActual);
    }
}