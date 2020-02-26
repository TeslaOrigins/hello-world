/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface_sistema_de_supermercado;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Tesla
 */
public class Tela_Busca extends javax.swing.JFrame {
    

    DefaultListModel defaultListModel = new DefaultListModel();
    
    /**
     * Creates new form Tela_Interna_Chefe
     */
    public Tela_Busca() throws FileNotFoundException {
        initComponents();
        Background b= new Background();
        setLocationRelativeTo(null);
        setResizable(false);
        
        this.bindData(); //adiciona elementos na lista da tela
        setLocationRelativeTo(null); //ela no centro
        setDefaultCloseOperation( Tela_Busca.DISPOSE_ON_CLOSE );
    }
    
    public ArrayList getFuncionarios() throws FileNotFoundException{
        ArrayList func = new ArrayList();
        Scanner in = new Scanner(new File("Cadastro.txt"));
        
        while (in.hasNextLine()) {
            String s = in.nextLine();
            String[] sArray = s.split(";");
            func.add(sArray[0]);
        }
        
        return func;
    }
    
    private void bindData() throws FileNotFoundException{
        getFuncionarios().stream().forEach((func) -> {
            defaultListModel.addElement(func);
        });
        jList1.setModel(defaultListModel);
        jList1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
    private void searchFilter(String parametro) throws FileNotFoundException{
        DefaultListModel itensFiltrados = new DefaultListModel();
        ArrayList funcs = getFuncionarios();
        funcs.stream().forEach((func) -> {
            String funcName = func.toString().toLowerCase();
            if(funcName.contains(parametro.toLowerCase())){
                itensFiltrados.addElement(func);
            }
        });
        defaultListModel = itensFiltrados;
        jList1.setModel(defaultListModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        C2_identificador = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Bem vindo chefe, Qual usuario deseja editar?");

        C2_identificador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C2_identificadorActionPerformed(evt);
            }
        });
        C2_identificador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                C2_identificadorKeyReleased(evt);
            }
        });

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 30, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(34, 34, 34))
                    .addComponent(C2_identificador)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(C2_identificador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void C2_identificadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C2_identificadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_C2_identificadorActionPerformed

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        JOptionPane.showMessageDialog(rootPane, jList1.getSelectedValue(), "Funcionario Selecionado", JOptionPane.INFORMATION_MESSAGE);
        Tela_Cadastro Tela_C = new Tela_Cadastro();
        try {
            Tela_C.getBttn1_Cadastrar().setVisible(false);
            Tela_C.getBttn1_Alterar().setVisible(true);
            Tela_C.getJLabel1().setText("ALTERAR FUNCIONÁRIOS");
            Tela_C.getT1_Cargo().setVisible(true);
            Tela_C.getC1_Cargo().setVisible(true);
            Tela_C.getC2_Senha().setEditable(false);  
            Tela_C.alteraFuncionario(jList1.getSelectedValue().toString());
            Tela_C.setVisible(true);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tela_Busca.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Tela_Busca.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }//GEN-LAST:event_jList1MouseClicked

    private void C2_identificadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_C2_identificadorKeyReleased
        try {
            searchFilter(C2_identificador.getText());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tela_Busca.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_C2_identificadorKeyReleased

    public String identificadorToSring(){
        return C2_identificador.getText();
    }
    
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
            java.util.logging.Logger.getLogger(Tela_Busca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Busca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Busca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Busca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Tela_Busca().setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Tela_Busca.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField C2_identificador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
