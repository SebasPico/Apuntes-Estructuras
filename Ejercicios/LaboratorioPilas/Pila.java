package LaboratorioPilas;

public class Pila<T> {
    private Nodo<T> cima;

    public boolean estaVacia() {
        return cima == null;
    }

    public void apilar(T valor) {
        cima = new Nodo<>(valor, cima);
    }

    public T desapilar() {
        if (estaVacia()) {
            throw new IllegalStateException("La pila está vacía.");
        }

        T valor = cima.getValor();
        cima = cima.getSiguiente();
        return valor;
    }

    public T verCima() {
        if (estaVacia()) {
            throw new IllegalStateException("La pila está vacía.");
        }
        return cima.getValor();
    }
}