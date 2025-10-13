package abstractas;

import modelo.JugadorH;
import modelo.Mesa;
import modelo.Pirinola;
import modelo.Cara;
import java.util.ArrayList;

public abstract class JuegoMng {
    protected ArrayList<JugadorH> jugadores;
    protected Mesa mesa;
    protected Pirinola pirinola;
    
    public JuegoMng(ArrayList<JugadorH> jugadores, Mesa mesa, Pirinola pirinola) {
        this.jugadores = jugadores;
        this.mesa = mesa;
        this.pirinola = pirinola;
    }
    
    public void turno(JugadorH jugador) {
        System.out.println(jugador.getNombre());
        Cara c = pirinola.girar();
        System.out.println(c.getNombre());
        
        if (c.getNombre().equals("Pon uno")) {
            mesa.tomalno(jugador.ponUno());
        } else if (c.getNombre().equals("Pon dos")) {
            mesa.tomalos(jugador.ponDos());
        } else if (c.getNombre().equals("Toma uno")) {
            jugador.tomsUno(mesa.ponUno());
        } else if (c.getNombre().equals("Toma dos")) {
            jugador.tomsDos(mesa.ponDos());
        } else if (c.getNombre().equals("Toma todo")) {
            jugador.tomsTodo(mesa.pierdesTodo());
        } else if (c.getNombre().equals("Pierdes todo")) {
            mesa.tomaloo(jugador.ponTodo());
        } else {
            int t = 0;
            for (JugadorH jdr : jugadores) {
                t += jdr.ponUno();
            }
            mesa.tomaloo(t);
        }
        
        if (mesa.getEstado() == false) {
            System.out.println("La mesa se ha quedado sin frijolitos, se reponen");
            mesa.setBolsa(10);
        } else {
            System.out.println("La mesa tiene " + mesa.getBolsa() + " frijolitos");
        }
    }
    
    public abstract void jugar();
    public abstract void jugarPartida();
    public abstract JugadorH ganador();
    public abstract void estadoJugadores();
    public abstract boolean hayGanador(ArrayList<JugadorH> jugadores);
}