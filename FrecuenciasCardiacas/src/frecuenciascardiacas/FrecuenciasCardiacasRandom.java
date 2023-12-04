
package frecuenciascardiacas;
import java.util.Scanner;
//import java.time.YearMonth;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

// Upper Camel Class
public class FrecuenciasCardiacasRandom {
    
    public static void main(String[] args) {
       // Lower Camel Class (since method: main)
       int sesiones, nSesion=1, year,currentYear, age, date;
       float $PulseRate, $maxPulseRate, $idealPulseRateLow, $idealPulseRateHigh, hiit;
       String name, date3, today3, idealPulseRange;
       // Iniciar scanner
       Scanner sc = new Scanner (System.in);
       // Determinar periodo
       Random random = new Random(); // esto inicializa nuestro aleatorizador
       System.out.println("Cuantas veces a la semana usted se ejercita? (esto es autogenerado)");
       sesiones = random.nextInt(1,7) + 1; // para propositos practicos solo coloco un maximo de 7 veces que el ciclo se repita
       //Comenzar Programa
       System.out.println("Coloque su nombre: (no lo autogenero porque traeria caracteres sin sentido) ");
       name = sc.next();
       System.out.println("Su dia, mes y año de nacimiento son autogenerados(dd/MM/AAAA)");
       //Aqui abajo solo autogenero el año, pues el dia y mes no son solicitadosen la presentacion, ni necesarios en el calculo
       
       date = random.nextInt(1924, 2015)+1;
       //Ahora importamos la fecha actual (java.util.Date)
       Date today = new Date();
       // El todayFormat solo es el formato para la fecha compleja que la utilidad de java (java.util.date) nos da por defecto.
       SimpleDateFormat todayFormat = new SimpleDateFormat("dd/MM/Y");
       String todayString = todayFormat.format(today);
       
       today3 = todayString.replaceAll("\\d+{2}\\D+{2}","");
       currentYear = Integer.parseInt(today3);
       // Sacamos edad en años de la persona
       age = currentYear-date;
       System.out.println("Estimado "+name+", usted tiene: "+age+" años");
       //       System.out.println(day+""+month+""+year);
       
       String[][] output = new String[sesiones+1][7];
        output[0][0] = "Nombre";
        output[0][1] = "Edad";
        output[0][2] = "Sesion";
        output[0][3] = "Frecuencia";
        output[0][4] = "Max.Frecuencia";
        output[0][5] = "Frec. Ideal";
        output[0][6] = "Max. Tiempo HIIT";
       do {
       
       
       // Calculamos frecuencia cardiaca esperada
       System.out.println("Ingrese su frecuencia cardiaca en su sesion "+nSesion+" de ejercicio: (autogenerado)");
       $PulseRate=  random.nextFloat(60,220)+1;
       $maxPulseRate = 220-age;
       $idealPulseRateLow = (float) ($maxPulseRate*0.5);
       $idealPulseRateHigh= (float) ($maxPulseRate*0.8);
        System.out.println("");
        System.out.println("Su frecuencia cardiaca maxima es: "+$maxPulseRate);
        // English: bpm ; Español: lpm. Latidos por minuto
        idealPulseRange = Float.toString($idealPulseRateLow)+"-"+Float.toString($idealPulseRateHigh);
        
        System.out.println("Su frecuencia cardiaca esperada o ideal es desde: "+$idealPulseRateLow+" lpm hasta "+$idealPulseRateHigh+" lpm");
        System.out.println("");
        System.out.println("Cuantos minutos sin descanso resistio de Ejercicio de Alta Intensidad (autogenerado)");
        System.out.println("");
        hiit = random.nextFloat(1,40)+1;
        
        //Aqui genero la tabla estadistica
        output[nSesion][0] = name;
        // Para posibilitar nuestra tabla estadistica debemos convertir nuestros datos Int(numeros-enteros) en Strings(cadenas-de-caracteres)
        output[nSesion][1] = Integer.toString(age);
        output[nSesion][2] = Integer.toString(nSesion);
        output[nSesion][3] = Float.toString($PulseRate);
        output[nSesion][4] = Float.toString($maxPulseRate);
        output[nSesion][5] = idealPulseRange;
        output[nSesion][6] = Float.toString(hiit);
        nSesion++;

       }while (nSesion<=sesiones);
       nSesion--;
        
       // Java suggestion: for (String[] output1 : output)
       for (int i = 0; i < output.length; i++) {
            if (output[i][0] != null) {
                System.out.println(output[i][0] + "\t" + output[i][1] + "\t" + output[i][2] + "\t" + output[i][3] + "\t" + output[i][4] + "\t" + output[i][5] + "\t" + output[i][6] );
            }
       }
        System.out.println("Trabajazaso de MRodz ('😉' emoji wink)");
    }
}
// Trabajazaso de MRodz 😉
/*
						
Frecuencias Cardiacas autogeneradas, Prueba de escritorio						
Nombre	Edad	Sesion	Frecuencia	Max.Frecuencia	Frec. Ideal	Max. Tiempo HIIT
kalo	46	1	189.95285	174	87.0-139.2	8.835336
kalo	46	2	188.70502	174	87.0-139.2	22.003372
kalo	46	3	156.29663	174	87.0-139.2	33.946777
kalo	46	4	107.31105	174	87.0-139.2	40.164993
kalo	46	5	151.31554	174	87.0-139.2	19.57388
kalo	46	6	149.73938	174	87.0-139.2	29.263815
kalo	46	7	175.57507	174	87.0-139.2	13.754712

*/