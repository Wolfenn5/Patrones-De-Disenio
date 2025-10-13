package prueba;

import abstractas.JuegoMng;
import modelo.*;
import java.util.ArrayList;

public class TestPirinola extends JuegoMng {
    
    public TestPirinola(ArrayList<JugadorH> jugadores, Mesa mesa, Pirinola pirinola) {
        super(jugadores, mesa, pirinola);
    }
    
    @Override
    public void jugar() {
        System.out.println("=== INICIANDO JUEGO DE PIRINOLA ===");
        jugarPartida();
    }
    
    @Override
    public void jugarPartida() {
        int ronda = 1;
        
        while (!hayGanador(jugadores)) {
            System.out.println("\n--- Ronda " + ronda + " ---");
            estadoJugadores();
            
            for (JugadorH jugador : jugadores) {
                if (jugador.getEstado() && !hayGanador(jugadores)) {
                    turno(jugador);
                    System.out.println("---");
                }
            }
            ronda++;
            
            // Verificar si quedan jugadores activos
            if (ronda > 12) { // nomas porque si
                System.out.println("Límite de rondas alcanzado");
                break;
            }
        }
        
        JugadorH ganador = ganador();
        if (ganador != null) {
            System.out.println("\n¡¡¡FELICIDADES!!!");
            System.out.println("GANADOR: " + ganador.getNombre() + " con " + ganador.getBolsa() + " frijolitos");
        } else {
            System.out.println("\nEl juego terminó sin ganadores");
        }
    }
    
    @Override
    public JugadorH ganador() {
        JugadorH posibleGanador = null;
        int jugadoresActivos = 0;
        
        for (JugadorH jugador : jugadores) {
            if (jugador.getEstado()) {
                jugadoresActivos++;
                posibleGanador = jugador;
            }
        }
        
        return jugadoresActivos == 1 ? posibleGanador : null;
    }
    
    @Override
    public void estadoJugadores() {
        System.out.println("Estado de los jugadores:");
        for (JugadorH jugador : jugadores) {
            System.out.println("  " + jugador.toString());
        }
    }
    
    @Override
    public boolean hayGanador(ArrayList<JugadorH> jugadores) {
        int jugadoresActivos = 0;
        
        for (JugadorH jugador : jugadores) {
            if (jugador.getEstado()) {
                jugadoresActivos++;
            }
        }
        
        // Verificación de los 3 estados:
        // - Más de 1 jugador activo: juego continúa (false)
        // - Exactamente 1 jugador activo: hay ganador (true)
        // - 0 jugadores activos: juego termina sin ganador (true)
        return jugadoresActivos <= 1;
    }
    
    public static void main(String[] args) {
        // Crear caras de la pirinola
        ArrayList<Cara> caras = new ArrayList<>();
        caras.add(new Cara("Pon uno"));
        caras.add(new Cara("Pon dos"));
        caras.add(new Cara("Toma uno"));
        caras.add(new Cara("Toma dos"));
        caras.add(new Cara("Toma todo"));
        caras.add(new Cara("Pierdes todo"));
        caras.add(new Cara("Todos ponen"));
        
        // Crear componentes del juego
        Pirinola pirinola = new Pirinola(caras);
        Mesa mesa = new Mesa(10);
        
        // Crear jugadores
        ArrayList<JugadorH> jugadores = new ArrayList<>();
        int numeroJugadores = 4;
        int frijolesIniciales = 10; 
    
        //jugadores.add(new JugadorH("Yo", 10));
        for (int i = 0; i < numeroJugadores; i++) 
        {
            jugadores.add(new JugadorH("Jugador " + (i + 1), frijolesIniciales));
        }
        
        
        // Iniciar juego
        TestPirinola juego = new TestPirinola(jugadores, mesa, pirinola);
        juego.jugar();
    }
}