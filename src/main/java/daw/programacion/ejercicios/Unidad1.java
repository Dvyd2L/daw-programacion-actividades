package daw.programacion.ejercicios;

import daw.programacion.interfaces.TriFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class Unidad1 {
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

        //----------------------------------------------
        //          Declaración de variables
        //----------------------------------------------

        // Constantes
        final double FIRST_TEST_X = 2, SECOND_TEST_X = 0.5, THIRD_TEST_X = 1.3;
        final double FIRST_TEST_Y = 3, SECOND_TEST_Y = 10, THIRD_TEST_Y = 4.2;
        final double FIRST_TEST_Z = 4, SECOND_TEST_Z = 5, THIRD_TEST_Z = 8.9;
        enum Operations {
            OPERACION_1("f(x) = x / 3 + 8"), OPERACION_2("f(x, y, z) = x² / y² + y² / z²"), OPERACION_3("f(x, y) = x² + 3xy + y² / (1 / x²)");

            private final String description;

            Operations(String description) {
                this.description = description;
            }

            public String getDescription() {
                return description;
            }
        }

        // Variables de entrada
        double userX, userY, userZ;

        // Variables de salida
        Function<Double, Double> firstOperation = (Double x) -> x / 3.0 + 8.0;
        TriFunction<Double, Double, Double, Double> secondOperation = (Double x, Double y, Double z) -> Math.pow(x, 2) / Math.pow(y, 2) + Math.pow(y, 2) / Math.pow(z, 2);
        BiFunction<Double, Double, Double> thirdOperation = (Double x, Double y) -> (Math.pow(x, 2) + 3 * x * y + Math.pow(y, 2)) / Math.pow(x, -2);

        // Variables auxiliares
        Scanner console = new Scanner(System.in); // Clase Scanner para petición de datos de entrada
        // Plantilla de salida de datos
        TriFunction<Double, Double, Double, Void> printResults = (Double x, Double y, Double z) -> {
            System.out.println("CÁLCULOS ARITMÉTICOS");
            System.out.println("--------------------");
            System.out.println("Valor para la x: " + x);
            System.out.println("Valor para la y: " + y);
            System.out.println("Valor para la z: " + z);

            System.out.println("\nRESULTADO");
            System.out.println("---------");
            System.out.println(Operations.OPERACION_1 + ": " + Operations.OPERACION_1.getDescription() + " => " + firstOperation.apply(x));
            System.out.println(Operations.OPERACION_2 + ": " + Operations.OPERACION_2.getDescription() + " => " + secondOperation.apply(x, y, z));
            System.out.println(Operations.OPERACION_3 + ": " + Operations.OPERACION_3.getDescription() + " => " + thirdOperation.apply(x, y));
            return null;
        };

        //----------------------------------------------
        //                Entrada de datos
        //----------------------------------------------
        System.out.print("Introduce un valor para 'x': ");
        userX = console.nextDouble();
        System.out.print("Introduce un valor para 'y': ");
        userY = console.nextDouble();
        System.out.print("Introduce un valor para 'z': ");
        userZ = console.nextDouble();

        //----------------------------------------------
        //                 Procesamiento
        //----------------------------------------------

        /*
         * En mi caso la ejecución está encapsulada en las propias variables
         * de salida, ya que estas son expresiones lambda.
         */

        //----------------------------------------------
        //              Salida de resultados
        //----------------------------------------------
        System.out.println("\n······························\n");
        printResults.apply(FIRST_TEST_X, FIRST_TEST_Y, FIRST_TEST_Z);
        System.out.println("\n······························\n");
        printResults.apply(SECOND_TEST_X, SECOND_TEST_Y, SECOND_TEST_Z);
        System.out.println("\n······························\n");
        printResults.apply(THIRD_TEST_X, THIRD_TEST_Y, THIRD_TEST_Z);
        System.out.println("\n······························\n");
        printResults.apply(userX, userY, userZ);
        System.out.println("\n······························\n");

        System.out.println();
        System.out.println("Fin del programa.");
    }

    public void ejercicio2() {
        final double CONSTANTE1 = 80.3;
        final int CONSTANTE2 = 3;
        boolean valorBool;
        byte enteroByte;
        short enteroShort;
        int enteroInt, producto;
        long enteroLong;
        double decimalDoble;
        float decimalSimple;

        // Y el siguiente conjunto de acciones:
        /*
        valorBool = 0;
        decimalSimple = 9.9 * 4.6;
        enteroInt = 'a';
        decimalDoble = 5,17;
        enteroLong = 25_369L;
        producto = enteroLong * enteroInt;
        valorBool = (97 == 'a' == 97);
        CONSTANTE1 = 100.3;
        decimalSimple = 'c';
        decimalDoble = 3.2 * 4.7;
        producto = CONSTANTE1 * CONSTANTE2;
        decimalDoble = 5.67F;
        decimalDoble  = 8;
        enteroInt = 1/2;
        */
        // Realiza las tareas que se indican a continuación:

        // Comenta las sentencias incorrectas e incluye una breve explicación del error encontrado.
        // Si se puede, modifica las instrucciones erróneas para que sean válidas haciendo un casting (conversión explícita).
        // Identifica aquellas sentencias en las que se ha realizado una conversión implícita.
        // Para ello, incluye un comentario especificando el tipo de dato origen y el nuevo tipo de dato.
        // Se proporcionan tres ejemplos como modelo:

        // Las variables booleanas solo pueden tener los valores true o false
        // valorBool = 0;

        // decimalSimple = 9.9 * 4.6;
        // SOLUCIÓN: CASTING EXPLÍCITO
        decimalSimple = (float) (9.9 * 4.6);

        // CASTING IMPLÍCITO: de tipo char a tipo int
        enteroInt = 'a';

        // Ten en cuenta que en este ejercicio lo único que hay que hacer es incluir comentarios en el código para identificar las tres posibles casuísticas.
        // De hecho, hay sentencias correctas en las que no se da ninguno de los casos y, por tanto, no tienen que ser comentadas.

        //----------------------------------------------
        //          Solución del ejercicio
        //----------------------------------------------

        // valorBool = 0; // [ERROR] Las variables booleanas solo pueden tener los valores true o false
        decimalSimple = (float) (9.9 * 4.6);  // SOLUCIÓN: CASTING EXPLÍCITO -> de tipo double a tipo float
        enteroInt = 'a'; // [SOLUCIÓN] CASTING IMPLÍCITO: de tipo char a tipo int
        // decimalDoble = 5, 17; // [ERROR] Asignación incorrecta, el valor 17 no se esta asignando a ninguna variable
        enteroLong = 25_369L;
        producto = (int) enteroLong * enteroInt;  // [SOLUCIÓN] CASTING EXPLÍCITO: de tipo long a tipo int
        // valorBool = (97 == 'a' == 97); // [ERROR] No se puede aplicar el operador de comparación entre un boolean y un int (97 == 'a' es true)
        // CONSTANTE1 = 100.3; // [ERROR] No se puede reasignar una constante
        decimalSimple = 'c'; // [SOLUCIÓN]: CASTING IMPLÍCITO: de tipo char a tipo float
        decimalDoble = 3.2 * 4.7;
        producto = (int) CONSTANTE1 * CONSTANTE2; // [SOLUCIÓN] CASTING EXPLÍCITO: de tipo double a tipo int
        decimalDoble = 5.67F;
        decimalDoble = 8; // [SOLUCIÓN] CASTING IMPLÍCITO: de tipo int a tipo double
        enteroInt = 1 / 2; // [SOLUCIÓN] CASTING IMPLÍCITO: de tipo double a tipo int
    }

    public void ejercicio3() {
        //----------------------------------------------
        //          Declaración de variables
        //----------------------------------------------

        // Constantes
        final int MIN_LENGTH = 12;
        enum PasswordRequirements {
            LONGITUD_MINIMA("La longitud de la contraseña debe ser, como mínimo, de 12 caracteres."), COMENZAR_VOCAL("Tiene que comenzar con una vocal (mayúscula o minúscula)."), TERMINAR_CONSONANTE("Debe terminar con una consonante (mayúscula o minúscula)."), CARACTERES_ESPECIALES("Tiene que contener, al menos, uno de los siguientes caracteres especiales: arroba ('@'), almohadilla ('#'), barra baja ('_'), punto ('.') o punto y coma (';').");

            private final String description;

            PasswordRequirements(String description) {
                this.description = description;
            }

            public String getDescription() {
                return description;
            }
        }

        // Variables de entrada
        String userPassword;

        // Variables de salida
        String result;
        List<String> errors = new ArrayList<String>();

        // Variables auxiliares
        Scanner console = new Scanner(System.in); // Clase Scanner para petición de datos de entrada
        Predicate<String> hasMinLength = (String password) -> password.length() >= MIN_LENGTH;
        Predicate<String> beginWithVocal = (String password) ->
                String.valueOf(password.charAt(0)).matches("[aeiouAEIOU]");
        Predicate<String> endWithConsonant = (String password) ->
                String.valueOf(password.charAt(password.length() - 1))
                        .matches("[bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ]");
        Predicate<String> hasSpecialChar = (String password) -> password.matches(".*[@#_.;].*");
        Predicate<String> isValidPassword = (String password) -> {
            final boolean testResultMinLength = hasMinLength.test(password);
            final boolean testResultBeginWithVocal = beginWithVocal.test(password);
            final boolean testResultEndWithConsonant = endWithConsonant.test(password);
            final boolean testResultHasSpecialChar = hasSpecialChar.test(password);

            // Evaluar cada condición y añadir el mensaje de error si no se cumple, utilizando lambdas
            errors.add(!hasMinLength.test(password) ? PasswordRequirements.LONGITUD_MINIMA.getDescription() : null);
            errors.add(!beginWithVocal.test(password) ? PasswordRequirements.COMENZAR_VOCAL.getDescription() : null);
            errors.add(!endWithConsonant.test(password) ? PasswordRequirements.TERMINAR_CONSONANTE.getDescription() : null);
            errors.add(!hasSpecialChar.test(password) ? PasswordRequirements.CARACTERES_ESPECIALES.getDescription() : null);

            // Eliminar cualquier valor nulo de la lista de errores
            errors.removeIf(Objects::isNull);

            return testResultMinLength &&
                    testResultBeginWithVocal &&
                    testResultEndWithConsonant &&
                    testResultHasSpecialChar;
        };


        //----------------------------------------------
        //                Entrada de datos
        //----------------------------------------------
        System.out.println("VALIDACIÓN DE CONTRASEÑAS");
        System.out.println("-------------------------");
        System.out.println("Introduzca la contraseña: ");
        userPassword = console.next();
        console.close();

        //----------------------------------------------
        //                 Procesamiento
        //----------------------------------------------
        result = isValidPassword.test(userPassword) ? "VÁLIDA" : "NO VÁLIDA";

        //----------------------------------------------
        //              Salida de resultados
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");
        System.out.println("La contraseña es " + result);
        System.out.println(!errors.isEmpty() ? String.join("\n", errors) : "");


        System.out.println();
        System.out.println("Fin del programa.");
    }
}
