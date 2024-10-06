package set;

import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {

  private Set<Contato> contatoSet;

  public AgendaContatos() {
    this.contatoSet = new HashSet<>();
  }

  public void adicionarContatos(String nome, int numero){
    contatoSet.add(new Contato(nome, numero));
  }
  public void exibirContatos() {
    System.out.println(contatoSet);
  }
  public Set<Contato> pesquisarPorNome(String nome) {
    Set<Contato> contatosPorNome = new HashSet<>();
    for (Contato c : contatoSet) {
      if(c.getNome().startsWith(nome)) {
        contatosPorNome.add(c);
      }
    }
    return contatosPorNome;
  }

  public Contato atualizarNumeroContato(String nome, int novoNumero) {
    Contato contatoAtualizado = null;
    for (Contato c: contatoSet) {
      if (c.getNome().equalsIgnoreCase(nome)) {
        c.setNumero(novoNumero);
        contatoAtualizado = c;
        break; //se ja achou, da o break pois nao existe nenhum outro.
      }
    }
    return contatoAtualizado;
  }

  public static void main(String[] args) {
    AgendaContatos agendaContatos = new AgendaContatos();
    agendaContatos.exibirContatos();

    agendaContatos.adicionarContatos("Camila", 123456);
    agendaContatos.adicionarContatos("Camila", 333445); //não foi add pq tem nome igual ao anterior (set nao permite)
    agendaContatos.adicionarContatos("Camila Cavalcante", 111111);
    agendaContatos.adicionarContatos("Camila DIO", 654897);
    agendaContatos.adicionarContatos("Maria Silva", 111111);

    agendaContatos.exibirContatos();

    System.out.println(agendaContatos.pesquisarPorNome("Camila"));
    System.out.println(agendaContatos.atualizarNumeroContato("Maria Silva",555555));
    agendaContatos.exibirContatos();

  }

}
