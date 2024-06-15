package BackEndBosques.Foro.Model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@Document(collection = "Noticias")
public class Noticia {
    @Id
    private String id_noticia;
    private String titulo;
    private Date fecha;
    private String contenido;
    private Proyecto proyecto;

    public Noticia(String titulo, Date fecha, String contenido, Proyecto proyecto) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.contenido = contenido;
        this.proyecto = proyecto;
    }

    public String getId_noticia() {
        return id_noticia;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }
}
