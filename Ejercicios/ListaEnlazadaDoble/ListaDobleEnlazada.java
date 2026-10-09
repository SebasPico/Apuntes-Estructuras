package ListaEnlazadaDoble;

public class ListaDobleEnlazada {
   
    private Nodo head;
    private Nodo end;

    public Nodo getHead(){
        return head;
    }

    public Nodo getEnd(){
        return end;
    }

    public void setHead(Nodo head){
        this.head = head;
    }

    public void setEnd(Nodo end){
        this.end = end;
    }

    //Método 1: Agregar un nodo al final de la lista doble enlazada
    public void agregar (int dato){
        if(head == null && end == null){
            head = new Nodo(dato);
            end = head;
        } else {
            Nodo nuevoNodo = new Nodo(dato);
            nuevoNodo.setAnterior(end);
            end.setSiguiente(nuevoNodo);
            end = nuevoNodo;
        }
    }

    //Método 2: Imprimir lista desde la cabeza
    public void imprimirListaCabeza(){
        if(head == null && end == null){
            System.out.println("La lista está vacía.");
            return;
        }else{
            Nodo actual = head;
        System.out.println("Lista: ");
        while(actual != null){
            System.out.println(actual.getDato() + " ");
            actual = actual.getSiguiente();
        }
        System.out.println();
        }
    }

    //Método 3: Imprimir listad desde la cola
    public void imprimirListaCola(){
        if(head == null && end == null){
            System.out.println("La lista está vacía.");
            return;
        }else{
            Nodo actual = end;
        System.out.println("Lista: ");
        while(actual != null){
            System.out.println(actual.getDato() + " ");
            actual = actual.getAnterior();
        }
        System.out.println();
        }
    }

    //Método 4: Buscar un dato de la lista
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

    //Método 5: Actualizar recorriendo hacia la derecha (desde la cabeza)
    public void actualizarDerecha(int dato, int nuevoDato){
        Nodo actual = head;

        while(actual != null){
            if(actual.getDato() == dato){
                // Se encuenta el dato mientras se recorre hacía la izquierda
                actual.setDato(nuevoDato);
                System.out.println("Se actualizó (recorrido desde cabeza) el valor " + dato + " por " + nuevoDato + ".");
                return;
            }
            actual = actual.getSiguiente();
        }
        // Aquí ya no se encontró el dato
        System.out.println("El valor " + dato + " no existe en la lista (recorrido desde cabeza).");
    }

    //Método 6: Actualizar recorriendo hacia la izquierda (desde la cola (end))
    public void actualizarIzquierda(int dato, int nuevoDato){
        Nodo actual = end;

        while(actual != null){
            if(actual.getDato() == dato){
                // Se encuenta el dato mientras se recorre hacía la izquierda
                actual.setDato(nuevoDato);
                System.out.println("Se actualizó (recorrido desde cola) el valor " + dato + " por " + nuevoDato + ".");
                return;
            }
            actual = actual.getAnterior();
        }
        // Aquí ya no encontró el dato
        System.out.println("El valor " + dato + " no existe en la lista (recorrido desde cola).");
    }

    //Método 7: Eliminar un nodo de la lista (usando solo buscarDato)
    public void eliminarValor(int dato){
        Nodo objetivo = buscarDato(dato);
        if(objetivo == null){
            System.out.println("No se puede eliminar el valor " + dato + " porque no existe en la lista.");
            return;
        }
    }

    //Método 8: Eliminar valor con 3 casos: cabeza, cola y nodo intermedio
    //Este método maneja explícitamente cada caso y corrige los punteros anterior y siguiente
    public void eliminarValorTresCasos(int dato){
        Nodo objetivo = buscarDato(dato);

        // Caso 0: si el valor no existe, no hay nada que eliminar
        if(objetivo == null){
            System.out.println("No se puede eliminar el valor " + dato + " porque no existe en la lista.");
            return;
        }

        // Caso 1: el nodo a eliminar es la CABEZA
        if(objetivo == head){
            Nodo nuevoHead = head.getSiguiente();
            if(nuevoHead != null){
                // La nueva cabeza ya no tiene nodo anterior
                nuevoHead.setAnterior(null);
            } else {
                // Si era el único nodo, la cola también queda vacía
                end = null;
            }
            // Desconectamos la cabeza eliminada del resto
            head.setSiguiente(null);
            head = nuevoHead;
            System.out.println("Se eliminó el valor " + dato + " (era la cabeza).");
            return;
        }

        // Caso 2: el nodo a eliminar es la COLA (end)
        if(objetivo == end){
            Nodo nuevoEnd = end.getAnterior();
            // El nuevo final ya no tiene siguiente
            nuevoEnd.setSiguiente(null);
            // Se desconecta la cola eliminada
            end.setAnterior(null);
            end = nuevoEnd;
            System.out.println("Se eliminó el valor " + dato + " (era la cola).");
            return;
        }

        // Caso 3: el nodo a eliminar está EN MEDIO (no es cabeza ni cola)
        Nodo anterior = objetivo.getAnterior();
        Nodo siguiente = objetivo.getSiguiente();

        // Enlazamos el anterior con el siguiente (saltamos el objetivo)
        anterior.setSiguiente(siguiente);
        // Enlazamos el siguiente con el anterior (en ambos sentidos)
        siguiente.setAnterior(anterior);

        // Limpiamos los punteros del nodo eliminado (buena práctica)
        objetivo.setAnterior(null);
        objetivo.setSiguiente(null);

        System.out.println("Se eliminó el valor " + dato + " (nodo intermedio).");
    }


}
