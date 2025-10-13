package modelo;

import java.util.ArrayList;
import java.util.Random;

public class Pirinola {
    private ArrayList<Cara> caras;
    private Random random;
    
    public Pirinola(ArrayList<Cara> caras) {
        this.caras = caras;
        this.random = new Random();
    }
    
    public Cara girar() {
        int index = random.nextInt(caras.size());
        return caras.get(index);
    }
    
    @Override
    public String toString() {
        return "Pirinola con " + caras.size() + " caras";
    }
}