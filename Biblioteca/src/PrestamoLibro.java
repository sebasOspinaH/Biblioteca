import java.util.ArrayList;

public class PrestamoLibro {
    GestionLibros l = new GestionLibros();
    Controlador_cliente c = new Controlador_cliente();
    ArrayList<Libro> libros;
    ArrayList<Cliente> clientes;

    public PrestamoLibro() {
        this.clientes = c.getClientes();
        this.libros = l.getLibros();
    }
    public void generarprestamo(Cliente c, Libro l){
        c.setPresentalibro("si");
        l.setEstado("prestado");
    }
    public void registrardevoluciones(Cliente c, Libro l){
        c.setPresentalibro("no");
        l.setEstado("disponible");
    }
}
