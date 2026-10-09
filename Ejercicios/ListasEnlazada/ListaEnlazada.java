
package ListasEnlazada;

public class ListaEnlazada {

    private Nodo head;

    public Nodo getHead() {
        return head;
    }

    public void setHead(Nodo head) {
        this.head = head;
    }

    // Método 1: Agregar primer nodo (cuando la lista está vacía)
    public void agregarPrimerNodo(int dato) {
        if (head == null) {
            head = new Nodo(dato);
        } else {
            System.out.println("La lista ya tiene nodos. Use otro método.");
        }
    }

    // Método 2: Añadir al final (cola)
    public void agregarAlFinal(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        
        if (head == null) {
            head = nuevoNodo;
            return;
        }
        Nodo actual = head;
        while (actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }
        actual.setSiguiente(nuevoNodo);
    }

    // Método 3: Añadir en una posición específica
    public void agregarEnPosicion(int dato, int posicion) {
        if (posicion < 0) {
            System.out.println("Posición inválida.");
            return;
        }

        if (posicion == 0) {
            Nodo nuevoNodo = new Nodo(dato);
            nuevoNodo.setSiguiente(head);
            head = nuevoNodo;
            return;
        }

        Nodo nuevoNodo = new Nodo(dato);
        Nodo actual = head;
        int contador = 0;

        while (actual != null && contador < posicion - 1) {
            actual = actual.getSiguiente();
            contador++;
        }

        if (actual == null) {
            System.out.println("Posición fuera de rango.");
        } else {
            nuevoNodo.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(nuevoNodo);
        }
    }

    //Método 4: Agregar al inicio de la lista
    public void agregarAlPrincipio(int dato){
        Nodo nuevoNodo = new Nodo(dato);
        nuevoNodo.setSiguiente(head);
        head = nuevoNodo;
    }

    //Método 5: Buscar un dato de la lista
    public Nodo buscarDato(int dato){
        Nodo actual = head;
        while(actual != null){
            if(actual.getDato() == dato){
                return actual;
            }
            actual = actual.getSiguiente();
        }
        System.out.println("El valor " + dato + " no existe en la lista.");
        return null;
    }

    //Método 6: Eliminar un nodo de la lista (usando solo buscarDato)
    public void EliminarValor(int dato){
        // Se busca con el metofo buscar el dato a eliminar
        Nodo objetivo = buscarDato(dato);

        // Si devuelve null, significa que el valor NO está en la lista, por lo tanto no nada que eliminar
        if (objetivo == null) {
            System.out.println("No se puede eliminar el valor " + dato + " porque no existe en la lista.");
            return;
        }

        // CASO ESPECIAL 1 — el nodo a eliminar es la CABEZA de la lista
        if (objetivo == head) {
            // Movemos la cabeza al segundo nodo de la lista 
            head = head.getSiguiente();
            // El valor que eliminamos dejamos su señalizador en nulls
            objetivo.setSiguiente(null);
            System.out.println("\nSe eliminó el valor " + dato + " (era la cabeza).");
            return;
        }

        // CASO ESPECIAL 2 — el nodo a eliminar es la COLA 
        // Como no hay un nodo DESPUÉS para "intercambiar datos", tenemos que encontrar
        // el nodo anterior a la cola para cortar el enlace
        if (objetivo.getSiguiente() == null) {
            // Empezamos desde la cabeza
            Nodo actual = head;
            // Avanzamos hasta que el SIGUIENTE de "actual" sea el objetivo o sea, el penúltimo
            while (actual.getSiguiente() != objetivo) {
                actual = actual.getSiguiente();
            }
            // Hacemos que este penúltimo nodo apunte a null, eliminando la cola de la lista
            actual.setSiguiente(null);
            System.out.println("\nSe eliminó el valor " + dato + " (era la cola).");
            return;
        }

        // CASO GENERAL — el nodo a eliminar está EN MEDIO de la lista
        // Truco del "cambio de datos":
        //  - Copiamos el dato del nodo SIGUIENTE dentro del nodo objetivo
        //  - Luego hacemos que el objetivo apunte al siguiente del siguiente
        //  - Con esto, en realidad borramos el nodo siguiente, pero su dato quedó en el objetivo
        Nodo siguiente = objetivo.getSiguiente();
        // Copiamos el dato del nodo siguiente dentro del objetivo (ahora ambos tienen el mismo dato)
        objetivo.setDato(siguiente.getDato());
        // "Saltamos" el nodo siguiente desde el objetivo, desenganchándolo de la lista
        objetivo.setSiguiente(siguiente.getSiguiente());
        // Desconectamos por completo el nodo que realmente eliminamos
        siguiente.setSiguiente(null);
        System.out.println("\nSe eliminó el valor " + dato + ".");
    }

    //Método 7: Actualizar un valor de la lista
    public void actualizarValor(int datoAnterior, int nuevoDato){
        Nodo objetivo = buscarDato(datoAnterior);

        // Si no existe ese dato, no podemos actualizar nada
        if(objetivo == null){
            System.out.println("No se puede actualizar el valor " + datoAnterior + " porque no existe en la lista.");
            return;
        }

        // Se guarda el valor anterior para el mensaje de terminal
        int valorAnteriorReal = objetivo.getDato();
        // Se actualiza nodo encontrado por el nuevo valor
        objetivo.setDato(nuevoDato);

        System.out.println("\nSe actualizó el valor " + valorAnteriorReal + " por " + nuevoDato + ".");
    }

    // Método para imprimir la lista
    public void imprimirLista() {
        if (head == null) {
            System.out.println("La lista está vacía.");
            return;
        }else{
            Nodo actual = head;
        System.out.print("Lista: ");
        while (actual != null) {
            System.out.print(actual.getDato() + " ");
            actual = actual.getSiguiente();
        }
        System.out.println();
        }
    }


}
