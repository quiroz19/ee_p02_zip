/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

import javax.swing.JOptionPane;

/**
 *
 * @author Anita
 */
public class Huffman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        char ayu[];
        Archivo ar=new Archivo();
        // TODO code application logic here
        Estructura e = new Estructura();
        //String entrada = JOptionPane.showInputDialog("Mensaje");
        String codificado = "", decodificado = "";
        String [] decodifica;
        ayu=ar.leer("Ejemplito.txt").toCharArray();
        //for(int i = 0; i < entrada.length(); i++)
            //e.agrega(entrada.charAt(i));
            for(int i = 0; i < ayu.length-1; i++)
            e.agrega(ayu[i]);
        //e.agrega('\256');

        e.ordena();
        e.formaArbol();
        e.imprimeArbol();
        e.destruyeArbol();
        JOptionPane.showMessageDialog(null, e);
        
        //for(int i = 0; i < entrada.length(); i++)
          //  codificado += e.codifica(entrada.charAt(i)) + " ";
          for(int i = 0; i < ayu.length-1; i++){
            codificado += e.codifica(ayu[i]) + " ";
             }
         ar.crearTxt("Comprimido.txt",e.toString());
        //codificado += e.codifica('\256') + " ";
        
        JOptionPane.showMessageDialog(null, codificado);
        decodifica = codificado.split(" ");
        for(int i = 0; i < decodifica.length ; i++){
            System.out.println(decodifica[i]);
            decodificado += e.decodifica(decodifica[i]);
        }
        JOptionPane.showMessageDialog(null, decodificado);
        
    }
    
}
