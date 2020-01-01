/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.GerArquivos;
import Model.DadosMidia;
import Model.InterpretadorGeneros;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author lucas
 */
public class GerDados extends InterpretadorGeneros {
    
    public static final int ID_INICIAL = 1;

    private GerArquivos gerArquivos;
    private ArrayList<DadosMidia> midias;

    public GerDados() {
        gerArquivos = new GerArquivos();
        midias = gerArquivos.carregarDados();
    }

    //  MÉTODOS DE BUSCA -------------------------------------------------------
    
    // Busca mídias a partir de seus ids
    public DadosMidia buscarId(int id) {
        Iterator<DadosMidia> iter = this.midias.iterator();
        DadosMidia midia;

        while (iter.hasNext()) {
            midia = iter.next();
            if (midia.id == id) {
                return midia;
            }
        }

        return (DadosMidia) null;
    }

    // Busca por mídias a partir de ambos o nome e o nome alternativo
    public ArrayList<DadosMidia> buscarNome(String nome) {
        Iterator<DadosMidia> iter = this.midias.iterator();
        ArrayList<DadosMidia> resultados = new ArrayList<>();
        DadosMidia midia;

        while (iter.hasNext()) {
            midia = iter.next();
            if (midia.nome.contains(nome) || midia.nomeAlt.contains(nome)) {
                resultados.add(midia);
            }
        }

        return resultados;
    }

    // Busca por mídias que contém todos um dos gêneros da string generos (string generos tem os generos separados por ,
    public ArrayList<DadosMidia> buscarGeneros(String generos) {
        Iterator<DadosMidia> iter = this.midias.iterator();
        ArrayList<DadosMidia> resultados = new ArrayList<>();
        DadosMidia midia;

        while (iter.hasNext()) {
            midia = iter.next();
            if (compararGeneros(decodificar(midia.generos), decodificar(generos))) {
                resultados.add(midia);
            }
        }

        return resultados;
    }

    // Compara duas listas de gêneros de mídia, se um tem um gênero identico à outra retorna true, do contrário false
    private boolean compararGeneros(ArrayList<String> g1, ArrayList<String> g2) {
        Iterator<String> iter1 = g1.iterator();
        while (iter1.hasNext()) {
            if (g2.contains(iter1.next())) {
                return true;
            }
        }
        return false;
    }

    //  MÉTODOS CRUD DE DADOS --------------------------------------------------
    
    // Salva os dados do vetor de mídias no arquivo de dados
    public void salvarAlteracoes() {
        gerArquivos.salvarDados(midias);
    }
    
    // Carrega novamente os dados do arquivo padrão
    public void carregarDados(){
        this.midias = gerArquivos.carregarDados();
    }
    
    // Altera o arquivo para o do nome especificado e carrega seus dados
    public void carregarDados(String arquivo){
        gerArquivos.setFileName(arquivo);
        this.midias = gerArquivos.carregarDados();
    }
    

    // Altera a mídia com o id especificado com os dados da nova mídia
    public boolean alterarMidia(int idDaMidia, DadosMidia novaMidia) {
        DadosMidia busca = buscarId(idDaMidia);
        if (busca == null) {
            return false;
        }
        
        int posicao = midias.indexOf(busca);
        novaMidia.id = busca.id;
        midias.add(posicao, novaMidia);
        midias.remove(busca);
        return true;
    }
    
    // Altera a mídia com o id especificado com os dados da nova mídia
    public boolean removerMidia(int idDaMidia) {
        DadosMidia busca = buscarId(idDaMidia);
        int posicao;
        if (busca == null) {
            return false;
        }
        // Pega o indice para remover
        posicao = midias.indexOf(busca);
        
        // Busca pelos proximos ao que será removido e reduz os ids deles em 1
        Iterator<DadosMidia> iter = midias.iterator();
        DadosMidia aux;
        while(iter.hasNext()){
            aux = iter.next();
            if(aux.id > busca.id){
                aux.id -=1;
            }
        }
        
        midias.remove(posicao);
        return true;
    }

    // Insere a midia do argumento no final do vetor com o id do ultimo do vetor + 1
    public void inserirMidia(DadosMidia midia) {
        midia.id = proximoId();
        midias.add(midia);
    }

    // Pega o próximo id disponível para inserir
    public int proximoId() {
        // Caso não haja midias cadastradas
        if(midias.size() <= 0)
            return ID_INICIAL;
        
        int proxId = -1;
        Iterator<DadosMidia> iter = midias.iterator();
        DadosMidia midia;
        while (iter.hasNext()) {
            midia = iter.next();
            if (midia.id > proxId) {
                proxId = midia.id;
            }
        }
        proxId++;
        return proxId;
    }

    // Procura se o id especificado já existe
    public boolean idExiste(int id) {
        Iterator<DadosMidia> iter = midias.iterator();
        while (iter.hasNext()) {
            if (iter.next().id == id) {
                return true;
            }
        }
        return false;
    }

    //  MÉTODOS ESTÁTICOS E GENÉRICOS ------------------------------------------
    
    // Remove os caracteres da string caracteresProibidos da string str
    public static String filtrarString(String str, String caracteresProibidos) {
        char chars[] = str.toCharArray();
        String resultado = "";

        for (char letra : chars) {
            if (!caracteresProibidos.contains(letra + "")) {
                resultado += letra;
            }
        }

        return resultado;
    }

    // Jeito rápido de decodificar generos a partir de uma string
    public ArrayList<String> separarGeneros(String generos) {
        return decodificar(generos.toCharArray());
    }

    public ArrayList<DadosMidia> getMidias() {
        return this.midias;
    }
}
