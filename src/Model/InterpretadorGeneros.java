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
public abstract class InterpretadorGeneros {
    
    private static final String ALFABETO_INVALIDO = " ";
    private static final char DELIMITADOR_ATRIBUTO = ',';                   // Caractere que deve ser inserido no fim da lista de caracteres (antes de chamar esta função)

    public ArrayList<String> decodificar(String dados){
        return decodificar(dados.toCharArray());
    }
    
    public ArrayList<String> decodificar(char dados[]) {
        ArrayList<String> generos = new ArrayList<>();

        String auxString = "";
        int estado = 1, posChar = 0;
        for (int loops = 0; posChar < dados.length && loops <= dados.length * 3; loops ++) {
            if (estado == 1) {
                if (!ALFABETO_INVALIDO.contains(toLowerCase("" + dados[posChar]))) {
                    if (dados[posChar] == DELIMITADOR_ATRIBUTO) {
                        estado = 2;
                    } else if(posChar == dados.length -1 && !auxString.isEmpty()){
                        auxString += toLowerCase("" + dados[posChar]);
                        estado = 2;
                    } else {
                        // Coloca o caractere na string do atributo
                        auxString += toLowerCase("" + dados[posChar]);
                    }
                }
                //System.out.println("Size: "+ generos.size() + "\nchar: " + dados[posChar] + "\naux: " + auxString);
                posChar++;
            }
            if (estado == 2) {
                generos.add(auxString);
                auxString = "";
                estado = 1;
            }
        }
        if(posChar < dados.length)
            System.out.println("ERRO LOOP INFINITO NO INTERPRETADOR!");
        //System.out.println("\nRESULTADO= "+resultados.size() + " entradas");
        //GerArquivos.debugPrintCSVArray(resultados);
        return generos;
    }
}
