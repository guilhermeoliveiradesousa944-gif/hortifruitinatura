package Entidades;

public class Produto {
    private String nome;
    private double preco;
    private int estoque;
    private String validade;

    public Produto(String nome) {
        this.nome = nome;
    }

    public Produto(String nome, double preco, int estoque, String validade) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
        this.validade = validade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    // Método para mostrar os dados do produto
    public void mostrarproduto() {
        System.out.println("===== Produto =====");
        System.out.println("Nome: " + nome);
        System.out.println("Preço: " + preco);
        System.out.println("Validade: " + validade);
        System.out.println("================================");
    }
    
}

