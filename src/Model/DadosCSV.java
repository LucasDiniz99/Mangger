/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author lucas
 */
public class DadosCSV {
    private String dados[];
    
    public DadosCSV(Object obj[]){
        dados = new String[obj.length];
        
        for(int i = 0; i < obj.length; i++){
            this.dados[i] = (String)obj[i];
        }
    }
    
    public String[] getData(){
        return this.dados;
    }
    
    public static void debugPrintCSVArray(ArrayList<DadosCSV> dados){
        Iterator<DadosCSV> iter = dados.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }
    
    public static ArrayList<DadosMidia> csvParaMidia(ArrayList<DadosCSV> dados){
        ArrayList<DadosMidia> midia = new ArrayList<>();
        Iterator<DadosCSV> iter =  dados.iterator();
        while(iter.hasNext()){
            midia.add(new DadosMidia(iter.next().getData()));
        }
        return  midia;
    }
   
    @Override
    public String toString(){
        String result = "";
        for(int i =0; i < dados.length; i++){
            result +="["+i+"]: "+ dados[i] + "\t";
        }
        return result;
    }
}
