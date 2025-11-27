/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pluginsSE.movimientos;
import adaptadores.habilidadPlugin;
/**
 *
 * @author rober
 */


// servidor externo -> politica de movimiento
public class dobleSalto implements habilidadPlugin{
    @Override
    public String getNombre() { 
        return "Salto Doble"; 
    }

    @Override
    public void ejecutar(String objetivo) {
        System.out.println("   >> [MOVIMIENTO] ¡Saltando dos veces en el aire!");
    }
}
