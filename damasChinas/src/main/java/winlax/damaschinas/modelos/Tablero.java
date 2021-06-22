package winlax.damaschinas.modelos;

public class Tablero {

    public static final String SIMBOLO_VACIO = "";
    private String[][] tablero;

    public Tablero() {
        this.tablero = new String[8][8];

    }

    public String[][] getTablero() {
        return tablero;
    }

    public void setTablero(String[][] tablero) {
        this.tablero = tablero;
    }

    public void dibujarTablero(String jugador1, String jugador2) {
        System.out.println("Jugador1: " + jugador1 + "\t\t\t" + "Jugador2: " + jugador2);
        System.out.println("\t_________________________________________________________________________________________________________________________________");
        for (int i = 0; i < tablero.length; i++) {
            System.out.print("\t|");
            for (int j = 0; j < tablero.length; j++) {
                System.out.print("\t");
                System.out.print(tablero[i][j] + "\t");
                System.out.print("|");
            }
            System.out.println("");
            System.out.println("\t_________________________________________________________________________________________________________________________________");
        }
    }

    public void dibujarTablero() {
        System.out.println("\t_________________________________________________________________________________________________________________________________");
        for (int i = 0; i < tablero.length; i++) {
            System.out.print("\t|");
            for (int j = 0; j < tablero.length; j++) {
                System.out.print("\t");
                System.out.print(tablero[i][j] + "\t");
                System.out.print("|");
            }
            System.out.println("");
            System.out.println("\t_________________________________________________________________________________________________________________________________");
        }
    }

    public void llenarTablero(jugador jugador1, jugador jugador2) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < 8; j++) {
                tablero[i][j] = SIMBOLO_VACIO;
                if (i == 0 && j % 2 == 0) {
                    tablero[0][j] = jugador1.getSimbolo();
                }
                if (i == 1 && j % 2 != 0) {
                    tablero[1][j] = jugador1.getSimbolo();
                }
                if (i == 2 && j % 2 == 0) {
                    tablero[2][j] = jugador1.getSimbolo();
                }
                if (i == 5 && j % 2 != 0) {
                    tablero[5][j] = jugador2.getSimbolo();
                }
                if (i == 6 && j % 2 == 0) {
                    tablero[6][j] = jugador2.getSimbolo();
                }
                if (i == 7 && j % 2 != 0) {
                    tablero[7][j] = jugador2.getSimbolo();
                }
            }
        }
    }

    /* public boolean estaLlenoElTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[i][j].equalsIgnoreCase("SIMBOLO_VACIO")) {
                    return false;
                }
            }
        }
        return true;
    }
     */
}
