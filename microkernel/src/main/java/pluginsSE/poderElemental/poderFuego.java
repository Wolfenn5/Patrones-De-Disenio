/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pluginsSE.poderElemental;
import adaptadores.habilidadPlugin;
/**
 *
 * @author rober
 */

// servidor externo -> politica de poderElemental
public class poderFuego implements habilidadPlugin {
    @Override
    public String getNombre() { 
        return "Bola de Fuego"; 
    }

    @Override
    public void ejecutar(String objetivo) {
        System.out.println("   >> [FUEGO] Rostizando a " + objetivo + " por 50 HP.");
    }
}
