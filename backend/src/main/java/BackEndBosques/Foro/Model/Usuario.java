package BackEndBosques.Foro.Model;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "Usuario")
public class Usuario {
    @Id
    private Integer id_usuario;
    private String nombre;
    private String correo;
    private String contrasena;
    public Usuario( String nombre, String correo, String contrasena) {
        this.nombre= nombre;
        this.correo = correo;
        this.contrasena = contrasena;
    }
    public Integer getId() {return id_usuario;}
    public String getNombre(){return nombre;}
    public void setNombre(String nombre) {this.nombre   =nombre;}
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
