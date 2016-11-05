/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Anita
 */
public class Huffman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    	javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
        
    }
    
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
            try {
                UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                System.err.println("Couldn't use system look and feel.");
            }
 
        //Create and set up the window.
        JFrame frame = new JFrame("TreeDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Add content to the window.
        Estructura e = new Estructura();

        String entrada = JOptionPane.showInputDialog("Mensaje");
        String codificado = "", decodificado = "";
        String [] decodifica;
        
        for(int i = 0; i < entrada.length(); i++)
            e.agrega(entrada.charAt(i));
        e.agrega('\256');

        e.ordena();
        e.formaArbol();
        e.imprimeArbol();
        e.destruyeArbol();
        JOptionPane.showMessageDialog(null, e.toString());
        
        for(int i = 0; i < entrada.length(); i++)
            codificado += e.codifica(entrada.charAt(i)) + " ";
        
        codificado += e.codifica('\256') + " ";
        
        JOptionPane.showMessageDialog(null, codificado);
        decodifica = codificado.split(" ");
        for(int i = 0; i < decodifica.length - 1; i++){
            System.out.println(decodifica[i]);
            decodificado += e.decodifica(decodifica[i]);
        }
        JOptionPane.showMessageDialog(null, decodificado);
        frame.add(e);
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
}
