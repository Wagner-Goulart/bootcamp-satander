package dio.aula;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import dio.aula.model.User;
import dio.aula.repository.UserRepository;

@Component
public class StartApp implements CommandLineRunner {
    
    @Autowired
    private UserRepository repository;

    public void run(String... args) throws Exception {
        User user = new User();

        user.setName("Natasha");
        user.setUserName("Ngoulart");
        user.setPassword("123456");

        repository.save(user);

        for(User u : repository.findAll()){
            System.out.println(" AQUIIIII " + u);
        }


    }
    
}
