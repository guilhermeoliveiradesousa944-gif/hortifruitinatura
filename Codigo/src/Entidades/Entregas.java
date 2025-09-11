package Entidades;

import java.util.Date;

public class Entregas {
    //atributos
    private int entrega;
    private Date dataEntrega;
    private String enderecoEntrega, status;

    //gets e sets
    public int getEntrega() {
        return entrega;
    }
    public void setEntrega(int entrega) {
        this.entrega = entrega;
    }
    public Date getDataEntrega() {
        return dataEntrega;
    }
    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }
    public String getEnderecoEntrega() {
        return enderecoEntrega;
    }
    public void setEnderecoEntrega(String enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public void IniciarEntrega(){

    }
    public void CancelarEntrega(){

    }
    public void FinalizarEntrega(){
        
    }


    
}
