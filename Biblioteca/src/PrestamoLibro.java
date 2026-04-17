import java.util.ArrayList;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PrestamoLibro {
    GestionLibros l = new GestionLibros();
    Controlador_cliente c = new Controlador_cliente();
    ArrayList<Libro> libros;
    ArrayList<Cliente> clientes;
    private static final double MULTA_POR_DIA = 500.0;
    // Dias maximos para devolver el libro
    private static final int DIAS_PRESTAMO = 7;

    public PrestamoLibro() {
        this.clientes = c.getClientes();
        this.libros = l.getLibros();
    }

    public void generarprestamo(Cliente c, Libro l) {
        c.setPresentalibro("si");
        l.setEstado("prestado");
        c.agregarhistorial(l.getNombre());
        l.incrementarContadorPrestamo();
        // Guardar fecha de prestamo en el libro
        l.setFechaPrestamo(LocalDate.now());
        l.setFechaLimite(LocalDate.now().plusDays(DIAS_PRESTAMO));
        System.out.println("Fecha limite de devolucion: " + l.getFechaLimite());
    }

    public void registrardevoluciones(Cliente c, Libro l) {
        LocalDate hoy = LocalDate.now();
        LocalDate fechaLimite = l.getFechaLimite();

        if (fechaLimite != null && hoy.isAfter(fechaLimite)) {
            long diasRetraso = ChronoUnit.DAYS.between(fechaLimite, hoy);
            double multa = diasRetraso * MULTA_POR_DIA;
            c.agregarMulta(multa);
            System.out.println("Devolucion con retraso de " + diasRetraso + " dia(s).");
            System.out.println("Multa generada: $" + multa);
            System.out.println("Multa total pendiente del cliente: $" + c.getMultaTotal());
        } else {
            System.out.println("Devolucion a tiempo. Sin multa.");
        }

        c.setPresentalibro("no");
        l.setEstado("disponible");
        l.setFechaPrestamo(null);
        l.setFechaLimite(null);
    }
}
