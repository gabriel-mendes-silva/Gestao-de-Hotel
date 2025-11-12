package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.*;
import model.bo.Quarto;
import view.TelaCadastroQuarto;
import view.TelaBuscaQuarto;

public class ControllerCadQuarto implements ActionListener {

    TelaCadastroQuarto telaCadastroQuarto;
    public static int codigo;

    public ControllerCadQuarto(TelaCadastroQuarto telaCadastroQuarto) {
        this.telaCadastroQuarto = telaCadastroQuarto;

        this.telaCadastroQuarto.getjButtonNovo().addActionListener(this);
        this.telaCadastroQuarto.getjButtonSair().addActionListener(this);
        this.telaCadastroQuarto.getjButtonGravar().addActionListener(this);
        this.telaCadastroQuarto.getjButtonCancelar().addActionListener(this);
        this.telaCadastroQuarto.getjButtonBuscar().addActionListener(this);

        utilities.Utilities.ativaDesativa(this.telaCadastroQuarto.getjPanelBotoes(), true);
        utilities.Utilities.limpaComponentes(this.telaCadastroQuarto.getjPanelDados(), false);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        //-------------------- NOVO --------------------
        if (evento.getSource() == this.telaCadastroQuarto.getjButtonNovo()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroQuarto.getjPanelBotoes(), false);
            utilities.Utilities.limpaComponentes(this.telaCadastroQuarto.getjPanelDados(), true);
            this.telaCadastroQuarto.getjTextFieldID().setEnabled(false);
            this.telaCadastroQuarto.getjTextFieldStatus().setEnabled(false);
            this.telaCadastroQuarto.getjTextAreaDescricao().requestFocus();
        }

        //-------------------- CANCELAR --------------------
        if (evento.getSource() == this.telaCadastroQuarto.getjButtonCancelar()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroQuarto.getjPanelBotoes(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroQuarto.getjPanelDados(), false);
        }

        //-------------------- GRAVAR --------------------
        else if (evento.getSource() == this.telaCadastroQuarto.getjButtonGravar()) {

            if (this.telaCadastroQuarto.getjTextAreaDescricao().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "O campo Descrição é obrigatório!");
                this.telaCadastroQuarto.getjTextAreaDescricao().requestFocus();
            } else {

                Quarto quarto = new Quarto();
                quarto.setDescricao(this.telaCadastroQuarto.getjTextAreaDescricao().getText());
                quarto.setCapacidadeHospedes(Integer.parseInt(this.telaCadastroQuarto.getjTextFieldCapacidade().getText()));
                quarto.setMetragem(Float.parseFloat(this.telaCadastroQuarto.getjTextFieldMetragem().getText()));
                quarto.setIdentificacao(this.telaCadastroQuarto.getjTextFieldIdentificacao().getText());
                quarto.setAndar(Integer.parseInt(this.telaCadastroQuarto.getjTextFieldAndar().getText()));
                boolean aceitaAnimais = this.telaCadastroQuarto.getjRadioButtonSim().isSelected();
                quarto.setFlagAnimais(aceitaAnimais);
                quarto.setObs(this.telaCadastroQuarto.getjTextAreaObservacao().getText());

                if (this.telaCadastroQuarto.getjTextFieldID().getText().trim().equalsIgnoreCase("")) {
                    quarto.setStatus('A');
                    service.QuartoService.criar(quarto);
                } else {
                    quarto.setId(Integer.parseInt(this.telaCadastroQuarto.getjTextFieldID().getText()));
                    quarto.setStatus(this.telaCadastroQuarto.getjTextFieldStatus().getText().charAt(0));
                    service.QuartoService.atualizar(quarto);
                }

                utilities.Utilities.ativaDesativa(this.telaCadastroQuarto.getjPanelBotoes(), true);
                utilities.Utilities.limpaComponentes(this.telaCadastroQuarto.getjPanelDados(), false);
            }
        }

        //-------------------- BUSCAR --------------------
        if (evento.getSource() == this.telaCadastroQuarto.getjButtonBuscar()) {

            codigo = 0;

            TelaBuscaQuarto busca = new TelaBuscaQuarto(null, true);
            ControllerBuscaQuarto controllerBusca = new ControllerBuscaQuarto(busca);
            busca.setVisible(true);

            if (codigo != 0) {
                utilities.Utilities.ativaDesativa(this.telaCadastroQuarto.getjPanelBotoes(), false);
                utilities.Utilities.limpaComponentes(this.telaCadastroQuarto.getjPanelDados(), true);

                this.telaCadastroQuarto.getjTextFieldID().setEnabled(false);
                this.telaCadastroQuarto.getjTextFieldStatus().setEnabled(false);

                Quarto quarto = service.QuartoService.carregar(codigo);

                this.telaCadastroQuarto.getjTextFieldID().setText(String.valueOf(quarto.getId()));
                this.telaCadastroQuarto.getjTextAreaDescricao().setText(quarto.getDescricao());
                this.telaCadastroQuarto.getjTextFieldCapacidade().setText(String.valueOf(quarto.getCapacidadeHospedes()));
                this.telaCadastroQuarto.getjTextFieldMetragem().setText(String.valueOf(quarto.getMetragem()));
                this.telaCadastroQuarto.getjTextFieldIdentificacao().setText(quarto.getIdentificacao());
                this.telaCadastroQuarto.getjTextFieldAndar().setText(String.valueOf(quarto.getAndar()));
                if (quarto.isFlagAnimais()) {
                    this.telaCadastroQuarto.getjRadioButtonSim().setSelected(true);
                } else {
                    this.telaCadastroQuarto.getjRadioButtonNao().setSelected(true);
                }
                this.telaCadastroQuarto.getjTextAreaObservacao().setText(quarto.getObs());
                this.telaCadastroQuarto.getjTextFieldStatus().setText(String.valueOf(quarto.getStatus()));
            }
        }

        //-------------------- SAIR --------------------
        if (evento.getSource() == this.telaCadastroQuarto.getjButtonSair()) {
            this.telaCadastroQuarto.dispose();
        }
    }
}
