package canditatura;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        System.out.println("Processo seletivo");
        String [] candidatos = {"Wagner", "Liandra", "Natasha", "Pedro", "Felipe"};
        for( String candidato : candidatos) {
            entrandoEmContado(candidato);
        }
    }

    static void entrandoEmContado(String canditado){
        int tentativasRealizadas =1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do {
            atendeu = antender();
            continuarTentando = !atendeu;

            if(continuarTentando) {
                tentativasRealizadas ++;
            } else {
                System.out.println("Contato relizado com sucesso");
            }

        } while( continuarTentando && tentativasRealizadas < 3);

        if(atendeu) {
            System.out.println("Conseguimos com com " + canditado + " na " + tentativasRealizadas + " tentativa");
        } else {
            System.out.println("Não conseguimos contato com " + canditado + " no numero máximo de tentativas");
        }
    }

    static boolean antender(){
        return new Random().nextInt(3)==1;
    }

    static void imprimirSelecionados() {
         String [] candidatos = {"Wagner", "Liandra", "Natasha", "Pedro", "Felipe"};

         System.out.println("Imprimindo a lista de candidatos informando o indice do elemento");

         for(int indice = 0 ; indice < candidatos.length; indice++){
            System.out.println("O candidato de número " + (indice +1 ) + " é " + candidatos[indice]);
         }

         System.out.println("Forma abreviada de interação For each");

         for(String candidato : candidatos) {
            System.out.println("Candidato selecionado foi " + candidato);
         }
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
