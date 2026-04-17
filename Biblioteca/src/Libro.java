import java.time.LocalDate;

public class Libro {
    private String nombre;
    private String autor;
    private String editorial;
    private int anhoP;
    private String estado;
    private String identificador;
    private int contadorPrestamos;
    private LocalDate fechaPrestamo;
    private LocalDate fechaLimite;

    public Libro(String autor, String nombre, String editorial, int anhoP, String estado, String identificador) {
        this.autor = autor;
        this.nombre = nombre;
        this.editorial = editorial;
        this.anhoP = anhoP;
        this.estado = estado;
        this.identificador = identificador;
        this.contadorPrestamos = 0;
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

    public int getAnhoP() {
        return anhoP;
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

    public int getContadorPrestamos(){
        return this.contadorPrestamos;
    }
    public void incrementarContadorPrestamo(){
        this.contadorPrestamos ++;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(LocalDate fechaLimite) {
        this.fechaLimite = fechaLimite;
    }
}
