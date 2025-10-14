package prueba;

import abstractas.JuegoMng;
import modelo.*;
import java.util.ArrayList;




/**
 * Clase principal (que contiene el main) que ejecuta el juego de la pirinola.
 * Extiende JuegoMng y se hacen las implementaciones concretas
 */
public class TestPirinola extends JuegoMng 
{
    
    
    
    /**
     * Constructor que inicia el juego completo.
     * @param jugadores lista de jugadores
     * @param mesa mesa del juego
     * @param pirinola pirinola con sus caras
     */
    public TestPirinola(ArrayList<JugadorH> jugadores, Mesa mesa, Pirinola pirinola) 
    {
        super(jugadores, mesa, pirinola);
    }
    
    
    /**
     * Inicia el juego con un mensaje.
     */
    @Override
    public void jugar() 
    {
        System.out.println("---------------------INICIO JUEGO DE PIRINOLA---------------------");
        jugarPartida();
    }
    
    
    
    /**
     * Ejecuta una partida completa por rondas hasta que haya un ganador.
     * Aparte de manejar la ronda, verifica el estado del juego.
     * Se puso in cierto limite de rondas solo por comodiad al imprimir
     */
    @Override
    public void jugarPartida() 
    {
        int ronda= 1;
        
        while (!hayGanador(jugadores)) 
        {
            System.out.println("\n\n--- Ronda " + ronda + " ---");
            estadoJugadores();
            
            
            // Turno de jugadores
            for (JugadorH jugador : jugadores) 
            {
                if (jugador.getEstado() && !hayGanador(jugadores)) 
                {
                    turno(jugador);
                    System.out.println("----------------");
                }
            }
            ronda++;
            
            
            
            // Verificar si quedan jugadores activos
            // Se puede comentar si no se quieren rondas especificas
            if (ronda>12) 
            { 
                System.out.println("Límite de rondas, FIN");
                break;
            }
        }
        
        
        
        // Verificar si hay ganador
        JugadorH ganador= ganador();
        if (ganador != null) 
        {
            System.out.println("Gana el jugador: " + ganador.getNombre() + " quedo con " + ganador.getBolsa() + " frijoles");
        } 
        else 
        {
            System.out.println("\nNo hay ganador porque quedo mas de un jugador activo");
        }
    }
    
    
    
    /**
     * Hay un ganador cuando solo queda un jugador activo.
     * @return el jugador ganador, o null si no hay exactamente un jugador activo
     */
    @Override
    public JugadorH ganador() 
    {
        JugadorH posibleGanador= null;
        int jugadoresActivos = 0;
        
        
        // Contar los jugadores y ver si hay uno o mas activos
        for (JugadorH jugador : jugadores) 
        {
            if (jugador.getEstado()) 
            {
                jugadoresActivos++;
                posibleGanador = jugador;
            }
        }
        return jugadoresActivos == 1 ? posibleGanador : null; // ternario si queda un solo jugador da true
    }
    
    
    
    
    /**
     * Muestra la informacion  de cada jugador.
     * Nombre
     * Cantidad de frijoles
     * Estado (activo/inactivo)
     */
    @Override
    public void estadoJugadores() 
    {
        System.out.println("Estado de los jugadores:");
        for (JugadorH jugador : jugadores) 
        {
            System.out.println("  " + jugador.toString());
        }
    }
    
    
    @Override
    public boolean hayGanador(ArrayList<JugadorH> jugadores) 
    {
        int jugadoresActivos = 0;
        
        
        for (JugadorH jugador : jugadores) 
        {
            if (jugador.getEstado()) 
            {
                jugadoresActivos++;
            }
        }
        
        // Verificacion de los 3 estados:
        // Mas de 1 jugador activo: juego continúa (false)
        // 1 jugador activo: hay ganador (true)
        // Si ya no hay jugadores activos: juego termina sin ganador (true)
        return jugadoresActivos<=1;
    }
    
    
    
    
    /**
     * Método principal que inicia el juego de pirinola.
     * @param args argumentos de linea de comandos (no se utilizan al momento de ejcutar)
     */
    public static void main(String[] args) 
    {
        // Crear caras de la pirinola
        ArrayList<Cara> caras = new ArrayList<>();
        caras.add(new Cara("Pon uno"));
        caras.add(new Cara("Pon dos"));
        caras.add(new Cara("Toma uno"));
        caras.add(new Cara("Toma dos"));
        caras.add(new Cara("Toma todo"));
        caras.add(new Cara("Pierdes todo"));
        caras.add(new Cara("Todos ponen"));
        
        // Crear "componentes" del juego
        Pirinola pirinola= new Pirinola(caras);
        Mesa mesa= new Mesa(10); // 10 frijoles iniciales
        
        // Crear jugadores
        ArrayList<JugadorH> jugadores= new ArrayList<>();
        int numeroJugadores= 4;
        int frijolesIniciales= 10; 
    
        //jugadores.add(new JugadorH("Yo", 10));
        for (int i = 0; i < numeroJugadores; i++) 
        {
            jugadores.add(new JugadorH("Jugador " + (i + 1), frijolesIniciales));
        }
        
        
        // Iniciar juego
        TestPirinola juego= new TestPirinola(jugadores, mesa, pirinola);
        juego.jugar();
    }
}