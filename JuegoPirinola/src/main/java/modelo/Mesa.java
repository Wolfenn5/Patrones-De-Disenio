package modelo;

/**
 * Representa la mesa del juego que contiene los frijoles disponibles al momento.
 * Es el medio por el cual se obtienen y se pierden frijoles
 */
public class Mesa 
{
    private int bolsa; // contiene la cantidad de frijoles en la mesa
    
    
    /**
     * Constructor que inicializa la mesa con una cantidad a especificar de frijoles (por regla 10).
     * @param bolsa la cantidad inicial de frijolitos en la mesa
     */
    public Mesa(int bolsa) 
    {
        this.bolsa = bolsa;
    }
    
    
    /**
     * Getter para obtener la cantidad actual de frijoles en la mesa.
     * @return la cantidad de frijoles disponibles
     */
    public int getBolsa() 
    {
        return bolsa;
    }
    
    
    /**
     * Setter para poner una nueva cantidad de frijoles en la mesa.
     * Se usa para reponer frijoles cuando la mesa se llegue a quedar vacia
     * @param bolsa la nueva cantidad de frijolitos
     */
    public void setBolsa(int bolsa) 
    {
        this.bolsa= bolsa;
    }
    
    
    /**
     * La mesa recibe un frijol de un jugador.
     * Suma 1 frijol a la bolsa de la mesa
     * @param valor la cantidad a recibir (1)
     */
    public void ponUno(int valor) 
    {
        this.bolsa= this.bolsa+valor;
    }
    
    
    /**
     * La mesa recibe dos frijoles de un jugador.
     * Suma 2 frijoles a la bolsa de la mesa
     * @param valor la cantidad a recibir (2)
     */
    public void ponDos(int valor) 
    {
        this.bolsa= this.bolsa+valor;
    }
    
    /**
     * La mesa recibe una cantidad de frijoles.
     * Se usa si la pirinola da caras como "Todos ponen" o "Pierdes todo"
     * @param valor la cantidad total de frijolitos a recibir
     */
    public void ponTodo(int valor) 
    {
        this.bolsa= this.bolsa+valor;
    }
    
    /**
     * La mesa da un frijol a un jugador.
     * Si hay frijoles, da uno
     * @return 1 si pudo entregar, 0 si la mesa esta vacia
     */
    public int ponUno() 
    {
        if (bolsa>=1) 
        {
            bolsa= bolsa-1;
            return 1;
        }
        return 0;
    }
    
    
    /**
     * La mesa da dos frijoles a un jugador.
     * Si hay frijoles, da dos
     * @return 1 si pudo entregar, 0 si no hay al menos 2
     */
    public int ponDos() 
    {
        if (bolsa>=2) 
        {
            bolsa= bolsa-2;
            return 2;
        }
        return 0;
    }
    
    
    /**
     * La mesa da todos sus frijoles a un jugador.
     * La mesa da todo lo que tenia al jugador.
     * @return la cantidad total de frijoles que habia en la mesa
     */
    public int tomaTodo() 
    {
        int temp= bolsa;
        bolsa= 0;
        return temp;
    }
    
    
    /**
     * Getter para verificar si la mesa tiene frijoles.
     * @return true si la mesa tiene al menos 1 frijol, false si esta vacia
     */
    public boolean getEstado() 
    {
        return bolsa>0;
    }
    
    
    /**
     * Devuelve en texto del estado de la mesa.
     * @return string que indica la cantidad de frijoles en la mesa
     */
    @Override
    public String toString() 
    {
        return "La mesa tiene " + bolsa + " frijolitos";
    }
}