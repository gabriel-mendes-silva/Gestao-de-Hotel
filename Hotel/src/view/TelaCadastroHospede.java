/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author aluno
 */
public class TelaCadastroHospede extends javax.swing.JDialog {

    

    /**
     * Creates new form TemplateCadastro2025
     */
    public TelaCadastroHospede(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
    }

    public JPanel getjDados() {
        return jPanelDados;
    }
    
    public JButton getjButtonBuscar() {
        return jButtonBuscar;
    }

    public JButton getjButtonCancelar() {
        return jButtonCancelar;
    }

    public JButton getjButtonGravar() {
        return jButtonGravar;
    }

    public JButton getjButtonNovo() {
        return jButtonNovo;
    }

    public JButton getjButtonSair() {
        return jButtonSair;
    }

    public JPanel getjBotoes() {
        return jPanelBotoes;
    }

    public JFormattedTextField getjFormattedTextFieldCPF() {
        return jFormattedTextFieldCPF;
    }

    public void setjFormattedTextFieldCPF(JFormattedTextField jFormattedTextFieldCPF) {
        this.jFormattedTextFieldCPF = jFormattedTextFieldCPF;
    }

    public JFormattedTextField getjFormattedTextFieldCep() {
        return jFormattedTextFieldCep;
    }

    public void setjFormattedTextFieldCep(JFormattedTextField jFormattedTextFieldCep) {
        this.jFormattedTextFieldCep = jFormattedTextFieldCep;
    }

    public JFormattedTextField getjFormattedTextFieldDataCadastro() {
        return jFormattedTextFieldDataCadastro;
    }

    public void setjFormattedTextFieldDataCadastro(JFormattedTextField jFormattedTextFieldDataCadastro) {
        this.jFormattedTextFieldDataCadastro = jFormattedTextFieldDataCadastro;
    }

    public JFormattedTextField getjFormattedTextFieldFone1() {
        return jFormattedTextFieldFone1;
    }

    public void setjFormattedTextFieldFone1(JFormattedTextField jFormattedTextFieldFone1) {
        this.jFormattedTextFieldFone1 = jFormattedTextFieldFone1;
    }

    public JFormattedTextField getjFormattedTextFieldFone2() {
        return jFormattedTextFieldFone2;
    }

    public void setjFormattedTextFieldFone2(JFormattedTextField jFormattedTextFieldFone2) {
        this.jFormattedTextFieldFone2 = jFormattedTextFieldFone2;
    }

    public JFormattedTextField getjFormattedTextFieldNome() {
        return jFormattedTextFieldNome;
    }

    public void setjFormattedTextFieldNome(JFormattedTextField jFormattedTextFieldNome) {
        this.jFormattedTextFieldNome = jFormattedTextFieldNome;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabelBairro() {
        return jLabelBairro;
    }

    public void setjLabelBairro(JLabel jLabelBairro) {
        this.jLabelBairro = jLabelBairro;
    }

    public JLabel getjLabelCEP() {
        return jLabelCEP;
    }

    public void setjLabelCEP(JLabel jLabelCEP) {
        this.jLabelCEP = jLabelCEP;
    }

    public JLabel getjLabelCNPJ() {
        return jLabelCNPJ;
    }

    public void setjLabelCNPJ(JLabel jLabelCNPJ) {
        this.jLabelCNPJ = jLabelCNPJ;
    }

    public JLabel getjLabelCPF() {
        return jLabelCPF;
    }

    public void setjLabelCPF(JLabel jLabelCPF) {
        this.jLabelCPF = jLabelCPF;
    }

    public JLabel getjLabelCidade() {
        return jLabelCidade;
    }

    public void setjLabelCidade(JLabel jLabelCidade) {
        this.jLabelCidade = jLabelCidade;
    }

    public JLabel getjLabelComplemento() {
        return jLabelComplemento;
    }

    public void setjLabelComplemento(JLabel jLabelComplemento) {
        this.jLabelComplemento = jLabelComplemento;
    }

    public JLabel getjLabelContato() {
        return jLabelContato;
    }

    public void setjLabelContato(JLabel jLabelContato) {
        this.jLabelContato = jLabelContato;
    }

    public JLabel getjLabelDataCadastro() {
        return jLabelDataCadastro;
    }

    public void setjLabelDataCadastro(JLabel jLabelDataCadastro) {
        this.jLabelDataCadastro = jLabelDataCadastro;
    }

    public JLabel getjLabelEmail() {
        return jLabelEmail;
    }

    public void setjLabelEmail(JLabel jLabelEmail) {
        this.jLabelEmail = jLabelEmail;
    }

    public JLabel getjLabelFone1() {
        return jLabelFone1;
    }

    public void setjLabelFone1(JLabel jLabelFone1) {
        this.jLabelFone1 = jLabelFone1;
    }

    public JLabel getjLabelFone2() {
        return jLabelFone2;
    }

    public void setjLabelFone2(JLabel jLabelFone2) {
        this.jLabelFone2 = jLabelFone2;
    }

    public JLabel getjLabelID() {
        return jLabelID;
    }

    public void setjLabelID(JLabel jLabelID) {
        this.jLabelID = jLabelID;
    }

    public JLabel getjLabelInscricaoEstadual() {
        return jLabelInscricaoEstadual;
    }

    public void setjLabelInscricaoEstadual(JLabel jLabelInscricaoEstadual) {
        this.jLabelInscricaoEstadual = jLabelInscricaoEstadual;
    }

    public JLabel getjLabelLogradouro() {
        return jLabelLogradouro;
    }

    public void setjLabelLogradouro(JLabel jLabelLogradouro) {
        this.jLabelLogradouro = jLabelLogradouro;
    }

    public JLabel getjLabelNome() {
        return jLabelNome;
    }

    public void setjLabelNome(JLabel jLabelNome) {
        this.jLabelNome = jLabelNome;
    }

    public JLabel getjLabelObservacao() {
        return jLabelObservacao;
    }

    public void setjLabelObservacao(JLabel jLabelObservacao) {
        this.jLabelObservacao = jLabelObservacao;
    }

    public JLabel getjLabelRG() {
        return jLabelRG;
    }

    public void setjLabelRG(JLabel jLabelRG) {
        this.jLabelRG = jLabelRG;
    }

    public JLabel getjLabelRazaoSocial() {
        return jLabelRazaoSocial;
    }

    public void setjLabelRazaoSocial(JLabel jLabelRazaoSocial) {
        this.jLabelRazaoSocial = jLabelRazaoSocial;
    }

    public JLabel getjLabelStatus() {
        return jLabelStatus;
    }

    public void setjLabelStatus(JLabel jLabelStatus) {
        this.jLabelStatus = jLabelStatus;
    }

    public JPanel getjPanelDados() {
        return jPanelDados;
    }

    public void setjPanelDados(JPanel jPanelDados) {
        this.jPanelDados = jPanelDados;
    }

    public JPanel getjPanelTitulo() {
        return jPanelTitulo;
    }

    public void setjPanelTitulo(JPanel jPanelTitulo) {
        this.jPanelTitulo = jPanelTitulo;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public void setjScrollPane2(JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    public JTextArea getjTextAreaObservacao() {
        return jTextAreaObservacao;
    }

    public void setjTextAreaObservacao(JTextArea jTextAreaObservacao) {
        this.jTextAreaObservacao = jTextAreaObservacao;
    }

    public JTextField getjTextFieldBairro() {
        return jTextFieldBairro;
    }

    public void setjTextFieldBairro(JTextField jTextFieldBairro) {
        this.jTextFieldBairro = jTextFieldBairro;
    }

    public JTextField getjTextFieldCNPJ() {
        return jTextFieldCNPJ;
    }

    public void setjTextFieldCNPJ(JTextField jTextFieldCNPJ) {
        this.jTextFieldCNPJ = jTextFieldCNPJ;
    }

    public JTextField getjTextFieldCidade() {
        return jTextFieldCidade;
    }

    public void setjTextFieldCidade(JTextField jTextFieldCidade) {
        this.jTextFieldCidade = jTextFieldCidade;
    }

    public JTextField getjTextFieldComplemento() {
        return jTextFieldComplemento;
    }

    public void setjTextFieldComplemento(JTextField jTextFieldComplemento) {
        this.jTextFieldComplemento = jTextFieldComplemento;
    }

    public JTextField getjTextFieldContato() {
        return jTextFieldContato;
    }

    public void setjTextFieldContato(JTextField jTextFieldContato) {
        this.jTextFieldContato = jTextFieldContato;
    }

    public JTextField getjTextFieldEmail() {
        return jTextFieldEmail;
    }

    public void setjTextFieldEmail(JTextField jTextFieldEmail) {
        this.jTextFieldEmail = jTextFieldEmail;
    }

    public JTextField getjTextFieldID() {
        return jTextFieldID;
    }

    public void setjTextFieldID(JTextField jTextFieldID) {
        this.jTextFieldID = jTextFieldID;
    }

    public JTextField getjTextFieldInscricaoEstadual() {
        return jTextFieldInscricaoEstadual;
    }

    public void setjTextFieldInscricaoEstadual(JTextField jTextFieldInscricaoEstadual) {
        this.jTextFieldInscricaoEstadual = jTextFieldInscricaoEstadual;
    }

    public JTextField getjTextFieldLogradouro() {
        return jTextFieldLogradouro;
    }

    public void setjTextFieldLogradouro(JTextField jTextFieldLogradouro) {
        this.jTextFieldLogradouro = jTextFieldLogradouro;
    }

    public JTextField getjTextFieldRG() {
        return jTextFieldRG;
    }

    public void setjTextFieldRG(JTextField jTextFieldRG) {
        this.jTextFieldRG = jTextFieldRG;
    }

    public JTextField getjTextFieldRazaoSocial() {
        return jTextFieldRazaoSocial;
    }

    public void setjTextFieldRazaoSocial(JTextField jTextFieldRazaoSocial) {
        this.jTextFieldRazaoSocial = jTextFieldRazaoSocial;
    }

    public JTextField getjTextFieldStatus() {
        return jTextFieldStatus;
    }

    public void setjTextFieldStatus(JTextField jTextFieldStatus) {
        this.jTextFieldStatus = jTextFieldStatus;
    }
    
    
    
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTitulo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanelBotoes = new javax.swing.JPanel();
        jButtonNovo = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonBuscar = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jButtonGravar = new javax.swing.JButton();
        jPanelDados = new javax.swing.JPanel();
        jTextFieldID = new javax.swing.JTextField();
        jLabelID = new javax.swing.JLabel();
        jFormattedTextFieldNome = new javax.swing.JFormattedTextField();
        jLabelNome = new javax.swing.JLabel();
        jLabelFone1 = new javax.swing.JLabel();
        jLabelFone2 = new javax.swing.JLabel();
        jFormattedTextFieldFone1 = new javax.swing.JFormattedTextField();
        jFormattedTextFieldFone2 = new javax.swing.JFormattedTextField();
        jFormattedTextFieldCPF = new javax.swing.JFormattedTextField();
        jLabelCPF = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabelEmail = new javax.swing.JLabel();
        jLabelCEP = new javax.swing.JLabel();
        jLabelLogradouro = new javax.swing.JLabel();
        jTextFieldLogradouro = new javax.swing.JTextField();
        jLabelBairro = new javax.swing.JLabel();
        jTextFieldBairro = new javax.swing.JTextField();
        jFormattedTextFieldCep = new javax.swing.JFormattedTextField();
        jLabelCidade = new javax.swing.JLabel();
        jTextFieldCidade = new javax.swing.JTextField();
        jLabelComplemento = new javax.swing.JLabel();
        jTextFieldComplemento = new javax.swing.JTextField();
        jLabelDataCadastro = new javax.swing.JLabel();
        jLabelRG = new javax.swing.JLabel();
        jTextFieldRG = new javax.swing.JTextField();
        jLabelObservacao = new javax.swing.JLabel();
        jLabelStatus = new javax.swing.JLabel();
        jTextFieldStatus = new javax.swing.JTextField();
        jLabelRazaoSocial = new javax.swing.JLabel();
        jTextFieldRazaoSocial = new javax.swing.JTextField();
        jLabelCNPJ = new javax.swing.JLabel();
        jTextFieldCNPJ = new javax.swing.JTextField();
        jLabelInscricaoEstadual = new javax.swing.JLabel();
        jTextFieldInscricaoEstadual = new javax.swing.JTextField();
        jLabelContato = new javax.swing.JLabel();
        jTextFieldContato = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaObservacao = new javax.swing.JTextArea();
        jFormattedTextFieldDataCadastro = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanelTitulo.setBackground(new java.awt.Color(0, 102, 0));
        jPanelTitulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setBackground(new java.awt.Color(0, 102, 0));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Hóspede");
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout jPanelTituloLayout = new javax.swing.GroupLayout(jPanelTitulo);
        jPanelTitulo.setLayout(jPanelTituloLayout);
        jPanelTituloLayout.setHorizontalGroup(
            jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTituloLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(58, 58, 58))
        );
        jPanelTituloLayout.setVerticalGroup(
            jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTituloLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jPanelBotoes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButtonNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Create.png"))); // NOI18N
        jButtonNovo.setText("Novo");
        jButtonNovo.setActionCommand("0");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Cancel.png"))); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setActionCommand("1");

        jButtonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Find.png"))); // NOI18N
        jButtonBuscar.setText("Buscar");
        jButtonBuscar.setActionCommand("0");

        jButtonSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Exit.png"))); // NOI18N
        jButtonSair.setText("Sair");
        jButtonSair.setActionCommand("0");

        jButtonGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Load.png"))); // NOI18N
        jButtonGravar.setText("Gravar");
        jButtonGravar.setActionCommand("1");

        javax.swing.GroupLayout jPanelBotoesLayout = new javax.swing.GroupLayout(jPanelBotoes);
        jPanelBotoes.setLayout(jPanelBotoesLayout);
        jPanelBotoesLayout.setHorizontalGroup(
            jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotoesLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jButtonNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonCancelar)
                .addGap(72, 72, 72)
                .addComponent(jButtonGravar)
                .addGap(72, 72, 72)
                .addComponent(jButtonBuscar)
                .addGap(71, 71, 71)
                .addComponent(jButtonSair)
                .addGap(80, 80, 80))
        );
        jPanelBotoesLayout.setVerticalGroup(
            jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotoesLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonCancelar)
                        .addComponent(jButtonNovo)
                        .addComponent(jButtonGravar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonBuscar)
                        .addComponent(jButtonSair)))
                .addContainerGap())
        );

        jPanelDados.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelID.setText("ID");

        jLabelNome.setText("Nome");

        jLabelFone1.setText("Fone 1");

        jLabelFone2.setText("Fone 2");

        try {
            jFormattedTextFieldFone1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jFormattedTextFieldFone2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jFormattedTextFieldCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabelCPF.setText("CPF");

        jTextFieldEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEmailActionPerformed(evt);
            }
        });

        jLabelEmail.setText("Email");

        jLabelCEP.setText("CEP");

        jLabelLogradouro.setText("Logradouro");

        jLabelBairro.setText("Bairro");

        try {
            jFormattedTextFieldCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabelCidade.setText("Cidade");

        jLabelComplemento.setText("Complemento");

        jLabelDataCadastro.setText("Data de Cadastro");

        jLabelRG.setText("RG");

        jLabelObservacao.setText("Observacao");

        jLabelStatus.setText("Status");

        jLabelRazaoSocial.setText("Razão Social");

        jLabelCNPJ.setText("CNPJ");

        jLabelInscricaoEstadual.setText("Inscrição Estadual");

        jLabelContato.setText("Contato");

        jTextAreaObservacao.setColumns(20);
        jTextAreaObservacao.setRows(5);
        jScrollPane2.setViewportView(jTextAreaObservacao);

        try {
            jFormattedTextFieldDataCadastro.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanelDadosLayout = new javax.swing.GroupLayout(jPanelDados);
        jPanelDados.setLayout(jPanelDadosLayout);
        jPanelDadosLayout.setHorizontalGroup(
            jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDadosLayout.createSequentialGroup()
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelID)
                            .addComponent(jLabelNome)
                            .addComponent(jTextFieldEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosLayout.createSequentialGroup()
                                .addComponent(jLabelFone1)
                                .addGap(185, 185, 185))
                            .addComponent(jFormattedTextFieldFone1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelFone2)
                            .addComponent(jFormattedTextFieldFone2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelCEP)
                            .addComponent(jLabelEmail)
                            .addComponent(jTextFieldID))
                        .addGap(53, 53, 53)
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCNPJ)
                            .addComponent(jLabelInscricaoEstadual)
                            .addComponent(jLabelRazaoSocial)
                            .addComponent(jLabelContato)
                            .addComponent(jTextFieldCNPJ)
                            .addComponent(jTextFieldInscricaoEstadual)
                            .addComponent(jTextFieldContato)
                            .addComponent(jTextFieldRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabelLogradouro)
                        .addComponent(jLabelBairro)
                        .addComponent(jFormattedTextFieldCep, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                        .addComponent(jTextFieldLogradouro)
                        .addComponent(jTextFieldBairro)
                        .addComponent(jFormattedTextFieldNome)))
                .addGap(51, 51, 51)
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldRG, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                    .addComponent(jLabelRG)
                    .addComponent(jLabelDataCadastro)
                    .addComponent(jLabelComplemento)
                    .addComponent(jLabelCidade)
                    .addComponent(jTextFieldCidade, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldComplemento, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelCPF)
                    .addComponent(jFormattedTextFieldCPF, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelStatus)
                    .addComponent(jTextFieldStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                    .addComponent(jLabelObservacao)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                    .addComponent(jFormattedTextFieldDataCadastro))
                .addGap(27, 27, 27))
        );
        jPanelDadosLayout.setVerticalGroup(
            jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDadosLayout.createSequentialGroup()
                        .addComponent(jLabelCidade)
                        .addGap(0, 0, 0)
                        .addComponent(jTextFieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelComplemento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelDataCadastro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jFormattedTextFieldDataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelCPF)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabelRG)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelObservacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelStatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelDadosLayout.createSequentialGroup()
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDadosLayout.createSequentialGroup()
                                .addComponent(jLabelID)
                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelDadosLayout.createSequentialGroup()
                                        .addGap(124, 124, 124)
                                        .addComponent(jFormattedTextFieldFone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabelFone2))
                                    .addGroup(jPanelDadosLayout.createSequentialGroup()
                                        .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabelNome)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jFormattedTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabelFone1)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextFieldFone2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(jLabelEmail)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelDadosLayout.createSequentialGroup()
                                .addComponent(jLabelRazaoSocial)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jLabelCNPJ)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelInscricaoEstadual)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldInscricaoEstadual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelContato)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabelCEP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextFieldCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelLogradouro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jLabelBairro)
                        .addGap(5, 5, 5)
                        .addComponent(jTextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelBotoes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jTextFieldEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEmailActionPerformed

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
            java.util.logging.Logger.getLogger(TemplateCadastro2025.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TemplateCadastro2025.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TemplateCadastro2025.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TemplateCadastro2025.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaCadastroHospede dialog = new TelaCadastroHospede(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonGravar;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JFormattedTextField jFormattedTextFieldCPF;
    private javax.swing.JFormattedTextField jFormattedTextFieldCep;
    private javax.swing.JFormattedTextField jFormattedTextFieldDataCadastro;
    private javax.swing.JFormattedTextField jFormattedTextFieldFone1;
    private javax.swing.JFormattedTextField jFormattedTextFieldFone2;
    private javax.swing.JFormattedTextField jFormattedTextFieldNome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelBairro;
    private javax.swing.JLabel jLabelCEP;
    private javax.swing.JLabel jLabelCNPJ;
    private javax.swing.JLabel jLabelCPF;
    private javax.swing.JLabel jLabelCidade;
    private javax.swing.JLabel jLabelComplemento;
    private javax.swing.JLabel jLabelContato;
    private javax.swing.JLabel jLabelDataCadastro;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelFone1;
    private javax.swing.JLabel jLabelFone2;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelInscricaoEstadual;
    private javax.swing.JLabel jLabelLogradouro;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelObservacao;
    private javax.swing.JLabel jLabelRG;
    private javax.swing.JLabel jLabelRazaoSocial;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JPanel jPanelBotoes;
    private javax.swing.JPanel jPanelDados;
    private javax.swing.JPanel jPanelTitulo;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaObservacao;
    private javax.swing.JTextField jTextFieldBairro;
    private javax.swing.JTextField jTextFieldCNPJ;
    private javax.swing.JTextField jTextFieldCidade;
    private javax.swing.JTextField jTextFieldComplemento;
    private javax.swing.JTextField jTextFieldContato;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldInscricaoEstadual;
    private javax.swing.JTextField jTextFieldLogradouro;
    private javax.swing.JTextField jTextFieldRG;
    private javax.swing.JTextField jTextFieldRazaoSocial;
    private javax.swing.JTextField jTextFieldStatus;
    // End of variables declaration//GEN-END:variables

    public JPanel getjPanelBotoes() {
        return this.jPanelBotoes;
    }
}
