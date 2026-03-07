public class Cliente {
    private int id;
    private int  telefono;
    private String nombre;
    private String presentalibro;
    private String direccion;

    public Cliente(int id, int telefono, String presentalibro, String nombre, String dir) {
        this.id = id;
        this.telefono = telefono;
        this.nombre = nombre;
        this.presentalibro = presentalibro;
        this.direccion = dir;
    }

    public int getId() {
        return id;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPresentalibro() {
        return presentalibro;
    }

    public void setTelefono(int telefono) {
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
}
