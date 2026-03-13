import java.util.ArrayList;

public class Controlador_cliente {
  ArrayList  <cliente> clientes;

    public Controlador_cliente(ArrayList<cliente> clientes) {
        this.clientes = clientes;
    }

    public void guardarcliente(cliente cliente){
        clientes.add(cliente);
    }
    public void eliminarcliente(int id){
        for (int i =0; i<clientes.size();i++){
            if (clientes.get(i).getId() == id){
          clientes.remove(i); }
        }
    }
    
}
