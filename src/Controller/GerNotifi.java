/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DadosMidia;
import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class GerNotifi {
    
    Component comp;
    
    public GerNotifi(Component c){
        this.comp = c;
    }
    
    public boolean notificarSalvamento(){
        
        String titulo = "Tem certeza que deseja sair ?";
        String texto = "As alterações ainda não foram salvas, acesse o menu do topo e pressione salvar para salva-las\nTem certeza que deseja sair ?";
        int result = JOptionPane.showConfirmDialog(comp,texto, titulo,JOptionPane.YES_NO_OPTION);
        if(result == 0)
            return true;
        return false;
    }
    
    public boolean notificarCarregamento(){
        
        String titulo = "Tem certeza que deseja carregar os dados ?";
        String texto = "As alterações ainda não foram salvas, acesse o menu do topo e pressione salvar para salva-las\nTem certeza que deseja carregar os dados ?";
        int result = JOptionPane.showConfirmDialog(comp,texto, titulo,JOptionPane.YES_NO_OPTION);
        if(result == 0)
            return true;
        return false;
    }
    
    public boolean notificarExclusaoMidia(DadosMidia dados){
        
        String titulo = "Tem certeza que deseja excluir esta entrada ?";
        String texto = "Tem certeza que deseja excluir a entrada "+dados.id + ": " + dados.nome + " ?";
        int result = JOptionPane.showConfirmDialog(comp,texto, titulo,JOptionPane.YES_NO_OPTION);
        if(result == 0)
            return true;
        return false;
    }
    
    public boolean notificarSairAlteracao(){
        
        String titulo = "Tem certeza que deseja sair sem salvar ?";
        String texto = "Tem certeza que deseja sair sem salvar ?\ntodas as alterações feitas serão perdidas";
        int result = JOptionPane.showConfirmDialog(comp,texto, titulo,JOptionPane.YES_NO_OPTION);
        if(result == 0)
            return true;
        return false;
    }
    
    public boolean notificarAlteracao(){
        
        String titulo = "Tem certeza que deseja alterar esta entrada ?";
        String texto = "Tem certeza que deseja alterar a entrada selecionada ?\ntodos os dados dela serão sobrescrevidos!";
        int result = JOptionPane.showConfirmDialog(comp,texto, titulo,JOptionPane.YES_NO_OPTION);
        if(result == 0)
            return true;
        return false;
    }
}
