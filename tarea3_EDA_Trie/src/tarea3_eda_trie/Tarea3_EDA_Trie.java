/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea3_eda_trie;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.util.*;
import java.io.*;
import com.opencsv.*;

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
        String [] palabras;
        int y = 0;
        String resul[][] = new String[51][3];
        long inicio,fin;
        
        for(int x=1000;x<=50000;x=x+1000){
            resul[y][0] = "" + x;
            palabras = new String[x];
            llenaArreglo(palabras, x);
            inicio  = System.nanoTime();
            trieSort(palabras, alfabeto);
            fin = System.nanoTime();
            resul[y][1] = "" + (fin - inicio);
            y++;
        }
        y = 0;
        for(int w=1000;w<=50000;w=w+1000){
            palabras = new String[w];
            llenaArreglo(palabras, w);
            inicio  = System.nanoTime();
            mergeSort(palabras, w);
            fin = System.nanoTime();
            resul[y][2] = "" + (fin - inicio);
            y++;
        }
     
        
        try{
            CSVWriter writer = new CSVWriter(new FileWriter("resultados.csv"));
            // feed in your array (or convert your data to an array)
            String[] titulos = {"Datos","TrieSort","MergeSort"};
            writer.writeNext(titulos);
            for(int p=0;p<resul.length;p++){
                writer.writeNext(resul[p]);
            }    
            writer.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }//main
    
    public static void llenaArreglo(String[] arre, int max){
        File entrada;
        Scanner lector;
        entrada = new File("palabras.txt");
        try{
            lector = new Scanner(entrada);
            int i = 0;
            
            while(i < max && i < arre.length && lector.hasNext()){
                arre[i] = lector.next();
                i++;
            }
            lector.close();
            revolver(arre);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    } 
    
    public static void revolver(String[] arre){
        ArrayList<String> aux = new ArrayList();
        for(int i=0;i<arre.length;i++){
            aux.add(arre[i]);
        }
        Collections.shuffle(aux);
        for(int j=0;j<arre.length;j++){
            arre[j] = aux.get(j);
        }
    }
    
    public static String[] trieSort(String[] arre, char[] sim){
        Trie trie = new Trie(sim);
        for(int i=0;i<arre.length;i++){
            trie.agrega(arre[i]);
        }
        String [] resp = trie.trieSort();
        return resp;
    }
    
    public static void mergeSort(String[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        String[] l = new String[mid];
        String[] r = new String[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }
    
    public static void merge(String[] a, String[] l, String[] r, int left, int right) {
      int i = 0, j = 0, k = 0;
      while (i < left && j < right) {
          if (l[i].compareTo(r[j]) <= 0) { //l[i] <= r[j]
              a[k++] = l[i++];
          }
          else {
              a[k++] = r[j++];
          }
      }
      while (i < left) {
          a[k++] = l[i++];
      }
      while (j < right) {
          a[k++] = r[j++];
      }
  }
    
}//class
