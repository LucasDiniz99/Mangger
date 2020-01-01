/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.GerNotifi;
import Controller.GerDados;
import View.Gerenciavel;
import View.ListaDeObras;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Stack;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author lucas
 */
public class GerViews extends javax.swing.JFrame {

    public static final Dimension PREFERRED_SIZE = new Dimension(1024, 768);
    public static final Dimension START_DIMENSION = new Dimension(1, 1);
    private GerDados gerDados;
    private GerNotifi gerNotifi;
    private Stack<Gerenciavel> listaViews;
    public boolean dadosAlterados = false;
    
    private Gerenciavel VIEW_INICIAL = new ListaDeObras(this);

    /**
     * Creates new form ViewController
     */
    public GerViews() {
        initComponents();
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        this.setSize(PREFERRED_SIZE);
        
        this.gerDados = new GerDados();
        this.listaViews = new Stack<>();
        this.gerNotifi = new GerNotifi(this);
        
        abrirView(VIEW_INICIAL);
    }

    public void abrirView(Gerenciavel novaView) {
        Gerenciavel atual;
        // Se já existe views na lista, desativa totalmente a atual e remove do contexoto (não da pilha)
        if (this.listaViews.size() > 0) {
            atual = this.listaViews.peek();
            atual.viewSetVisibility(false);
            atual.getView().setEnabled(false);
            this.remove(atual.getView());
        }
        // Adiciona a nova novaView na lista
        this.listaViews.push(novaView);
        // Insere a novaView neste frame e a configura
        novaView.viewSetSize(START_DIMENSION);
        this.add(novaView.getView(), BorderLayout.CENTER);
        // Certificar que a primeira view tem tamanho correto
        if(this.listaViews.size() <= 1)
            this.pack();
        // Reinicializa a view
        novaView.viewRestart();
    }

    public void voltarView() {
        // Se for a ultima view da pilha pergunta se o usuario quer sair da aplicação
        if (this.listaViews.size() <= 1) {
            if(dadosAlterados){
                if(gerNotifi.notificarSalvamento())
                    System.exit(0);
                else
                    return;
            }
            System.exit(0);
        }
        // Remove a view atual da pilha e pega a anterior
        Gerenciavel atual = listaViews.pop();
        Gerenciavel anterior = listaViews.peek();
        // Desabilita e remove a view atual
        atual.viewSetVisibility(false);
        atual.getView().setEnabled(false);
        this.remove(atual.getView());
        // Reativa e reconfigura a view anterior e a insere no contexto atual
        anterior.viewSetSize(START_DIMENSION);
        anterior.viewRestart();
        anterior.getView().setEnabled(true);
        this.add(anterior.getView());
    }

    public GerDados getGerDados(){
        return this.gerDados;
    }
    
    public void alterarDados(){
        this.dadosAlterados = true;
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        MI_Salvar = new javax.swing.JMenuItem();
        MI_Carregar = new javax.swing.JMenuItem();
        MI_CarregarOutro = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        jMenu1.setText("Arquivo");

        MI_Salvar.setText("Salvar Alterações");
        MI_Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_SalvarActionPerformed(evt);
            }
        });
        jMenu1.add(MI_Salvar);

        MI_Carregar.setText("Carregar");
        MI_Carregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_CarregarActionPerformed(evt);
            }
        });
        jMenu1.add(MI_Carregar);

        MI_CarregarOutro.setText("Carregar outro");
        MI_CarregarOutro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_CarregarOutroActionPerformed(evt);
            }
        });
        jMenu1.add(MI_CarregarOutro);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MI_SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_SalvarActionPerformed
        gerDados.salvarAlteracoes();
        this.dadosAlterados = false;
    }//GEN-LAST:event_MI_SalvarActionPerformed

    private void MI_CarregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_CarregarActionPerformed
        if(dadosAlterados)
            if(!gerNotifi.notificarCarregamento())
                return;
        gerDados.carregarDados();
        listaViews.get(listaViews.size()-1).viewRestart();
    }//GEN-LAST:event_MI_CarregarActionPerformed

    private void MI_CarregarOutroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_CarregarOutroActionPerformed
        if(dadosAlterados)
            if(!gerNotifi.notificarCarregamento())
                return;
        String nomeArquivo = JOptionPane.showInputDialog("Qual é o nome do arquivo(Caminho) ?");
        if(nomeArquivo.length() <= 0)
            gerDados.carregarDados(); 
        else 
            gerDados.carregarDados(nomeArquivo);
        listaViews.get(listaViews.size()-1).viewRestart();
    }//GEN-LAST:event_MI_CarregarOutroActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        try { 
            JPanel view  = this.listaViews.get(this.listaViews.size()-1).getView();
            view.revalidate();
        } catch (Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_formComponentResized

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GerViews.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GerViews.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GerViews.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GerViews.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GerViews().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MI_Carregar;
    private javax.swing.JMenuItem MI_CarregarOutro;
    private javax.swing.JMenuItem MI_Salvar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}