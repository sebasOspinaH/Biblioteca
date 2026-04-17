import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Cliente> clientes   = Persistencia.cargarClientes();
        ArrayList<Libro>   libros     = Persistencia.cargarLibros();
        ArrayList<Prestamo> prestamos = Persistencia.cargarPrestamos();

        Controlador_cliente con = new Controlador_cliente(clientes);
        GestionLibros g         = new GestionLibros(libros);
        PrestamoLibro p         = new PrestamoLibro(prestamos);

        int opcion;
        do {
            System.out.println("\n----- MENU -----");
            System.out.println("1.  Registrar cliente");
            System.out.println("2.  Registrar libro");
            System.out.println("3.  Consultar info libro");
            System.out.println("4.  Listar libros");
            System.out.println("5.  Listar clientes");
            System.out.println("6.  Pedir libro");
            System.out.println("7.  Devolver libro");
            System.out.println("8.  Consultar historial cliente");
            System.out.println("9.  Consultar libros más prestados");
            System.out.println("10. Consultar multas de un cliente");
            System.out.println("11. Reservar libro");
            System.out.println("12. Consultar reservas de un libro");
            System.out.println("13. Salir");
            System.out.print("Ingrese la opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese cantidad de clientes a registrar: ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    for (int i = 0; i < n; i++) {
                        System.out.println("\nCliente #" + (i + 1));
                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();
                        System.out.print("Identificacion: ");
                        int id = sc.nextInt();
                        System.out.print("Telefono: ");
                        long telefono = sc.nextLong();
                        sc.nextLine();
                        System.out.print("Direccion: ");
                        String dir = sc.nextLine();
                        Cliente c = new Cliente(id, telefono, "No", nombre, dir);
                        boolean r = con.guardarcliente(c);
                        System.out.println(r ? "Cliente exitosamente guardado" : "Cliente ya existente");
                    }
                    Persistencia.guardarClientes(con.getClientes());
                    break;

                case 2:
                    System.out.print("Ingrese cantidad de libros a registrar: ");
                    int a = sc.nextInt();
                    sc.nextLine();
                    for (int i = 0; i < a; i++) {
                        System.out.println("\nLibro #" + (i + 1));
                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();
                        System.out.print("Identificacion: ");
                        String idl = sc.nextLine();
                        System.out.print("Autor: ");
                        String au = sc.nextLine();
                        System.out.print("Año publicacion: ");
                        int ap = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Editorial: ");
                        String ed = sc.nextLine();
                        Libro l = new Libro(au, nombre, ed, ap, "Disponible", idl);
                        boolean r = g.guardarLibro(l);
                        System.out.println(r ? "Libro exitosamente guardado" : "Libro ya existente");
                    }
                    Persistencia.guardarLibros(g.getLibros());
                    break;

                case 3:
                    System.out.print("Ingrese identificador de libro: ");
                    String id3 = sc.nextLine();
                    System.out.println(g.mostrarInfo(id3));
                    break;

                case 4:
                    if (g.getLibros().isEmpty()) { System.out.println("No hay libros registrados."); break; }
                    for (Libro l : g.getLibros()) System.out.println(g.mostrarInfo(l.getIdentificador()) + "\n");
                    break;

                case 5:
                    if (con.getClientes().isEmpty()) { System.out.println("No hay clientes registrados."); break; }
                    for (Cliente c : con.getClientes()) System.out.println(con.mostrarInfo(c.getId()) + "\n");
                    break;

                case 6:
                    System.out.print("Ingrese el identificador del libro: ");
                    String idli = sc.nextLine();
                    System.out.print("Ingrese el identificador del cliente: ");
                    int idcli = sc.nextInt();
                    sc.nextLine();
                    Libro lib = g.buscarLibro(idli);
                    Cliente clien = con.buscarCliente(idcli);
                    if (lib != null && clien != null) {
                        if (lib.getEstado().equalsIgnoreCase("disponible")) {
                            p.generarprestamo(clien, lib);
                            System.out.println("Libro correctamente prestado");
                            Persistencia.guardarLibros(g.getLibros());
                            Persistencia.guardarClientes(con.getClientes());
                            Persistencia.guardarPrestamos(p.getPrestamos());
                        } else {
                            System.out.println("El libro no está disponible actualmente.");
                        }
                    } else {
                        System.out.println("Libro o cliente no encontrado");
                    }
                    break;

                case 7:
                    System.out.print("Ingrese el identificador del libro: ");
                    String idlib = sc.nextLine();
                    System.out.print("Ingrese el identificador del cliente: ");
                    int idclie = sc.nextInt();
                    sc.nextLine();
                    Libro libro = g.buscarLibro(idlib);
                    Cliente cliente = con.buscarCliente(idclie);
                    if (libro != null && cliente != null && libro.getEstado().equalsIgnoreCase("prestado")) {
                        p.registrardevoluciones(cliente, libro);
                        System.out.println("Libro correctamente devuelto");
                        Persistencia.guardarLibros(g.getLibros());
                        Persistencia.guardarClientes(con.getClientes());
                        Persistencia.guardarPrestamos(p.getPrestamos());
                    } else {
                        System.out.println("Libro o cliente no encontrado, o el libro no está prestado");
                    }
                    break;

                case 8:
                    System.out.print("Ingrese el id del cliente: ");
                    int idHist = sc.nextInt();
                    sc.nextLine();
                    Cliente cHist = con.buscarCliente(idHist);
                    if (cHist != null) {
                        if (cHist.getHistorialPrestamos().isEmpty()) {
                            System.out.println("El cliente no tiene historial");
                        } else {
                            System.out.println("Historial de préstamos:");
                            for (String nombreLib : cHist.getHistorialPrestamos())
                                System.out.println("  - " + nombreLib);
                        }
                    } else { System.out.println("Cliente no encontrado"); }
                    break;

                case 9:
                    g.mostrarMasPrestados();
                    break;

                case 10:
                    System.out.print("Ingrese el id del cliente: ");
                    int idMulta = sc.nextInt();
                    sc.nextLine();
                    Cliente cMulta = con.buscarCliente(idMulta);
                    if (cMulta != null) {
                        System.out.printf("Cliente: %s%n", cMulta.getNombre());
                        System.out.printf("Multa pendiente: $%.0f%n", cMulta.getMultaPendiente());
                    } else { System.out.println("Cliente no encontrado"); }
                    break;

                case 11:
                    System.out.print("Ingrese el identificador del libro a reservar: ");
                    String idRes = sc.nextLine();
                    System.out.print("Ingrese el id del cliente que reserva: ");
                    int idCliRes = sc.nextInt();
                    sc.nextLine();
                    Libro libroRes = g.buscarLibro(idRes);
                    Cliente cliRes  = con.buscarCliente(idCliRes);
                    if (libroRes == null || cliRes == null) {
                        System.out.println("Libro o cliente no encontrado");
                    } else if (libroRes.getEstado().equalsIgnoreCase("disponible")) {
                        System.out.println("El libro está disponible. No es necesario reservar, puedes pedirlo directamente.");
                    } else {
                        libroRes.agregarReserva(idCliRes);
                        System.out.println("Reserva registrada. " + cliRes.getNombre()
                                + " está en la posición " + libroRes.getListaReservas().size()
                                + " de la lista de espera para \"" + libroRes.getNombre() + "\".");
                        Persistencia.guardarLibros(g.getLibros());
                    }
                    break;

                case 12:
                    System.out.print("Ingrese el identificador del libro: ");
                    String idConsRes = sc.nextLine();
                    Libro libroConsRes = g.buscarLibro(idConsRes);
                    if (libroConsRes == null) {
                        System.out.println("Libro no encontrado");
                    } else if (!libroConsRes.tieneReservas()) {
                        System.out.println("El libro \"" + libroConsRes.getNombre() + "\" no tiene reservas pendientes.");
                    } else {
                        System.out.println("Lista de reservas para \"" + libroConsRes.getNombre() + "\":");
                        int pos = 1;
                        for (int idC : libroConsRes.getListaReservas()) {
                            Cliente rc = con.buscarCliente(idC);
                            String nombreC = (rc != null) ? rc.getNombre() : "ID " + idC;
                            System.out.println("  " + pos++ + ". " + nombreC);
                        }
                    }
                    break;

                case 13:
                    System.out.println("Guardando datos y saliendo del sistema...");
                    Persistencia.guardarClientes(con.getClientes());
                    Persistencia.guardarLibros(g.getLibros());
                    Persistencia.guardarPrestamos(p.getPrestamos());
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 13);
    }
}
