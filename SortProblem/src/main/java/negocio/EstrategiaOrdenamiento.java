package negocio;

/**
 * Interfaz para las estrategias de ordenamiento la cual utiliza el Patrón Strategy.
 * Los algoritmos de ordenamiento deben implementar esta interfaz ya que por default, el metodo ordenar es abstracto en la interfaz.
 */
public interface EstrategiaOrdenamiento {
    void ordenar(int[] numeros);
}
