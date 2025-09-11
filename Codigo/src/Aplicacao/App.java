package Aplicacao;

import java.util.Arrays;
import java.util.List;

import Entidades.Clientes;
import Entidades.Fornecedores;
import Entidades.Pagamento;
import Entidades.Produto;
import Entidades.Vendas;


public class App {
    public static void main(String[] args) throws Exception {
        Clientes cliente = new Clientes("felipe Silva", "joao@email.com", "11999999999", "72880675");
       
         List<Entidades.Produto> p = Arrays.asList(
            new Produto("Arroz"),
            new Produto("Feijão"),
            new Produto("Macarrão")
        );
       
        Entidades.Fornecedores fornecedor1 = new Fornecedores(
            "Distribuidora Alimentos LTDA",
            "12.345.678/0001-99",
            "(11) 98765-4321",
            p
        );


        cliente.mostrarDados();
        fornecedor1.mostrarFornecedor();
        fornecedor1.mostrarProdutosFornecidos();

        // 1. Criar produto
        Produto produto = new Produto("maça", 4.90, 10, "12/2026");

        // 2. Criar venda com quantidade e produto
        Vendas venda = new Vendas(2, produto, 100 ); // 2 unidades
        
        // 3. Calcular valor total da venda
        double total = produto.getPreco() * venda.getQuantidade();
        venda.setValorTotal(total);

        // 4. Criar pagamento e definir método
        Pagamento pagamento = new Pagamento(venda, cliente);
        pagamento.setmetododePagamento("credito"); // pode ser "credito", "debito" ou "pix"
        
        // 5. Gerar nota fiscal
        pagamento.Notafiscal();


    }

}
