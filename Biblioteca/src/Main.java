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
                    for (int i = 0; i < n; i++) {
                        System.out.println("\nCliente #" + i);

                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();

                        System.out.print("identificacion: ");
                        int id = sc.nextInt();

                        System.out.print("telefono: ");
                        int telefono = sc.nextInt();

                        System.out.print("direccion: ");
                        String direccion = sc.nextLine();

                        System.out.print("presenta libro: ");
                        String pLibro = sc.nextLine();

                        Cliente c = new Cliente(id, telefono, pLibro, nombre, direccion);
                        boolean r = con.guardarcliente(c);
                        if (r) {
                            System.out.println("Cliente exitosamente guardado");
                        } else {
                            System.out.println("Cliente ya existente");
                        }
                    }
                    sc.nextLine();
                    break;
                case 2:
                    System.out.print("Ingrese cantidad de libros a registrar: ");
                    int a = sc.nextInt();
                    sc.nextLine();
                    for (int i = 0; i < a; i++) {
                        System.out.println("\nlibro #" + i);

                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();

                        System.out.print("identificacion: ");
                        String id = sc.nextLine();

                        System.out.print("autor: ");
                        String au = sc.nextLine();

                        System.out.print("año publicacion: ");
                        String ap = sc.nextLine();

                        System.out.print("editorial: ");
                        String ed = sc.nextLine();

                        System.out.println("estado: ");
                        String es = sc.nextLine();

                        Libro l = new Libro(au,nombre,ed,ap,es,id);
                        boolean r = g.guardarLibro(l) ;
                        if (r) {
                            System.out.println("libro exitosamente guardado");
                        } else {
                            System.out.println("libro ya existente");
                        }
                    }
                    sc.nextLine();
                    break;
                case 3:
                    System.out.print("Ingrese identificador de libro: ");
                    String id = sc.nextLine();
                    sc.nextLine();

                    Libro l = g.buscarLibro(id);
                    if(l!=null){
                        l.mostrarInfo();
                    }else{
                        System.out.println("libro no encontrado");
                    }
                    sc.nextLine();
                    break;
                case 4:
                    for(int i = 0; i < g.getLibros().size(); i++){
                        System.out.println(g.getLibros().get(i).getNombre());
                    }
                    sc.nextLine();
                    break;
                case 5:
                    for(int i = 0; i < con.getClientes().size(); i++){
                        System.out.println(con.getClientes().get(i).getNombre());
                    }
                    sc.nextLine();
                    break;
                case 6:
                    System.out.println("Ingrese el identificador del libro: ");
                    String idli = sc.nextLine();
                    System.out.println("Ingrese el identificador del cliente: ");
                    int idcli = sc.nextInt();
                    boolean r = p.generarprestamo(idcli,idli);
                    if(r){
                        System.out.println("Libro correctamente prestado");
                    }else{
                        System.out.println("Libro o cliente no encontrado");
                    }
                    sc.nextLine();
                    break;
                case 7:
                    System.out.println("Ingrese el identificador del libro: ");
                    String idlib = sc.nextLine();
                    System.out.println("Ingrese el identificador del cliente: ");
                    int idclie = sc.nextInt();
                    boolean re = p.registrardevoluciones(idclie,idlib);
                    if(re){
                        System.out.println("Libro correctamente devuelto");
                    }else{
                        System.out.println("Libro o cliente no encontrado");
                    }
                    sc.nextLine();
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }while (opcion != 8);
        }
    }
