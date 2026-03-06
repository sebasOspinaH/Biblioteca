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
            System.out.println("2. Mostrar maquinas");
            System.out.println("3. Consultar maquinas");
            System.out.println("4. Modificar nombre, estado, tipo");
            System.out.println("5. Calcular total actividad maquina");
            System.out.println("6. Mostrar Mejor maquina");
            System.out.println("7. Salir");
            System.out.print("Opcion: ");
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

                        Cliente c = new Cliente(id,telefono,pLibro,nombre,direccion);
                        boolean r = con.guardarcliente(c);
                        if(r){
                            System.out.println("Cliente exitosamente guardado");
                        }else{
                            System.out.println("Cliente ya existente");
                        }
                    }
                        sc.nextLine();
                    }
                    break;

            }while (opcion != 7);
        }
    }
