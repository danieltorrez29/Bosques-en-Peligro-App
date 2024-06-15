package BackEndBosques.Foro.Model;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@Document(collection = "RespuestasForo")
public class RespuestasForo {
    @Id
    private String id_respuesta;
    @DBRef
    private Publicacion publicacion;
    private String contenido;
    private Date fecha;

    public RespuestasForo(Publicacion publicacion, String contenido, Date fecha) {
        this.publicacion = publicacion;
        this.contenido = contenido;
        this.fecha = fecha;
    }

    public String getId_respuesta() {
        return id_respuesta;
    }
    public String getContenido() {
        return contenido;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
