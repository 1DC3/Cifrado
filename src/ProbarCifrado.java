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
        String mensaje = "DS";
        Cifrado c = new Cifrado(mensaje);
       char[] men =  c.codificar();
        System.out.println("Mensaje Original:" + mensaje );
        System.out.print("Mensaje Codificado:" );
       
        for(int i=0; i<men.length; i++){
            System.out.printf("%c", men[i]);
        }
        System.out.println();
    }
    
}
