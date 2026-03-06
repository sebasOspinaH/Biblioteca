import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
//        // to see how IntelliJ IDEA suggests fixing it.
//        System.out.printf("Hello and welcome!");
//
//        for (int i = 1; i <= 5; i++) {
//            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//            System.out.println("i = " + i);
// }
        Scanner sc = new Scanner(System.in);

        Controlador_cliente con = new Controlador_cliente();
        int opcion;
        do {
            System.out.println("\n----- MENU -----");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Registrar libro");
            System.out.println("3. Consultar maquinas");
            System.out.println("4. Modificar nombre, estado, tipo");
            System.out.println("5. Calcular total actividad maquina");
            System.out.println("6. Mostrar Mejor maquina");
            System.out.println("7. Salir");
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
                case 3:
                    System.out.print("Ingrese número de maquina: ");
                    int pos = sc.nextInt();
                    sc.nextLine();

                    if (pos >= 0 && pos < n) {

                        System.out.println("Nombre: " + datosTexto.getDatos(pos, 0));
                        System.out.println("Estado: " + datosTexto.getDatos(pos, 1));
                        System.out.println("Tipo de Juego: " + datosTexto.getDatos(pos, 2));
                        System.out.println("Creditos: " + datosNumericos.getDatos(pos, 0));
                        System.out.println("Jugadores: " + datosNumericos.getDatos(pos, 1));
                        System.out.println("Dinero Recaudado: " + datosNumericos.getDatos(pos, 2));

                    } else {
                        System.out.println("Maquina no encontrada.");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese número de maquina: ");
                    int m = sc.nextInt();
                    sc.nextLine();

                    if (m >= 0 && m < n) {

                        System.out.println("1. Cambiar nombre");
                        System.out.println("2. Cambiar estado");
                        System.out.println("1. Cambiar tipo de juego");
                        int op = sc.nextInt();
                        sc.nextLine();

                        if (op == 1) {
                            System.out.print("Nuevo nombre: ");
                            datosTexto.setDatos(m, op -1, sc.nextLine());
                        } else if (op == 2) {
                            System.out.print("Nuevo estado: ");
                            datosTexto.setDatos(m, op -1, sc.nextLine());
                        }else if(op == 3){
                            System.out.println("Nuevo Tipo de juego");
                            datosTexto.setDatos(m, op -1, sc.nextLine());
                        }

                    } else {
                        System.out.println("Maquina no encontrada.");
                    }
                    break;
                case 5:
                    System.out.print("Ingrese número de maquina: ");
                    int num = sc.nextInt();
                    sc.nextLine();

                    double total = 0;
                    for (int i = 0; i < datosNumericos.getColumnas(); i++) {
                        total += datosNumericos.getDatos(num, i);
                    }
                    System.out.println("Total maquina: " + total);
                    break;

//                    case 6:
//                    int[] b = new int[];
//                    for(int i = 0; i < datosNumericos.getFilas(); i++)
//                    int mayor = datosNumericos.getDatos(0, 3);
//                    int indiceMayor = 0;
//
//                    for (int i = 1; i < n; i++) {
//                        if (datosNumericos.get(i, 2) > mayor) {
//                            mayor = datosNumericos.get(i, 2);
//                            indiceMayor = i;
//                        }
//                    }
//
//                    System.out.println("\nMoto más costosa:");
//                    System.out.println("Marca: " + datosTexto.get(indiceMayor, 0));
//                    System.out.println("Modelo: " + datosTexto.get(indiceMayor, 1));
//                    System.out.println("Precio: " + mayor);
//                    break;
//
//                case 7:
//                    System.out.println("Saliendo del sistema...");
//                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }while (opcion != 7);
        }
    }
