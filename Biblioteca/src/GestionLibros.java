import java.util.ArrayList;

public class GestionLibros {
    ArrayList<Libro> libros;

    public GestionLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    public ArrayList<Libro> getLibros() { return libros; }

    public boolean guardarLibro(Libro l) {
        if (buscarLibro(l.getIdentificador()) == null) {
            libros.add(l);
            return true;
        }
        return false;
    }

    public boolean eliminarLibro(String id) {
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getIdentificador().equalsIgnoreCase(id)) {
                libros.remove(i);
                return true;
            }
        }
        return false;
    }

    public Libro buscarLibro(String id) {
        for (Libro l : libros) {
            if (l.getIdentificador().equalsIgnoreCase(id)) return l;
        }
        return null;
    }

    public String mostrarInfo(String id) {
        Libro li = buscarLibro(id);
        if (li != null) {
            return "identificador: " + li.getIdentificador() + "\n"
                    + "nombre: " + li.getNombre() + "\n"
                    + "estado: " + li.getEstado() + "\n"
                    + "editorial: " + li.getEditorial() + "\n"
                    + "año publicacion: " + li.getAnhoP() + "\n"
                    + "autor: " + li.getAutor() + "\n"
                    + "reservas en espera: " + li.getListaReservas().size();
        }
        return "libro no existente";
    }

    public void mostrarMasPrestados() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados en el sistema.");
            return;
        }
        ArrayList<Libro> ordenados = new ArrayList<>(libros);
        for (int i = 0; i < ordenados.size() - 1; i++) {
            for (int j = 0; j < ordenados.size() - 1 - i; j++) {
                if (ordenados.get(j).getContadorPrestamos() < ordenados.get(j + 1).getContadorPrestamos()) {
                    Libro temp = ordenados.get(j);
                    ordenados.set(j, ordenados.get(j + 1));
                    ordenados.set(j + 1, temp);
                }
            }
        }
        int cantidad = Math.min(3, ordenados.size());
        System.out.println("\n----- LIBROS MÁS PRESTADOS -----");
        for (int i = 0; i < cantidad; i++) {
            Libro l = ordenados.get(i);
            System.out.println((i + 1) + ". " + l.getNombre()
                    + " (ID: " + l.getIdentificador() + ")"
                    + " | Autor: " + l.getAutor()
                    + " | Préstamos: " + l.getContadorPrestamos());
        }
        System.out.println("--------------------------------");
    }
}
