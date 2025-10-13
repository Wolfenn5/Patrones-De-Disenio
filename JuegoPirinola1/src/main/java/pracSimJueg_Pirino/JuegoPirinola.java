//Práctica: Implementación del simulador del juego de la pirinola

package pracSimJueg_Pirino;

import java.util.Random;

public class JuegoPirinola 

{
    public static void main(String[] args) 
    {
        Random tiro_azar= new Random();
        String caras []= 
        {
            "Toma uno", 
            "Toma dos", 
            "Toma todo",
            "Pon uno", 
            "Pon dos", 
            "Pon todo",
            "Todos ponen"
        };



        // Condiciones iniciales
        int frijoles_jugador []= {20, 20, 20, 20}; // frijoles iniciales de cada jugador
        int mesa=10; // frijoles iniciales en la mesa
        int jugadores_activos= 4; // se dira que el orden de turno de los jugadores sera de forma secuencial como se recorra el arreglo
        int numero_jugador= 0; // indice para saber que jugador tiene el turno actual




        while (jugadores_activos>1) 
        {
            if (frijoles_jugador[numero_jugador]>0) // si el jugador actual tiene frijoles
            {
                int indice_cara= tiro_azar.nextInt(caras.length); // random entre 0 y el numero de caras, pirinola
                String cara= caras[indice_cara]; // seleccionar que cara al azar salio
                System.out.println("El jugador " + (numero_jugador + 1) + " gira la pirinola y le sale: " + cara);


                if (cara.equals("Toma uno")) 
                {
                    if (mesa>=1) 
                    {
                        mesa= mesa-1;
                        frijoles_jugador[numero_jugador]= frijoles_jugador[numero_jugador] + 1; // el jugador x recibe 1 frijol
                    }

                } 

                else if (cara.equals("Toma dos")) 
                {
                    int toma= 2;
                    if (mesa<2) 
                    {
                        toma= mesa; // si hay menos de 2, se toma lo que haya en la mesa
                    }
                    mesa= mesa-toma; // se quitan
                    frijoles_jugador[numero_jugador]= frijoles_jugador[numero_jugador] + toma; // el jugador x recibe "toma" frijoles
                } 

                else if (cara.equals("Toma todo")) 
                {
                    frijoles_jugador[numero_jugador]= frijoles_jugador[numero_jugador] + mesa; // el jugador x recibe "mesa" frijoles
                    mesa= 10;
                } 

                else if (cara.equals("Pon uno")) 
                {
                    if (frijoles_jugador[numero_jugador]>0) 
                    {
                        frijoles_jugador[numero_jugador]= frijoles_jugador[numero_jugador] - 1; // el jugador x pone 1 frijol
                        mesa= mesa + 1;
                    }
                } 
                
                else if (cara.equals("Pon dos"))
                {
                    int pon= 2;
                    if (frijoles_jugador[numero_jugador]<2) 
                    {
                        pon= frijoles_jugador[numero_jugador]; // si el jugador tiene menos de 2 pone los que tenga
                    }
                    frijoles_jugador[numero_jugador]= frijoles_jugador[numero_jugador] - pon; // se restan del jugador
                    mesa= mesa + pon;
                } 
                
                else if (cara.equals("Pon todo")) 
                {
                    mesa= mesa + frijoles_jugador[numero_jugador]; // el jugador pone todo lo que tenga
                    frijoles_jugador[numero_jugador] = 0; 
                } 
                
                else if (cara.equals("Todos ponen")) 
                {
                    for (int i=0; i<4; i++) // todos ponen un solo frijol
                    {
                        if (frijoles_jugador[i]>0) 
                        {
                            frijoles_jugador[i]= frijoles_jugador[i] - 1;
                            mesa= mesa + 1;
                        }
                    }
                }
                


                // Se acabaron los frijoles en la mesa?
                if (mesa==0) 
                {
                    System.out.println("Se acabaron los frijoles :( , invocando 10 mas :)");
                    mesa= 10; 
                }



                // Resultados actuales
                System.out.println("Frijoles en la mesa: " + mesa);
                System.out.println("\nFrijoles de jugadores de esta ronda: ");
                for (int i=0; i<4; i++) 
                {
                    System.out.println("Jugador " + (i + 1) + ": " + frijoles_jugador[i]);
                }
                System.out.println("---------------FIN DE RONDA---------------\n\n");



                jugadores_activos= 0; // asumir que no hay jugadores "por ahora" para actualizar el estado
                for (int i=0; i<4; i++) 
                {
                    if (frijoles_jugador[i]>0) // si al jugador actual se le acaban los frijoles
                    {
                        jugadores_activos= jugadores_activos + 1;
                    }
                }
            }



            numero_jugador= numero_jugador + 1; // siguiente turno del jugador
            if (numero_jugador>=4) // si es el turno del jugador 4 volver a darle el turno al 1
            {
                numero_jugador= 0;
            }
        }




        for (int i=0; i<4; i++) 
        {
            if (frijoles_jugador[i]>0) // comprobar quien tiene frijoles todavia
            {
                System.out.println("Gana el jugador: " + (i + 1));
                break;
            }
        }
    }
}