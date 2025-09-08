package Entidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Vendas {
    //Atributos
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate dataVenda = LocalDate.now();
    private Double valorTotal;
    private int id;

    //construtores
    public Vendas( Double valorTotal, int id) {
        this.valorTotal = valorTotal;
        this.id = id;
    }

    //gets e sets
    public LocalDate getDataVenda() {
        return dataVenda;
    }
    public Double getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
    public int getid() {
        return id;
    }
    public void setid(int id) {
        this.id = id;
    }

    public void mostrarRelatorio() {
        System.out.println("----- Relatório de Venda -----");
        System.out.println("ID: " + id);
        System.out.println("Valor Total: R$ " + String.format("%.2f", valorTotal));
        System.out.println("Data da Venda: " + getDataVenda().format(formato));
    }





}