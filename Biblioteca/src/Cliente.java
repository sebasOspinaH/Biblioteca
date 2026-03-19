import java.util.ArrayList;
public class Cliente {
    private int id;
    private long  telefono;
    private String nombre;
    private String presentalibro;
    private String direccion;
    private ArrayList<String> historialprestamos= new ArrayList<>();

    public Cliente(int id, long telefono, String presentalibro, String nombre, String dir) {
        this.id = id;
        this.telefono = telefono;
        this.nombre = nombre;
        this.presentalibro = presentalibro;
        this.direccion = dir;
    }

    public int getId() {
        return id;
    }

    public long getTelefono() {
        return telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPresentalibro() {
        return presentalibro;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPresentalibro(String presentalibro) {
        this.presentalibro = presentalibro;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void agregarhistorial(String nombrelibro){
	    historialprestamos.add(nombrelibro);
}
    public ArrayList<String> getHistorialPrestamos(){
	    return historialprestamos;
}
}
