package list.listaTarefa;
import java.util.ArrayList;
import java.util.List;

public class Listatarafa {
    private List<Tarefa> tarefaList;

    public Listatarafa(){
        this.tarefaList = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao){
        tarefaList.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao){
        List<Tarefa> tarefasParaRemover = new ArrayList<>();

        for (Tarefa t : tarefaList) {
            if (t.getDescricao().equalsIgnoreCase(descricao)){
               tarefasParaRemover.add(t); 
            }
        }

        tarefaList.removeAll(tarefasParaRemover);
    }

    public int obterNumeroTotalDeTarefas(){
        return tarefaList.size();
    }

    public void obeterDescricoestarafas(){
        System.out.println(tarefaList);
    }

    public static void main(String[] args) {
        Listatarafa listatarafa = new Listatarafa();

       
        listatarafa.adicionarTarefa("tarefa 1");
        listatarafa.adicionarTarefa("tarefa 2");
        listatarafa.adicionarTarefa("tarefa 3");

        listatarafa.removerTarefa("tarefa 1");
         System.out.println("O número total de tarefas é " + listatarafa.obterNumeroTotalDeTarefas());

         listatarafa.obeterDescricoestarafas();
    }
}
