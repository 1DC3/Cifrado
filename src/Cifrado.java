/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author diego
 */
public class Cifrado {

    private final static int RANGO = 4;
    private String mensaje;
    private int[] cocientes;

    public Cifrado(String mensaje) {
        this.mensaje = mensaje;
    }

    public char[] codificar() {
        // En caso de que su longitud no sea múltiplo de 4 le añadimos el carácter asterísco al final
        completarMensaje();
        char men[] = actualizarMensaje();
        men = cambiarPosicion(men);

        return men;
    }

    public char[] descodificar(String mensaje) {
        char men[] = recuperarMensaje(mensaje);
        men = cambiarPosicion(men);
        men = quitarAsteriscos(men);

        return men;

    }
    
    private char[] quitarAsteriscos(char[] mensaje){
        for(int i=mensaje.length-1; i>mensaje.length-1-RANGO; i--){
            if(mensaje[i] == '*'){
                mensaje[i] = ' ';
            }
        }
        return mensaje;
    }

    private char[] recuperarMensaje(String mensaje) {
        char[] mensaje2 = new char[this.mensaje.length()];
        final int ADD = 7;
        final int DIV = 95;
        final int SUM = 32;

        for (int i = 0; i < mensaje.length(); i++) {
            mensaje2[i] = (char) (((mensaje.charAt(i) - SUM) + DIV * this.cocientes[i]) - ADD);
        }
        return mensaje2;
    }

    public String getMensaje() {
        return this.mensaje;
    }

    private char[] cambiarPosicion(char[] men) {
        char p1 = men[0];
        int pp1 = this.cocientes[0];

        men[0] = men[RANGO - 1];
        men[RANGO - 1] = p1;
        this.cocientes[0] = this.cocientes[RANGO - 1];
        this.cocientes[RANGO - 1] = pp1;

        for (int i = 1; i < this.mensaje.length() / RANGO; i++) {
            char p2 = men[i * (RANGO)];
            int pp2 = this.cocientes[i * (RANGO)];
            men[(i * RANGO)] = men[i * RANGO + RANGO - 1];
            men[i * RANGO - 1 + RANGO] = p2;
            this.cocientes[(i * RANGO)] = this.cocientes[i * RANGO - 1 + RANGO];
            this.cocientes[i * RANGO - 1 + RANGO] = pp2;
        }
        return men;
    }

    private char[] actualizarMensaje() {
        char[] mensaje2 = new char[this.mensaje.length()];
        this.cocientes = new int[this.mensaje.length()];
        final int ADD = 7;
        final int DIV = 95;
        final int SUM = 32;

        for (int i = 0; i < this.mensaje.length(); i++) {
            mensaje2[i] = (char) ((this.mensaje.charAt(i) + ADD) % DIV + SUM);
            this.cocientes[i] = (this.mensaje.charAt(i) + ADD) / DIV;
        }
        return mensaje2;
    }

    private void completarMensaje() {

        int rest = RANGO - (this.mensaje.length() % RANGO);

        if (rest != RANGO) {
            for (int i = 0; i < rest; i++) {
                this.mensaje += '*';
            }
        }
    }

}
