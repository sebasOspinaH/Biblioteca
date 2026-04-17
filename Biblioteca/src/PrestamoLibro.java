import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class PrestamoLibro {
    private static final double MULTA_POR_DIA = 500.0; // $500 pesos por día de retraso
    private ArrayList<Prestamo> prestamos;

    public PrestamoLibro(ArrayList<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void generarprestamo(Cliente c, Libro l) {
        c.setPresentalibro("si");
        l.setEstado("prestado");
        c.agregarhistorial(l.getNombre());
        l.incrementarContadorPrestamo();

        LocalDate hoy = LocalDate.now();
        LocalDate limite = hoy.plusDays(7);
        Prestamo p = new Prestamo(c.getId(), l.getIdentificador(), hoy, limite);
        prestamos.add(p);

        System.out.println("Fecha de préstamo: " + hoy + " | Fecha límite de devolución: " + limite);
    }

    public void registrardevoluciones(Cliente c, Libro l) {
        c.setPresentalibro("no");
        l.setEstado("disponible");

        // Buscar el préstamo activo
        Prestamo prestamoActivo = null;
        for (Prestamo p : prestamos) {
            if (p.getIdLibro().equalsIgnoreCase(l.getIdentificador())
                    && p.getIdCliente() == c.getId()
                    && !p.isDevuelto()) {
                prestamoActivo = p;
                break;
            }
        }

        if (prestamoActivo != null) {
            prestamoActivo.setDevuelto(true);
            LocalDate hoy = LocalDate.now();
            long diasRetraso = ChronoUnit.DAYS.between(prestamoActivo.getFechaLimite(), hoy);
            if (diasRetraso > 0) {
                double multa = diasRetraso * MULTA_POR_DIA;
                c.agregarMulta(multa);
                System.out.println("⚠ Devolución con retraso de " + diasRetraso + " día(s).");
                System.out.printf("  Multa generada: $%.0f | Total multa acumulada: $%.0f%n",
                        multa, c.getMultaPendiente());
            } else {
                System.out.println("Devolución a tiempo. Sin multa.");
            }
        }

        if (l.tieneReservas()) {
            int siguienteId = l.siguienteReserva();
            System.out.println("📢 El libro \"" + l.getNombre() + "\" está disponible.");
            System.out.println("   Siguiente cliente en lista de espera (ID): " + siguienteId);
        }
    }

    public Prestamo buscarPrestamoActivo(String idLibro) {
        for (Prestamo p : prestamos) {
            if (p.getIdLibro().equalsIgnoreCase(idLibro) && !p.isDevuelto()) {
                return p;
            }
        }
        return null;
    }
}
