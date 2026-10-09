public class ArbolBinarioBusqueda{
    private Nodo raiz;

    public ArbolBinarioBusqueda(){
        raiz = null;
    }

    // Getter de la raíz
    public Nodo getRaiz() {
        return raiz;
    }

    // Setter de la raíz
    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    //Insertar Valor
    public void insertar(int valor){
        raiz = insertarRecursivo(raiz, valor);
    }

    private Nodo insertarRecursivo(Nodo nodo, int valor){
        
        //Si el arbol esta vacio
        if(nodo == null){
            return new Nodo(valor);
        }

        //Si el valor es menor va izquierda
        if(valor < nodo.getValor()){
            nodo.setIzquierda(insertarRecursivo(nodo.getIzquierda(), valor));
        }
        //Si el valor es mayor va derecha
        else if(valor > nodo.getValor()){
            nodo.setDerecha(insertarRecursivo(nodo.getDerecha(), valor));
        }

        //Si es igual, no inserta nada
        return nodo;
    }

    //Buscar valor
    public boolean buscar(int valor){
        return buscarRecursivo(raiz, valor);
    }

    private boolean buscarRecursivo(Nodo nodo, int valor){
        
        if(nodo == null){
            return false;
        }

        if(valor == nodo.getValor()){
            return true;
        }

        if(valor < nodo.getValor()){
            return buscarRecursivo(nodo.getIzquierda(), valor);
        }

        return buscarRecursivo(nodo.getDerecha(), valor);
    }
}