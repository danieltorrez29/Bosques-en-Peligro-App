package BackEndBosques.Foro.Model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "Superficie")
public class SuperficieDeforestada {
    @Id
    private String id_superficie;
    private String superficie;
    private String ano;
    private Region region;

    public SuperficieDeforestada(String superficie, String ano, Region region) {
        this.superficie = superficie;
        this.ano = ano;
        this.region = region;
    }

    public String getId_superficie() {
        return id_superficie;
    }

    public String getSuperficie() {
        return superficie;
    }

    public void setSuperficie(String superficie) {
        this.superficie = superficie;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
