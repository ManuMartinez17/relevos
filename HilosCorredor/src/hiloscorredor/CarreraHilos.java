/*
 * Clase Thread
 */
package hiloscorredor;

import static java.lang.Thread.sleep;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tania Martinez
 * @since 15/04/2021
 */
public class CarreraHilos extends Thread {
    //Atributos de la clase
    
    private int posicionHilo;
    Equipo equipo;
    private int distancia;
/**
 * Constructor de la clase carreraHilos en donde se inicializan las variables
 * @param posicionHilo donde inicia cada hilo
 * @param equipo cada corredor se identificara con un equipo
 * @param distancia numero aleatorio
 */
    public CarreraHilos(int posicionHilo, Equipo equipo) {
        this.posicionHilo = posicionHilo;
        this.equipo = equipo;
    }
 
 // Metodo de arranque de todos los hilos corredores
    @Override    
    public void run() {
        distanciaRecorridaCorredor1();
        distanciaRecorridaCorredor2();
        distanciaRecorridaCorredor3();

    }
   // Metodo que genera numeros aleatorios para que la distancia nunca sea la misma
    public int generaNumeroAleatorio() {
        int num = ThreadLocalRandom.current().nextInt(0, 50 + 1);
        if (num >= 0 && num <= 20) {
            num = 5;
        } else if (num >= 20 && num <= 50) {
            num = 1;
        } else {
            num = 1;
        }
        return num;
    }
   // Metodo para los corredores numero 1 de cada equipo
    private synchronized int distanciaRecorridaCorredor1() {
        if (posicionHilo == 0) {
            for (int i = 0; i <= 33; i++) {
                try {
                    distancia = generaNumeroAleatorio();
                    this.equipo.setPasoCorredor1(this.equipo.getPasoCorredor1() + distancia);
                    Thread.sleep(500);
                    if (this.equipo.getPasoCorredor1() + distancia >= 33) {
                        this.equipo.setPasoCorredor1(33);
                        break;
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(CarreraHilos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            synchronized (this.equipo) {
                this.equipo.notifyAll();
            }
        } else {
            hiloEspera();
        }
        equipo.setPosicion(equipo.getPosicion() + distancia);
        return equipo.getPosicion();
    }
    // Metodo para los corredores numero 2 de cada equipo
    private synchronized int distanciaRecorridaCorredor2() {
        if (posicionHilo == 33) {           
            for (int i = 33; i <= 66; i++) {
                try {
                    distancia = generaNumeroAleatorio();
                    this.equipo.setPasoCorredor2(this.equipo.getPasoCorredor2() + distancia);
                    Thread.sleep(500);
                    if (this.equipo.getPasoCorredor2() + distancia >= 66) {
                        this.equipo.setPasoCorredor2(66);
                        break;
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(CarreraHilos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            synchronized (this.equipo) {
                this.equipo.notifyAll();
            }
        } else {
            hiloEspera();
        }
        equipo.setPosicion(equipo.getPosicion() + distancia);
        return equipo.getPosicion();
    }
    // Metodo para los corredores numero 3 de cada equipo
    private synchronized int distanciaRecorridaCorredor3() {  
    if (posicionHilo == 66) {
            for (int i = 66; i <= 100; i++) {
                try {
                    distancia = generaNumeroAleatorio();
                    this.equipo.setPasoCorredor3(this.equipo.getPasoCorredor3() + distancia);
                    Thread.sleep(500);
                    if (this.equipo.getPasoCorredor3() + distancia >= 100) {
                        this.equipo.setPasoCorredor3(100);
                        break;
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(CarreraHilos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            synchronized (this.equipo) {
                this.equipo.notifyAll();
            }
        } else {
            hiloEspera();
        }
        equipo.setPosicion(equipo.getPosicion() + distancia);
        return equipo.getPosicion();
    }
    // Metodo para poner en espera cada hilo de los corredores
    private void hiloEspera() {
        synchronized (this.equipo) {
            try {
                this.equipo.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(CarreraHilos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
}
