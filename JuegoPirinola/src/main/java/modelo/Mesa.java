package modelo;

public class Mesa {
    private int bolsa;
    
    public Mesa(int bolsa) {
        this.bolsa = bolsa;
    }
    
    public int getBolsa() {
        return bolsa;
    }
    
    public void setBolsa(int bolsa) {
        this.bolsa = bolsa;
    }
    
    public void tomalno(int valor) {
        this.bolsa += valor;
    }
    
    public void tomalos(int valor) {
        this.bolsa += valor;
    }
    
    public void tomaloo(int valor) {
        this.bolsa += valor;
    }
    
    public int ponUno() {
        if (bolsa >= 1) {
            bolsa -= 1;
            return 1;
        }
        return 0;
    }
    
    public int ponDos() {
        if (bolsa >= 2) {
            bolsa -= 2;
            return 2;
        }
        return 0;
    }
    
    public int pierdesTodo() {
        int temp = bolsa;
        bolsa = 0;
        return temp;
    }
    
    public boolean getEstado() {
        return bolsa > 0; // false si la bolsa == 0 (no hay frijoles)
    }
    
    @Override
    public String toString() {
        return "Mesa tiene " + bolsa + " frijolitos";
    }
}