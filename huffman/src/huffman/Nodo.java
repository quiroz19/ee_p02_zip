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
// la clase nodo,que recibe nuestros datos, para manipularlo de manera de cola y asi mismo tambien utilizarlo para crear nuestro arbol
public class Nodo {
    char dato;
    int frecuencia;
    String codigo;
    Nodo anterior, siguiente, izquierda, derecha;
    
    public Nodo(char dato){
        this.dato = dato;
        this.frecuencia = 1;
        this.codigo = "";
        anterior = null;
        siguiente = null;
        izquierda = null;
        derecha = null;
    }
    
    public void addFrecuencia(){
        frecuencia++;
    }

    public void setDato(char dato) {
        this.dato = dato;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }
    
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public void setIzquierda(Nodo izquierda) {
        this.izquierda = izquierda;
    }

    public void setDerecha(Nodo derecha) {
        this.derecha = derecha;
    }

    public char getDato() {
        return dato;
    }

    public int getFrecuencia() {
        return frecuencia;
    }
    
    public String getCodigo(){
        return codigo;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public Nodo getIzquierda() {
        return izquierda;
    }

    public Nodo getDerecha() {
        return derecha;
    }
    
    @Override
    public String toString(){
        return getDato() + ":" + getFrecuencia() + ":" + getCodigo();
    }
}
