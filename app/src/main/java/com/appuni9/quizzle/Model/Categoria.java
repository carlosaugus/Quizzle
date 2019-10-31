package com.appuni9.quizzle.Model;

public class Categoria {
    private String Nome;
    private String Imagem;

    public Categoria() {
    }

    public Categoria(String nome, String imagem) {
        Nome = nome;
        Imagem = imagem;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getImagem() {
        return Imagem;
    }

    public void setImagem(String imagem) {
        Imagem = imagem;
    }
}
