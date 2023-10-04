package set.listaAlunos;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {
    private Set<Aluno> alunosSet;

    public GerenciadorAlunos() {
        this.alunosSet = new HashSet<>();
    }

    public void adicionarAluno(String nome, Long matricula, double nota) {
        alunosSet.add(new Aluno(nome, matricula, nota));
    }

    public void removerAluno(long matricula) {
        Aluno alunoParaRemover = null;

        for (Aluno a : alunosSet) {
            if (a.getMatricula() == matricula) {
                alunoParaRemover = a;
            }
        }

        alunosSet.remove(alunoParaRemover);
    }

    public Set<Aluno> exibirAlunoPorNome() {
        Set<Aluno> exibirAlunoPorNome = new TreeSet<>(alunosSet);

        return exibirAlunoPorNome;
    }

    public Set<Aluno> exibirAlunoPorNota() {
        Set<Aluno> exibirAlunoPorNota = new TreeSet<>(new ComparatorPorNota());

        exibirAlunoPorNota.addAll(alunosSet);

        return exibirAlunoPorNota;

    }

    public void exibirAlunos() {
        System.out.println(alunosSet);
    }

    public static void main(String[] args) {
        GerenciadorAlunos gerenciadorAlunos = new GerenciadorAlunos();

        gerenciadorAlunos.adicionarAluno("Wagner", 1l, 9.9);
        gerenciadorAlunos.adicionarAluno("Natasha", 2l, 9);
        gerenciadorAlunos.adicionarAluno("Lili", 3l, 9.5);

        System.out.println(gerenciadorAlunos.exibirAlunoPorNome());
    }

}
