/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import static jdk.nashorn.internal.objects.NativeString.toLowerCase;

/**
 *
 * @author lucas
 */
public abstract class InterpretadorCSV {

    private static final String ALFABETO_INVALIDO = "";
    private static final char DELIMITADOR_ATRIBUTO = '\t';
    private static final char DELIMITADOR_OBJETO = '\n';
    public static final char DELIMITADOR_FIMARQUIVO = (char)244;                    // Caractere que deve ser inserido no fim da lista de caracteres (antes de chamar esta função)

    public ArrayList<DadosCSV> decodificar(String dados){
        return decodificar(dados.toCharArray());
    }
    
    public ArrayList<DadosCSV> decodificar(char dados[]) {
        ArrayList<DadosCSV> resultados = new ArrayList<>();
        ArrayList<String> atributos = new ArrayList<>();

        String auxString = "";
        int estado = 1, posChar = 0;
        for (int loops = 0; posChar < dados.length && loops <= dados.length * 3; loops ++) {
            if (estado == 1) {
                if (!ALFABETO_INVALIDO.contains(toLowerCase("" + dados[posChar]))) {
                    if (dados[posChar] == DELIMITADOR_ATRIBUTO) {
                        estado = 2;
                    } else if (dados[posChar] == DELIMITADOR_OBJETO || dados[posChar] == DELIMITADOR_FIMARQUIVO) {
                        estado = 3;
                        // Pegar o que sobrou na string que armazena o atributo
                        if(!auxString.isEmpty())
                        {
                            estado = 2;
                            continue;
                        }
                    } else {
                        // Coloca o caractere na string do atributo
                        auxString += toLowerCase("" + dados[posChar]);
                    }
                }
                //System.out.println("Size: "+ atributos.size() + "\nchar: " + dados[posChar] + "\naux: " + auxString);
                posChar++;
            }
            if (estado == 2) {
                atributos.add(auxString);
                auxString = "";
                estado = 1;
            }
            if (estado == 3) {
                resultados.add(new DadosCSV(atributos.toArray()));
                atributos.clear();
                estado = 1;
            }
        }
        if(posChar < dados.length)
            System.out.println("ERRO LOOP INFINITO NO INTERPRETADOR!");
        //System.out.println("\nRESULTADO= "+resultados.size() + " entradas");
        //GerArquivos.debugPrintCSVArray(resultados);
        return resultados;
    }
}
