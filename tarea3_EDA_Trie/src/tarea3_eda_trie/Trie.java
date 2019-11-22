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
    private int cont;

    public Trie(char[] sim){
        this.sim = sim;
        this.raiz = new NodoTrie(sim.length);
        this.cont = 0;
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
            throw new NullPointerException("La palabra tiene simbolos desconocidos");
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
            cont++;
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
            throw new NullPointerException("La palabra tiene simbolos desconocidos");
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
    
    public boolean isEmpty(){
        return cont == 0;
    }
    
    public String[] trieSort(){
        String[] resp = new String[cont];
        if(!this.isEmpty()){
            int idx = 0;
            trieSort(resp,raiz,"");
        }
        return resp;
    } 
    
    private void trieSort(String[] arre,NodoTrie act,String palabra){
        if(act.isEmpty()){
            return;
        }
        
        for(int i=0;i<this.sim.length;i++){
            NodoTrie hijo = act.getHijo(i);
            
            if(hijo == null){
                continue;
            }
            
            String pal = palabra + this.sim[i];
           
            if(hijo.getEsFinDePalabra()){
                this.agregaArreglo(arre, pal);
            }
                   
            trieSort(arre,hijo,pal);
        }
    }
    
    private void agregaArreglo(String[] arre, String dato){
        int i = 0;
        boolean band = true;
        while(i < arre.length && band){
            if(arre[i] == null){
                band = false;
            }
            i++;
        }
        i--;
        if(i < arre.length){
            arre[i] = dato;
        }
        
    }
    
}//class
