package Controladores;

import Model.Usuario;
import Repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/usuarios")
public class ControladorUsuario {
    @Autowired
    private RepositorioUsuario miRepositorioUsuario;

    @GetMapping("")
    public List<Usuario> index() {
        return this.miRepositorioUsuario.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Usuario create(@RequestBody Usuario infoUsuario) {
        infoUsuario.setContrasena(convertirSHA256(infoUsuario.getContrasena()));
        return this.miRepositorioUsuario.save(infoUsuario);
    }

    @GetMapping("{id}")
    public Usuario show(@PathVariable String id) {
        return this.miRepositorioUsuario.findById(id).orElse(null);
    }

    @PutMapping("{id}")
    public Usuario update(@PathVariable String id, @RequestBody Usuario infoUsuario) {
        Optional<Usuario> optionalUsuario = this.miRepositorioUsuario.findById(id);
        if (optionalUsuario.isPresent()) {
            Usuario usuarioActual = optionalUsuario.get();
            usuarioActual.setNombre(infoUsuario.getNombre());
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
            e.printStackTrace();
            return null;
        }
    }
}
