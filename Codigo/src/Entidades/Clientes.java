package Entidades;

public class Clientes {
    //atributos
    private String nome;
    private String email;
    private String telefone;
    private String endereco;
    //construtor
    public Clientes(String nome, String email, String telefone, String endereco) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }
    
    public String getNome() {
        return nome;
    }
    
    // Gets e Sets
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    //mostar dados do cliente
    public void mostrarDados() {
        System.out.println("===== Dados do Cliente =====");
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("Telefone: " + telefone);
        System.out.println("Endereço: " + endereco);
        System.out.println("============================");
    }
        
}
