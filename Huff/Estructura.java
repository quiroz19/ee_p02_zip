/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

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
    public void agrega(char dato){
        Nodo recorre = cabeza;

        while(recorre != null && recorre.getDato() != dato)
            recorre = recorre.getSiguiente();
        
        if(recorre != null)
            recorre.addFrecuencia();
        else
            push(new Nodo(dato));
    }
    
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
    
    public void ordena(){
        Nodo i = cabeza, j, swap_izq, swap_der;
        char swap_dato;
        int swap_freq;
        String swap_cod;
        
        while(i != null){
            j = i.getSiguiente();
            while(j != null){
                if(i.getFrecuencia() >= j.getFrecuencia()){
                    swap_dato = j.getDato();
                    swap_freq = j.getFrecuencia();
                    swap_cod = j.getCodigo();
                    swap_izq = j.getIzquierda();
                    swap_der = j.getDerecha();
                    j.setDato(i.getDato());
                    j.setFrecuencia(i.getFrecuencia());
                    j.setCodigo(i.getCodigo());
                    j.setIzquierda(i.getIzquierda());
                    j.setDerecha(i.getDerecha());
                    i.setDato(swap_dato);
                    i.setFrecuencia(swap_freq);
                    i.setCodigo(swap_cod);
                    i.setIzquierda(swap_izq);
                    i.setDerecha(swap_der);
                }
                j = j.getSiguiente();
            }
            i = i.getSiguiente();
        }
    }
    
    public void formaArbol(){
        Nodo suma, izq, der;
        
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
    
    public void imprimeArbol(){
//        System.out.println("Prueba " + cabeza.getFrecuencia());
        recorreArbol("", cabeza);
    }
    
    public void recorreArbol(String cad, Nodo actual){
        if(actual != null){
            if(actual.getDato() != '\0'){
                System.out.println("'" + actual.getDato() + "' -" + cad + " ");
                actual.setCodigo(cad);
            }
            recorreArbol(cad + "0", actual.getIzquierda());
            recorreArbol(cad + "1", actual.getDerecha());
        }
    }
    
    public void destruyeArbol(){
        reintegraNodo(cabeza);
        cola = cola.getAnterior();
        cola.setSiguiente(null);
        ordena();
    }
    
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
    
    public String codifica(char letra){
        Nodo recorre = cabeza;
        
        while(recorre != null && recorre.getDato() != letra)
            recorre = recorre.getSiguiente();
        
        if(recorre != null)
            return recorre.getCodigo();
        else
            return "";
    }
    
    public char decodifica(String cadena){
        Nodo recorre = cabeza;
        
        while(recorre != null && !recorre.getCodigo().equals(cadena))
            recorre = recorre.getSiguiente();
        
        if(recorre != null)
            return recorre.getDato();
        else
            return '\0';
    }
    
    @Override
    public String toString(){
        String cadena = "";
        Nodo recorre = cabeza;
        
        while(recorre != null){
            cadena += recorre + ", ";
            recorre = recorre.getSiguiente();
        }
        
        return cadena;
    }
    public String toStrings(){
        String cadena = "";
        Nodo recorre = cabeza;
        
        while(recorre != null){
            cadena += recorre + ", ";
            recorre = recorre.getSiguiente();
        }
        
        return cadena;
    }
}
