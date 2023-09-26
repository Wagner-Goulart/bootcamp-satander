public class CondicionalEncadeada {
    public static void main(String[] args) {
        int nota = 4;

        // CONDICIONAL
        if(nota >= 7) {
            System.out.println("Aprovado"); // EXECUTA QUANDO O RESULTADO É TRUE
        } else if (nota >= 5 && nota < 7) { // NOVA CONDICIONAL
            System.out.println("Recuperação"); // EXCUTA QUANDO TRUE
        } else {
            System.out.println("Reprovado"); // EXCECUTA QUANDO FALSE
        }
    }
}
