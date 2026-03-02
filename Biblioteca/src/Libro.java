public class Libro {
    private String nombre;
    private String autor;
    private String editorial;
    private String añoP;
    private String estado;
    private String identificador;

    public Libro(String autor, String nombre, String editorial, String añoP, String estado, String identificador) {
        this.autor = autor;
        this.nombre = nombre;
        this.editorial = editorial;
        this.añoP = añoP;
        this.estado = estado;
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getAñoP() {
        return añoP;
    }

    public void setAñoP(String añoP) {
        this.añoP = añoP;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdentificador() {
        return identificador;
    }
}
