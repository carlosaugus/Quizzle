package com.appuni9.quizzle.Model;

public class Questoes {

    private String ImagemQuestao;
    private String Questao;
    private String RespA;
    private String RespB;
    private String RespC;
    private String RespD;
    private int categoriaId;
    private String respCorreta;

    public Questoes() {
    }

    public Questoes(String imagemQuestao, String questao, String respA, String respB, String respC, String respD, int categoriaId, String respCorreta) {
        ImagemQuestao = imagemQuestao;
        Questao = questao;
        RespA = respA;
        RespB = respB;
        RespC = respC;
        RespD = respD;
        this.categoriaId = categoriaId;
        this.respCorreta = respCorreta;
    }

    public String getImagemQuestao() {
        return ImagemQuestao;
    }

    public void setImagemQuestao(String imagemQuestao) {
        ImagemQuestao = imagemQuestao;
    }

    public String getQuestao() {
        return Questao;
    }

    public void setQuestao(String questao) {
        Questao = questao;
    }

    public String getRespA() {
        return RespA;
    }

    public void setRespA(String respA) {
        RespA = respA;
    }

    public String getRespB() {
        return RespB;
    }

    public void setRespB(String respB) {
        RespB = respB;
    }

    public String getRespC() {
        return RespC;
    }

    public void setRespC(String respC) {
        RespC = respC;
    }

    public String getRespD() {
        return RespD;
    }

    public void setRespD(String respD) {
        RespD = respD;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getRespCorreta() {
        return respCorreta;
    }

    public void setRespCorreta(String respCorreta) {
        this.respCorreta = respCorreta;
    }
}
