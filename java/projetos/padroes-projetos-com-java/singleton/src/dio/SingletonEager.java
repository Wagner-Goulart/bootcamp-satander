package dio;

// SINGLETON APRESSADO
public class SingletonEager {
    // INSTANCIA JÁ É CRIADO NO ATRIBUTO
    private static SingletonEager instancia = new SingletonEager();

    // CONTRUTOR PRIVADO
    private SingletonEager(){
        super();
    }

    // RETORNA A INSTANCIA CRIADA
    public static SingletonEager getInstancia(){
        return instancia;
    }
}
