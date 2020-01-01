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
public class DadosMidia {

    //Quantidade de caracteristicas que a midia tem
    public static final int QUANT_DADOS = 15;

    public Integer id = -1;
    public String nome = "";
    public String nomeAlt = "";
    public Double notaMAL = 0.0;
    public String dataLancamento = "00/00/0000";
    public String tipo = "";
    public Integer capitulos = 0;
    public String status = "p";
    public String generos = "";
    public String altor = "";
    public String sinopse = "";
    public String fonteSinopse = "";
    public Double proxCapLeitura = 0.0;
    public String leituraCompleta = "n";
    public String dataDeLeitura = "00/00/0000";
    
    public DadosMidia(Object dados[]){
        if(!setValue(dados))
            System.out.println("Erro ao armazenar dados na midia");
    }

    public DadosMidia() {
        
    }

    public boolean setValue(Object dados[]) {
        try{
            if(dados.length < 15)
                return false;
            
            this.id = safeStringToInt((String)dados[0]);
            this.nome = (String) dados[1];
            this.nomeAlt = (String) dados[2];
            this.notaMAL = safeStringToDouble((String)dados[3]);
            this.dataLancamento = (String) dados[4];
            this.tipo = (String) dados[5];
            this.capitulos = safeStringToInt((String)dados[6]);
            this.status = (String)dados[7];
            this.generos = (String) dados[8];
            this.altor = (String) dados[9];
            this.sinopse = (String) dados[10];
            this.fonteSinopse = (String) dados[11];
            this.proxCapLeitura = safeStringToDouble((String)dados[12]);
            this.leituraCompleta = (String)dados[13];
            this.dataDeLeitura = (String) dados[14];

            return true;
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
    
    private String safeString(char str[]){
        String saida = "";
        String charsValidos = "1234567890.-";
        for(int i =0; i < str.length; i++){
            if(charsValidos.contains(str[i] + "")){
                saida += str[i];
            }
        }
        if(saida.length() <= 0)
            saida = "0";
        return saida;
    }
    
    private Double safeStringToDouble(String str){
        return Double.valueOf(safeString(str.toCharArray()));
    }
    
    private Integer safeStringToInt(String str){
        return Integer.valueOf(safeString(str.toCharArray()));
    }

    @Override
    public String toString() {
        String result = "";
        result += this.id;
        result += '\t';
        result += this.nome;
        result += '\t';
        result += this.nomeAlt;
        result += '\t';
        result += this.notaMAL;
        result += '\t';
        result += this.dataLancamento;
        result += '\t';
        result += this.tipo;
        result += '\t';
        result += this.capitulos;
        result += '\t';
        result += this.status;
        result += '\t';
        result += this.generos;
        result += '\t';
        result += this.altor;
        result += '\t';
        result += this.sinopse;
        result += '\t';
        result += this.fonteSinopse;
        result += '\t';
        result += this.proxCapLeitura;
        result += '\t';
        result += this.leituraCompleta;
        result += '\t';
        result += this.dataDeLeitura;
        result += '\n';
        
        return result;
    }
    
    public static void debugPrintMedia(ArrayList<DadosMidia> dados){
        Iterator<DadosMidia> iter = dados.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }
}
