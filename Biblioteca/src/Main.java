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
        int opcion;
        do{
            System.out.println("\n----- MENU -----");
            System.out.println("1. Registrar libro");
            System.out.println("2. Mostrar ");
            System.out.println("3. Consultar maquinas");
            System.out.println("4. Modificar nombre, estado, tipo");
            Scanner op = new Scanner("Ingrese la opcion: ");
            opcion = op.nextInt();
            op.nextLine();
            switch(opcion){
                case 1:
                    Scanner sc = new Scanner("Ingrese la cantidad de libros a guardar: ");
                    int n = sc.nextInt();
                    for(int i = 0; i < n; i++){
                        System.out.println("Ingrese el indicador del libro: ");
                        int indicador = sc.nextInt();
                        System.out.println("Ingrese el nombre del libro: ");
                        String nombre = sc.nextLine();
                        System.out.println("Ingrese el nombre del libro: ");
                        String autor = sc.nextLine();
                        System.out.println("Ingrese el nombre del libro: ");
                        String editorial = sc.nextLine();
                        System.out.println("Ingrese el nombre del libro: ");
                        String anhoP = sc.nextLine();
                    }
            }
        }while(opcion != 100);
   }
}