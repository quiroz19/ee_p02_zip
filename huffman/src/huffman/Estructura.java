/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

/**
 *
 * @author Anita
 */
public class Estructura {
    Nodo cabeza, cola, raiz;
    
    public Estructura(){
        cabeza = null;
        cola = null;
        raiz = null;
    }
    //agregamos un caracter
    public void agrega(char dato){
        Nodo recorre = cabeza;
      //hacemos un recorrido para la frecuencia ose el numero de veces que se repite ese caracter
        while(recorre != null && recorre.getDato() != dato)
            recorre = recorre.getSiguiente();
        
        if(recorre != null)
            recorre.addFrecuencia();
        else
            push(new Nodo(dato));
        //se agrega el dato a un nuevo nodo y este a su vez a la cola
    }
    //Aqui le agregamos un nuevo nodo a la cola
    public void push(Nodo nodo){
        if(cabeza == null){
            cabeza = nodo;
            cola = nodo;
        }
        else{
            nodo.setSiguiente(cabeza);
            cabeza.setAnterior(nodo);
            cabeza = nodo;
        }
    }
    //Aqui quitamos un nodo
    public Nodo pop(){
        Nodo retorno = cabeza;
        
        if(cabeza != cola){
            cabeza = cabeza.getSiguiente();
            cabeza.setAnterior(null);
        } else {
            cola = null;
            cabeza = null;
        }
        
        retorno.setSiguiente(null);
        
        return retorno;
    }
    
    //ordenamos nuestra cola desordenada para hacer la cola de prioridad 
    public void ordena(){
        Nodo i = cabeza, j, _izq, _der;
        char _dato;
        int _freq;
        String _cod;
        
        while(i != null){
            j = i.getSiguiente();
            while(j != null){
                if(i.getFrecuencia() >= j.getFrecuencia()){
                    _dato = j.getDato();
                    _freq = j.getFrecuencia();
                    _cod = j.getCodigo();
                    _izq = j.getIzquierda();
                    _der = j.getDerecha();
                    j.setDato(i.getDato());
                    j.setFrecuencia(i.getFrecuencia());
                    j.setCodigo(i.getCodigo());
                    j.setIzquierda(i.getIzquierda());
                    j.setDerecha(i.getDerecha());
                    i.setDato(_dato);
                    i.setFrecuencia(_freq);
                    i.setCodigo(_cod);
                    i.setIzquierda(_izq);
                    i.setDerecha(_der);
                }
                j = j.getSiguiente();
            }
            i = i.getSiguiente();
        }
    }
    //aqui formamos el arbol
    public void formaArbol(){
        Nodo suma, izq, der;
        //sumamos las frecuencias para construir nuestro arbol y lor ordenamos
        while(cabeza != cola){
            izq = pop();
            der = pop();
            suma = new Nodo('\0');
            suma.setFrecuencia(izq.getFrecuencia() + der.getFrecuencia());
            suma.setIzquierda(izq);
            suma.setDerecha(der);
            push(suma);
            ordena();
        }
    }
    //metodo recursivo para imprimir el arbol 
    public void imprimeArbol(){
//        System.out.println("Prueba " + cabeza.getFrecuencia());
        recorreArbol("", cabeza);
    }
    //recibe el ultimo nodo que nos quedo al final de la suma e inicializamos en vacio el string esto para escribir nuetro recorrido(binario)
    public void recorreArbol(String cad, Nodo actual){
        if(actual != null){
            if(actual.getDato() != '\0'){
                //System.out.println("'" + actual.getDato() + "':" + cad + " ");
                actual.setCodigo(cad);
            }
            recorreArbol(cad + "0", actual.getIzquierda());
            recorreArbol(cad + "1", actual.getDerecha());
        }
    }
    //este metodo recursivo nos permite deshacer el arbol y ordenandolo
    public void destruyeArbol(){
        reintegraNodo(cabeza);
        cola = cola.getAnterior();
        cola.setSiguiente(null);
        ordena();
    }
    //metodo auxiliar que ayuda a deshacer el arbol el cual recibe al principio la raiz
    public void reintegraNodo(Nodo actual){
        if(actual != null){
            reintegraNodo(actual.getIzquierda());
            actual.setIzquierda(null);
            reintegraNodo(actual.getDerecha());
            actual.setDerecha(null);
            if(actual.getDato() != '\0')
                push(actual);
        }
    }
    //
    public String codifica(char letra){
        Nodo recorre = cabeza;
        
        while(recorre != null && recorre.getDato() != letra)
            recorre = recorre.getSiguiente();
        
        if(recorre != null)
            return recorre.getCodigo();
        else
            return "";
    }
    //para decodificar o regresar al mensaje inicial utilizamos la tabla antes creada para comparar
    public char decodifica(String cadena){
        Nodo recorre = cabeza;
        
        while(recorre != null && !recorre.getCodigo().equals(cadena))
            recorre = recorre.getSiguiente();
        
        if(recorre != null)
            return recorre.getDato();
        else
            return '\0'; //caracter null
    }
    
    @Override
    public String toString(){ //se adjunta la informacion de cada nodo y se manda a imprimir la informacion
        String cadena = "";
        Nodo recorre = cabeza;
        
        while(recorre != null){
            cadena += recorre + ", ";
            recorre = recorre.getSiguiente();
        }
        
        return cadena;
    }
}
