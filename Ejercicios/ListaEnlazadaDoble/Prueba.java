package ListaEnlazadaDoble;

public class Prueba {

    public static void main(String[] args){
        ListaDobleEnlazada lista = new ListaDobleEnlazada();

        //Agregar
        System.out.println("Agregar al final");
        lista.agregar(5);
        lista.agregar(10);
        lista.agregar(15);
        lista.imprimirListaCabeza();

        // Buscar dato
        System.out.println("Buscar dato");
        lista.buscarDato(10);
    }
    
}
