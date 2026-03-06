import java.util.ArrayList;

public class PrestamoLibro {
    ArrayList<Cliente> clientes;
    ArrayList<Libro> libros;

    public PrestamoLibro(ArrayList<Cliente> clientes, ArrayList <Libro> libros) {
        this.clientes = clientes;
        this.libros = libros;
    }
    public void generarprestamo(int idcl , String idli){
        for (int i = 0; i< clientes.size(); i++){
            if(clientes.get(i).getId()==idcl){
                clientes.get(i).setPresentalibro("Si");
            }
        }
        for(int l = 0; l<libros.size(); l++){
            if(libros.get(l).getIdentificador().equals(idli)){
                libros.get(l).setEstado("prestado a un cliente");
            }
        }
    }
    public void registrardevoluciones(int idclm, String idliq){
        for (int i = 0; i< clientes.size(); i++){
            if (clientes.get(i).getId()==idclm){
                clientes.get(i).setPresentalibro("No");
            }
        }
        for (int k = 0 ; k< libros.size(); k++){
            if(libros.get(k).getIdentificador().equals(idliq)){
                libros.get(k).setEstado("disponible");
            }
        }
    }
}
