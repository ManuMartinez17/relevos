/*
 * Juego de relevos en donde se tiene tres equipos
 * 1Equipo: Rojo   2Equipo: Morado  3Equipo:Azul
 * cada equipo cuenta con 3 jugadores y al terminar 
 * la carrera el programa le dira cual fue el ganador
 */
package hiloscorredor;

/**
 *
 * @author Tania Martinez
 * @since 15/04/2021
 */
public class HilosCorredor {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {        
       
        // Se realizan las instancias
        
        Equipo primero = new Equipo(1, 100);
        Equipo segundo = new Equipo(2, 100);
        Equipo tercero = new Equipo(3, 100);
        // Se crean los objetos
        
        CarreraHilos jugador1 = new CarreraHilos(0, primero);
        CarreraHilos jugador2 = new CarreraHilos(33, primero);
        CarreraHilos jugador3 = new CarreraHilos(66, primero);
        CarreraHilos jugador4 = new CarreraHilos(0, segundo);
        CarreraHilos jugador5 = new CarreraHilos(33, segundo);
        CarreraHilos jugador6 = new CarreraHilos(66, segundo);
        CarreraHilos jugador7 = new CarreraHilos(0, tercero);
        CarreraHilos jugador8 = new CarreraHilos(33, tercero);
        CarreraHilos jugador9 = new CarreraHilos(66, tercero);
        
        //Se realiza instancia del hilo imprimir
        ImprimirHilos  imprimir = new ImprimirHilos(primero,segundo,tercero);
        
        //Se inician los hilos de los corredores
        jugador1.start();
        jugador4.start();
        jugador7.start();
        jugador2.start();
        jugador5.start();
        jugador8.start();
        jugador3.start();
        jugador6.start();
        jugador9.start();
        
        //Se inicia el hilo para imprimir
        imprimir.start();

    }

}
