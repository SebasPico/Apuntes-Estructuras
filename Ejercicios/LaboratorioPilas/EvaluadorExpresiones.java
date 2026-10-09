package LaboratorioPilas;

// Esta clase se encarga de leer la operacion y calcular su resultado.
public class EvaluadorExpresiones {
    
    // Aqui se usan dos pilas: una para numeros y otra para operadores. 
    public double evaluar(String expresion) {
        if (expresion == null || expresion.trim().isEmpty()) {
            throw new IllegalArgumentException("Ingrese una expresión.");
        }

        Pila<Double> operandos = new Pila<>();
        Pila<Character> operadores = new Pila<>();
        int posicion = 0;
        boolean esperabaOperando = true;

        // Recorremos la expresion caracter por caracter.
        while (posicion < expresion.length()) {
            char caracter = expresion.charAt(posicion);

            if (Character.isWhitespace(caracter)) {
                posicion++;
                continue;
            }

            if (Character.isDigit(caracter) || caracter == '.') {
                // Si encontramos un numero, lo guardamos en la pila de operandos.
                int inicio = posicion;
                boolean tienePunto = false;
                while (posicion < expresion.length()) {
                    char parte = expresion.charAt(posicion);
                    if (Character.isDigit(parte)) {
                        posicion++;
                    } else if (parte == '.' && !tienePunto) {
                        tienePunto = true;
                        posicion++;
                    } else {
                        break;
                    }
                }
                try {
                    operandos.apilar(Double.parseDouble(expresion.substring(inicio, posicion)));
                } catch (NumberFormatException exception) {
                    throw new IllegalArgumentException("Número inválido.");
                }
                esperabaOperando = false;
                continue;
            }

            if (caracter == '(') {
                // El parentesis se guarda para no resolver lo que esta afuera todavia.
                if (!esperabaOperando) {
                    throw new IllegalArgumentException("Falta un operador antes de '('.");
                }
                operadores.apilar(caracter);
                posicion++;
                continue;
            }

            if (caracter == ')') {
                // Al cerrar un parentesis, resolvemos todo lo que quedo dentro.
                if (esperabaOperando) {
                    throw new IllegalArgumentException("Paréntesis vacío o expresión incompleta.");
                }
                while (!operadores.estaVacia() && operadores.verCima() != '(') {
                    aplicarOperacion(operandos, operadores.desapilar());
                }
                if (operadores.estaVacia()) {
                    throw new IllegalArgumentException("Paréntesis desbalanceados.");
                }
                operadores.desapilar();
                posicion++;
                continue;
            }

            if (esOperador(caracter)) {
                // Antes de guardar el nuevo operador, revisamos si ya toca
                // resolver el operador que esta arriba de la pila.
                if (esperabaOperando) {
                    throw new IllegalArgumentException("La expresión tiene operadores consecutivos.");
                }
                while (!operadores.estaVacia()
                        && operadores.verCima() != '('
                        && prioridad(operadores.verCima()) >= prioridad(caracter)) {
                    aplicarOperacion(operandos, operadores.desapilar());
                }
                operadores.apilar(caracter);
                esperabaOperando = true;
                posicion++;
                continue;
            }

            throw new IllegalArgumentException("Carácter no válido: '" + caracter + "'.");
        }

        if (esperabaOperando) {
            throw new IllegalArgumentException("La expresión está incompleta.");
        }

        // Al terminar, resolvemos los operadores que todavia quedan en la pila.
        while (!operadores.estaVacia()) {
            if (operadores.verCima() == '(') {
                throw new IllegalArgumentException("Paréntesis desbalanceados.");
            }
            aplicarOperacion(operandos, operadores.desapilar());
        }

        double resultado = operandos.desapilar();
        if (!operandos.estaVacia()) {
            throw new IllegalArgumentException("Faltan operadores entre los números.");
        }
        return resultado;
    }

    // Saca los dos ultimos numeros y vuelve a guardar el resultado.
    private void aplicarOperacion(Pila<Double> operandos, char operador) {
        if (operandos.estaVacia()) {
            throw new IllegalArgumentException("Faltan operandos.");
        }
        double derecho = operandos.desapilar();
        if (operandos.estaVacia()) {
            throw new IllegalArgumentException("Faltan operandos.");
        }
        double izquierdo = operandos.desapilar();

        // El segundo numero que sale es el de la derecha de la operacion.
        if (operador == '/' && derecho == 0) {
            throw new IllegalArgumentException("No se puede dividir entre cero.");
        }

        switch (operador) {
            case '+': operandos.apilar(izquierdo + derecho); break;
            case '-': operandos.apilar(izquierdo - derecho); break;
            case '*': operandos.apilar(izquierdo * derecho); break;
            case '/': operandos.apilar(izquierdo / derecho); break;
            default: throw new IllegalArgumentException("Operador no válido.");
        }
    }

    // Indica si el caracter es uno de los operadores que acepta la calculadora.
    private boolean esOperador(char caracter) {
        return caracter == '+' || caracter == '-' || caracter == '*' || caracter == '/';
    }

    // Suma y resta tienen prioridad 1; multiplicacion y division, prioridad 2.
    private int prioridad(char operador) {
        return operador == '+' || operador == '-' ? 1 : 2;
    }
}