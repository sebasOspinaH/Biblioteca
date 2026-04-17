import java.time.LocalDate;

public class Prestamo {
    private int idCliente;
    private String idLibro;
    private LocalDate fechaPrestamo;
    private LocalDate fechaLimite;
    private boolean devuelto;

    public Prestamo(int idCliente, String idLibro, LocalDate fechaPrestamo, LocalDate fechaLimite) {
        this.idCliente = idCliente;
        this.idLibro = idLibro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaLimite = fechaLimite;
        this.devuelto = false;
    }

    public int getIdCliente() { return idCliente; }
    public String getIdLibro() { return idLibro; }
    public LocalDate getFechaPrestamo() { return fechaPrestamo; }
    public LocalDate getFechaLimite() { return fechaLimite; }
    public boolean isDevuelto() { return devuelto; }

    public void setDevuelto(boolean devuelto) { this.devuelto = devuelto; }
    public void setFechaLimite(LocalDate f) { this.fechaLimite = f; }
    public void setFechaPrestamo(LocalDate f) { this.fechaPrestamo = f; }
    public void setIdCliente(int i) { this.idCliente = i; }
    public void setIdLibro(String s) { this.idLibro = s; }
}
