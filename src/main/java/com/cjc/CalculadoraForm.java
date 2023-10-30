package com.cjc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public abstract class CalculadoraForm extends JFrame {

    private static int TAMANHO_TXT = 10;

    protected JPanel pnlForm;
    protected JPanel pnlRodape;

    protected JButton btncalcular;
    protected JButton btnLimpar;
    protected JButton btnFechar;

    //Capital
    protected JLabel lblCapital;
    protected JTextField txtCapital;

    //Taxa de Juros
    protected JLabel lblTaxaJuros;
    protected JTextField txtTaxaJuros;

    //Período
    protected JLabel lblPeriodo;
    protected JTextField txtPeriodo;

    //Montante
    protected JLabel lblMontante;
    protected JTextField txtMontante;




    public CalculadoraForm(){
        this.inicializar();
        this.eventos();
    }

    private void inicializar(){
        this.setTitle("Calculadora Juros Composto");


        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());
        this.setResizable(false);
        this.getContentPane().add(getPnlForm(), BorderLayout.CENTER);
        this.getContentPane().add(getPnlRodape(), BorderLayout.PAGE_END);
        this.pack();

    }

    protected abstract void btnCalcularclick(ActionEvent ev);
    protected abstract void btnLimparclick(ActionEvent ev);
    protected abstract void btnfecharclick(ActionEvent ev);

    private void eventos(){
        btncalcular.addActionListener(this::btnCalcularclick);
        btnLimpar.addActionListener(this::btnLimparclick);
        btnFechar.addActionListener(this::btnfecharclick);



    }

    public JPanel getPnlForm() {
        if (pnlForm == null){
            pnlForm = new JPanel(new GridLayout(4,2));

            lblCapital = new JLabel("Capital");
            txtCapital = new JTextField(TAMANHO_TXT);


            lblTaxaJuros = new JLabel("Taxa de Juros( use . para casas decimais)");
            txtTaxaJuros = new JTextField(TAMANHO_TXT);

            lblPeriodo = new JLabel("Período (mês)");
            txtPeriodo = new JTextField(TAMANHO_TXT);
            lblMontante = new JLabel("Montante");
            txtMontante = new JTextField(TAMANHO_TXT);
            txtMontante.setEditable(false);

            pnlForm.add(lblCapital);
            pnlForm.add(txtCapital);
            pnlForm.add(lblTaxaJuros);
            pnlForm.add(txtTaxaJuros);
            pnlForm.add(lblPeriodo);
            pnlForm.add(txtPeriodo);
            pnlForm.add(lblMontante);
            pnlForm.add(txtMontante);

        }
        return pnlForm;
    }

    public void setPnlForm(JPanel pnlForm) {
        this.pnlForm = pnlForm;
    }

    public JPanel getPnlRodape() {

        if (pnlRodape == null){
            pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
            btncalcular = new JButton("Calcular");
            btncalcular.setBorderPainted(true);
            btnLimpar = new JButton("Limpar");
            btnLimpar.setBorderPainted(true);
            btnFechar = new JButton("Fechar");
            btnFechar.setBorderPainted(true);

            pnlRodape.add(btncalcular);
            pnlRodape.add(btnLimpar);
            pnlRodape.add(btnFechar);

        }
        return pnlRodape;
    }

    public void setPnlRodape(JPanel pnlRodape) {
        this.pnlRodape = pnlRodape;
    }
}
