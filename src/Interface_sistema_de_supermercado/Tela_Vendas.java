package Interface_sistema_de_supermercado;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sistema_de_supermercado.Produto;

/**
 *
 * @author Paulo
 */
public final class Tela_Vendas extends javax.swing.JFrame {

    String op;
    ArrayList<Produto> listaProd = new ArrayList<>(); //Criando um ArrayList para os produtos (uma lista de produtos)

    public void CarregarTabProd() {
        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Código", "Produto", "Preço", "Qtd", "Subtotal"}, 0); //Modelagem de tabela padrão
        for (int i = 0; i < listaProd.size(); i++) {
            Object linha[] = new Object[]{listaProd.get(i).getCodBarras(),
                                          listaProd.get(i).getNome(),
                                          listaProd.get(i).getPreco(),
                                          listaProd.get(i).getQtd(),
                                          listaProd.get(i).getSubtotal()};
            modelo.addRow(linha); //Add a linha
        }
        tbl_prod.setModel(modelo);
        tbl_prod.getColumnModel().getColumn(0).setResizable(false);
        tbl_prod.getColumnModel().getColumn(0).setPreferredWidth(40);
        tbl_prod.getColumnModel().getColumn(1).setResizable(false);
        tbl_prod.getColumnModel().getColumn(1).setPreferredWidth(150);
        tbl_prod.getColumnModel().getColumn(2).setResizable(false);
        tbl_prod.getColumnModel().getColumn(2).setPreferredWidth(50);
        tbl_prod.getColumnModel().getColumn(3).setResizable(false);
        tbl_prod.getColumnModel().getColumn(3).setPreferredWidth(20);
        tbl_prod.getColumnModel().getColumn(4).setResizable(false);
    }

    public Tela_Vendas(java.awt.Frame parent, boolean modal) {
        //super(parent, modal);
        setResizable(false);
        initComponents();
        this.setLocationRelativeTo(null);
        op = "Navegar";
        ManipularInterface();
        c_totalPag.setEnabled(false);
        c_nomeProd.setEnabled(false);
        c_preço.setEnabled(false);
        this.setDefaultCloseOperation(Tela_Vendas.DISPOSE_ON_CLOSE );
    }

    /**
     * Creates new form Tela_Interna_Funcionario
     */
    public Tela_Vendas() {
        Background b= new Background();
        setResizable(false);
        b.setVisible(true);
        initComponents();
        this.setLocationRelativeTo(null); //Janela no centro da tela
        c_totalPag.setEnabled(false);
        c_nomeProd.setEnabled(false);
       this.setDefaultCloseOperation(Tela_Vendas.DISPOSE_ON_CLOSE );


    }

    public void pesquisaEst() {
        try {
            FileInputStream estoque = new FileInputStream("Estoque.txt"); //Entrada pra ler
            InputStreamReader input = new InputStreamReader(estoque); //Quem vai ler o arquivo
            BufferedReader br = new BufferedReader(input); //Ler linha por linha (função readLine) até encontrar o \n
            String linha;

            do { // Faça algo enquanto tiver conteudo
                linha = br.readLine(); //Leio a linha
                if (linha != null) { //Se for lido e diferente de null, faça:
                    String[] sArray = linha.split(";"); //Dividir a linha de acordo com o ; encontrado

                    if (sArray[0].equals(c_codBarras.getText())) { //Se a String palavras na posição 0 for igual ao lido no campo do codigoB
                        System.out.println(sArray[0] + " " + sArray[1] + " " + sArray[2] + " " + sArray[3]);
                        c_nomeProd.setText(sArray[1].toUpperCase());
                        c_preço.setText(sArray[2]);
                    }
                }
            } while (linha != null);

        } catch (Exception e) {
            Logger.getLogger(Tela_Vendas.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public void addCarrinho() {
        try {
            FileInputStream estoque = new FileInputStream("Estoque.txt"); //Entrada pra ler
            InputStreamReader input = new InputStreamReader(estoque); //Quem vai ler o arquivo
            BufferedReader br = new BufferedReader(input); //Ler linha por linha (função readLine) até encontrar o \n
            String linha;
            int quant = 0;
            do { // Faça algo enquanto tiver conteudo
                linha = br.readLine(); //Leio a linha
                if (linha != null) { //Se for lido e diferente de null, faça:
                    String[] sArray = linha.split(";"); //Dividir a linha de acordo com o ; encontrado
                    if (sArray[0].equals(c_codBarras.getText())) { //Se a String palavras na posição 0 for igual ao lido no campo do codigoB
                        quant = Integer.parseInt(sArray[3]);
                    }
                }
            } while (linha != null);
            if (Integer.parseInt(c_qtd.getText()) <= quant) {
                int cod = Integer.parseInt(c_codBarras.getText());
                double pre = Double.parseDouble(c_preço.getText());
                int qd = Integer.parseInt(c_qtd.getText());
                Produto P = new Produto(cod, c_nomeProd.getText(), pre, qd, qd * pre);
                listaProd.add(P);
            } else {
                JOptionPane.showMessageDialog(null, "Não temos essa quantidade em estoque.", "Requisição Inválida", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            Logger.getLogger(Tela_Vendas.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public double somarValores() {
        double somaTotal = 0;
        try {
            for (int i = 0; i < tbl_prod.getRowCount(); i++) {
                somaTotal += Double.parseDouble(tbl_prod.getValueAt(i, 4).toString());
                //c_totalPag.setText("" + somaTotal);
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro ao somar: " + e.getMessage());
        }
    return somaTotal;
    }

    public void ManipularInterface() {
        switch (op) {
            case "Navegar":
                btn_add.setEnabled(false);
                btn_remover.setEnabled(false);
                btn_pag.setEnabled(false);
                btn_cancel.setEnabled(false);
                c_qtd.setEnabled(true);
                break;
            case "Pesquisar":
                btn_add.setEnabled(true);
                btn_remover.setEnabled(false);
                btn_pag.setEnabled(false);
                btn_cancel.setEnabled(false);
                c_qtd.setEnabled(true);
            case "Adicionar":
                btn_add.setEnabled(true);
                btn_remover.setEnabled(false);
                btn_pag.setEnabled(true);
                btn_cancel.setEnabled(true);
                c_qtd.setEnabled(true);
                break;
            case "Remover":
                btn_add.setEnabled(true);
                btn_remover.setEnabled(true);
                btn_pag.setEnabled(true);
                btn_cancel.setEnabled(true);
                c_qtd.setEnabled(true);
                break;
            default:
                System.out.println("Inválido");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_prod = new javax.swing.JTable();
        btn_pag = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        c_totalPag = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        c_codBarras = new javax.swing.JTextField();
        btn_pesquisar = new javax.swing.JButton();
        btn_add = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        c_nomeProd = new javax.swing.JTextField();
        c_preço = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        c_qtd = new javax.swing.JTextField();
        btn_remover = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(44, 62, 80));

        jPanel5.setBackground(new java.awt.Color(248, 148, 6));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("VENDA DE PRODUTOS");

        jPanel3.setBackground(new java.awt.Color(44, 62, 80));

        jPanel1.setBackground(new java.awt.Color(44, 62, 80));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "CARRINHO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        tbl_prod.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbl_prod.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Produto", "Preço", "Qtd", "Subtotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_prod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_prodMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_prod);
        if (tbl_prod.getColumnModel().getColumnCount() > 0) {
            tbl_prod.getColumnModel().getColumn(0).setResizable(false);
            tbl_prod.getColumnModel().getColumn(0).setPreferredWidth(40);
            tbl_prod.getColumnModel().getColumn(1).setResizable(false);
            tbl_prod.getColumnModel().getColumn(1).setPreferredWidth(150);
            tbl_prod.getColumnModel().getColumn(2).setResizable(false);
            tbl_prod.getColumnModel().getColumn(2).setPreferredWidth(50);
            tbl_prod.getColumnModel().getColumn(3).setResizable(false);
            tbl_prod.getColumnModel().getColumn(3).setPreferredWidth(20);
            tbl_prod.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        btn_pag.setBackground(new java.awt.Color(0, 102, 0));
        btn_pag.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_pag.setForeground(new java.awt.Color(255, 255, 255));
        btn_pag.setText("PAGAMENTO");
        btn_pag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pagActionPerformed(evt);
            }
        });

        btn_cancel.setBackground(new java.awt.Color(102, 0, 0));
        btn_cancel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_cancel.setForeground(new java.awt.Color(255, 255, 255));
        btn_cancel.setText("CANCELAR VENDA");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(44, 62, 80));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "SUBTOTAL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel2.setBackground(new java.awt.Color(44, 62, 80));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("TOTAL A PAGAR:");

        c_totalPag.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        c_totalPag.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(c_totalPag, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c_totalPag, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(44, 62, 80));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "DETALHES DO PRODUTO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Código:");

        btn_pesquisar.setText(" Pesquisar");
        btn_pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pesquisarActionPerformed(evt);
            }
        });

        btn_add.setBackground(new java.awt.Color(0, 102, 204));
        btn_add.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_add.setForeground(new java.awt.Color(255, 255, 255));
        btn_add.setText("ADICIONAR AO CARRINHO");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nome:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Preço:");

        c_nomeProd.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        c_preço.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Quantidade:");

        btn_remover.setBackground(new java.awt.Color(102, 0, 0));
        btn_remover.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_remover.setForeground(new java.awt.Color(255, 255, 255));
        btn_remover.setText("REMOVER");
        btn_remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btn_add)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_remover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c_codBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(c_qtd, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(c_preço, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c_nomeProd)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c_codBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c_nomeProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c_qtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c_preço, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_remover, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btn_pag, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(208, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_pag, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(262, 262, 262)
                .addComponent(jLabel1)
                .addContainerGap(272, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pesquisarActionPerformed
        op = "Pesquisar";
        ManipularInterface();
        pesquisaEst();

    }//GEN-LAST:event_btn_pesquisarActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        op = "Adicionar";
        ManipularInterface();
        addCarrinho();
        CarregarTabProd();
        c_totalPag.setText("" +somarValores());

    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        this.dispose(); //Encerra a compra e fecha
        Tela_Login Tela_L = new Tela_Login(); //Instanciei a tela de login
        Tela_L.setVisible(true);             //Mostrar tela de login novamente
        Tela_L.setLocationRelativeTo(null);     //Centro
        Tela_L.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void btn_removerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removerActionPerformed
        int index = tbl_prod.getSelectedRow();
        if(index>=0 && index<listaProd.size()){
            listaProd.remove(index);
        }
        CarregarTabProd();
        c_totalPag.setText("" +somarValores());
        op = "Navegar";
        ManipularInterface();
    }//GEN-LAST:event_btn_removerActionPerformed

    private void tbl_prodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_prodMouseClicked
        int index = tbl_prod.getSelectedRow();
        if (index >= 0 && index < listaProd.size()) {
            Produto P = listaProd.get(index);
            c_codBarras.setText(String.valueOf(P.getCodBarras()));
            c_nomeProd.setText(P.getNome());
            c_preço.setText(String.valueOf(P.getPreco()));
            op = "Remover";
            ManipularInterface();
        }
    }//GEN-LAST:event_tbl_prodMouseClicked

    private void btn_pagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pagActionPerformed
        this.dispose(); //Encerra a compra e fecha
        Produto pagamento = new Produto();
        pagamento.setTotPagamento(c_totalPag.getText());
        Tela_Pagamento Tela_P = new Tela_Pagamento(); //Instancia tela pag
        Tela_P.exportarPag(pagamento);
        Tela_P.setVisible(true);             //Mostrar tela pag 
        Tela_P.setLocationRelativeTo(null);     //Centro
        Tela_P.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }//GEN-LAST:event_btn_pagActionPerformed

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
            java.util.logging.Logger.getLogger(Tela_Vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Tela_Vendas dialog = new Tela_Vendas(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_pag;
    private javax.swing.JButton btn_pesquisar;
    private javax.swing.JButton btn_remover;
    private javax.swing.JTextField c_codBarras;
    private javax.swing.JTextField c_nomeProd;
    private javax.swing.JTextField c_preço;
    private javax.swing.JTextField c_qtd;
    private javax.swing.JTextField c_totalPag;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_prod;
    // End of variables declaration//GEN-END:variables
}
