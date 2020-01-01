package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Model.DadosCSV;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import Model.DadosMidia;
import Model.InterpretadorCSV;

/**
 *
 * @author lucas
 */
public class GerArquivos extends InterpretadorCSV {

    public static final String LOC_PADRAO_ARQUIVO = "dados.txt";
    
    private String fileName;

    public GerArquivos(String filename) {
        this.fileName = filename;
    }
    
    public GerArquivos(){
        this.fileName = LOC_PADRAO_ARQUIVO;
    }

    public void criarArquivo(){
        File arquivo = new File(this.fileName);
        if(!arquivo.exists()){
            try {
                arquivo.createNewFile();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }
    
    //retorna os dadosMidia do arquivo interpretados em forma de um arraylist de DadosMidia
    public ArrayList<DadosMidia> carregarDados() {
        try {
            ArrayList<DadosCSV> dadosMidia;
            String dados;
            Scanner sc = new Scanner(new File(fileName));
            sc.useDelimiter("\\Z");
            // So chama se o arquivo não estiver vazio, do contrário só retorna um vetor vazio
            if(sc.hasNext())
                dados = sc.next();
            else
                return new ArrayList<DadosMidia>();
            dados += InterpretadorCSV.DELIMITADOR_FIMARQUIVO;      // O char em questão é o caractere que indica fim de arquivo
            dadosMidia = decodificar(dados.toCharArray());
            //debugPrintCSVArray(dadosMidia); //mostrar se o csv está correto
            ArrayList<DadosMidia> midias = DadosCSV.csvParaMidia(dadosMidia);
            return midias;
        } catch (IOException e) {
            System.out.println(e);
        }
        this.criarArquivo();
        return new ArrayList<>();
    }

    //Salva os dadosMidia no arraylist de DadosMidia no arquivo no caminho da classe
    public void salvarDados(ArrayList<DadosMidia> array) {
        String data = arrayDadosMidiaString(array);
        try {
            FileWriter writer = new FileWriter(this.fileName);
            writer.write(data);
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    //  MÉTODOS ESTÁTICOS E GENÉRICOS ------------------------------------------
    
    //transforma um array de DadosMidia em uma string
    public static String arrayDadosMidiaString(ArrayList<DadosMidia> array) {
        String result = "";
        Iterator<DadosMidia> iter = array.iterator();
        while (iter.hasNext()) {
            result += iter.next();
        }
        return result;
    }
    
    // Seta o arquivo que ele gerencia
    public void setFileName(String file){
        this.fileName = file;
    }
}
