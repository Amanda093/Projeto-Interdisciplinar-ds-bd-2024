/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Conexao;

/**
 *
 * @author noeba
 */
public class FrmCrud extends javax.swing.JDialog {
    Conexao conexao;
    /**
     * Creates new form FrmCrud
     */
    public FrmCrud(String table) {
        conexao = new Conexao();
        conexao.conecta();
        
        ImageIcon icone = new ImageIcon("src/img/gamesphere-ico.png");
        setIconImage(icone.getImage());
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        initComponents();
         try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmCrud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCrud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCrud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCrud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        };
        lblTitulo.setText(table);
        setTitle(table);
        tblCrud.setFocusable(false);
        tblCrud.setIntercellSpacing(new Dimension(0, 0));
        tblCrud.setRowHeight(25);
        tblCrud.setGridColor(new Color(240, 240, 240));
        tblCrud.setSelectionBackground(new Color(217, 235, 249));
        tblCrud.getTableHeader().setFont(new Font("", Font.BOLD, 12));
        tblCrud.setSelectionForeground(Color.BLACK);

        switch(table){
            case "Cliente":
                getContentPane().remove(lblCampo9);
                getContentPane().remove(lblCampo8);
                getContentPane().remove(lblCampo7);
                getContentPane().remove(txtCampo9);
                getContentPane().remove(txtCampo8);
                getContentPane().remove(txtCampo7);
                
                lblCampo1.setText("CodCliente:");
                lblCampo2.setText("Nome:");
                lblCampo3.setText("Telefone:");
                lblCampo4.setText("Endereco:");
                lblCampo5.setText("RG:");
                lblCampo6.setText("CPF:");
                tblCrud.setModel(new javax.swing.table.DefaultTableModel(
                new Object [] [] {
                    {null, null, null, null, null, null}
                },
                new String [] {"CodCliente", "Nome", "Telefone", "Endereco", "RG", "CPF"})
                {
                boolean[] canEdit = new boolean []{
                false, false, false, false, false, false};
        
                public boolean isCellEditable(int rowIndex, int columnIndex){
                return canEdit [columnIndex];}
                });
                tblCrud.setAutoCreateRowSorter(true);

                conexao.executaSQL("select * from cliente order by CodCliente");
        
                DefaultTableModel modelocliente = (DefaultTableModel) tblCrud.getModel();
                modelocliente.setNumRows(0);
                try {
                    conexao.resultset.beforeFirst();
                    while(conexao.resultset.next()) {
                        modelocliente.addRow(new Object[] {
                        conexao.resultset.getString("CodCliente"),
                        conexao.resultset.getString("Nome"),
                        conexao.resultset.getString("Telefone"),
                        conexao.resultset.getString("Endereco"),
                        conexao.resultset.getString("RG"),
                        conexao.resultset.getString("CPF")
                        });
                    }
                } catch (SQLException erro) {
                    JOptionPane.showMessageDialog(null, "\n Erro ao listar dados da tabela!! :\n " + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                }
                
            break;
            
            case "Fornecedor":
                
                getContentPane().remove(lblCampo9);
                getContentPane().remove(lblCampo8);
                getContentPane().remove(lblCampo7);
                getContentPane().remove(lblCampo6);
                getContentPane().remove(txtCampo9);
                getContentPane().remove(txtCampo8);
                getContentPane().remove(txtCampo7);
                getContentPane().remove(txtCampo6);
                
                lblCampo1.setText("CodFornecedor:");
                lblCampo2.setText("Nome:");
                lblCampo3.setText("CNPJ:");
                lblCampo4.setText("Telefone:");
                lblCampo5.setText("Endereco:");
                tblCrud.setModel(new javax.swing.table.DefaultTableModel(
                new Object [] [] {
                    {null, null, null, null, null}
                },
                new String [] {"CodFornecedor", "Nome", "CNPJ", "Telefone", "Endereco"})
                {
                boolean[] canEdit = new boolean []{
                false, false, false, false, false};
        
                public boolean isCellEditable(int rowIndex, int columnIndex){
                return canEdit [columnIndex];}
                });
                
                tblCrud.setAutoCreateRowSorter(true);

                conexao.executaSQL("select * from fornecedor order by CodFornecedor");
        
                DefaultTableModel modelofornecedor = (DefaultTableModel) tblCrud.getModel();
                modelofornecedor.setNumRows(0);
                try {
                    conexao.resultset.beforeFirst();
                    while(conexao.resultset.next()) {
                        modelofornecedor.addRow(new Object[] {
                        conexao.resultset.getString("CodFornecedor"),
                        conexao.resultset.getString("Nome"),
                        conexao.resultset.getString("CNPJ"),
                        conexao.resultset.getString("Telefone"),
                        conexao.resultset.getString("endereco")
                        });
                    }
                } catch (SQLException erro) {
                    JOptionPane.showMessageDialog(null, "\n Erro ao listar dados da tabela!! :\n " + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                }
                
            break;
            
            case "Funcionario":
                lblCampo1.setText("CodFuncionario:");
                lblCampo2.setText("Nome:");
                lblCampo3.setText("Salario:");
                lblCampo4.setText("Email:");
                lblCampo5.setText("Telefone:");
                lblCampo6.setText("RG:");
                lblCampo7.setText("CPF:");
                lblCampo8.setText("Usuario:");
                lblCampo9.setText("Senha:");
                tblCrud.setModel(new javax.swing.table.DefaultTableModel(
                new Object [] [] {
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null}
                },
                new String [] {"CodFuncionario", "Nome", "Salario", "Email", "Telefone", "RG", "CPF", "Usuario", "Senha"})
                {
                boolean[] canEdit = new boolean []{
                false, false, false, false, false, false, false, false, false};
        
                public boolean isCellEditable(int rowIndex, int columnIndex){
                return canEdit [columnIndex];}
                });
                
                tblCrud.setAutoCreateRowSorter(true);

                conexao.executaSQL("select * from funcionario order by CodFuncionario");
        
                DefaultTableModel modelofuncionario = (DefaultTableModel) tblCrud.getModel();
                modelofuncionario.setNumRows(0);
                try {
                    conexao.resultset.beforeFirst();
                    while(conexao.resultset.next()) {
                        modelofuncionario.addRow(new Object[] {
                        conexao.resultset.getString("CodFuncionario"),
                        conexao.resultset.getString("Nome"),
                        conexao.resultset.getString("Salario"),
                        conexao.resultset.getString("Email"),
                        conexao.resultset.getString("Telefone"),
                        conexao.resultset.getString("RG"),
                        conexao.resultset.getString("CPF"),
                        conexao.resultset.getString("Usuario"),
                        conexao.resultset.getString("Senha")
                        });
                    }
                } catch (SQLException erro) {
                    JOptionPane.showMessageDialog(null, "\n Erro ao listar dados da tabela!! :\n " + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                }
                
            break;
            
            case "Produto":
                
                getContentPane().remove(lblCampo9);
                getContentPane().remove(lblCampo8);
                getContentPane().remove(lblCampo7);
                getContentPane().remove(lblCampo6);
                getContentPane().remove(txtCampo9);
                getContentPane().remove(txtCampo8);
                getContentPane().remove(txtCampo7);
                getContentPane().remove(txtCampo6);
                
                lblCampo1.setText("CodProduto:");
                lblCampo2.setText("Nome:");
                lblCampo3.setText("Preco:");
                lblCampo4.setText("CodTipoProd:");
                lblCampo5.setText("CodFornecedor:");
                tblCrud.setModel(new javax.swing.table.DefaultTableModel(
                new Object [] [] {
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null}
                },
                new String [] {"CodProduto", "Nome", "Preco", "CodTipoProd", "CodFornecedor"})
                {
                boolean[] canEdit = new boolean []{
                false, false, false, false, false};
        
                public boolean isCellEditable(int rowIndex, int columnIndex){
                return canEdit [columnIndex];}
                });
                
                tblCrud.setAutoCreateRowSorter(true);

                conexao.executaSQL("select * from produto order by CodProduto");
        
                DefaultTableModel modeloproduto = (DefaultTableModel) tblCrud.getModel();
                modeloproduto.setNumRows(0);
                try {
                    conexao.resultset.beforeFirst();
                    while(conexao.resultset.next()) {
                        modeloproduto.addRow(new Object[] {
                        conexao.resultset.getString("CodProduto"),
                        conexao.resultset.getString("Nome"),
                        conexao.resultset.getString("Preco"),
                        conexao.resultset.getString("CodTipoProd"),
                        conexao.resultset.getString("CodFornecedor")
                        });
                    }
                } catch (SQLException erro) {
                    JOptionPane.showMessageDialog(null, "\n Erro ao listar dados da tabela!! :\n " + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                }
                
            break;
            
            case "Reserva":
                getContentPane().remove(lblCampo9);
                getContentPane().remove(lblCampo8);
                getContentPane().remove(txtCampo9);
                getContentPane().remove(txtCampo8);
                
                lblCampo1.setText("CodReserva:");
                lblCampo2.setText("DataInicial:");
                lblCampo3.setText("DataFinal:");
                lblCampo4.setText("CodTipoReserva:");
                lblCampo5.setText("CodCliente:");
                lblCampo6.setText("CodFuncionario:");
                lblCampo7.setText("CodProduto:");
                tblCrud.setModel(new javax.swing.table.DefaultTableModel(
                new Object [] [] {
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null}
                },
                new String [] {"CodReserva", "DataInicial", "DataFinal", "CodTipoReserva", "CodCliente", "CodFuncionario", "CodProduto"})
                {
                boolean[] canEdit = new boolean []{
                false, false, false, false, false, false, false, false};
        
                public boolean isCellEditable(int rowIndex, int columnIndex){
                return canEdit [columnIndex];}
                });
                
                tblCrud.setAutoCreateRowSorter(true);

                conexao.executaSQL("select * from reserva order by CodReserva");
        
                DefaultTableModel modeloreserva = (DefaultTableModel) tblCrud.getModel();
                modeloreserva.setNumRows(0);
                try {
                    conexao.resultset.beforeFirst();
                    while(conexao.resultset.next()) {
                        modeloreserva.addRow(new Object[] {
                        conexao.resultset.getString("CodReserva"),
                        conexao.resultset.getString("DataInicial"),
                        conexao.resultset.getString("DataFinal"),
                        conexao.resultset.getString("CodTipoReserva"),
                        conexao.resultset.getString("CodCliente"),
                        conexao.resultset.getString("CodFuncionario"),
                        conexao.resultset.getString("CodProduto")
                        });
                    }
                } catch (SQLException erro) {
                    JOptionPane.showMessageDialog(null, "\n Erro ao listar dados da tabela!! :\n " + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                }
                
            break;
            
            case "Tipo do Produto":
                getContentPane().remove(lblCampo9);
                getContentPane().remove(lblCampo8);
                getContentPane().remove(lblCampo7);
                getContentPane().remove(lblCampo6);
                getContentPane().remove(lblCampo5);
                getContentPane().remove(lblCampo4);
                getContentPane().remove(lblCampo1);
                getContentPane().remove(txtCampo9);
                getContentPane().remove(txtCampo8);
                getContentPane().remove(txtCampo7);
                getContentPane().remove(txtCampo6);
                getContentPane().remove(txtCampo5);
                getContentPane().remove(txtCampo4);
                getContentPane().remove(txtCampo1);
                
                lblCampo2.setText("CodTipoProd:");
                lblCampo3.setText("Descricao:");
                tblCrud.setModel(new javax.swing.table.DefaultTableModel(
                new Object [] [] {
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null}
                },
                new String [] {"CodTipoProd", "Descricao"})
                {
                boolean[] canEdit = new boolean []{
                false, false};
        
                public boolean isCellEditable(int rowIndex, int columnIndex){
                return canEdit [columnIndex];}
                });
                
                tblCrud.setAutoCreateRowSorter(true);

                conexao.executaSQL("select * from tipo_produto order by CodTipoProd");
        
                DefaultTableModel modelotipoprod = (DefaultTableModel) tblCrud.getModel();
                modelotipoprod.setNumRows(0);
                try {
                    conexao.resultset.beforeFirst();
                    while(conexao.resultset.next()) {
                        modelotipoprod.addRow(new Object[] {
                        conexao.resultset.getString("CodTipoProd"),
                        conexao.resultset.getString("Descricao")
                        });
                    }
                } catch (SQLException erro) {
                    JOptionPane.showMessageDialog(null, "\n Erro ao listar dados da tabela!! :\n " + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                }
                
            break;
            
            case "Tipo da Reserva":
                getContentPane().remove(lblCampo9);
                getContentPane().remove(lblCampo8);
                getContentPane().remove(lblCampo7);
                getContentPane().remove(lblCampo6);
                getContentPane().remove(lblCampo5);
                getContentPane().remove(lblCampo4);
                getContentPane().remove(lblCampo1);
                getContentPane().remove(txtCampo9);
                getContentPane().remove(txtCampo8);
                getContentPane().remove(txtCampo7);
                getContentPane().remove(txtCampo6);
                getContentPane().remove(txtCampo5);
                getContentPane().remove(txtCampo4);
                getContentPane().remove(txtCampo1);
                
                lblCampo2.setText("CodTipoReserva:");
                lblCampo3.setText("Descricao:");
                tblCrud.setModel(new javax.swing.table.DefaultTableModel(
                new Object [] [] {
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null}
                },
                new String [] {"CodTipoReserva", "Descricao"})
                {
                boolean[] canEdit = new boolean []{
                false, false};
        
                public boolean isCellEditable(int rowIndex, int columnIndex){
                return canEdit [columnIndex];}
                });
                
                tblCrud.setAutoCreateRowSorter(true);

                conexao.executaSQL("select * from tipo_reserva order by CodTipoReserva");
        
                DefaultTableModel modelotiporeserva = (DefaultTableModel) tblCrud.getModel();
                modelotiporeserva.setNumRows(0);
                try {
                    conexao.resultset.beforeFirst();
                    while(conexao.resultset.next()) {
                        modelotiporeserva.addRow(new Object[] {
                        conexao.resultset.getString("CodTipoReserva"),
                        conexao.resultset.getString("Descricao")
                        });
                    }
                } catch (SQLException erro) {
                    JOptionPane.showMessageDialog(null, "\n Erro ao listar dados da tabela!! :\n " + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                }
                
            break;
            
            default:
                
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

        lblTitulo = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        txtCampo1 = new javax.swing.JTextField();
        lblCampo1 = new javax.swing.JLabel();
        txtCampo2 = new javax.swing.JTextField();
        lblCampo2 = new javax.swing.JLabel();
        lblCampo3 = new javax.swing.JLabel();
        txtCampo3 = new javax.swing.JTextField();
        lblCampo4 = new javax.swing.JLabel();
        lblCampo5 = new javax.swing.JLabel();
        txtCampo5 = new javax.swing.JTextField();
        txtCampo4 = new javax.swing.JTextField();
        lblCampo6 = new javax.swing.JLabel();
        lblCampo8 = new javax.swing.JLabel();
        lblCampo7 = new javax.swing.JLabel();
        lblCampo9 = new javax.swing.JLabel();
        txtCampo7 = new javax.swing.JTextField();
        txtCampo9 = new javax.swing.JTextField();
        txtCampo8 = new javax.swing.JTextField();
        txtCampo6 = new javax.swing.JTextField();
        btnPrimeiro = new javax.swing.JButton();
        btnUltimo = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnProximo = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        btnGravar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        scrScrollcrud = new javax.swing.JScrollPane();
        tblCrud = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();
        txtPesquisa = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 74, 87));
        lblTitulo.setText("Crud");
        lblTitulo.setName("lblTitulo"); // NOI18N

        btnVoltar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.setToolTipText("Voltar para a pagina inicial");
        btnVoltar.setName("btnVoltar"); // NOI18N
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        txtCampo1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCampo1.setName("txtCampo1"); // NOI18N
        txtCampo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCampo1ActionPerformed(evt);
            }
        });

        lblCampo1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCampo1.setText("Código:");
        lblCampo1.setName("lblCampo1"); // NOI18N

        txtCampo2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCampo2.setName("txtCampo2"); // NOI18N
        txtCampo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCampo2ActionPerformed(evt);
            }
        });

        lblCampo2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCampo2.setText("Campo 2:");
        lblCampo2.setName("lblCampo2"); // NOI18N

        lblCampo3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCampo3.setText("Campo 3:");
        lblCampo3.setName("lblCampo3"); // NOI18N

        txtCampo3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCampo3.setName("txtCampo3"); // NOI18N
        txtCampo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCampo3ActionPerformed(evt);
            }
        });

        lblCampo4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCampo4.setText("Campo 4:");
        lblCampo4.setName("lblCampo4"); // NOI18N

        lblCampo5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCampo5.setText("Campo 5:");
        lblCampo5.setName("lblCampo5"); // NOI18N

        txtCampo5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCampo5.setName("txtCampo5"); // NOI18N
        txtCampo5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCampo5ActionPerformed(evt);
            }
        });

        txtCampo4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCampo4.setName("txtCampo4"); // NOI18N
        txtCampo4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCampo4ActionPerformed(evt);
            }
        });

        lblCampo6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCampo6.setText("Campo 6:");
        lblCampo6.setName("lblCampo6"); // NOI18N

        lblCampo8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCampo8.setText("Campo 8:");
        lblCampo8.setName("lblCampo8"); // NOI18N

        lblCampo7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCampo7.setText("Campo 7:");
        lblCampo7.setName("lblCampo7"); // NOI18N

        lblCampo9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCampo9.setText("Campo 9:");
        lblCampo9.setName("lblCampo9"); // NOI18N

        txtCampo7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCampo7.setName("txtCampo7"); // NOI18N
        txtCampo7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCampo7ActionPerformed(evt);
            }
        });

        txtCampo9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCampo9.setName("txtCampo9"); // NOI18N
        txtCampo9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCampo9ActionPerformed(evt);
            }
        });

        txtCampo8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCampo8.setName("txtCampo8"); // NOI18N
        txtCampo8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCampo8ActionPerformed(evt);
            }
        });

        txtCampo6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCampo6.setName("txtCampo6"); // NOI18N
        txtCampo6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCampo6ActionPerformed(evt);
            }
        });

        btnPrimeiro.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPrimeiro.setText("Primeiro");
        btnPrimeiro.setName("btnPrimeiro"); // NOI18N
        btnPrimeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeiroActionPerformed(evt);
            }
        });

        btnUltimo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUltimo.setText("Último");
        btnUltimo.setName("btnUltimo"); // NOI18N
        btnUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoActionPerformed(evt);
            }
        });

        btnAnterior.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAnterior.setText("Anterior");
        btnAnterior.setName("btnAnterior"); // NOI18N
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });

        btnProximo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnProximo.setText("Próximo");
        btnProximo.setName("btnProximo"); // NOI18N
        btnProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProximoActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setName("btnExcluir"); // NOI18N
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnPesquisar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.setName("btnPesquisar"); // NOI18N
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnGravar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGravar.setText("Gravar");
        btnGravar.setName("btnGravar"); // NOI18N
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

        btnAlterar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.setName("btnAlterar"); // NOI18N
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        tblCrud.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblCrud.setName("tblCrud"); // NOI18N
        scrScrollcrud.setViewportView(tblCrud);

        btnNovo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNovo.setText("Novo Registro");
        btnNovo.setName("btnRegistro"); // NOI18N
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        txtPesquisa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPesquisa.setName("txtPesquisar"); // NOI18N
        txtPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(btnNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCampo6)
                            .addComponent(txtCampo6, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCampo8)
                            .addComponent(txtCampo8, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(scrScrollcrud, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCampo2)
                                    .addComponent(txtCampo2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCampo3)
                                    .addComponent(txtCampo3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCampo4)
                                    .addComponent(txtCampo4, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCampo5)
                                    .addComponent(txtCampo5, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCampo7)
                                    .addComponent(txtCampo7, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCampo9)
                                    .addComponent(txtCampo9, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(txtCampo1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnPrimeiro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnProximo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnUltimo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblCampo1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTitulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(btnPesquisar)
                                .addGap(18, 18, 18)
                                .addComponent(txtPesquisa)))
                        .addGap(32, 32, 32))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCampo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCampo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrimeiro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUltimo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProximo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCampo2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCampo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCampo3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCampo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCampo4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCampo4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCampo5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCampo5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCampo6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCampo6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCampo7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCampo7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCampo8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCampo8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCampo9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCampo9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(scrScrollcrud, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void txtCampo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCampo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCampo1ActionPerformed

    private void txtCampo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCampo2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCampo2ActionPerformed

    private void txtCampo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCampo3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCampo3ActionPerformed

    private void txtCampo5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCampo5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCampo5ActionPerformed

    private void txtCampo4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCampo4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCampo4ActionPerformed

    private void txtCampo7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCampo7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCampo7ActionPerformed

    private void txtCampo9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCampo9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCampo9ActionPerformed

    private void txtCampo8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCampo8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCampo8ActionPerformed

    private void txtCampo6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCampo6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCampo6ActionPerformed

    private void btnPrimeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeiroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPrimeiroActionPerformed

    private void btnUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUltimoActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProximoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProximoActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGravarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNovoActionPerformed

    private void txtPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisaActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnGravar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnPrimeiro;
    private javax.swing.JButton btnProximo;
    private javax.swing.JButton btnUltimo;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel lblCampo1;
    private javax.swing.JLabel lblCampo2;
    private javax.swing.JLabel lblCampo3;
    private javax.swing.JLabel lblCampo4;
    private javax.swing.JLabel lblCampo5;
    private javax.swing.JLabel lblCampo6;
    private javax.swing.JLabel lblCampo7;
    private javax.swing.JLabel lblCampo8;
    private javax.swing.JLabel lblCampo9;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JScrollPane scrScrollcrud;
    private javax.swing.JTable tblCrud;
    private javax.swing.JTextField txtCampo1;
    private javax.swing.JTextField txtCampo2;
    private javax.swing.JTextField txtCampo3;
    private javax.swing.JTextField txtCampo4;
    private javax.swing.JTextField txtCampo5;
    private javax.swing.JTextField txtCampo6;
    private javax.swing.JTextField txtCampo7;
    private javax.swing.JTextField txtCampo8;
    private javax.swing.JTextField txtCampo9;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
}
