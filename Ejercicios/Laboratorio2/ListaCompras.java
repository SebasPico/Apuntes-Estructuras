package Laboratorio2;

public class ListaCompras {
    private Nodo head;
    private int size;

    public ListaCompras(){
        this.head = null;
        this.size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean estaVacia(){
        return head == null;
    }

    public void agregar(String nombre, int cantidad, String categoria){
        Articulo nuevoArticulo = new Articulo(nombre, cantidad, categoria);
        Nodo nuevoNodo = new Nodo(nuevoArticulo);

        if(head == null){
            head = nuevoNodo;
        }else{
            Nodo actual = head;
            while(actual.getSiguiente() != null){
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
        size++;
        System.out.println("Articulo \"" + nombre + "\" agregado a la lista en la posición " + size);
    }

    public void mostrarTodo(){
        if(head == null){
            System.out.println("La lista de compras está vacía");
            return;
        }
        System.out.println("\n--- LISTA DE COMPRAS COMPLETA (" + size + "articulos) ---");
        Nodo actual= head;
        int contador = 1;
        while(actual != null){
            System.out.println(contador + ". " + actual.getArticulo());
            actual = actual.getSiguiente();
            contador++;
        }
    }

    public void mostrarPorCategoria(String categoria){
        if(head == null){
            System.out.println("La lista de compras está vacía");
            return;
        }
        System.out.println("\n--- ARTICULOS DE LA CATEGORIA " + categoria + " ---");
        Nodo actual = head;
        boolean encontrados = false;
        int contador = 1;
        while(actual != null){
            if(actual.getArticulo().getCategoria().equals(categoria)){
                System.out.println(contador + ". " +actual.getArticulo());
                contador++;
            }
            actual = actual.getSiguiente();
        }

        if(!encontrados){
            System.out.println("No se encontraron artículos en la categoría \"" + categoria + "\".");
        }
    }

    private Nodo buscarNodo(String nombre){
        Nodo actual = head;
        while(actual != null){
            if(actual.getArticulo().getNombre().equalsIgnoreCase(nombre)){
                return actual;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    public int buscarCantidad(String nombre){
        Nodo nodo = buscarNodo(nombre);
        if(nodo == null){
            return -1;
        }
        return nodo.getArticulo().getCantidad();
    }

    public boolean actualizarCantidad(String nombre, int cantidadComprada){
        Nodo nodo = buscarNodo(nombre);
        if(nodo == null){
            return false;
        }

        Articulo articulo= nodo.getArticulo();
        int nuevaCantidad = articulo.getCantidad() - cantidadComprada;

        if(nuevaCantidad <= 0){
            System.out.println("La cantidad comprada cubre lo requerido. Se elimina \"" + nombre + "\" de la lista.");
            eliminar(nombre);
        }else{
            articulo.setCantidad(nuevaCantidad);
            System.out.println("Cantidad actualizada. Ahora se necesitan " + nuevaCantidad + " de \"" + nombre + "\".");
        }
        return true;
    }

    public boolean eliminar(String nombre){
        if(head == null){
            return false;
        }

        //CASO ESPECIAL: el articulo que se elimina es la cabeza
        if(head.getArticulo().getNombre().equalsIgnoreCase(nombre)){
            head = head.getSiguiente();
            size--;
            return true;
        }

        Nodo anterior = head;
        Nodo actual = head.getSiguiente();

        while(actual != null){
            if(actual.getArticulo().getNombre().equalsIgnoreCase(nombre)){
                anterior.setSiguiente(actual.getSiguiente());
                size--;
                return true;
            }
            anterior = actual;
            actual = actual.getSiguiente();
        }

        return false; //No encontró el articulo
    }

}
