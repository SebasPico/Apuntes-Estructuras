package Recursividad;

public class Factorial {

    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    public static void main(String[] args) {

        int n = 5;

        int resultado = factorial(n);

        System.out.println("El factorial de " + n + " es: " + resultado);
    }
}