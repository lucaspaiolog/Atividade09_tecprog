package br.edu.fatecpg.preferencia.model;

public class Usuario {
    private String tema;
    private boolean notificacoes;
    private int volume;

    public Usuario(String tema, boolean notificacoes, int volume) {
        this.tema = tema;
        this.notificacoes = notificacoes;
        this.volume = volume;
    }

    public String getPreferencias() {
        return "Tema: " + tema + ", Notificações: " + (notificacoes ? "Ativadas" : "Desativadas") + ", Volume: " + volume;
    }
}
