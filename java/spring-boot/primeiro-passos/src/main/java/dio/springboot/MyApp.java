package dio.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component // Define um componente que implemente um ComandLineRuner
public class MyApp implements CommandLineRunner {
    
    @Autowired // Injeção de dependencia, cria a instancia de uma calculadores de a necessidade do new
    private Calculadora calculadora;

    @Override
    public void run(String... args) throws Exception {
       System.out.println("Resultado " + calculadora.somar(2, 7));
    }
    
}
