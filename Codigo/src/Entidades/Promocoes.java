package Entidades;

import java.util.Date;

public class Promocoes {
    //atributos
    private String descricao;
    private Date dataInicio, dataFim;
    private double descontoPercentual;

    //gets e sets
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Date getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }
    public Date getDataFim() {
        return dataFim;
    }
    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }
    public double getDescontoPercentual() {
        return descontoPercentual;
    }
    public void setDescontoPercentual(double descontoPercentual) {
        this.descontoPercentual = descontoPercentual;
    }

    public void AtivarPromocao(){

    }
    public void DesativarPromocao(){

    }

}
