package Entidades;

public class Produto {
    private int id, estoque;
    private String nome, categoria, descricao;
    private double preco;

    //construtor
    public Produto(String categoria, String descricao, int estoque, int id, String nome, double preco) {
        this.categoria = categoria;
        this.descricao = descricao;
        this.estoque = estoque;
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }


    //gets e sets
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }



}
