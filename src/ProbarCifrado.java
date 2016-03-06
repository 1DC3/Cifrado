/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author diego
 */
public class ProbarCifrado {
    
    public static void main(String[] args){
        String mensaje = "Vamos a la playa fe";
        String mensaje2 = "";
        Cifrado c = new Cifrado(mensaje);
       char[] men =  c.codificar();
        System.out.println("Mensaje Original:" + mensaje );
        System.out.print("Mensaje Codificado:" );
       
        for(int i=0; i<men.length; i++){
            System.out.printf("%c", men[i]);
            mensaje2+=men[i];
        }
        System.out.println();
        System.out.print("Mensaje descodificado:");
        char[]men2 = c.descodificar(mensaje2);
        for(int i=0; i<men2.length; i++){
            System.out.printf("%c",men2[i]);
        }
        System.out.println();
    }
    
}
