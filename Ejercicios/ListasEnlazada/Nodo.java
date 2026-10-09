package ListasEnlazada;

public class Nodo {
    private int dato;
    private Nodo siguiente;

    public Nodo(int dato) {
        this.dato = dato;
        siguiente = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

}
