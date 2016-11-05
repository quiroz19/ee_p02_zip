
/**
 * Write a description of class Archivo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;
public class Archivo
{
    File f;
       FileReader lector;
       FileWriter escritor;
    public void leer1(){
     File file = new File("Ejemplito.txt");//en el archivo poner la palabra que se encuentra en el paquete
     String renglon="", texto="";
     
     try{
        BufferedReader le= new BufferedReader(new FileReader(file));
        
        while(true){
            renglon=le.readLine();
           if(renglon!=null) 
             texto=texto+renglon+"\n";
             else
             break;
          
        }
        renglon=le.readLine();
        }catch(IOException e){
         System.out.println(e.getMessage());
        }
      System.out.println(texto);  
    }
    
    public String leer(String nombre){
       
        try{
        f= new File(nombre);
        lector =new FileReader(f);
        BufferedReader br=new BufferedReader(lector);
        String l="";
        String aux="";
        
        while(true){
            aux=br.readLine();
            if(aux!=null)
                l=l+aux+"\n";
            else
                break;
        }
        br.close();
        lector.close();
        return l;
        
        }catch(IOException e){
            System.out.println("Error "+e.getMessage());
        }
          return null;
    }
    
    
    public void recibe(String nombre, String texto){
     String temp=this.leer(nombre);
     temp=temp+texto+"\n";
     this.crearTxt(nombre, temp);
    }
    public void crearTxt(String nombre, String texto){
        try{
            f=new File(nombre);
            escritor= new FileWriter(f);
            BufferedWriter bw= new BufferedWriter(escritor);
            PrintWriter salida=new PrintWriter(bw);
            
            salida.write(texto+"\n");
            salida.close();
        }catch(IOException e){
            System.out.println("Error "+e.getMessage());
        }
    }
    
    public static void main(String []args){
     Archivo a=new Archivo();
     System.out.println(a.leer("Ejemplito.txt"));
     a.crearTxt("total.txt",a.leer("Ejemplito.txt"));
    }
}
