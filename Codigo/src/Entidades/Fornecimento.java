package Entidades;

import java.util.Date;

public class Fornecimento {
    //atributos
    private int quantidadeFornacida;
    private Date dataFornecimento;

    //gets e sets
    public int getQuantidadeFornacida() {
        return quantidadeFornacida;
    }
    public void setQuantidadeFornacida(int quantidadeFornacida) {
        this.quantidadeFornacida = quantidadeFornacida;
    }
    public Date getDataFornecimento() {
        return dataFornecimento;
    }
    public void setDataFornecimento(Date dataFornecimento) {
        this.dataFornecimento = dataFornecimento;
    }

    public void RelatorioFornecimento(){

    }
    
}
