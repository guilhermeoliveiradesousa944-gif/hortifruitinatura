package Entidades;

import java.time.LocalDate;
import java.util.Scanner;

public class Pagamento {
    //atributos
    private Vendas vendas;
    private Clientes cliente;
    private Produto produto;
    private String metododePagamento;
    private double valorPago, valorTotal;
    private  LocalDate dataPagamento = LocalDate.now(); 
    Scanner sc = new Scanner(System.in);

    
    // construtor
    public Pagamento(String metododePagamento, double valorPago) {
        this.metododePagamento = metododePagamento;
        this.valorPago = valorPago;
    }
        public Pagamento (Vendas vendas, Clientes clientes){
        this.vendas = vendas;
        this.cliente = clientes;
    }
    //gets e sets
    public String getmetododePagamento() {
        return metododePagamento;
    }
    public void setmetododePagamento(String metododePagamento) {
        this.metododePagamento = metododePagamento;
    }
    public double getValorPago() {
        return valorPago;
    }
    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }
    public LocalDate getDataPagamento() {
        return dataPagamento;
    }
    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public double MetodoPagamento(){
        
        switch (getmetododePagamento()) {
            
            case "credito":
            System.out.println("Quantidade de parcelas? ");
            int parcela = sc.nextInt();
            valorTotal = vendas.getValorTotal()/parcela;
            System.out.println("Quantidade a ser paga no  Credito: " + valorTotal);
            break;
            case "debito":
            valorTotal = vendas.getValorTotal();
            System.out.println("Quantidade a ser paga no  Debito: " + valorTotal);
            break;        
            default:
            valorTotal = vendas.getValorTotal();
            System.out.println("Quantidade a ser paga no pix: " + valorTotal);

                break;
        }
        return valorTotal;

    }


    public void Notafiscal(){
        valorTotal = MetodoPagamento();
        System.out.println("=== NOTA FISCAL ===");
        System.out.println("Número: " + vendas.getid());
        System.out.println("Data de Emissão: " + getDataPagamento());
        System.out.println("Destinatário: " + cliente.getNome());
        vendas.getProdutos().forEach(produto -> {System.out.println("Valor Unitário: R$" + produto.getPreco());        
        System.out.println("Produto: " + produto.getNome() );
        System.out.println("Quantidade: " + vendas.getQuantidade());
        System.out.println("Valor Unitário: R$" + produto.getPreco());
        System.out.println("Valor Total: R$" + valorTotal);
        ;});    
        

    }

}
