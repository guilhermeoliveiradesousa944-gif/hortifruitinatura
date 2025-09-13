package Entidades;

import java.util.Date;

public class Estoque {
    //atributos
    private int quantidadeAtual, quantidadeMinima;
    private Date dataUltimaAtualizacao;

    //gets e sets
    public int getQuantidadeAtual() {
        return quantidadeAtual;
    }
    public void setQuantidadeAtual(int quantidadeAtual) {
        this.quantidadeAtual = quantidadeAtual;
    }
    public int getQuantidadeMinima() {
        return quantidadeMinima;
    }
    public void setQuantidadeMinima(int quantidadeMinima) {
        this.quantidadeMinima = quantidadeMinima;
    }
    public Date getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }
    public void setDataUltimaAtualizacao(Date dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }

    public void AtulizarEstoque(){

    }
    public void ExcluirItem(){

    }
    public void CadastarProduto(){
        
    }

}
