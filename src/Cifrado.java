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

    public String getMensaje() {
        return this.mensaje;
    }

    private char[] cambiarPosicion(char[] men) {
            char p1 = men[0];
            men[0] = men[RANGO-1];
            men[RANGO-1] = p1;

        for (int i = 1; i < this.mensaje.length() / RANGO; i++) {
            char p2 = men[i*(RANGO-1)];
            men[(i*RANGO-1)] =  men[i*RANGO-1+RANGO];
            men[i*RANGO-1+RANGO] = p2;
        }
        return men;
    }

    private char[] actualizarMensaje() {
        char[] mensaje2 = new char[this.mensaje.length()];
        final int ADD = 7;
        final int DIV = 95;
        final int SUM = 32;

        for (int i = 0; i < this.mensaje.length(); i++) {
            mensaje2[i] = (char) ((this.mensaje.charAt(i) + ADD) % DIV + SUM);
        }
        return mensaje2;
    }

    private void completarMensaje() {

        int rest = this.mensaje.length() % RANGO;

        for (int i = 0; i < rest; i++) {
            this.mensaje += '*';
        }
    }

}
