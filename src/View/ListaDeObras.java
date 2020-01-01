/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.GerNotifi;
import Controller.GerTabelas;
import Model.DadosMidia;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author lucas
 */
public class ListaDeObras extends javax.swing.JPanel implements Gerenciavel{

    GerNotifi gerNotifi;
    GerViews gerViews;
    GerTabelas tabelaObras;
    GerTabelas tabelaGeneros;
    /**
     * Creates new form ListaDeMangas
     */
    public ListaDeObras(GerViews ger) {
        initComponents();
        this.gerViews = ger;
        this.gerNotifi = new GerNotifi(this);
        this.tabelaObras = new GerTabelas(this.Tbl_Obras);
        this.tabelaGeneros = new GerTabelas(this.Tbl_Generos);
        
        tabelaObras.setupObras();
    }
    
    public void atualizar(){
        buscar("",0);
        this.Fld_Busca.setText("");
    }
    
    public void buscar(String busca, int tipo){
        ArrayList<DadosMidia> dadosBuscados;
        switch(tipo){
            default:
            case 0:
                dadosBuscados = gerViews.getGerDados().buscarNome(busca);
                tabelaObras.setData(dadosBuscados);
                break;
            case 1:
                dadosBuscados = gerViews.getGerDados().buscarGeneros(busca);
                tabelaObras.setData(dadosBuscados);
                break;
            case 2:
                dadosBuscados = new ArrayList<>();
                dadosBuscados.add(gerViews.getGerDados().buscarId(Integer.valueOf(busca)));
                tabelaObras.setData(dadosBuscados);
        }
        //DadosMidia.debugPrintMedia(dadosBuscados);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Txt_BoasVindas_TelaInicial = new javax.swing.JLabel();
        Fld_Busca = new javax.swing.JTextField();
        Btn_Buscar = new javax.swing.JButton();
        Btn_Atualizar = new javax.swing.JButton();
        Btn_Sair = new javax.swing.JButton();
        CBox_TipoDeBusca = new javax.swing.JComboBox();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        Pnl_AbaObras = new javax.swing.JPanel();
        Txt_TituloAba = new javax.swing.JLabel();
        Btn_Adicionar_Obras = new javax.swing.JButton();
        Btn_Alterar_Obras = new javax.swing.JButton();
        Btn_Visualizar_Obras = new javax.swing.JButton();
        Btn_Remover_Obras = new javax.swing.JButton();
        Txt_ResultadosBuscaObras = new javax.swing.JLabel();
        ScrPane_TabelaObras = new javax.swing.JScrollPane();
        Tbl_Obras = new javax.swing.JTable();
        Pnl_AbaGeneros = new javax.swing.JPanel();
        Txt_TituloAba1 = new javax.swing.JLabel();
        Txt_ResultadosBuscaGeneros = new javax.swing.JLabel();
        Btn_CarregarGeneros = new javax.swing.JButton();
        ScrPane_TabelaGeneros = new javax.swing.JScrollPane();
        Tbl_Generos = new javax.swing.JTable();

        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(1024, 768));

        Txt_BoasVindas_TelaInicial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Txt_BoasVindas_TelaInicial.setText("BEM VINDO A LISTA DE OBRAS CADASTRADAS");

        Fld_Busca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Fld_BuscaActionPerformed(evt);
            }
        });

        Btn_Buscar.setText("Buscar");
        Btn_Buscar.setPreferredSize(new java.awt.Dimension(63, 20));
        Btn_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_BuscarActionPerformed(evt);
            }
        });

        Btn_Atualizar.setText("Atualizar");
        Btn_Atualizar.setPreferredSize(new java.awt.Dimension(63, 20));
        Btn_Atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_AtualizarActionPerformed(evt);
            }
        });

        Btn_Sair.setText("Sair");
        Btn_Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_SairActionPerformed(evt);
            }
        });

        CBox_TipoDeBusca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nome", "Genero", "Id" }));
        CBox_TipoDeBusca.setPreferredSize(new java.awt.Dimension(63, 20));

        Txt_TituloAba.setText("LISTA DE OBRAS CADASTRADAS NA APLICAÇÃO:");

        Btn_Adicionar_Obras.setText("Adicionar");
        Btn_Adicionar_Obras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Adicionar_ObrasActionPerformed(evt);
            }
        });

        Btn_Alterar_Obras.setText("Alterar");
        Btn_Alterar_Obras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Alterar_ObrasActionPerformed(evt);
            }
        });

        Btn_Visualizar_Obras.setText("Visualizar");
        Btn_Visualizar_Obras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Visualizar_ObrasActionPerformed(evt);
            }
        });

        Btn_Remover_Obras.setText("Remover");
        Btn_Remover_Obras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Remover_ObrasActionPerformed(evt);
            }
        });

        Tbl_Obras.setAutoCreateRowSorter(true);
        Tbl_Obras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Nota", "Tipo", "Data Lançamento", "Status", "Generos", "Prox Capitulo", "Status Leitura", "Data de Leitura"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tbl_Obras.getTableHeader().setResizingAllowed(false);
        Tbl_Obras.getTableHeader().setReorderingAllowed(false);
        ScrPane_TabelaObras.setViewportView(Tbl_Obras);

        javax.swing.GroupLayout Pnl_AbaObrasLayout = new javax.swing.GroupLayout(Pnl_AbaObras);
        Pnl_AbaObras.setLayout(Pnl_AbaObrasLayout);
        Pnl_AbaObrasLayout.setHorizontalGroup(
            Pnl_AbaObrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_AbaObrasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Pnl_AbaObrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ScrPane_TabelaObras)
                    .addGroup(Pnl_AbaObrasLayout.createSequentialGroup()
                        .addGroup(Pnl_AbaObrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Txt_TituloAba)
                            .addGroup(Pnl_AbaObrasLayout.createSequentialGroup()
                                .addComponent(Btn_Adicionar_Obras)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Btn_Alterar_Obras)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Btn_Visualizar_Obras)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Btn_Remover_Obras)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Txt_ResultadosBuscaObras, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        Pnl_AbaObrasLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Btn_Adicionar_Obras, Btn_Alterar_Obras, Btn_Remover_Obras, Btn_Visualizar_Obras});

        Pnl_AbaObrasLayout.setVerticalGroup(
            Pnl_AbaObrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_AbaObrasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Txt_TituloAba)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Pnl_AbaObrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_Adicionar_Obras)
                    .addComponent(Btn_Alterar_Obras)
                    .addComponent(Btn_Visualizar_Obras)
                    .addComponent(Txt_ResultadosBuscaObras)
                    .addComponent(Btn_Remover_Obras))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrPane_TabelaObras, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                .addContainerGap())
        );

        Pnl_AbaObrasLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Btn_Visualizar_Obras, Txt_ResultadosBuscaObras});

        jTabbedPane1.addTab("Obras", Pnl_AbaObras);

        Txt_TituloAba1.setText("LISTA DE GENEROS CADASTRADAS NA APLICAÇÃO:");

        Btn_CarregarGeneros.setText("Carregar Gêneros");

        Tbl_Generos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Genero", "Descrição"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ScrPane_TabelaGeneros.setViewportView(Tbl_Generos);

        javax.swing.GroupLayout Pnl_AbaGenerosLayout = new javax.swing.GroupLayout(Pnl_AbaGeneros);
        Pnl_AbaGeneros.setLayout(Pnl_AbaGenerosLayout);
        Pnl_AbaGenerosLayout.setHorizontalGroup(
            Pnl_AbaGenerosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_AbaGenerosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Pnl_AbaGenerosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ScrPane_TabelaGeneros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1006, Short.MAX_VALUE)
                    .addGroup(Pnl_AbaGenerosLayout.createSequentialGroup()
                        .addComponent(Txt_TituloAba1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Txt_ResultadosBuscaGeneros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(Pnl_AbaGenerosLayout.createSequentialGroup()
                        .addComponent(Btn_CarregarGeneros)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        Pnl_AbaGenerosLayout.setVerticalGroup(
            Pnl_AbaGenerosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_AbaGenerosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Pnl_AbaGenerosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Txt_TituloAba1)
                    .addComponent(Txt_ResultadosBuscaGeneros))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btn_CarregarGeneros)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrPane_TabelaGeneros, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                .addContainerGap())
        );

        Pnl_AbaGenerosLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Txt_ResultadosBuscaGeneros, Txt_TituloAba1});

        jTabbedPane1.addTab("Generos", Pnl_AbaGeneros);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Btn_Sair)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Txt_BoasVindas_TelaInicial, javax.swing.GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE))
                    .addComponent(Fld_Busca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CBox_TipoDeBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Btn_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Btn_Atualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Txt_BoasVindas_TelaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_Sair)
                    .addComponent(Btn_Atualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Fld_Busca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CBox_TipoDeBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Btn_Atualizar, Btn_Buscar, CBox_TipoDeBusca, Fld_Busca});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Btn_Sair, Txt_BoasVindas_TelaInicial});

    }// </editor-fold>//GEN-END:initComponents

    private void Btn_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_BuscarActionPerformed
        buscar(this.Fld_Busca.getText() + "",this.CBox_TipoDeBusca.getSelectedIndex());
    }//GEN-LAST:event_Btn_BuscarActionPerformed

    private void Fld_BuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Fld_BuscaActionPerformed
        buscar(this.Fld_Busca.getText() + "",this.CBox_TipoDeBusca.getSelectedIndex());
    }//GEN-LAST:event_Fld_BuscaActionPerformed

    private void Btn_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_SairActionPerformed
        this.gerViews.voltarView();
    }//GEN-LAST:event_Btn_SairActionPerformed

    private void Btn_AtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_AtualizarActionPerformed
        atualizar();
    }//GEN-LAST:event_Btn_AtualizarActionPerformed

    private void Btn_Adicionar_ObrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Adicionar_ObrasActionPerformed
        gerViews.abrirView(new EditarMangas(gerViews));
    }//GEN-LAST:event_Btn_Adicionar_ObrasActionPerformed

    private void Btn_Alterar_ObrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Alterar_ObrasActionPerformed
        Integer id = this.tabelaObras.getSelectedId();
        if(id >= 0){
            gerViews.abrirView(new EditarMangas(gerViews, id));
        }
    }//GEN-LAST:event_Btn_Alterar_ObrasActionPerformed

    private void Btn_Visualizar_ObrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Visualizar_ObrasActionPerformed
        Integer id = this.tabelaObras.getSelectedId();
        if(id >= 0){
            gerViews.abrirView(new EditarMangas(gerViews, id,true));
        }
    }//GEN-LAST:event_Btn_Visualizar_ObrasActionPerformed

    private void Btn_Remover_ObrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Remover_ObrasActionPerformed
        Integer id = this.tabelaObras.getSelectedId();
        if(id >= 0){
            if(!gerNotifi.notificarExclusaoMidia(gerViews.getGerDados().buscarId(id)))
                return;
            gerViews.getGerDados().removerMidia(id);
            atualizar();
            gerViews.alterarDados();
        }
    }//GEN-LAST:event_Btn_Remover_ObrasActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Adicionar_Obras;
    private javax.swing.JButton Btn_Alterar_Obras;
    private javax.swing.JButton Btn_Atualizar;
    private javax.swing.JButton Btn_Buscar;
    private javax.swing.JButton Btn_CarregarGeneros;
    private javax.swing.JButton Btn_Remover_Obras;
    private javax.swing.JButton Btn_Sair;
    private javax.swing.JButton Btn_Visualizar_Obras;
    private javax.swing.JComboBox CBox_TipoDeBusca;
    private javax.swing.JTextField Fld_Busca;
    private javax.swing.JPanel Pnl_AbaGeneros;
    private javax.swing.JPanel Pnl_AbaObras;
    private javax.swing.JScrollPane ScrPane_TabelaGeneros;
    private javax.swing.JScrollPane ScrPane_TabelaObras;
    private javax.swing.JTable Tbl_Generos;
    private javax.swing.JTable Tbl_Obras;
    private javax.swing.JLabel Txt_BoasVindas_TelaInicial;
    private javax.swing.JLabel Txt_ResultadosBuscaGeneros;
    private javax.swing.JLabel Txt_ResultadosBuscaObras;
    private javax.swing.JLabel Txt_TituloAba;
    private javax.swing.JLabel Txt_TituloAba1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void viewSetVisibility(boolean value) {
        this.setVisible(value);
    }

    @Override
    public JPanel getView() {
        return this;
    }

    @Override
    public void viewSetSize(Dimension d) {
        this.setSize(d);
    }

    @Override
    public void viewRestart() {
        this.setVisible(true);
        this.CBox_TipoDeBusca.setSelectedIndex(0);
        atualizar();
    }

    @Override
    public Dimension viewGetSize() {
         return this.getSize();
    }
}