package BackEndBosques.Foro.Model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "Proyecto")
public class Proyecto {
    @Id
    private String id_proyecto;
    private String link;
    @DBRef
    private Region region;

    public Proyecto(String link, Region region) {
        this.link = link;
        this.region = region;
    }

    public String getId_proyecto() {
        return id_proyecto;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
