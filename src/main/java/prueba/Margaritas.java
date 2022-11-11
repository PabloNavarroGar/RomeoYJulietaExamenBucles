/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prueba;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author pablo
 */
public class Margaritas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //variable para que aparezcan en el main por el return
        int flores;
        int numeroDeHojas;
        int random;
        int dado = 0;
        String texto = "";

        String repeticionPrograma = "";
        //Todo los metodos en un bucle do while para que la cuando salga la 
        //pregunta de repetir el programa al decir si se vuelva a repetir
        do {
            flores = numeroDeMargaritas();
            numeroDeHojas = numeroHojasPorCadaMargarita(flores);
            random = generarTiradasDado(dado);
            texto = quererNoquerer(dado);
            repeticionPrograma = repeticionPrograma();
        } while (repeticionPrograma.equalsIgnoreCase("Si"));
    }

    public static int numeroDeMargaritas() {
        //metodo para pedir un numero entero que son las Margartias, mediando consola
        //y con un filtro para que sea de 1 a 10 
        Scanner teclado = new Scanner(System.in);
        int margaritas = 0;

        do {
            try {
                System.out.println("Romeo, cuantas margaritas tienes(entre 1 y 10)");

                margaritas = teclado.nextInt();

                System.out.println(" Las margaritas que has cogido son " + margaritas);

            } catch (InputMismatchException ime) {
                System.out.println("Dato Invalido,vuelva a introducirlo");
                teclado.nextLine();
            }
        } while (!filtradoMargaritas(margaritas));
        return margaritas;

    }

    public static boolean filtradoMargaritas(double hojas) {
        //Filtado de las hojas(flores) que coge romeo
        return (hojas >= 1 && hojas <= 10);

    }

    public static int numeroHojasPorCadaMargarita(int margaritas) {
        //Por cada hoja que se pide, se hace un for con contador puesto en +1 
        //para que salga la primera flor en 1 y asi sucesivamente
        Scanner teclado = new Scanner(System.in);
        int petalos = 0;
        int contador = 1;
        for (int i = 0; i < margaritas; i++) {

            System.out.println("¿Cuantos petalos tiene la margarita numero " + contador++ + " ?");
            petalos = teclado.nextInt();
        }
        return petalos;
    }

    public static int generarTiradasDado(int dado) {
        //Clase random para generar un numero random
        Random numeroAleatorio = new Random();
        //El int de la maquina se iguala al numero random con un next Int para que sea int
        //y 6 y fuera del parentesiss +1 para que pille los 6, si no seria hasta 5
        dado = numeroAleatorio.nextInt(6) + 1;
        System.out.println("El numero que ha salido del dado es : " + dado);

        //bucle con do while con la condicion que si sale 3 vuelva a tirar , 
        //con la condicion dre que si el numero que sale es par,
        //empiece con mequiere, si no empieza "no me quiere"
        do {
            if (dado % 2 == 0) {

                System.out.println("Empieza con 'me quiere' ");

            } else {
                System.out.println(" Empieza con 'no me quiere");
            }
            //Aqui si sale el 3 como en la condicion de abajo vuelve a tirar 
            //hasta que salga un numero que no sea 3
            if (dado == 3) {
                System.out.println("No me gusta el 3 vuelvo a tirar");

                dado = numeroAleatorio.nextInt(6) + 1;

                System.out.println("El numero que ha vuelto a salir tras volver a "
                        + "tirar es  : " + dado);
                if (dado % 2 == 0) {
                    System.out.println("Empieza con 'me quiere' ");

                } else {
                    System.out.println(" Empieza con 'no me quiere");

                }
            }

        } while (dado == 3);
        return dado;
    }

    public static String quererNoquerer(int dado) {
        //String con el resulltado de que dado el numero del daño que ayamos sacado 
        //si es par o impar
        //terminara cogiendo una opcion u otra
        //por razones que no se siempre acaba pillando Termina queriendomse no se si esta bien o mal
  
        return (dado % 2 == 0?" Mequiere":"No me quiere");
    }

    public static String repeticionPrograma() {
        boolean repetir = true;
        String texto = "";
        Scanner teclado = new Scanner(System.in);
        //pequeño menu que sale al final que nos miestra si queremos repetir la operacion.
        //admitira si y no

        do {

            try {
                texto = """
                     Quieres repetir el programa?
                     
                     Escribe "si", si quieres repetir.
                     Escribe "no", si quieres salir. 
                     
                     """;
                System.out.println(texto);

                texto = teclado.nextLine();
                  repetir=false;
            } catch (ArrayIndexOutOfBoundsException ime) {
                System.out.println("Error, vuelve a escribir las opciones correctas");

            }
                //Por estar acostumbrado a JOpntion no me sale como poner que si pongo otra opcion no la admite,
                //se que a lo mejor el fallo es muy tonto pero no me sale vico, sorry
            return texto;
        } while (repetir);

    }

}
