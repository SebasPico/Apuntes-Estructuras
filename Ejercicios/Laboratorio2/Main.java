package Laboratorio2;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaCompras lista = new ListaCompras();

        cargarListaInicial(lista);

        int opcion = -1;
        while (opcion != 0) {
            mostrarMenu();
            opcion = leerEntero(sc, "Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    agregarArticulo(sc, lista);
                    break;
                case 2:
                    lista.mostrarTodo();
                    break;
                case 3:
                    mostrarPorCategoria(sc, lista);
                    break;
                case 4:
                    buscarCantidad(sc, lista);
                    break;
                case 5:
                    actualizarCantidad(sc, lista);
                    break;
                case 6:
                    eliminarArticulo(sc, lista);
                    break;
                case 0:
                    System.out.println("Saliendo del programa. ¡Buenas compras!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }

        sc.close();
    }

    /**
     * Carga los 10 artículos iniciales indicados en el enunciado.
     */
    private static void cargarListaInicial(ListaCompras lista) {
        lista.agregar("Pan", 2, "Panadería");
        lista.agregar("Huevos", 12, "Lácteos");
        lista.agregar("Tomates", 5, "Verduras");
        lista.agregar("Café", 1, "Bebidas");
        lista.agregar("Papel Higiénico", 1, "Higiene");
        lista.agregar("Detergente", 1, "Limpieza");
        lista.agregar("Queso", 1, "Lácteos");
        lista.agregar("Plátanos", 6, "Frutas");
        lista.agregar("Jabón", 3, "Higiene");
        lista.agregar("Lechuga", 2, "Verduras");
        System.out.println("\nLista inicial cargada con éxito (10 artículos).\n");
    }

    private static void mostrarMenu() {
        System.out.println("\n===== LISTA DE COMPRAS DEL MERCADO =====");
        System.out.println("1. Agregar artículo");
        System.out.println("2. Mostrar toda la lista");
        System.out.println("3. Mostrar artículos por categoría");
        System.out.println("4. Buscar cantidad de un artículo");
        System.out.println("5. Actualizar cantidad (compra parcial)");
        System.out.println("6. Eliminar artículo");
        System.out.println("0. Salir");
        System.out.println("=========================================");
    }

    private static void agregarArticulo(Scanner sc, ListaCompras lista) {
        System.out.print("Nombre del artículo: ");
        String nombre = sc.nextLine().trim();

        int cantidad = leerEntero(sc, "Cantidad requerida: ");

        System.out.print("Categoría: ");
        String categoria = sc.nextLine().trim();

        lista.agregar(nombre, cantidad, categoria);
    }

    private static void mostrarPorCategoria(Scanner sc, ListaCompras lista) {
        System.out.print("Ingrese la categoría a consultar: ");
        String categoria = sc.nextLine().trim();
        lista.mostrarPorCategoria(categoria);
    }

    private static void buscarCantidad(Scanner sc, ListaCompras lista) {
        System.out.print("Nombre del artículo a buscar: ");
        String nombre = sc.nextLine().trim();

        int cantidad = lista.buscarCantidad(nombre);
        if (cantidad == -1) {
            System.out.println("El artículo \"" + nombre + "\" no está en la lista.");
        } else {
            System.out.println("Se necesitan " + cantidad + " unidad(es) de \"" + nombre + "\".");
        }
    }

    private static void actualizarCantidad(Scanner sc, ListaCompras lista) {
        System.out.print("Nombre del artículo comprado: ");
        String nombre = sc.nextLine().trim();

        int cantidadComprada = leerEntero(sc, "Cantidad efectivamente comprada: ");

        boolean actualizado = lista.actualizarCantidad(nombre, cantidadComprada);
        if (!actualizado) {
            System.out.println("El artículo \"" + nombre + "\" no está en la lista.");
        }
    }

    private static void eliminarArticulo(Scanner sc, ListaCompras lista) {
        System.out.print("Nombre del artículo a eliminar: ");
        String nombre = sc.nextLine().trim();

        boolean eliminado = lista.eliminar(nombre);
        if (eliminado) {
            System.out.println("Artículo \"" + nombre + "\" eliminado correctamente.");
        } else {
            System.out.println("El artículo \"" + nombre + "\" no está en la lista.");
        }
    }

    /**
     * Lee un entero de forma segura, repitiendo la solicitud si la entrada no es válida.
     */
    private static int leerEntero(Scanner sc, String mensaje) {
        int valor;
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine().trim();
            try {
                valor = Integer.parseInt(entrada);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingrese un número válido.");
            }
        }
        return valor;
    }
}