/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea3_eda_trie;

/**
 *
 * @author ipimentem
 */
public class NodoTrie {
    private NodoTrie hijos[];
    private boolean esFinDePalabra;
    private static int numSim;
    
    public NodoTrie(int numSim){
	this.numSim = numSim;
	this.hijos = new NodoTrie[this.numSim];
	this.esFinDePalabra = false;
    }

    public NodoTrie(){
	this.hijos = new NodoTrie[this.numSim];
	this.esFinDePalabra = false;
    }

    public void setHijo(NodoTrie nuevo, int i){
	this.hijos[i] = nuevo;
    }

    public NodoTrie getHijo(int i){
	return this.hijos[i];
    }
    
    public NodoTrie[] getHijos(){
        return hijos; 
    }

    public boolean getEsFinDePalabra(){
	return this.esFinDePalabra;
    }

    public void setEsFinDePalabra(){
	this.esFinDePalabra = !this.esFinDePalabra;
    }
    
    public boolean isEmpty(){
        NodoTrie act;
        boolean band = true;
        int i = 0;
        while(i < hijos.length && band){        
            act = hijos[i];
            if(act == null){
                band = false;
            }
            i++;
        }
        return band;
    }
}
