/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adaptadores;

/**
 *
 * @author rober
 */


// permite al Cliente acceder a los servicios de los SE
public interface habilidadPlugin {
    String getNombre();
    void ejecutar(String objetivo);
}
