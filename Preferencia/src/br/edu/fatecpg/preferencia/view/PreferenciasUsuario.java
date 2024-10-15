package br.edu.fatecpg.preferencia.view;

import br.edu.fatecpg.preferencia.model.Usuario;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PreferenciasUsuario extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> temaComboBox;
    private JCheckBox notificacoesCheckBox;
    private JSlider volumeSlider;
    private JTextArea preferenciasTextArea;

    public PreferenciasUsuario() {
        setTitle("Configurações de Preferências");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(new GridLayout(5, 2));

        // Componentes
        JLabel temaLabel = new JLabel("Tema:");
        temaComboBox = new JComboBox<>(new String[] {"Claro", "Escuro"});

        JLabel notificacoesLabel = new JLabel("Notificações:");
        notificacoesCheckBox = new JCheckBox("Ativar Notificações");

        JLabel volumeLabel = new JLabel("Volume:");
        volumeSlider = new JSlider(0, 100, 50);

        JButton salvarButton = new JButton("Salvar");
        preferenciasTextArea = new JTextArea(5, 20);
        preferenciasTextArea.setEditable(false);

        // Eventos
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tema = (String) temaComboBox.getSelectedItem();
                boolean notificacoes = notificacoesCheckBox.isSelected();
                int volume = volumeSlider.getValue();

                Usuario usuario = new Usuario(tema, notificacoes, volume);
                preferenciasTextArea.setText(usuario.getPreferencias());

                // Alterar a cor do JFrame com base no tema
                if (tema.equals("Claro")) {
                    getContentPane().setBackground(Color.WHITE);
                } else {
                    getContentPane().setBackground(Color.DARK_GRAY);
                }
            }
        });

        // Adicionando componentes à janela
        getContentPane().add(temaLabel);
        getContentPane().add(temaComboBox);
        getContentPane().add(notificacoesLabel);
        getContentPane().add(notificacoesCheckBox);
        getContentPane().add(volumeLabel);
        getContentPane().add(volumeSlider);
        getContentPane().add(salvarButton);
        getContentPane().add(preferenciasTextArea);

        setVisible(true);
    }

    public static void main(String[] args) {
        new PreferenciasUsuario();
    }
}

