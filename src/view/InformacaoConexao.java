
/******************************************************************************
 * Nome do arquivo  : StationManager.java
 * Autor            : Leonidio Alves de Moraes Junior
 * Data de criação  : 07/02/2025
 * Empresa          : FATESG - Engenharia de Software - V Período
 * Descrição        : Gerenciador de Rede Radial
 *
 * Histórico de modificações:
 * Data        | Autor                          | Descrição
 * ------------|--------------------------------|--------------------------------
 * 07/02/2025  | Leonidio Alves de Moraes Junior| Implementação inicial
 * 09/02/2025  | Leonidio Alves de Moraes Junior| Correção de bugs
 * 
 * Copyright (c) 2025 FATESG. Todos os direitos reservados.
 * Este código é confidencial e de propriedade de FATESG.
 * A sua distribuição ou reprodução é proibida sem autorização expressa.
 ******************************************************************************/

package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import model.UnidadeGridGerenciadorDeRedesRadiais;
import model.UnidadeGridConsumidora;
import model.UnidadeGridFonteProducaoEnergia;
import model.UnidadeGridUsinaDeProducao;

public class InformacaoConexao extends javax.swing.JDialog {

    UnidadeGridGerenciadorDeRedesRadiais unidadeGrid = UnidadeGridGerenciadorDeRedesRadiais.getInstanciaDoDistribuidor();

    public InformacaoConexao(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        jLabel3.setText(UnidadeGridGerenciadorDeRedesRadiais.getInstanciaDoDistribuidor().getIdentificadorGerenciador());        
        jLabel4.setText(unidadeGrid.getUsinaDeProducao().get(0).getIdentificadorUnidadeGrid());
        
        adicionarUnidadesAoJTree(jTree1, unidadeGrid);
        adicionarFontesEnergia(jTable1);
    }
    
       
    // Método para adicionar as fontes de energia ao JTable
    public void adicionarFontesEnergia(JTable jTable1) {
       
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        

        // Adiciona as colunas ao JTable
        model.addColumn("identificadorFonteProducao");
        model.addColumn("tipoFonteEnergia");
        model.addColumn("fonteRenovavel");
        model.addColumn("potenciaEmEstoque");
        model.addColumn("quantidadeEnergiaConsumidaporHora");
        model.addColumn("quantidadeEnergiaProduzidaporHora");
        
        UnidadeGridGerenciadorDeRedesRadiais unidadeGrid = UnidadeGridGerenciadorDeRedesRadiais.getInstanciaDoDistribuidor();
        UnidadeGridUsinaDeProducao usinadoGrid = UnidadeGridUsinaDeProducao.getInstanciaDaUsinadoGrid();    
        
        // Supondo que usinadoGrid é uma instância já inicializada de um objeto que tem o método getMatrizEnergetica
        List<UnidadeGridFonteProducaoEnergia> listaFontesProducaoEnergias = new ArrayList<>();        
        listaFontesProducaoEnergias = usinadoGrid.getMatrizEnergetica().getFirst().getFontesProducaoEnergias();
        
        model.removeRow(0);
        model.removeRow(0);
        model.removeRow(0);
        model.removeRow(0);
        
        // Adiciona as linhas de dados ao JTable
        for (UnidadeGridFonteProducaoEnergia fonte : listaFontesProducaoEnergias) {
            Object[] linha = {
                fonte.getIdentificadorFonteProducao(),
                fonte.getTipoFonteEnergia(),
                fonte.isFonteRenovavel(),
                fonte.getPotenciaEmEstoque(),
                fonte.getQuantidadeEnergiaConsumidaporHora(),
                fonte.getQuantidadeEnergiaProduzidaporHora()
            };
            model.addRow(linha);                
    }
    }
    
private void adicionarUnidadesAoJTree(JTree tree, UnidadeGridGerenciadorDeRedesRadiais unidadeGrid) {
   
    DefaultMutableTreeNode root = new DefaultMutableTreeNode("Unidades Consumidoras do Grid");

    DefaultMutableTreeNode monofasicaNode = new DefaultMutableTreeNode("Rede Monofasica");
    DefaultMutableTreeNode bifasicaNode = new DefaultMutableTreeNode("Rede Bifásica");
    DefaultMutableTreeNode trifasicaNode = new DefaultMutableTreeNode("Rede Trifásica");

    for (UnidadeGridConsumidora consumidor : unidadeGrid.getListaConsumidores()) {
        switch (consumidor.getTipoCorrenteFase()) {
            case 1:
                monofasicaNode.add(new DefaultMutableTreeNode(consumidor.getIdentificadorUnidadeGrid() + " - " + consumidor.getResponsavelUnidade() + " - " + consumidor.getTelefoneResponsavel()));
                break;
            case 2:
                bifasicaNode.add(new DefaultMutableTreeNode(consumidor.getIdentificadorUnidadeGrid() + " - " + consumidor.getResponsavelUnidade() + " - " + consumidor.getTelefoneResponsavel()));
                break;
            case 3:
                trifasicaNode.add(new DefaultMutableTreeNode(consumidor.getIdentificadorUnidadeGrid() + " - " + consumidor.getResponsavelUnidade() + " - " + consumidor.getTelefoneResponsavel()));
                break;
            default:
                throw new AssertionError("Tipo de corrente não suportado: " + consumidor.getTipoCorrenteFase());
        }
    }

    root.add(monofasicaNode);
    root.add(bifasicaNode);
    root.add(trifasicaNode);

    DefaultTreeModel treeModel = new DefaultTreeModel(root);
    tree.setModel(treeModel);

    }    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sobre");
        setUndecorated(true);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Info.png"))); // NOI18N
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel7.setPreferredSize(new java.awt.Dimension(150, 150));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Conectando interfaces com adaptadores");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("jLabel3");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Tipo de conexão");

        jScrollPane1.setViewportView(jTree1);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(39, 39, 39)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton7.setText("Fechar");
        jButton7.setToolTipText("");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(224, 224, 224)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jButton7)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

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
            java.util.logging.Logger.getLogger(InformacaoConexao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacaoConexao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacaoConexao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacaoConexao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InformacaoConexao dialog = new InformacaoConexao(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables
}
