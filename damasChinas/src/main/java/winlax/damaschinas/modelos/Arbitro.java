package winlax.damaschinas.modelos;

import java.util.Scanner;

public class Arbitro extends persona {

    private jugador jugador1;
    private jugador jugador2;
    private Tablero tablero;

    private Scanner teclado;

    public Arbitro(jugador jugador1, jugador jugador2, Tablero tablero, Scanner teclado, String nombre) {
        super(nombre);
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.tablero = tablero;
        this.teclado = teclado;
    }

    public jugador getJugador1() {
        return jugador1;
    }

    public void setJugador1(jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public jugador getJugador2() {
        return jugador2;
    }

    public void setJugador2(jugador jugador2) {
        this.jugador2 = jugador2;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public Scanner getTeclado() {
        return teclado;
    }

    public void setTeclado(Scanner teclado) {
        this.teclado = teclado;
    }

    

    public void jugar() {
        this.tablero.llenarTablero(jugador1, jugador2);
        this.tablero.dibujarTablero(jugador1.getNombre(), jugador2.getNombre());

        do {
            colocarSimboloEnTablero(pedirPosicionFicha(jugador1), jugador1);
            this.tablero.dibujarTablero();
            if (buscarGanador(jugador1)) {
                break;
            }
            colocarSimboloEnTablero(pedirPosicionFicha(jugador2), jugador2);
            this.tablero.dibujarTablero();
        } while (!buscarGanador(jugador2));
    }

    public int[] pedirPosicionFicha(jugador jugador) {
        int[] posicionDePieza = new int[2];
        boolean repetir = false;
        System.out.println("Turno de jugador: " + jugador.getNombre());

        do {
            System.out.println(" > Ingrese su posicion en Y");
            posicionDePieza[0] = teclado.nextInt();
            if (posicionDePieza[0] < 1 || posicionDePieza[0] > 8) {
                System.out.println("Posicion incorrecta, intente de (1 - 8)");
                repetir = true;
            } else {
                repetir = false;
            }
        } while (repetir);

        do {
            System.out.println(" > Ingrese su posicion en X");
            posicionDePieza[1] = teclado.nextInt();
            if (posicionDePieza[1] < 1 || posicionDePieza[1] > 8) {
                System.out.println("Posicion incorrecta, intente de (1 - 8)");
                repetir = true;
            } else {
                repetir = false;
            }
        } while (repetir);

        return posicionDePieza;
    }

   public void colocarSimboloEnTablero(int[] posicion, jugador jugador) {
        if (this.tablero.getTablero()[posicion[0] - 1][posicion[1] - 1].equalsIgnoreCase(tablero.SIMBOLO_VACIO)) {
            this.tablero.getTablero()[posicion[0] - 1][posicion[1] - 1] = jugador.getSimbolo();
            jugador.getFichas()[posicion[0] - 1][posicion[1] - 1] = 1;
        }  else {
            System.out.println("Upsss... Espacio ocupado");
            colocarSimboloEnTablero(pedirPosicionFicha(jugador), jugador);
        }
    }

    public boolean buscarGanador(jugador jugador) {
        if (evaluarJugador(jugador)) {
            return true;
        }
        return false;
    }

    public boolean evaluarJugador(jugador jugador) {
        if (jugador.gano()) {
            System.out.println("FELICIDADES JUGADOR: " + jugador.getNombre() + " HAS GANADO");
            jugador.setGanadas(jugador.getGanadas() + 1);
            return true;
        }
        jugador.setPerdidas(jugador.getPerdidas() + 1);
        return false;
    }
}
