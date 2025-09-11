package Entidades;

import java.util.Date;

public class FeedbackClientes {
    //atributos
    private String comentario;
    private Date dataFedebeek;
    private int avaliacao;

    //gets e sets
    public String getComentario() {
        return comentario;
    }
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    public Date getDataFedebeek() {
        return dataFedebeek;
    }
    public void setDataFedebeek(Date dataFedebeek) {
        this.dataFedebeek = dataFedebeek;
    }
    public int getAvaliacao() {
        return avaliacao;
    }
    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    } 

    public void MostrarFeedback(){
        
    }
    
}
