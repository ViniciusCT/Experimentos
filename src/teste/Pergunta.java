/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

/**
 *
 * @author User
 */
public class Pergunta {
    
    private int _id;
    private int id;
    private String disciplina;
    private String assunto;
    private String descricao;
    private String imagemEnunciado;
    private String imagemResposta;

    
    public int get_Id() {
        return _id;
    }

    public void set_Id(int id) {
        this._id = id;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagemEnunciado() {
        return imagemEnunciado;
    }

    public void setImagemEnunciado(String imagemEnunciado) {
        this.imagemEnunciado = imagemEnunciado;
    }

    public String getImagemResposta() {
        return imagemResposta;
    }

    public void setImagemResposta(String imagemResposta) {
        this.imagemResposta = imagemResposta;
    }
    
    
    
}
