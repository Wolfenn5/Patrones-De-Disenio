package abstractas;




/**
 * Esta es la clase abstracta que representa un jugador.
 * En si define la estructura base y comportamiento que todos los jugadores deben implementar y por eso es abstracto
 * El jugador (jugadores) tiene una bolsa de frijoles y un estado (activo/inactivo) en donde true indicara que el jugador esta activo y false para inactivo (salio del juego)
 */
public abstract class Jugador 
{
    protected int bolsa;
    protected boolean estado;
    
    
    /**
     * Constructor que inicializa un jugador con 10 frijoles.
     * Todos los jugadores comienzan en estado activo (true)
     * @param bolsaInicial es la cantidad inicial de frijolitos para el jugador
     */
    public Jugador(int bolsaInicial) 
    {
        this.bolsa= bolsaInicial;
        this.estado= true;
    }
    
    
    
    /**
     * Getter que obtiene la cantidad actual de frijoles en la bolsa del jugador activo.
     * Para verificar si un jugador aun tiene frijoles
     * @return true si el jugador esta activo, false para inactivo
     */
    public abstract int getBolsa();
    
    
    
    
    /**
     * Getter que verifica si el jugador está activo y puede seguir jugando.
     * Un jugador está activo si tiene estado true y al menos 1 frijolito
     * @return true si el jugador esta activo, false si no
     */
    public abstract boolean getEstado();
    
    
    
    /**
     * Setter para que el jugador ponga un frijol en la mesa.
     * Si no puede poner (no tiene frijoles), debe actualizar su estado
     * @return 1 si pudo poner el frijol, 0 si no
     */
    public abstract int ponUno();
    
    
    
    /**
     * Setter para que el jugador ponga dos frijoles en la mesa.
     * Si no puede poner (no tiene frijoles), debe actualizar su estado
     * @return 2 si pudo poner los frijolitos, 0 si no pudo
     */
    public abstract int ponDos();
    
    
    
    /**
     * Setter para que el jugador pierda todos sus frijoles.
     * Se actualiza su estado como inactivo (false)
     * @return la cantidad de frijoles que perdio el jugador
     */
    public abstract int ponTodo();
    
    
    
    /**
     * Setter para que el jugador tome un frijol de la mesa.
     * Si el jugador esta activo, toma un frijol de la mesa y lo agrega a su bolsa
     * @param val la cantidad de frijoles a tomar (en este metodo abstracto sera 1 frijol)
     */
    public abstract void tomaUno(int val);
    
    
    
    /**
     * Setter para que el jugador tome dos frijoles de la mesa y los agrega a su bolsa.
     * Si el jugador esta activo, toma dos frijoles de la mesa y los agrega a su bolsa
     * @param val la cantidad de frijoles a tomar (en este metodo abstracto seran 2 frijoles)
     */
    public abstract void tomaDos(int val);
    
    
    
    /**
     * El jugador toma todos los frijolitos disponibles de la mesa.
     * Si el jugador esta activo, toma todos frijoles de la mesa y los agrega a su bolsa
     * @param val la cantidad total de frijoles que se tomsron de la mesa
     */
    public abstract void tomaTodo(int val);
}