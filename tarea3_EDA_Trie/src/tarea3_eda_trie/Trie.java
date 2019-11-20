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
public class Trie {
    private NodoTrie raiz;
    private char sim[];

    public Trie(char[] sim){
        this.sim = sim;
        raiz = new NodoTrie(sim.length);
    }

    private int getIdx(char c){
        int i = 0;

        while(i < sim.length && sim[i] != c){
            i++;
        }

        if(i == sim.length){
            i = -1;
        }

        return i;
    }

    public boolean busca(String key){
        if(key != null){
            return busca(key,raiz);
        }else{
            throw new NullPointerException("Llave nula");
        }
    }

    private boolean busca(String key, NodoTrie act){
        if(key == ""){
            if(act.getEsFinDePalabra()){
                return true;
            }
            return false;
        }

        char ch = key.charAt(0);
        int idx = getIdx(ch);
        if(idx == -1){
            throw new NullPointerException("La palabra tiene simbolos desconosidos");
        }

        NodoTrie sig = act.getHijo(idx);
        if(sig == null){
            return false;
        }

        String sub;
        if(key.length() == 1){
            sub = "";
        }else{
            sub = key.substring(1);
        }

        return busca(sub,sig);
    }
    
    public void agrega(String key){
        if(key != null){
            agrega(key,raiz);
        }else{
            throw new NullPointerException("Llave nula");
        }
    }
	
    private void agrega(String key, NodoTrie act){
        if(key == ""){
            if(!act.getEsFinDePalabra()){
                act.setEsFinDePalabra();
            } 
            return;
        }

        char ch = key.charAt(0);
        int idx = getIdx(ch);
        if(idx == -1){
            throw new NullPointerException("La palabra tiene simbolos desconosidos");
        }
		
        NodoTrie sig = act.getHijo(idx);
        if(sig == null){
            NodoTrie nuevo = new NodoTrie();
            act.setHijo(nuevo, idx);
            sig = nuevo;
        }

        String sub;
        if(key.length() == 1){
            sub = "";
        }else{
            sub = key.substring(1);
        }
		
        agrega(sub,sig);
    }
    
    
}//class
