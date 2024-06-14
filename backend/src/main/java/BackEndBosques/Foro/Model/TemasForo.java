package BackEndBosques.Foro.Model;

import org.springframework.data.annotation.Id;

public class TemasForo {
    @Id
    private String id_temas;
    private String nombre;

    public TemasForo(String id_temas, String nombre){
        this.id_temas= id_temas;
        this.nombre= nombre;
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
}
