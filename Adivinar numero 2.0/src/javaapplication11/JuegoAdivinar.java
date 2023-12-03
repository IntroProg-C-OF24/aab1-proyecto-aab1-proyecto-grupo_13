package javaapplication11;

import java.util.Scanner;

/**
 * Se le solicita desarrollar un demo tipo juego, que permita generar un número
 * aleatorio y le rete al usuario que lo adivine. Si no adivina el número, el
 * juego debe sugerirle lo intente nuevamente con pistas (es mayor, menor, es
 * par, impar, es primo, pertenece a la serie de fibonacy, es multiplo de N,
 * etc.), el usuario es quien deberá ir pidiendo repetitivamente que el sistema
 * le muestre o no, más pintas, solo que, si el usuario pide más pistas, el
 * sistema automáticamente le resta un intento y le informa cuantos intentos le
 * quedan. Al finalizar el juego, se debe felicitar al usuario si gana y como, o
 * pedir que lo intente de nuevo.
 *
 *
 * @author Carlos Sánchez
 */
public class JuegoAdivinar {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int intentos;
        boolean jugarNuevamente = true; 
        boolean mostrarOpciones; //Variable para mostrar las opciones de pistas solo 1 vez y no inundar la pantalla
        while (jugarNuevamente) {
            intentos = 15;  //Intentos por defecto: 15
            mostrarOpciones = true;
            int randomNumber, userNumber;
            boolean usuarioGano = false;

            randomNumber = (int) (Math.random() * 100 + 1);    //El número será entre 1 y 100. 
            System.out.println("Adivina un número del 1 al 100");

            while (intentos > 0) {
                System.out.println("Te quedan " + intentos + " intentos");
                userNumber = sc.nextInt();

                if (userNumber == randomNumber) {
                    usuarioGano = true;
                    break;
                } else {

                    if (intentos > 0) {
                        System.out.println("Número incorrecto. Eliga una pista. (Escribir numero para seleccionar) ");
                        if (mostrarOpciones) {
                            System.out.println("----------------------------");
                            System.out.println("Cada pista tiene un costo de 1 intento extra");
                            System.out.println("0.- NO USAR PISTAS. (Costo: 0 intentos)");
                            System.out.println("1.- El numero es mayor o menor al que escribiste");
                            System.out.println("2.- El número es par o impar");
                            System.out.println("3.- El número es divisible para 10.");
                            System.out.println("4.- El número es mayor o menor a 50");
                            System.out.println("5.- El número es/no es un cubo perfecto");
                            System.out.println("OTRO.- El número es mayor/menor a 10");
                             System.out.println("----------------------------");
                            mostrarOpciones = false;
                        }

                        int seleccionPista = sc.nextInt();

                        if (seleccionPista != 0) {
                            intentos--;
                            System.out.println(generarPista(randomNumber, userNumber, seleccionPista));
                        }
                    }

                }
                intentos--;
            }

            if (usuarioGano) {
                System.out.println("Felicidades, lograste adivinar el número");
            } else {
                System.out.println("Te haz quedado sin intentos. El número que pensé es: " + randomNumber);
            }

            System.out.println("Jugar otra vez? 1 = SI.  2 = NO");

            jugarNuevamente = (sc.nextInt() != 1) ? false : true;

        }

        System.out.println("Muchas gracias por jugar");

    }

    //Metodo que devuelve una pista en base a elección del usuario.
    public static String generarPista(int numeroRandom, int numeroUsuario, int seleccionPista) {

        String pista = "";

        //Pista de es mayor o menor
        if (seleccionPista == 1) {

            return (numeroUsuario > numeroRandom) ? "El número es menor al que acabas de adivinar: " + numeroUsuario
                    : "El número es mayor al que acabas de adivinar: " + numeroUsuario;

        }
        //Pista de si es par o impar:
        if (seleccionPista == 2) {

            return (numeroRandom % 2 == 0) ? "El número es par" : "El número es impar";
        }
        //Pista es divisible para 10: 
        if (seleccionPista == 3) {

            return (numeroRandom % 10 == 0) ? "El número es divisible por 10" : "El número no es divisible por 10";

        }
        //Pista el número es mayor o menor a 50
        if (seleccionPista == 4) {

            return (numeroRandom > 50) ? "El número es mayor a 50" : "El número es menor/igual a 50";
        }

        //El numero es un cubo perfecto:
        if (seleccionPista == 5) {

            return (numeroRandom == 1 || numeroRandom == 8 || numeroRandom == 27
                    || numeroRandom == 64) ? "El número es un cubo perfecto" : "El número no es un cubo perfecto";
        }

        //El usuario introdujo una opción marcada como OTRO. En este caso, se la toma como esta pista:
        return (numeroRandom > 10) ? "El número es mayor a 10" : "El número es menor a 10";
    }

}
