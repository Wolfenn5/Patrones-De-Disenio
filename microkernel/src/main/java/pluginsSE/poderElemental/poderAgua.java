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
public class poderAgua implements habilidadPlugin {
    @Override
    public String getNombre() { 
        return "Chorro de Agua"; 
    }

    @Override
    public void ejecutar(String objetivo) {
        System.out.println("   >> [AGUA] Mojando a " + objetivo + " (riesgo de congelacion).");
    }
}
