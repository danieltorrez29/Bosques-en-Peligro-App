package BackEndBosques.Foro.Model;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@NoArgsConstructor
@Document(collection = "Region")
public class Region {
    @Id
    private String id_region;
    private String nombre;

    public Region(String nombre) {
        this.nombre = nombre;
    }

    public String getId_region() {
        return id_region;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
