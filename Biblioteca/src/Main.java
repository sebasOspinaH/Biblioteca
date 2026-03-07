import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Controlador_cliente con = new Controlador_cliente();
        GestionLibros g = new GestionLibros();
        PrestamoLibro p = new PrestamoLibro();
        int opcion;
        do {
            System.out.println("\n----- MENU -----");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Registrar libro");
            System.out.println("3. Consultar info libro");
            System.out.println("4. Listar libros");
            System.out.println("5. Listar Clientes");
            System.out.println("6. Pedir Libro");
            System.out.println("7. Devolver Libro");
            System.out.println("8. Salir");
            System.out.print("Ingrese la opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese cantidad de clientes a registrar: ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    Cliente[] arr = new Cliente[n];
                    for (int i = 0; i < n; i++) {
                        System.out.println("\nCliente #" + (i+1));

                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();

                        System.out.print("identificacion: ");
                        int id = sc.nextInt();

                        System.out.print("telefono: ");
                        int telefono = sc.nextInt();

                        System.out.print("Direccion: ");
                        String dir = sc.nextLine();

                        String plibro = "No";
                        sc.nextLine();
                        Cliente c = new Cliente(id, telefono, plibro, nombre, dir);
                        boolean r = con.guardarcliente(c);
                        if (r == true) {
                            System.out.println("Cliente exitosamente guardado");
                        } else {
                            System.out.println("Cliente ya existente");
                        }

                    }

                    break;
                case 2:
                    System.out.print("Ingrese cantidad de libros a registrar: ");
                    int a = sc.nextInt();
                    sc.nextLine();
                    for (int i = 0; i < a; i++) {
                        System.out.println("\nlibro #" + (i+1));

                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();

                        System.out.print("identificacion: ");
                        String id = sc.nextLine();

                        System.out.print("autor: ");
                        String au = sc.nextLine();

                        System.out.print("año publicacion: ");
                        int ap = sc.nextInt();

                        System.out.print("editorial: ");
                        String ed = sc.nextLine();

                        String es = "Disponible";
                        sc.nextLine();
                        Libro l = new Libro(au,nombre,ed,ap,es,id);
                        boolean r = g.guardarLibro(l) ;
                        if (r == true) {
                            System.out.println("libro exitosamente guardado");
                        } else {
                            System.out.println("libro ya existente");
                        }
                    }
                    break;
                case 3:
                    System.out.print("Ingrese identificador de libro: ");
                    String id = sc.nextLine();
                    String m = g.mostrarInfo(id);
                    System.out.println(m);
                    break;
                case 4:
                    for(int i = 0; i < g.getLibros().size(); i++){
                        System.out.print(g.mostrarInfo(g.getLibros().get(i).getIdentificador())+"\n");
                        System.out.println("");
                    }
                    break;
                case 5:
                    for(int i = 0; i < con.getClientes().size(); i++){
                        System.out.print(con.mostrarInfo(con.getClientes().get(i).getId())+"\n");
                        System.out.println("");
                    }
                    break;
                case 6:
                    System.out.println("Ingrese el identificador del libro: ");
                    String idli = sc.nextLine();
                    System.out.println("Ingrese el identificador del cliente: ");
                    int idcli = sc.nextInt();
                    Libro lib = g.buscarLibro(idli);
                    Cliente clien = con.buscarCliente(idcli);
                    if(lib != null && clien != null && lib.getEstado().equalsIgnoreCase("disponible")){
                        System.out.println("Libro correctamente prestado");
                        p.generarprestamo(clien,lib);
                    }else{
                        System.out.println("Libro o cliente no encontrado");
                    }
                    break;
                case 7:
                    System.out.println("Ingrese el identificador del libro: ");
                    String idlib = sc.nextLine();
                    System.out.println("Ingrese el identificador del cliente: ");
                    int idclie = sc.nextInt();
                    Libro libro = g.buscarLibro(idlib);
                    Cliente cliente = con.buscarCliente(idclie);
                    if(libro != null && cliente != null && libro.getEstado().equalsIgnoreCase("prestado")){
                        System.out.println("Libro correctamente devuelto");
                        p.registrardevoluciones(cliente,libro);
                    }else{
                        System.out.println("Libro o cliente no encontrado");
                    }
                    break;
                case 8:
                    System.out.println("Saliendo del sistema");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }while (opcion != 8);
        }
    }
