package BackEndBosques.Foro.Controladores;

import BackEndBosques.Foro.Model.Usuario;
import BackEndBosques.Foro.Repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/usuarios")
public class ControladorUsuario {

    private static final Logger logger = LoggerFactory.getLogger(ControladorUsuario.class);

    @Autowired
    private RepositorioUsuario miRepositorioUsuario;

    @GetMapping("")
    public List<Usuario> index() {
        logger.info("GET /usuarios called");
        return this.miRepositorioUsuario.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Usuario create(@RequestBody Usuario infoUsuario) {
        logger.info("POST /usuarios called with data: {}", infoUsuario);
        infoUsuario.setContrasena(convertirSHA256(infoUsuario.getContrasena()));
        return this.miRepositorioUsuario.save(infoUsuario);
    }

    @GetMapping("{id}")
    public Usuario show(@PathVariable String id) {
        logger.info("GET /usuarios/{} called", id);
        return this.miRepositorioUsuario.findById(id).orElse(null);
    }

    @PutMapping("{id}")
    public Usuario update(@PathVariable String id, @RequestBody Usuario infoUsuario) {
        logger.info("PUT /usuarios/{} called with data: {}", id, infoUsuario);
        Optional<Usuario> optionalUsuario = this.miRepositorioUsuario.findById(id);
        if (optionalUsuario.isPresent()) {
            Usuario usuarioActual = optionalUsuario.get();
            usuarioActual.setNombre(infoUsuario.getNombre());
            usuarioActual.setNumero(infoUsuario.getNumero());
            usuarioActual.setCorreo(infoUsuario.getCorreo());
            usuarioActual.setContrasena(convertirSHA256(infoUsuario.getContrasena()));
            return this.miRepositorioUsuario.save(usuarioActual);
        } else {
            throw new RuntimeException("Usuario no encontrado");
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        logger.info("DELETE /usuarios/{} called", id);
        Optional<Usuario> optionalUsuario = this.miRepositorioUsuario.findById(id);
        if (optionalUsuario.isPresent()) {
            this.miRepositorioUsuario.delete(optionalUsuario.get());
        } else {
            throw new RuntimeException("Usuario no encontrado");
        }
    }

    private String convertirSHA256(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            logger.error("Error converting password to SHA-256", e);
            return null;
        }
    }
}

