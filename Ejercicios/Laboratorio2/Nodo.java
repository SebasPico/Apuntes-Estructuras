package Laboratorio2;

public class Nodo {
    
    private Articulo articulo;
    private Nodo siguiente;

    public Nodo(Articulo articulo) {
        this.articulo = articulo;
        siguiente = null;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

}

