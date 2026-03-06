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
            libros.add(li);
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
}
