package abstractas;

import modelo.JugadorH;
import modelo.Mesa;
import modelo.Pirinola;
import modelo.Cara;
import java.util.ArrayList;



/**
 * Clase abstracta que maneja el juego de la pirinola.
 * Tiene toda la logica del juego y define su estructura como definir la mesa, jugadores y las caras de la pirinola.
 */
public abstract class JuegoMng 
{
    /**
     * Lista de jugadores en el juego.
     * Para manejar los turnos y estado de los jugadores
     */
    protected ArrayList<JugadorH> jugadores;
    /**
     * Mesa del juego.
     * Para poner y tomar frijoles
     */
    protected Mesa mesa;
    /**
     * Pirinola del juego.
     * Tentra acciones para decirle a los jugadores que hacer
     */
    protected Pirinola pirinola;
    
    
    
    
    
    
    
    /**
     * Constructor que inicializa el gestor del juego.
     * @param jugadores lista de jugadores en el juego
     * @param mesa mesa con los 10 frijoles iniciales
     * @param pirinola pirinola con sus caras definidas
     */
    public JuegoMng(ArrayList<JugadorH> jugadores, Mesa mesa, Pirinola pirinola) 
    {
        this.jugadores = jugadores;
        this.mesa = mesa;
        this.pirinola = pirinola;
    }
    
    
    
    
    /**
     * Turno completo para un jugador.
     * Este metodo ejecuta un turno de un jugador,
     * gira la pirinola y ejecuta una accion segun la cara obtenida.
     * @param jugador el jugador en turno
     */
    public void turno(JugadorH jugador) 
    {
        // Para saber toda la informacion del turno
        System.out.println(jugador.getNombre());
        Cara c= pirinola.girar();
        System.out.println(c.getNombre());
        
        
        // Se hace lo que la pirinola diga
        if (c.getNombre().equals("Pon uno")) 
        {
            mesa.ponUno(jugador.ponUno());
        } 
        else if (c.getNombre().equals("Pon dos")) 
        {
            mesa.ponDos(jugador.ponDos());
        } 
        else if (c.getNombre().equals("Toma uno")) 
        {
            jugador.tomaUno(mesa.ponUno());
        } 
        else if (c.getNombre().equals("Toma dos")) 
        {
            jugador.tomaDos(mesa.ponDos());
        } 
        else if (c.getNombre().equals("Toma todo")) 
        {
            jugador.tomaTodo(mesa.tomaTodo());
        } 
        else if (c.getNombre().equals("Pon todo")) 
        {
            mesa.ponTodo(jugador.ponTodo());
        } 
        else if (c.getNombre().equals("Todos ponen"))
        {
            int t=0;
            for (JugadorH jdr : jugadores) 
            {
                t= t+jdr.ponUno();
            }
            mesa.ponTodo(t);
        }
        
        // Revisar si la mesa tiene frijoles o no
        if (mesa.getEstado() == false) 
        {
            System.out.println("La mesa no tiene frijoles, invocando 10 :)");
            mesa.setBolsa(10);
        } else 
        {
            System.out.println("La mesa tiene " + mesa.getBolsa() + " frijolitos");
        }
    }
    
    
    /**
     * Metodo abstracto para iniciar el juego.
     * En el juegoMng se define de forma concreta como se desarrolla el juego
     */
    public abstract void jugar();
    
    /**
     * Metodo abstracto para ejecutar una partida completa hasta que haya un ganador (o con el limite de rondas puesto).
     * Maneja las rondas y turnos de todos los jugadores
     */
    public abstract void jugarPartida();
    
    /**
     * Metodo abstracto para saber si hay un ganador en el juego.
     * Se gana cuando solo queda un jugador activo
     * @return el jugador ganador, o null si aun hay rondas por jugar y hay mas de un jugador activo
     */
    public abstract JugadorH ganador();
    
    /**
     * Metodo abstracto para mostrar el estado actual de todos los jugadores.
     * Muestra nombre, cantidad de frijoles y estado (activo o inactivo)
     */
    public abstract void estadoJugadores();
    
    /**
     * Metodo abstracto para terminar el juego (con ganador o no).
     * El juego termina cuando queda 1 jugador o se pasaron las rondas
     * @param jugadores la lista de jugadores a verificar
     * @return true si hay un ganador o no quedan jugadores activos, false si no
     */
    public abstract boolean hayGanador(ArrayList<JugadorH> jugadores);
}