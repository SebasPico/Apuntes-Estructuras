package ListaCircular;

public class ListaCircular{
    
    private Nodo head;

    public ListaCircular(){
        this.head = null;
    }

    public Nodo getHead() {
        return head;
    }

    public void setHead(Nodo head) {
        this.head = head;
    }

    //Metodo 1: Agregar 
    public void agregar(int dato){
        if(head == null){
            head = new Nodo(dato);
        } else {
            Nodo nuevoNodo = new Nodo(dato);
            Nodo temp = head;
            while(temp.getSiguiente() != head){
                temp = temp.getSiguiente();
            }
            temp.setSiguiente(nuevoNodo);
            nuevoNodo.setSiguiente(head);
        }
    }

    public void imprimirLista(){
        if(head != null){
            Nodo temp = head;
            do{
                System.out.println(temp.getDato());
                temp = temp.getSiguiente();
            }while(temp != head);
        }
    }



}