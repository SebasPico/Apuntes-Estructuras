package ListaCircular;

public class Main{
    public static void main(String[] args) {
        ListaCircular lista = new ListaCircular();

        lista.agregar(5);
        lista.agregar(10);
        lista.agregar(15);

        System.out.println("Estado inicial: ");
        lista.imprimirLista();
    
    }
}