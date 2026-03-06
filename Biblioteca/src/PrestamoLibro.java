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
    public boolean generarprestamo(int idcl , String idli){
        Cliente cli = c.buscarCliente(idcl);
        Libro li = l.buscarLibro(idli);
        if(cli!=null && li!=null){
            cli.setPresentalibro("si");
            li.setEstado("prestado");
            return true;
        }
        return false;
    }
    public boolean registrardevoluciones(int idcl, String idli){
        Cliente cli = c.buscarCliente(idcl);
        Libro li = l.buscarLibro(idli);
        if(cli!=null && li!=null){
            cli.setPresentalibro("no");
            li.setEstado("disponible");
            return true;
        }
        return false;
    }
}
