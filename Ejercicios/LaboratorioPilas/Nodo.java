package LaboratorioPilas;

class Nodo<T> {
    private final T valor;
    private final Nodo<T> siguiente;

    Nodo(T valor, Nodo<T> siguiente) {
        this.valor = valor;
        this.siguiente = siguiente;
    }

    T getValor() {
        return valor;
    }

    Nodo<T> getSiguiente() {
        return siguiente;
    }
}