package Aplicacao;

import java.util.Arrays;
import java.util.List;

import Entidades.Clientes;
import Entidades.Fornecedores;
import Entidades.Produto;
import Entidades.Vendas;

public class App {
    public static void main(String[] args) throws Exception {
        Entidades.Clientes cliente = new Clientes("felipe Silva", "joao@email.com", "11999999999", "72880675");
       
         List<Entidades.Produto> produtos = Arrays.asList(
            new Produto("Arroz"),
            new Produto("Feijão"),
            new Produto("Macarrão")
        );
       
        Entidades.Fornecedores fornecedor1 = new Fornecedores(
            "Distribuidora Alimentos LTDA",
            "12.345.678/0001-99",
            "(11) 98765-4321",
            produtos
        );
        cliente.mostrarDados();
        fornecedor1.mostrarFornecedor();
        fornecedor1.mostrarProdutosFornecidos();
        Entidades.Vendas vendas = new Vendas( 259.90, 5);
        vendas.mostrarRelatorio();

    }

}
