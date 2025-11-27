/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente;
import microkernel.motor;
import adaptadores.render;
import pluginsSE.poderElemental.poderAgua;
import pluginsSE.poderElemental.poderFuego;
// congelacion criogenica
import pluginsSE.movimientos.dobleSalto;
// volador de papantla


/**
 *
 * @author rober
 */
public class main {
    public static void main(String[] args) {
        
        // instanciar el microkernel
        motor motor = new motor();
        motor.iniciarSistema();

        
        
        
        // configuracion del cliente (instalar los SE)
        motor.registrarHabilidad(new poderFuego());
        motor.registrarHabilidad(new poderAgua());
        motor.registrarHabilidad(new dobleSalto());

        
        
        // renderizar (plugin SI simulado)
        motor.setRenderizador(new render() {
            @Override
            public void renderizar() {
                System.out.println("[pluginSI (Graficos)]: Dibujando escenario 3D...");
            }
        });

        
        
        
        // el cliente usa el sistema sin saber detalles de los plugins
        motor.procesarTurno("Boss Heraldo renacido");
    }
}
