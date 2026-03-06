import java.util.ArrayList;

public class Controlador_cliente {
  ArrayList  <Cliente> clientes;

    public Controlador_cliente() {
        this.clientes = new ArrayList<>();
    }

    public boolean guardarcliente(Cliente cliente){
        Cliente c = buscarCliente(cliente.getId());
        if(c == null){
            clientes.add(cliente);
            return true;
        }else{
            return false;
        }
    }
    public boolean eliminarcliente(String  id){
        for (int i =0; i<clientes.size();i++){
            if (clientes.get(i).getId().equalsIgnoreCase(id)){
            clientes.remove(i);
            return true;
            }
        }
        return false;
    }

    public Cliente buscarCliente(String id){
        for(int i = 0; i < clientes.size(); i++){
            if(clientes.get(i).getId().equalsIgnoreCase(id)){
                return clientes.get(i);
            }
        }
        return null;
    }
    
}
