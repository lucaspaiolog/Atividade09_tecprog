package br.edu.fatecpg.formulario.view;

import br.edu.fatecpg.formulario.model.Cliente;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroForm extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nomeField;
    private JSpinner idadeSpinner;
    private JRadioButton mascRadioButton;
    private JRadioButton femRadioButton;
    private JLabel resumoLabel;

    public CadastroForm() {
        setTitle("Formulário de Cadastro");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        // Componentes
        JLabel nomeLabel = new JLabel("Nome:");
        nomeField = new JTextField();

        JLabel idadeLabel = new JLabel("Idade:");
        idadeSpinner = new JSpinner(new SpinnerNumberModel(18, 0, 120, 1));

        JLabel sexoLabel = new JLabel("Sexo:");
        mascRadioButton = new JRadioButton("Masculino");
        femRadioButton = new JRadioButton("Feminino");
        ButtonGroup sexoGroup = new ButtonGroup();
        sexoGroup.add(mascRadioButton);
        sexoGroup.add(femRadioButton);

        JButton enviarButton = new JButton("Enviar");
        resumoLabel = new JLabel("");

        // Eventos
        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validarCampos()) {
                    String nome = nomeField.getText();
                    int idade = (int) idadeSpinner.getValue();
                    String sexo = mascRadioButton.isSelected() ? "Masculino" : "Feminino";

                    Cliente cliente = new Cliente(nome, idade, sexo);
                    resumoLabel.setText(cliente.getResumo());
                } else {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
                }
            }
        });

        // Adicionando componentes à janela
        add(nomeLabel);
        add(nomeField);
        add(idadeLabel);
        add(idadeSpinner);
        add(sexoLabel);
        add(mascRadioButton);
        add(new JLabel()); 
        add(femRadioButton);
        add(enviarButton);
        add(resumoLabel);

        setVisible(true);
    }

    private boolean validarCampos() {
        return !nomeField.getText().isEmpty() && (mascRadioButton.isSelected() || femRadioButton.isSelected());
    }

    public static void main(String[] args) {
        new CadastroForm();
    }
}


