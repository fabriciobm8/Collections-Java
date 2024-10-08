package map;

public class Produto {

  private String nome;
  private Double preco;
  private int quantidade;

  public Produto(String nome, double preco, int quantidade) {
    this.nome = nome;
    this.preco = preco;
    this.quantidade = quantidade;
  }

  public String getNome() {
    return nome;
  }

  public Double getPreco() {
    return preco;
  }

  public int getQuantidade() {
    return quantidade;
  }

  @Override
  public String toString() {
    return "Produto{" +
        "nome='" + nome + '\'' +
        ", preco=" + preco +
        ", quantidade=" + quantidade +
        '}';
  }
}
