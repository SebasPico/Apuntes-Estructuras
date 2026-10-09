public class Nodo{
    
    private int valor;
    private Nodo izquierda;
    private Nodo derecha;

    public Nodo (int valor){
        this.valor = valor;
        this.izquierda = null;
        this.derecha = null;
    }

    public Nodo(){

    }

    // Getter y Setter de valor
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    // Getter y Setter de izquierda
    public Nodo getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Nodo izquierda) {
        this.izquierda = izquierda;
    }

    // Getter y Setter de derecha
    public Nodo getDerecha() {
        return derecha;
    }

    public void setDerecha(Nodo derecha) {
        this.derecha = derecha;
    }
}