package abstractas;

public abstract class Jugador {
    protected int bolsa; // frijoles
    protected boolean estado; // true para activo
    
    public Jugador(int bolsaInicial) {
        this.bolsa = bolsaInicial;
        this.estado = true;
    }
    
    public abstract int getBolsa();
    public abstract boolean getEstado();
    public abstract int ponUno();
    public abstract int ponDos();
    public abstract int ponTodo();
    public abstract void tomsUno(int val);
    public abstract void tomsDos(int val);
    public abstract void tomsTodo(int val);
    
    
    
}