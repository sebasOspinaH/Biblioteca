import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Libro {
    private String nombre;
    private String autor;
    private String editorial;
    private int anhoP;
    private String estado;
    private String identificador;
    private int contadorPrestamos;
    private Queue<Integer> listaReservas = new LinkedList<>(); // IDs de clientes en lista de espera

    public Libro(String autor, String nombre, String editorial, int anhoP, String estado, String identificador) {
        this.autor = autor;
        this.nombre = nombre;
        this.editorial = editorial;
        this.anhoP = anhoP;
        this.estado = estado;
        this.identificador = identificador;
        this.contadorPrestamos = 0;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
    public String getEditorial() { return editorial; }
    public void setEditorial(String editorial) { this.editorial = editorial; }
    public int getAnhoP() { return anhoP; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public String getIdentificador() { return identificador; }
    public int getContadorPrestamos() { return this.contadorPrestamos; }
    public void setContadorPrestamos(int c) { this.contadorPrestamos = c; }
    public Queue<Integer> getListaReservas() { return listaReservas; }
    public void setListaReservas(Queue<Integer> q) { this.listaReservas = q; }

    public void incrementarContadorPrestamo() {
        this.contadorPrestamos++;
    }

    public void agregarReserva(int idCliente) {
        listaReservas.add(idCliente);
    }

    public Integer siguienteReserva() {
        return listaReservas.poll();
    }

    public boolean tieneReservas() {
        return !listaReservas.isEmpty();
    }
}
