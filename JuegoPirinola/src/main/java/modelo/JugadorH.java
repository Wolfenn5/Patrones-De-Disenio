package modelo;

import abstractas.Jugador;




/**
 * Implementación concreta de un jugador.
 * Extiende la clase abstracta Jugador y se implementan los metodos,
 * específica todas las acciones que un jugador puede hacer.
 */
public class JugadorH extends Jugador 
{
    private String nombre;
    
    
    /**
     * Constructor que crea un jugador con nombre y frijoles iniciales.
     * @param nombre el nombre del jugador
     * @param bolsa la cantidad inicial de frijoles
     */
    public JugadorH(String nombre, int bolsa) 
    {
        super(bolsa);
        this.nombre= nombre;
    }
    
    
    /**
     * Getter para obtener el nombre del jugador.
     * @return el nombre  del jugador
     */
    public String getNombre() 
    {
        return nombre;
    }
    
    
    /**
     * Getter para obtener el estado de la bolsa.
     * @return el estado de la bolsa
     */
    @Override
    public int getBolsa() 
    {
        return bolsa;
    }
    
    
    /**
     * Getter de si un jugador esta activo (true) y tiene al menos 1 frijol.
     */
    @Override
    public boolean getEstado() 
    {
        return estado && bolsa>0;
    }
    
    
    /**
     * Metodo para poner un frijol en la mesa
     * Si el jugador no puede poner un frijol, se marca como inactivo
     */
    @Override
    public int ponUno() 
    {
        if (bolsa>=1 && estado) 
        {
            bolsa= bolsa-1;
            return 1;
        } 
        else 
        {
            estado= false;
            return 0;
        }
    }
    
    
    /**
     * Metodo para poner dos frijoles en la mesa
     * Si el jugador no puede poner, se marca como inactivo
     */
    @Override
    public int ponDos() 
    {
        if (bolsa>=2 && estado) 
        {
            bolsa= bolsa-2;
            return 2;
        } 
        else 
        {
            estado= false;
            return 0;
        }
    }
    
    
    /**
     * Metodo para poner todos los frijoles en la mesa
     * El jugador pierde todos sus frijoles y se marca como inactivo
     */
    @Override
    public int ponTodo() 
    {
        if (estado) 
        {
            int temp= bolsa;
            bolsa= 0;
            estado= false;
            return temp;
        }
        return 0;
    }
    
    
    /**
     * Metodo para tomar un frijol de la mesa
     * Si el jugador esta activo, recibe un frijol
     */
    @Override
    public void tomaUno(int val) 
    {
        if (estado) 
        {
            bolsa= bolsa+val;
        }
    }
    
    
    /**
     * Metodo para tomar dos frijoles de la mesa
     * Si el jugador esta activo, recibe dos frijoles
     */
    @Override
    public void tomaDos(int val) 
    {
        if (estado) 
        {
            bolsa= bolsa+val;
        }
    }
    
    
    /**
     * Metodo para tomar todos los frijoles de la mesa
     * Si el jugador esta activo, recibe todos los frijoles
     */
    @Override
    public void tomaTodo(int val) 
    {
        if (estado) 
        {
            bolsa= bolsa+val;
        }
    }
    
    
    /**
     * Devuelve en texto el estado del jugador.
     * Como el nombre, cantidad de frijoles y estado (activo/inactivo).
     * @return string con la informacion completa del jugador
     */
    @Override
    public String toString() 
    {
        return nombre + " tiene " + bolsa + " frijolitos - " + (estado ? "ACTIVO" : "INACTIVO"); // con ternario para escribirlo en una osla linea
    }
}