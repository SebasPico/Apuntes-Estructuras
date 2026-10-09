
package ListasEnlazada;

public class PruebaActualizarValor {
    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();

        lista.agregarPrimerNodo(10);
        lista.agregarAlFinal(20);
        lista.agregarAlFinal(30);
        lista.agregarAlFinal(40);

        System.out.print("Estado inicial -> ");
        lista.imprimirLista();

        System.out.println("\n=== Caso 1: Actualizar valor inexistente (99)");
        lista.actualizarValor(99, 777);
        lista.imprimirLista();

        System.out.println("\n=== Caso 2: Actualizar la cabeza (10 -> 15)");
        lista.actualizarValor(10, 15);
        lista.imprimirLista();

        System.out.println("\n=== Caso 3: Actualizar nodo intermedio (20 -> 25)");
        lista.actualizarValor(20, 25);
        lista.imprimirLista();

        System.out.println("\n=== Caso 4: Actualizar la cola (40 -> 45)");
        lista.actualizarValor(40, 45);
        lista.imprimirLista();
    }
}
