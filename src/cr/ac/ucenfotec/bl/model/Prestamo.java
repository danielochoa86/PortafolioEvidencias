package cr.ac.ucenfotec.bl.model;

public class Prestamo {

    private int id;
    private int usuarioId;
    private int materialId;

    //constructor para crear
    public Prestamo(int usuarioId, int materialId) {
        this.usuarioId = usuarioId;
        this.materialId = materialId;
    }
    //constructor para leer
    public Prestamo(int id, int usuarioId, int materialId) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.materialId = materialId;
    }

    //getters
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public int getUsuarioId() {return usuarioId;}

    //setter
    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    public String toString() {
        return "Prestamo{" +
                "id=" + id +
                ", usuarioId=" + usuarioId +
                ", materialId=" + materialId +
                '}';
    }
}