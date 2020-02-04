package Interface_sistema_de_supermercado;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFrame;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import sistema_de_supermercado.TipoUsuario;

/**
 *
 * @author Natalo Santos
 */
public class Tela_Login extends javax.swing.JFrame {

    /**
     * Creates new form Tela_Login
     */
    public Tela_Login() {
        initComponents();
        this.setLocationRelativeTo(null); //tela no centro

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        T1_Login = new javax.swing.JLabel();
        T1_SENHA = new javax.swing.JLabel();
        C1_LOGIN = new javax.swing.JTextField();
        C1_SENHA = new javax.swing.JPasswordField();
        Bttn1_Entrar = new javax.swing.JButton();
        Bttn1_Cadastrar = new javax.swing.JButton();
        T1_N_SuperM = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        T1_Login.setText("LOGIN:");

        T1_SENHA.setText("SENHA:");

        C1_LOGIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C1_LOGINActionPerformed(evt);
            }
        });

        C1_SENHA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C1_SENHAActionPerformed(evt);
            }
        });

        Bttn1_Entrar.setText("Entrar");
        Bttn1_Entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bttn1_EntrarActionPerformed(evt);
            }
        });

        Bttn1_Cadastrar.setText("Cadastrar Funcionário");
        Bttn1_Cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bttn1_CadastrarActionPerformed(evt);
            }
        });

        T1_N_SuperM.setText("SUPERMERCADO  DO TEAM STI");

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("AUTENTICAÇÃO DE USUÁRIO");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel1)
                .addContainerGap(112, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(T1_SENHA)
                    .addComponent(T1_Login))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Bttn1_Entrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Bttn1_Cadastrar))
                    .addComponent(C1_LOGIN)
                    .addComponent(C1_SENHA))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(T1_N_SuperM, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(T1_N_SuperM, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(C1_LOGIN)
                    .addComponent(T1_Login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(C1_SENHA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T1_SENHA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Bttn1_Entrar)
                    .addComponent(Bttn1_Cadastrar))
                .addContainerGap(82, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void C1_SENHAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C1_SENHAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_C1_SENHAActionPerformed

    private void Bttn1_CadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bttn1_CadastrarActionPerformed
        Tela_Cadastro Tela_C = new Tela_Cadastro(); //chama a tela de cadastro
        Tela_C.setVisible(true);             // serve para mostrar o Jframe na tela
        Tela_C.setLocationRelativeTo(null);     // tela no centro 
        Tela_C.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();        //fecha a tela após o click 
    }//GEN-LAST:event_Bttn1_CadastrarActionPerformed

    private void C1_LOGINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C1_LOGINActionPerformed
    }//GEN-LAST:event_C1_LOGINActionPerformed

    private void Bttn1_EntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bttn1_EntrarActionPerformed
        File cadastro = new File("Cadastro.txt");
        int tipo = 0;
        boolean achou = false;
        String login = C1_LOGIN.getText().trim();
        String senha = String.valueOf(C1_SENHA.getPassword()); //usa valueOf pq o campo é senha é um char, e queremos o text.
        
        try {
            Scanner in = new Scanner(new File("Cadastro.txt"));
            while (in.hasNextLine()) {
                String s = in.nextLine();
                String[] sArray = s.split(";");
                String tipoUser = sArray[5];
                //System.out.println(sArray[0]); // verificar pelo próprio console do netbeans se ta pegando o vetor.
                // System.out.println(sArray[1]);
                
                if (login.equals(sArray[3]) && senha.equals(sArray[4])) {
                    if(tipoUser.equals(TipoUsuario.usuarioFuncionarioToString())){
                        tipo = TipoUsuario.USUARIO_FUNCIONARIO;
                    } else if(tipoUser.equals(TipoUsuario.usuarioGerenteToString())){    
                        tipo = TipoUsuario.USUARIO_GERENTE;
                    } else if(tipoUser.equals(TipoUsuario.usuarioChefeToString())){
                        tipo = TipoUsuario.USUARIO_CHEFE;
                    }               
                }
            }
            switch(tipo){
                case TipoUsuario.USUARIO_FUNCIONARIO:
                    JOptionPane.showMessageDialog(null, "Login Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                    Tela_Interna_Funcionario Tela_IF = new Tela_Interna_Funcionario(); //chama a tela interna funcionario
                    Tela_IF.setVisible(true);                  // serve para mostrar o Jframe na tela
                    Tela_IF.setLocationRelativeTo(null);       // tela no centro 
                    Tela_IF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    this.dispose();                           //fecha a tela após o click 
                    break;
                case TipoUsuario.USUARIO_GERENTE:
                    JOptionPane.showMessageDialog(null, "Login Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                    Tela_Interna_Gerente Tela_IG = new Tela_Interna_Gerente(); //chama a tela interna gerente
                    Tela_IG.setVisible(true);                  // serve para mostrar o Jframe na tela
                    Tela_IG.setLocationRelativeTo(null);       // tela no centro 
                    Tela_IG.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    this.dispose();
                    break;
                case TipoUsuario.USUARIO_CHEFE:   
                    JOptionPane.showMessageDialog(null, "Login Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                    Tela_Interna_Chefe Tela_IC = new Tela_Interna_Chefe(); //chama a tela interna Chefe
                    Tela_IC.setVisible(true);                  // serve para mostrar o Jframe na tela
                    Tela_IC.setLocationRelativeTo(null);       // tela no centro 
                    Tela_IC.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    this.dispose();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "senha/login incorreto", "error", JOptionPane.ERROR_MESSAGE);
            }

            in.close();

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,
                    "User Database Not Found", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_Bttn1_EntrarActionPerformed

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
            java.util.logging.Logger.getLogger(Tela_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bttn1_Cadastrar;
    private javax.swing.JButton Bttn1_Entrar;
    private javax.swing.JTextField C1_LOGIN;
    private javax.swing.JPasswordField C1_SENHA;
    private javax.swing.JLabel T1_Login;
    private javax.swing.JLabel T1_N_SuperM;
    private javax.swing.JLabel T1_SENHA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}