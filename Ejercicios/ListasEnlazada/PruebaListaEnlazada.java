
package ListasEnlazada;

public class PruebaListaEnlazada {
    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();
 
        // Prueba 1: Agregar primer nodo
        System.out.println("Añadir al principio");
        lista.agregarPrimerNodo(10);
        lista.imprimirLista();

        // Prueba 2: Agregar al final
        System.out.println("\nAñadir al final");
        lista.agregarAlFinal(20);
        lista.imprimirLista();

        // Prueba 3: Agregar al final otra vez
        System.out.println("\nAñadir al final");   
        lista.agregarAlFinal(30);
        lista.imprimirLista();

        System.out.println("\nAñadir al principio");
        lista.agregarAlPrincipio(5);
        lista.imprimirLista();

        // Prueba 4: Agregar en posición 1
        System.out.println("\nAñadir en la posición 1");
        lista.agregarEnPosicion(15, 1);
        lista.imprimirLista();

        //Prueba 5: Buscar un dato de la lista
        
       /* Nodo encontrado = lista.buscarDato(0);
        System.out.println("\nDato encontrado: " + encontrado.getDato());*/

        //Prueba 6: Eliminar un nodo de la lista
        lista.EliminarValor(15);
        lista.imprimirLista();
        
        //Prueba 7: Actualizar un nodo de la lista
        lista.actualizarValor(30, 40);
        lista.imprimirLista();

    }
}

