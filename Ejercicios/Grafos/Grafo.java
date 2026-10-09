package Grafos;

public class Grafo {

    public static void main(String[] args) {
        // Aquí puedes crear instancias de Grafo y probar sus métodos
        Grafos nuevoGrafo = new Grafos(6);
        nuevoGrafo.agregarArista(0, 1);
        nuevoGrafo.agregarArista(0, 5);
        nuevoGrafo.agregarArista(1, 2);
        nuevoGrafo.agregarArista(2, 1);
        nuevoGrafo.agregarArista(2,3);
        nuevoGrafo.agregarArista(2, 4);
        
        nuevoGrafo.mostrarAtristas();
    }
}