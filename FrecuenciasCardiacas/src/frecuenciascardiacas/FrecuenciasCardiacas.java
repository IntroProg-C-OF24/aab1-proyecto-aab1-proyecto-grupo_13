
package frecuenciascardiacas;
import java.util.Scanner;
//import java.time.YearMonth;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

// Upper Camel Class
public class FrecuenciasCardiacas {
    
    public static void main(String[] args) {
       // Lower Camel Class (since method: main)
       int sesiones, nSesion=1, year,currentYear, age;
       float $PulseRate, $maxPulseRate, $idealPulseRateLow, $idealPulseRateHigh, hiit;
       String name, date, date3, today3, idealPulseRange;
       // Iniciar scanner
       Scanner sc = new Scanner (System.in);
       // Determinar periodo
        System.out.println("Cuantas veces a la semana usted se ejercita?");
        sesiones = sc.nextInt();
       //Comenzar Programa
       System.out.println("Coloque su nombre: ");
       name = sc.next();
       System.out.println("Coloque su dia, mes y año de nacimiento (dd/MM/AAAA)");
       //day= sc.nextInt(); month=sc.nextInt(); year=sc.nextInt();
       date = sc.next();
       date3 = date.replaceAll("\\d+{2}\\D+{2}","");
       year = Integer.parseInt(date3);
       //Ahora importamos la fecha actual (java.util.Date)
       Date today = new Date();
       // El todayFormat solo es el formato para la fecha compleja que la utilidad de java (java.util.date) nos da por defecto.
       SimpleDateFormat todayFormat = new SimpleDateFormat("dd/MM/Y");
       String todayString = todayFormat.format(today);
       
       today3 = todayString.replaceAll("\\d+{2}\\D+{2}","");
       currentYear = Integer.parseInt(today3);
       // Sacamos edad en años de la persona
       age = currentYear-year;
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
       System.out.println("Ingrese su frecuencia cardiaca en su sesion "+nSesion+" de ejercicio: (solo numero)");
       $PulseRate= sc.nextFloat();
       $maxPulseRate = 220-age;
       $idealPulseRateLow = (float) ($maxPulseRate*0.5);
       $idealPulseRateHigh= (float) ($maxPulseRate*0.8);
        System.out.println("");
        System.out.println("Su frecuencia cardiaca maxima es: "+$maxPulseRate);
        // English: bpm ; Español: lpm. Latidos por minuto
        idealPulseRange = Float.toString($idealPulseRateLow)+"-"+Float.toString($idealPulseRateHigh);
        System.out.println("Su frecuencia cardiaca esperada o ideal es desde: "+$idealPulseRateLow+" lpm hasta "+$idealPulseRateHigh+" lpm");
        System.out.println("");
        System.out.println("Cuantos minutos sin descanso resistio de Ejercicio de Alta Intensidad");
        hiit = sc.nextFloat();
        //final String report1 = "Frecuencia en sesion "+nSesion+": "+$PulseRate+", frecuencia cardiaca maxima: "+$maxPulseRate+", frecuencia cardiaca ideal: "+$idealPulseRateLow+"-"+$idealPulseRateHigh+" lpm";
        //System.out.println(report1);
        
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
        System.out.println("Trabajazaso de MRodz 😉");
    }
}
// Trabajazaso de MRodz 😉
/*
Frecuencias Cardiacas, Prueba de escritorio						
Nombre	Edad	Sesion	Frecuencia	Max.Frecuencia	Frec. Ideal	Max. Tiempo HIIT
Alberto	26	1	150	194	97.0-155.2	15
Alberto	26	2	126	194	97.0-155.2	20
Alberto	26	3	190	194	97.0-155.2	5
*/