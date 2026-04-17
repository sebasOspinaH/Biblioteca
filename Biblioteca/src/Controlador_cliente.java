import java.util.ArrayList;

public class Controlador_cliente {
    ArrayList<Cliente> clientes;

    public Controlador_cliente(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Cliente> getClientes() { return clientes; }

    public boolean guardarcliente(Cliente cliente) {
        if (buscarCliente(cliente.getId()) == null) {
            clientes.add(cliente);
            return true;
        }
        return false;
    }

    public boolean eliminarcliente(int id) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId() == id) {
                clientes.remove(i);
                return true;
            }
        }
        return false;
    }

    public Cliente buscarCliente(int id) {
        for (Cliente c : clientes) {
            if (c.getId() == id) return c;
        }
        return null;
    }

    public String mostrarInfo(int id) {
        Cliente cli = buscarCliente(id);
        if (cli != null) {
            return "identificador: " + cli.getId() + "\n"
                    + "nombre: " + cli.getNombre() + "\n"
                    + "telefono: " + cli.getTelefono() + "\n"
                    + "direccion: " + cli.getDireccion() + "\n"
                    + "tiene libro?: " + cli.getPresentalibro() + "\n"
                    + "multa pendiente: $" + String.format("%.0f", cli.getMultaPendiente()) + "\n";
        }
        return "cliente no existente";
    }
}
