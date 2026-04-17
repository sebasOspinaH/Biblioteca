import java.util.ArrayList;

public class GestionLibros {
    ArrayList<Libro> libros;

    public GestionLibros(){
        this.libros = new ArrayList<>();
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public boolean guardarLibro(Libro l){
        Libro li = buscarLibro(l.getIdentificador());
        if(li==null){
            libros.add(l);
            return true;
        }
        return false;
    }

    public boolean eliminarLibro(String id){
        for(int i = 0; i < libros.size(); i++){
            if(libros.get(i).getIdentificador().equalsIgnoreCase(id)){
                libros.remove(i);
                return true;
            }
        }
        return false;

    }

    public Libro buscarLibro(String id){
        for(int i = 0; i < libros.size(); i++){
            if(libros.get(i).getIdentificador().equalsIgnoreCase(id)){
                return libros.get(i);
            }
        }
        return null;
    }

    public String mostrarInfo(String id){
        Libro li = buscarLibro(id);
        if(li!= null){
            String m = ("identificador: " + li.getIdentificador() + "\n"+"nombre: "+ li.getNombre() + "\n" + "estado: " + li.getEstado() + "\n" + "editorial: " + li.getEditorial() + "\n" + "año publicacion: " + li.getAnhoP() + "\n" + "autor: " + li.getAutor());
            return m;
        }
        return "libro no existente";
    }
    public void mostrarMasPrestados() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }

        // Encontrar el máximo número de préstamos
        int maxPrestamos = 0;
        for (Libro libro : libros) {
            if (libro.getContadorPrestamos() > maxPrestamos) {
                maxPrestamos = libro.getContadorPrestamos();
            }
        }

        if (maxPrestamos == 0) {
            System.out.println("No hay préstamos registrados aún.");
            return;
        }

        // Mostrar los libros con el máximo de préstamos
        System.out.println("Libro(s) más prestado(s) (" + maxPrestamos + " préstamo(s)):");
        for (Libro libro : libros) {
            if (libro.getContadorPrestamos() == maxPrestamos) {
                System.out.println("- " + libro.getNombre() + " (ID: " + libro.getIdentificador() + ")");
            }
        }
    }
}
