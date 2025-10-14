package modelo;

import java.util.ArrayList;
import java.util.Random;





/**
 * Representa la pirinola del juego y sus caras/acciones.
 * Simula el girar de una pirinola.
 */
public class Pirinola 
{
    private ArrayList<Cara> caras; // lista de caras
    private Random random;
    
    
    /**
     * Constructor que crea una pirinola con las caras.
     * @param caras la lista de caras de la pirinola
     */
    public Pirinola(ArrayList<Cara> caras) 
    {
        this.caras= caras;
        this.random= new Random();
    }
    
    
    /**
     * Simula el giro de la pirinola.
     * Con random se "gira" para obtener una cara
     * @return una cara aleatoria de la lista
     */
    public Cara girar() 
    {
        int index= random.nextInt(caras.size());
        return caras.get(index);
    }
    
    

}