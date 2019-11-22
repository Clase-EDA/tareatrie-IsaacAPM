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
public class Tarea3_EDA_Trie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        char[] alfabeto = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        Trie trie = new Trie(alfabeto);
        trie.agrega("help");
        trie.agrega("hola");
        trie.agrega("adbdbdc");
        trie.agrega("adios");
        trie.agrega("zoo");
        String[] ordenado = trie.trieSort();
        for(int i=0;i<ordenado.length;i++){
            System.out.println(ordenado[i] + "\n");
        }
    }
    
}
