package main.OperacoesBasicas.list;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    public  List<Item> ItemCarrinho;

    public CarrinhoDeCompras() {
        this.ItemCarrinho = new ArrayList<>();
    }

    public List<Item> getItemCarrinho() {
        return ItemCarrinho;
    }
    public void adicionarItem(String nome, double preco,
                              int quantidade){
        ItemCarrinho.add(new Item(nome,preco,quantidade));
    }
    public void removerItem(String nome){
        List<Item> itemParaRemover = new ArrayList<>();
        for (Item i: ItemCarrinho){
            if (i.getNome().equalsIgnoreCase(nome)) {
                itemParaRemover.add(i);
            }
        }
        ItemCarrinho.removeAll(itemParaRemover);
    }
    public double calcularValorTotal(){
        double valorTotal = 0;
        double valorTotalItem = 0;
        int qtd;
        double valorUnitario;
        List<Item> somaDosValores = new ArrayList<>();
        for(Item i :ItemCarrinho){
            qtd= i.getQuantidade();
            valorUnitario =i.getPreco();
            valorTotalItem = qtd*valorUnitario;
            valorTotal =valorTotal+ valorTotalItem;
        }
        return valorTotal;

    }
   public List<Item> exibirItens(){

        return ItemCarrinho;

    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();
        carrinhoDeCompras.adicionarItem("Abobora", 2.99, 1);
        carrinhoDeCompras.adicionarItem("Feijao", 6.99, 3);
        carrinhoDeCompras.exibirItens();
        System.out.println("O valor no carrinho é de "+ carrinhoDeCompras.calcularValorTotal());
        System.out.println("Os itens no carrinho de compra são: \n"+ carrinhoDeCompras.exibirItens()+ "\n");

    }
}
