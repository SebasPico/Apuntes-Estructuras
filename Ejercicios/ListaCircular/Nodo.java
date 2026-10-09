package ListaCircular;

public class Nodo{
    private int dato;
    private Nodo siguiente;

    public Nodo(){

    }

    public Nodo(int dato) {
        this.dato = dato;
        siguiente = this;
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