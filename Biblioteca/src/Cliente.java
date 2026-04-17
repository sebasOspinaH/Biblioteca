import java.util.ArrayList;

public class Cliente {
    private int id;
    private long telefono;
    private String nombre;
    private String presentalibro;
    private String direccion;
    private ArrayList<String> historialprestamos = new ArrayList<>();
    private double multaPendiente = 0.0;

    public Cliente(int id, long telefono, String presentalibro, String nombre, String dir) {
        this.id = id;
        this.telefono = telefono;
        this.nombre = nombre;
        this.presentalibro = presentalibro;
        this.direccion = dir;
    }

    public int getId() { return id; }
    public long getTelefono() { return telefono; }
    public String getNombre() { return nombre; }
    public String getPresentalibro() { return presentalibro; }
    public String getDireccion() { return direccion; }
    public ArrayList<String> getHistorialPrestamos() { return historialprestamos; }
    public double getMultaPendiente() { return multaPendiente; }

    public void setTelefono(long telefono) { this.telefono = telefono; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPresentalibro(String presentalibro) { this.presentalibro = presentalibro; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public void setMultaPendiente(double multaPendiente) { this.multaPendiente = multaPendiente; }
    public void setHistorialPrestamos(ArrayList<String> h) { this.historialprestamos = h; }

    public void agregarhistorial(String nombrelibro) {
        historialprestamos.add(nombrelibro);
    }

    public void agregarMulta(double valor) {
        this.multaPendiente += valor;
    }
}
