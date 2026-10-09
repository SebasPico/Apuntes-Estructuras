
import java.util.Scanner;

public class AlgoritmoMultiplicacion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Pedir datos al usuario
        System.out.print("Ingrese el valor de x: ");
        int x = scanner.nextInt();
        
        System.out.print("Ingrese el valor de y: ");
        int y = scanner.nextInt();
        
        scanner.close();
        
        // Calcular el producto
        int producto = y;
        int cuenta = 1;
        
        while (cuenta < x) {
            producto = producto + y;
            cuenta = cuenta + 1;
        }
        
        // Imprimir el resultado
        System.out.println("El producto de " + x + " y " + y + " es: " + producto);
    }
}
