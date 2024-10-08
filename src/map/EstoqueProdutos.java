package map;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {

  private Map<Long, Produto> estoqueProdutosMap;

  public EstoqueProdutos() {
    this.estoqueProdutosMap = new HashMap<>();
  }

  public void adicionarProduto(long cod, String nome, int quantidade, double preco) {
    estoqueProdutosMap.put(cod, new Produto(nome, preco, quantidade));
  }

  public void exibirProdutos() {
    System.out.println(estoqueProdutosMap);
  }

  public double calcularValorTotalEstoque() {
    double valorTotalEstoque = 0d;
    if (!estoqueProdutosMap.isEmpty()) {
      for (Produto p: estoqueProdutosMap.values()) {
        valorTotalEstoque+= p.getQuantidade()*p.getPreco();
      }
    }
    return valorTotalEstoque;
  }

  public Produto obterProdutoMaisCaro() {
    Produto produtoMaisCaro = null;
    double maiorPreco = Double.MIN_VALUE;
    if (!estoqueProdutosMap.isEmpty()) {
      for(Produto p: estoqueProdutosMap.values()) {
        if (p.getPreco() > maiorPreco) {
          produtoMaisCaro = p;
          maiorPreco = p.getPreco();
        }
      }
    }
    return produtoMaisCaro;
  }

  public Produto obterProdutoMaisBarato() {
    Produto produtoMaisBarato = null;
    double menorPreco = Double.MAX_VALUE;
    if (!estoqueProdutosMap.isEmpty()) {
      for(Produto p: estoqueProdutosMap.values()) {
        if (p.getPreco() < menorPreco) {
          produtoMaisBarato = p;
          menorPreco = p.getPreco();
        }
      }
    }
    return produtoMaisBarato;
  }

  public Produto obterProdutoMaiorQtdTotal() {
    Produto produtoMaiorQtdTotal = null;
    double maiorQtdTotal = Double.MIN_VALUE;
    if (!estoqueProdutosMap.isEmpty()) {
      for(Produto p: estoqueProdutosMap.values()) {
        if ((p.getPreco()*p.getQuantidade()) > maiorQtdTotal) {
          produtoMaiorQtdTotal = p;
          maiorQtdTotal = p.getPreco()*p.getQuantidade();
        }
      }
    }
    return produtoMaiorQtdTotal;
  }

  public static void main(String[] args) {
    EstoqueProdutos estoque = new EstoqueProdutos();
    estoque.exibirProdutos();

    estoque.adicionarProduto(1L,"Produto A",10,5.0);
    estoque.adicionarProduto(2L,"Produto B",5,16.0);
    estoque.adicionarProduto(3L,"Produto C",2,15.0);
    estoque.adicionarProduto(4L,"Produto D",200,1.0);
    estoque.adicionarProduto(5L,"Produto E",2,12.0);

    estoque.exibirProdutos();
    System.out.println("Valor Total do Estoque: R$ " + estoque.calcularValorTotalEstoque());
    System.out.println("Produto Mais Caro: " + estoque.obterProdutoMaisCaro());
    System.out.println("Produto Mais Barato: " + estoque.obterProdutoMaisBarato());
    System.out.println("Produto Com Maior Qtde x Vlr Total: "+ estoque.obterProdutoMaiorQtdTotal());

  }

}
