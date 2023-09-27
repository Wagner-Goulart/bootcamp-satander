package canditatura;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        System.out.println("Processo seletivo");
        selecaoCandidatos();
    }

    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;

        if ( salarioBase > salarioPretendido) {
            System.out.println("Ligar para o candidato");
        } else if ( salarioBase ==  salarioPretendido) {
            System.out.println("Ligar para o candidato com contra proposta");
        } else {
            System.out.println("Aguardando resultado dos demais candidatos");
        }
    }

    static void selecaoCandidatos(){
        String [] candidatos = {"Wagner", "Liandra", "Natasha", "Pedro", "Felipe", "Irineu", "Isabel", "Edson", "Luiz"};

        int candidatosSelecionados =0;
        int candidatoAtual =0;
        double salarioBase = 2000.0;

        while( candidatosSelecionados <5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " solicitou este valor de salario " + salarioPretendido);

            if(salarioBase >= salarioPretendido) {
                System.out.println("O candidato " + candidato + " foi selecionada para vaga");
                candidatosSelecionados++;
            }
            candidatoAtual++;
        }
    }

    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }


}
