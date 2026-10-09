import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();

        try (Scanner scanner = new Scanner(System.in)) {
            int opcion;
            do {
                System.out.println("\n--- Arbol binario de busqueda ---");
                System.out.println("1. Insertar valor");
                System.out.println("2. Buscar valor");
                System.out.println("3. Salir");
                opcion = leerEntero(scanner, "Elige una opcion: ");

                switch (opcion) {
                    case 1:
                        int valorInsertar = leerEntero(scanner, "Valor a insertar: ");
                        arbol.insertar(valorInsertar);
                        System.out.println("Valor insertado.");
                        break;
                    case 2:
                        int valorBuscar = leerEntero(scanner, "Valor a buscar: ");
                        if (arbol.buscar(valorBuscar)) {
                            System.out.println("El valor esta en el arbol.");
                        } else {
                            System.out.println("El valor no esta en el arbol.");
                        }
                        break;
                    case 3:
                        System.out.println("Programa finalizado.");
                        break;
                    default:
                        System.out.println("Opcion no valida.");
                }
            } while (opcion != 3);
        }
    }

    private static int leerEntero(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            }
            System.out.println("Ingresa un numero entero.");
            scanner.next();
        }
    }
}
