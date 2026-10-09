package Grafos;

public class Grafos {
    private int numeroNodos;
    private int [][] matrizAdyacencia;

    public Grafos(int numeroNodos) {
        this.numeroNodos = numeroNodos;
        NodoGrafo[] nodos= new NodoGrafo[numeroNodos];

        for(int i=0; i<numeroNodos; i++) {
            NodoGrafo nuevo = new NodoGrafo(i);
            nodos[i] = nuevo;
        }

        matrizAdyacencia = new int[numeroNodos][numeroNodos];
        IniciarMatriz();
    }

    private void IniciarMatriz(){
        for(int filas=0; filas<numeroNodos; filas++) {
            for(int posicion=0; posicion<numeroNodos; posicion++) {
                matrizAdyacencia[filas][posicion] = 0;
            }
        }
    }

    public void agregarArista(int origen, int destino){
        if(origen < numeroNodos && destino < numeroNodos) {
            matrizAdyacencia[origen][destino] = 1;
            matrizAdyacencia[destino][origen] = 1; // Si el grafo es no dirigido
        } else {
            System.out.println("Error: No existe ese nodo en el grafo");
        }
    }

    public void mostrarAtristas(){
        for(int i=0; i<numeroNodos; i++) {
            for(int j=0; j<numeroNodos; j++) {
                if(matrizAdyacencia[i][j] == 1) {
                    System.out.println("Arista: " + i + " - " + j);
                }
            }
        }  
    }
}