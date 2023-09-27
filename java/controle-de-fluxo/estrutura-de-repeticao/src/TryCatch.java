import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class TryCatch {
    public static void main(String[] args) throws Exception {
        try {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("Digite seu nome");
        String nome = scanner.next();

        System.out.println("Digite seu Sobrenome");
        String sobrenome = scanner.next();

        System.out.println("Digite sua Idade");
        int idade = scanner.nextInt();

        System.out.println("Digite sua Altura");
        double altura = scanner.nextDouble();

        System.out.println("Olá me chamo"+ " "+ nome +" " + sobrenome);
        System.out.println("Tenho " + idade + "" + " anos de idade");
        System.err.println("Minha altura é " + altura);
        } catch(InputMismatchException e) {
            System.out.println(("Os campos idade e altura precisam ser numéricos"));
        }
    
    }
}
