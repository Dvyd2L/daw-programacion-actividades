import interfaces.TriFunction;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Tema1 {
    /**
     * Escribe un programa en Java que convierta en expresiones algorítmicas las siguientes expresiones algebraicas.
     * Antes, define un enumerado con las cadenas que muestren las operaciones:
     * OPERACION_1,
     * OPERACION_2 y
     * OPERACION_3,
     * para posteriormente mostrar por pantalla cada valor del enumerado antes del resultado de cada operación:
     * Para ello tendrás que utilizar operadores aritméticos tales como la suma, la resta, el producto o la división.
     * Además, debes tener muy en cuenta el orden de precedencia de operadores para minimizar el uso de los
     * paréntesis, usándolos sólo cuando sea estrictamente necesario.
     */
    public void ejercicio1() {
        // variables
        double x1 = 2, x2 = 0.5, x3 = 1.3;
        double y1 = 3, y2 = 10, y3 = 4.2;
        double z1 = 4, z2 = 5, z3 = 8.9;

        // operations
        Function<Double, Double> op1 = (Double x) -> x / 3.0 + 8.0;
        TriFunction<Double, Double, Double, Double> op2 = (Double x, Double y, Double z) -> Math.pow(x, 2) / Math.pow(y, 2) + Math.pow(y, 2) / Math.pow(z, 2);
        BiFunction<Double, Double, Double> op3 = (Double x, Double y) -> (Math.pow(x, 2) + 3 * x * y + Math.pow(y, 2)) / Math.pow(x, -2);

        // print results
        TriFunction<Double, Double, Double, Double> printResults = (Double x, Double y, Double z) -> {
            System.out.println("CÁLCULOS ARITMÉTICOS");
            System.out.println("--------------------");
            System.out.println("Valor para la x: " + x);
            System.out.println("Valor para la y: " + y);
            System.out.println("Valor para la z: " + z);

            System.out.println("\nRESULTADO");
            System.out.println("---------");
            System.out.println("OPERACION_1: " + op1.apply(x));
            System.out.println("OPERACION_2: " + op2.apply(x, y, z));
            System.out.println("OPERACION_3: " + op3.apply(x, y));
            return null;
        };

        // execution
        printResults.apply(x1, y1, z1);
        System.out.println("\n······························\n");
        printResults.apply(x2, y2, z2);
        System.out.println("\n······························\n");
        printResults.apply(x3, y3, z3);
    }
}
