package Entidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Vendas {
    //Atributos
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate dataVenda = LocalDate.now();
    private Double valorTotal;
    private int quantidade, id;
    private List<Produto> produtos;

    //construtores
    public Vendas(int quantidade, Produto produtos, int id) {
        this.quantidade = quantidade;
        this.produtos = new ArrayList<>();
        this.produtos.add(produtos);
        this.id = id;
    }

    //gets e sets
    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
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

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutosComprados(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public boolean add(Produto e) {
        return produtos.add(e);
    }

    public boolean remove(Object o) {
        return produtos.remove(o);
    }

    public Produto remove(int index) {
        return produtos.remove(index);
    }

    public void mostrarRelatorio() {
        System.out.println("----- Relatório de Venda -----");
        System.out.println("ID: " + id);
        System.out.println("Valor Total: R$ " + String.format("%.2f", valorTotal));
        System.out.println("Data da Venda: " + getDataVenda().format(formato));
        System.out.println("---------------------------");
    }





}