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
    private String id_usuario;
    private String nombre;
<<<<<<< HEAD
    private String telefono;
    private String correo;
    private String contrasena;

    public Usuario( String nombre, String telefono, String correo, String contrasena) {
        this.nombre= nombre;
        this.telefono = telefono;
=======
    //arreglo usuario
    //
    private String numero;
    private String correo;
    private String contrasena;
    public Usuario( String nombre,String numero, String correo, String contrasena) {
        this.nombre= nombre;
        this.numero=numero;
>>>>>>> 0bb3f7c053d0cfbd1facc6a70eebcd025f90da2b
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public String getId() {return id_usuario;}
    public String getNombre(){return nombre;}

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setNombre(String nombre) {this.nombre   =nombre;}
    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }
//s
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
