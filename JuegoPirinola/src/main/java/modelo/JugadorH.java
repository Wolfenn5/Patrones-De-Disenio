package modelo;

import abstractas.Jugador;

public class JugadorH extends Jugador {
    private String nombre;
    
    public JugadorH(String nombre, int bolsa) {
        super(bolsa);
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    @Override
    public int getBolsa() {
        return bolsa;
    }
    
    @Override
    public boolean getEstado() {
        return estado && bolsa > 0;
    }
    
    @Override
    public int ponUno() {
        if (bolsa >= 1 && estado) {
            bolsa -= 1;
            return 1;
        } else {
            estado = false;
            return 0;
        }
    }
    
    @Override
    public int ponDos() {
        if (bolsa >= 2 && estado) {
            bolsa -= 2;
            return 2;
        } else {
            estado = false;
            return 0;
        }
    }
    
    @Override
    public int ponTodo() {
        if (estado) {
            int temp = bolsa;
            bolsa = 0;
            estado = false;
            return temp;
        }
        return 0;
    }
    
    @Override
    public void tomsUno(int val) {
        if (estado) {
            bolsa += val;
        }
    }
    
    @Override
    public void tomsDos(int val) {
        if (estado) {
            bolsa += val;
        }
    }
    
    @Override
    public void tomsTodo(int val) {
        if (estado) {
            bolsa += val;
        }
    }
    
    @Override
    public String toString() {
        return nombre + " tiene " + bolsa + " frijolitos - " + 
               (estado ? "ACTIVO" : "INACTIVO");
    }
}