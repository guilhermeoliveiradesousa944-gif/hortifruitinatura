package Entidades;

import java.util.List;

public class Fornecedores {
       // Atributos
    private String nome;
    private String cnpj;
    private String telefone;
    private List<String> produtosFornecidos;

    // Construtor
    public Fornecedores (String nome, String cnpj, String telefone, List<String> produtosFornecidos) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.telefone = telefone;
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
        for (String produto : produtosFornecidos) {
            System.out.println("- " + produto);
        }
        System.out.println("===========================");
    }

    

    
}
