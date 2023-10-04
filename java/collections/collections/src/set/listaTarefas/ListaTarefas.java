package set.listaTarefas;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {
    private Set<Tarefa> tarefasSet;

    public ListaTarefas() {
        this.tarefasSet = new HashSet<>();
    }

    public void adicionarTarefa(String descricao, boolean estaConcluida) {
        tarefasSet.add(new Tarefa(descricao, estaConcluida));
    }

    public void removerTarefa(String descricao) {
        Tarefa tarafeParaRemover = null;

        for (Tarefa t : tarefasSet) {
            if (t.getDescricao().equalsIgnoreCase(descricao)) {
                tarafeParaRemover = t;
            }
        }

        tarefasSet.remove(tarafeParaRemover);
    }

    private void exibirTarefas() {
        System.out.println(tarefasSet);
    }

    private void contarTarefas() {
        System.out.println("Você tem " + tarefasSet.size() + " tarefa(s)");
    }

    private Set<Tarefa> obterTarefasConcluidas() {
        Set<Tarefa> tarefaConcluida = new HashSet<>();

        for (Tarefa t : tarefasSet) {

            if (t.getEstaConcluida() == true) {
                tarefaConcluida.add(t);
            }
        }

        return tarefaConcluida;
    }

    private Set<Tarefa> obterTarefasPendentes() {
        Set<Tarefa> tarefaPendente = new HashSet<>();

        for (Tarefa t : tarefasSet) {
            if (t.getEstaConcluida() == false) {
                tarefaPendente.add(t);
            }
        }

        return tarefaPendente;
    }

    public Tarefa marcarTarefaComoConcluida(String descricao) {
        Tarefa tarefaConcluida = null;

        if (!tarefasSet.isEmpty()) {
            for (Tarefa t : tarefasSet) {
                if (t.getDescricao().equalsIgnoreCase(descricao)) {
                    t.setEstaConcluida(true);
                    tarefaConcluida = t;
                }
            }
        }

        return tarefaConcluida;
    }

    public Tarefa marcarTarefaComoPendente(String descricao) {
        Tarefa tarefaPendente = null;

        if (!tarefasSet.isEmpty()) {
            for (Tarefa t : tarefasSet) {
                if (t.getDescricao().equalsIgnoreCase(descricao)) {
                    t.setEstaConcluida(false);
                    tarefaPendente = t;
                }
            }
        }

        return tarefaPendente;
    }

    public void limparTarefas(){
        tarefasSet.clear();
    }

    public static void main(String[] args) {
        ListaTarefas listaTarefas = new ListaTarefas();

        listaTarefas.adicionarTarefa("Tirar o lixo", true);
        listaTarefas.adicionarTarefa("Comprar ração para as cachorras", false);
        listaTarefas.adicionarTarefa("Comprar leite", false);

        listaTarefas.contarTarefas();
        System.out.println(listaTarefas.obterTarefasConcluidas());
        listaTarefas.marcarTarefaComoConcluida("Comprar leite");
        listaTarefas.marcarTarefaComoPendente("Tirar o lixo");
        System.out.println(listaTarefas.obterTarefasPendentes());

        listaTarefas.limparTarefas();
        listaTarefas.exibirTarefas();

    }
}
