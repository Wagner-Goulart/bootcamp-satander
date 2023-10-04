package set.operacoesBaiscas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidados {
    private Set<Convidado> convidadoSet;

    public ConjuntoConvidados() {
        this.convidadoSet = new HashSet<>();
    }

    public void adicionarConvidado(String nome, int codigoConvite) {
        convidadoSet.add(new Convidado(nome, codigoConvite));
    }

    public void removerConvidadoPorCodigoDoConvite(int codigoConvite) {
        Convidado convidadoParaRomover = null;

        for (Convidado convidado : convidadoSet) {
            if (convidado.getCodigoConvite() == codigoConvite) {
                convidadoParaRomover = convidado;
                break;
            }
        }

        convidadoSet.remove(convidadoParaRomover);
    }

    public int contarConvidados() {
        return convidadoSet.size();
    }

    public void exibirConvidados() {
        System.out.println(convidadoSet);
    }

    public static void main(String[] args) {
        ConjuntoConvidados conjuntoConvidados = new ConjuntoConvidados();

        System.out.println("Existem " + conjuntoConvidados.contarConvidados() + " convidados dentro do SET");

        conjuntoConvidados.adicionarConvidado("Convidado 1", 100);
        conjuntoConvidados.adicionarConvidado("Convidado 1", 200);
        conjuntoConvidados.adicionarConvidado("Convidado 2", 300);
        conjuntoConvidados.adicionarConvidado("Convidado 4", 400);
        conjuntoConvidados.adicionarConvidado("Convidado 5", 500);

        System.out.println("Existem " + conjuntoConvidados.contarConvidados() + " convidados dentro do SET");

        conjuntoConvidados.removerConvidadoPorCodigoDoConvite(100);

        System.out.println("Existem " + conjuntoConvidados.contarConvidados() + " convidados dentro do SET");

        conjuntoConvidados.exibirConvidados();
    }
}
