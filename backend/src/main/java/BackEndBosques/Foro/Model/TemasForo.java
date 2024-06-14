package BackEndBosques.Foro.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "TemasForo")
public class TemasForo {
    @Id
    private String id_temas;
    private String nombre;
    @DBRef
    private Usuario usuario;

    public TemasForo(){
    }
    public TemasForo( String nombre, Usuario infoUsuario){
        this.nombre= nombre;
        this.usuario=infoUsuario;
    }
    public String getId_temas() {
        return id_temas;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
