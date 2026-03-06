import java.util.ArrayList;

public class Controlador_cliente {
  ArrayList  <Cliente> clientes;

    public Controlador_cliente() {
        this.clientes = new ArrayList<>();
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
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
    public boolean eliminarcliente(int id){
        for (int i =0; i<clientes.size();i++){
            if (clientes.get(i).getId()==id){
            clientes.remove(i);
            return true;
            }
        }
        return false;
    }

    public Cliente buscarCliente(int id){
        for(int i = 0; i < clientes.size(); i++){
            if(clientes.get(i).getId()==id){
                return clientes.get(i);
            }
        }
        return null;
    }
    
}
