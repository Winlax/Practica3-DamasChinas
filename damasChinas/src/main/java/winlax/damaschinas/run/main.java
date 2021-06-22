package winlax.damaschinas.run;

import java.util.Scanner;
import winlax.damaschinas.modelos.Arbitro;
import winlax.damaschinas.modelos.Tablero;
import winlax.damaschinas.modelos.jugador;

public class main {

    public static void main(String[] args) {
        main a = new main();
        Scanner teclado =  new Scanner(System.in);

        jugador jugador1 = new jugador("W", "William", 0, 0);
        jugador jugador2 = new jugador("O", "Oscar", 0, 0);
        jugador jugador3 = new jugador("A", "Alisa", 0, 0);
        jugador jugador4 = new jugador("C", "Charlie", 0, 0);
        jugador jugador5 = new jugador("J", "Jacky", 0, 0);

        System.out.println("1) jugador1: " + jugador1.getNombre() + " Simbolo: " + jugador1.getSimbolo());
        System.out.println("2) jugador2: " + jugador2.getNombre() + " Simbolo: " + jugador2.getSimbolo());
        System.out.println("3) jugador3: " + jugador3.getNombre() + " Simbolo: " + jugador3.getSimbolo());
        System.out.println("4) jugador4: " + jugador4.getNombre() + " Simbolo: " + jugador4.getSimbolo());
        System.out.println("5) jugador5: " + jugador5.getNombre() + " Simbolo: " + jugador5.getSimbolo());
        
        System.out.println("Ingrese 1er. jugador a usar: ");
        int ju1 = teclado.nextInt();
        
        System.out.println("Ingrese 2do. jugador a usar: ");
        int ju2 = teclado.nextInt();
        
       
        Tablero tablero = new Tablero();
        Arbitro arbitro = new Arbitro(jugador1, jugador5, tablero, teclado, "Arbitro");
        
        System.out.println("\n\n------------------------------DAMAS CHINAS------------------------------\n\n");
        
        arbitro.jugar();

    }
}
