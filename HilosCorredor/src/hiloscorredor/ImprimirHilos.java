/*
 * Metodo para imprimir la carrera y su respectivo ganador
 */
package hiloscorredor;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tania Martinez
 * @since 15/04/2021
 */

public class ImprimirHilos extends Thread{
    //Objetos que hacen referencia a cada equipo
    Equipo equipo1;
    Equipo equipo2;
    Equipo equipo3;

    /**
     * Constructor de la clase imprimir hilos
     * @param equipo1
     * @param equipo2
     * @param equipo3 
     */
    public ImprimirHilos(Equipo equipo1, Equipo equipo2, Equipo equipo3) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.equipo3 = equipo3;
    }

    // Metodo para arrancar la impresion de la carrera
    @Override
    public void run() {
        System.out.println("");
        System.out.println("\t\t\t\t\t\t *****RELEVOS*****");
        System.out.println("");
        while (true) {
            
            // For que recorrera la carrera de cada participante del equipo uno
            for (int j = 0; j < 100; j++) {
                if (this.equipo1.getPasoCorredor1() == j) {
                    System.out.print("\u001B[31m" + "♠");
                } else if (this.equipo1.getPasoCorredor2() == j) {
                    System.out.print("\u001B[31m" + "♠");
                } else if (this.equipo1.getPasoCorredor3() == j) {
                    System.out.print("\u001B[31m" + "♠");
                } else {
                    System.out.print("\u001B[31m" + "_");
                }
            }
            // For que recorrera la carrera de cada participante del equipo dos
            System.out.println("");
            for (int k = 0; k < 100; k++) {
                if (this.equipo2.getPasoCorredor1() == k) {
                    System.out.print("\u001B[35m" + "♣");
                } else if (this.equipo2.getPasoCorredor2() == k) {
                    System.out.print("\u001B[35m" + "♣");
                } else if (this.equipo2.getPasoCorredor3() == k) {
                    System.out.print("\u001B[35m" + "♣");
                } else {
                    System.out.print("\u001B[35m" + "_");
                }
            }
            // For que recorrera la carrera de cada participante del equipo tres
            System.out.println("");
            for (int i = 0; i < 100; i++) {
                if (this.equipo3.getPasoCorredor1() == i) {
                    System.out.print("\u001B[34m" + "♦");
                } else if (this.equipo3.getPasoCorredor2() == i) {
                    System.out.print("\u001B[34m" + "♦");
                } else if (this.equipo3.getPasoCorredor3() == i) {
                    System.out.print("\u001B[34m" + "♦");
                } else {
                    System.out.print("\u001B[34m" + "_");
                }
            }
            try {
                System.out.println(" ");
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(ImprimirHilos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            /* Se le asigna a una variable el paso del ultimo corredor de cada equipo
            con el fin de determinar que equipo fue el que gano.
            */
 
            int valor1 = equipo1.getPasoCorredor3();
            int valor2 = equipo2.getPasoCorredor3();
            int valor3 = equipo3.getPasoCorredor3();

            // Comparaciones para evaluar el ganador de la carrera
            if (valor1 == 100) {
                System.out.println("");
                System.out.println("\t\t\t\t\t *****RESULTADOS*****");
                System.out.println("");
                System.out.println("\u001B[31m" + " \tEQUIPO GANADOR ROJO 1: " + " ♠ ");
                break;
            } else if (valor2 == 100) {
                System.out.println("");
                System.out.println("\t\t\t\t\t *****RESULTADOS*****");
                System.out.println("");
                System.out.println("\u001B[35m" + " \tEQUIPO GANADOR MORADO 2: " + " ♣ ");
                break;
            } else if (valor3 == 100) {
                System.out.println("");
                System.out.println("\t\t\t\t\t *****RESULTADOS*****");
                System.out.println("");
                System.out.println("\u001B[34m" + "\tEQUIPO GANADOR AZUL 3: " + " ♦ ");
                break;
            }
        }

    }

}
