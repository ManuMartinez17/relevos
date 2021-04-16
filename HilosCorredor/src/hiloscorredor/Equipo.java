/*
 * Clase comun para los hilos, en donde se inicializan los pasos de los corredores
 * se declaran las posiciones de los equipos y la meta a la cual llegara los
 * corredores del equipo ganador 
 */
package hiloscorredor;

/**
 *
 * @author Tania Martinez
 * @since 15/04/2021
 */
public class Equipo {
   // Atributos de la clase 
    private int pasoCorredor1;
    private int pasoCorredor2 = 33;
    private int pasoCorredor3 = 66;

    private int posicion;
    private int meta;
    
    int equipo;

    public Equipo(int posicion, int meta) {
        this.posicion = posicion;
        this.meta = meta;
    }
/**
 * Constructor de la clase
 * @param meta punto de llegada de los jugadores
 * @param equipo numero del equipo 
 */
   /**
    * get y set de los atributos del constructor
    * @return 
    */
   
    public int getPosicion() {
        return posicion;
    }
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    public int getMeta() {
        return meta;
    }

    public void setMeta(int meta) {
        this.meta = meta;
    }

    public int getEquipo() {
        return equipo;
    }

    public void setEquipo(int equipo) {
        this.equipo = equipo;
    }

    public int getPasoCorredor1() {
        return pasoCorredor1;
    }

    public void setPasoCorredor1(int pasoCorredor1) {
        this.pasoCorredor1 = pasoCorredor1;
    }

    public int getPasoCorredor2() {
        return pasoCorredor2;
    }

    public void setPasoCorredor2(int pasoCorredor2) {
        this.pasoCorredor2 = pasoCorredor2;
    }

    public int getPasoCorredor3() {
        return pasoCorredor3;
    }

    public void setPasoCorredor3(int pasoCorredor3) {
        this.pasoCorredor3 = pasoCorredor3;
    }

   
}
