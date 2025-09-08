package Entidades;

import java.util.ArrayList;
import java.util.List;

public class Fornecedores {
       // Atributos
    private String nome;
    private String cnpj;
    private String telefone;
    private List<Produto> produtosFornecidos = new ArrayList<>();

    // Construtor
    public Fornecedores (String nome, String cnpj, String telefone, List<Produto> produtosFornecidos) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.produtosFornecidos = produtosFornecidos;
    }

    public String getNome() {
        return nome;
    }



    public void setNome(String nome) {
        this.nome = nome;
    }



    public String getCnpj() {
        return cnpj;
    }



    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }



    public String getTelefone() {
        return telefone;
    }



    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }



    public List<Produto> getProdutosFornecidos() {
        return produtosFornecidos;
    }



    public void setProdutosFornecidos(List<Produto> produtosFornecidos) {
        this.produtosFornecidos = produtosFornecidos;
    }



    // Método para mostrar os dados do fornecedor
    public void mostrarFornecedor() {
        System.out.println("===== Dados do Fornecedor =====");
        System.out.println("Nome: " + nome);
        System.out.println("CNPJ: " + cnpj);
        System.out.println("Telefone: " + telefone);
        System.out.println("================================");
    }

    // Método para mostrar os produtos fornecidos
    public void mostrarProdutosFornecidos() {
        System.out.println("=== Produtos Fornecidos ===");
        for (Produto produto : produtosFornecidos) {
            System.out.println("- " + produto.getNome());
        }
        System.out.println("===========================");
    }

    

    
}
