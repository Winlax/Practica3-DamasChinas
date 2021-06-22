
package winlax.damaschinas.modelos;

public class jugador extends persona{
    
    private String simbolo;
    private int fichas[][];
    private int ganadas;
    private int perdidas;

    public jugador(String simbolo, String nombre, int ganadas, int perdidas) {
        super(nombre);
        this.simbolo = simbolo;
        this.ganadas = ganadas;
        this.perdidas = perdidas;
        llenarFichas();
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public int[][] getFichas() {
        return fichas;
    }

    public void setFichas(int[][] fichas) {
        this.fichas = fichas;
    }

    public int getGanadas() {
        return ganadas;
    }

    public void setGanadas(int ganadas) {
        this.ganadas = ganadas;
    }

    public int getPerdidas() {
        return perdidas;
    }

    public void setPerdidas(int perdidas) {
        this.perdidas = perdidas;
    }

    

    private void llenarFichas() {
        this.fichas = new  int[8][8];
        for(int i = 0; i< this.fichas.length; i++) {
            for(int j = 0; j< this.fichas.length; j++) {
                fichas[i][j] = 0;
            }
        }
    }
    
    public boolean gano() {
        int contador = 12;
        for (int i = 0; i < this.fichas.length; i++) {
            for (int j = 0; j < this.fichas.length; j++) {
                contador -= fichas[i][j];
            }
            if (contador == 0) {
                return true;
            } 
        }
        return false;
    }
}
