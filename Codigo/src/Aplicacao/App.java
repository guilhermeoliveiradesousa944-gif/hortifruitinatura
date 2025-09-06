package Aplicacao;

import java.util.Arrays;

import Entidades.Clientes;
import Entidades.Fornecedores;

public class App {
    public static void main(String[] args) throws Exception {
        Entidades.Clientes cliente = new Clientes("João Silva", "joao@email.com", "11999999999", "72880675");
        var produtos = Arrays.asList("Arroz", "Feijão", "Açúcar", "Café");
        Entidades.Fornecedores fornecedor1 = new Fornecedores(
            "Distribuidora Alimentos LTDA",
            "12.345.678/0001-99",
            "(11) 98765-4321",
            produtos
        );
        cliente.mostrarDados();
        fornecedor1.mostrarFornecedor();
        fornecedor1.mostrarProdutosFornecidos();
    }
}
