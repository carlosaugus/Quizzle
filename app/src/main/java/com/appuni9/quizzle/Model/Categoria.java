package com.appuni9.quizzle.Model;

public class Categoria {
    private String Name;
    private String Imagem;

    public Categoria() {
    }

    public Categoria(String name, String imagem) {
        Name = name;
        Imagem = imagem;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImagem() {
        return Imagem;
    }

    public void setImagem(String imagem) {
        Imagem = imagem;
    }
}
