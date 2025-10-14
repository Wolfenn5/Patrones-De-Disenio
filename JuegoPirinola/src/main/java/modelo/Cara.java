package modelo;



/**
 * Indica una cara de la pirinola con una accion.
 * Al girar la pirinola muestra una cara y una accion a hacer
 */
public class Cara 
{
    
    private String nombre; // "pon uno", "todos ponen" ...
    
    
    /**
     * Constructor que crea una nueva cara con un nombre.
     * @param nombre el nombre de una cara y su acicon como todos ponen, pierdes todo etc.
     */
    public Cara(String nombre) 
    {
        this.nombre = nombre;
    }
    
    
    /**
     * Getter para obtener la accin que representa una cara.
     * @return el nombre de la cara
     */
    public String getNombre() 
    {
        return nombre;
    }
    
    
    /**
     * Devuelve el string de la cara.
     * @return el nombre de la cara como un string
     */
    @Override
    public String toString() {
        return nombre;
    }
}