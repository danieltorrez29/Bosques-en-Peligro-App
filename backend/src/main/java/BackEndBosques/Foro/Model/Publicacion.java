package BackEndBosques.Foro.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Date;

public class Publicacion {
    @Id
    private String id_publicacion;
    @DBRef
    private Usuario usuario;
    @DBRef
    private TemasForo tema;
    private String contenido;
    private Date fecha;

    public Publicacion(Usuario usuario, TemasForo tema, String contenido, Date fecha) {
        this.usuario = usuario;
        this.tema = tema;
        this.contenido = contenido;
        this.fecha = fecha;
    }
    public String get_id_publicacion() {
        return id_publicacion;
    }
    public Usuario get_usuario() {
        return usuario;
    }
    public TemasForo get_tema() {
        return tema;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public void setTemas(TemasForo tema) {
        this.tema = tema;
    }

}
