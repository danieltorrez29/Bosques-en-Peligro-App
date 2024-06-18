package BackEndBosques.Foro.Controladores;

import BackEndBosques.Foro.Model.RegistroModel;
import BackEndBosques.Foro.Model.Usuario;
import BackEndBosques.Foro.Service.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registro")
public class ControladorRegistro {

    @Autowired
    RegistroService registroService;

    @PostMapping
    public Usuario guardarRegistro(@RequestBody Usuario usuario) {
        return this.registroService.guardarRegistro(usuario);
    }


}
