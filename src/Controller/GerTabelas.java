/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DadosMidia;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


/**
 *
 * @author lucas
 */
public class GerTabelas{
    
    JTable tabela;  
    
    public GerTabelas(JTable tabela){
        this.tabela = tabela;
    }
    
    public void setupObras(){
        DefaultTableModel modeloTab = (DefaultTableModel) tabela.getModel();
        TableColumnModel coluna = (TableColumnModel) tabela.getColumnModel();        
        // Calibrando os tamanhos para tamanhos predefinidos
        setColumn(coluna, 0, 20, 20, 40);
        setColumn(coluna, 1, 70, 250, 500);
        setColumn(coluna, 2, 40, 50, 70);
        setColumn(coluna, 3, 60, 60, 70);
        setColumn(coluna, 4, 90, 100, 150);
        setColumn(coluna, 5, 70, 80, 90);
        setColumn(coluna, 6, 90, 130, 180);
        setColumn(coluna, 7, 80, 90, 100);
        setColumn(coluna, 8, 80, 90, 100);
        setColumn(coluna, 9, 90, 100, 150);
    }
    
    public void setColumn (TableColumnModel model, int coluna, int min, int pref, int max){
        model.getColumn(coluna).setMaxWidth(max);
        model.getColumn(coluna).setPreferredWidth(pref);
        model.getColumn(coluna).setMinWidth(min);
    }
    
    public void setData(ArrayList<DadosMidia> dados){
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        // Vetor para armazenar as colunas
        Object[] values = new Object[9];
        // Limpa a tabela
        model.setRowCount(0);
        // Iterage inserindo dado linha por linha
        Iterator<DadosMidia> iter = dados.iterator();
        DadosMidia midia;
        for(int i=0; iter.hasNext() ;i++){
            midia = iter.next();
            
            values[0] = midia.id;
            values[1] = midia.nome;
            values[2] = midia.notaMAL;
            values[3] = midia.tipo;
            values[4] = midia.status;
            values[5] = midia.generos;
            values[6] = midia.proxCapLeitura;
            values[7] = midia.leituraCompleta;
            values[8] = midia.dataDeLeitura;
            
            model.addRow(values);
        }
    }
    
    public void setData(DadosMidia dados){
        ArrayList<DadosMidia> midias = new ArrayList<>();
        midias.add(dados);
        this.setData(midias);
    }
    
    public int getSelectedId(){
        int selectedRow = tabela.getSelectedRow();
        if(selectedRow < 0 || selectedRow >= tabela.getRowCount()){
            return -1;
        }
        //return selectedRow;
        return (Integer)tabela.getValueAt(selectedRow, 0);
    }
}
