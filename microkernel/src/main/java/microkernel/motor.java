/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package microkernel;
import pluginsSI.gestorRecursos;
import adaptadores.habilidadPlugin;
import adaptadores.render;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author rober
 */



// MICROKERNEL
// implementa servicios y coordina la comunicación entre los plugins
public class motor {
    private final gestorRecursos resources; // acceso al servidor interno
    private final List<habilidadPlugin> habilidades;
    private render renderizador;

    
    
    public motor() {
        this.resources = new gestorRecursos();
        this.habilidades = new ArrayList<>();
    }

    
    
 
    public void iniciarSistema() {
        System.out.println(">>> INICIANDO MICROKERNEL (REAL ENGINE 4) <<<");
        resources.cargarRecursos();
    }

    
    
    // "socket" para plugins
    public void registrarHabilidad(habilidadPlugin habilidad) {
        habilidades.add(habilidad);
        System.out.println("[adaptadores]: Plugin registrado -> " + habilidad.getNombre());
    }

    
    
    
    public void setRenderizador(render render) {
        this.renderizador = render;
        System.out.println("[pluginSI (recursos)]: Motor grafico establecido.");
    }

    
    
    

    public void procesarTurno(String enemigo) {
        System.out.println("\n--- Nuevo Turno ---");
        
        
        if (renderizador != null) { // si se llega a tener un plugin de graficos
            renderizador.renderizar(); 
        }
        
        

        System.out.println("[Kernel]: Procesando habilidades del personaje...");
        for (habilidadPlugin h : habilidades) {
            h.ejecutar(enemigo);
        }
    }
}
