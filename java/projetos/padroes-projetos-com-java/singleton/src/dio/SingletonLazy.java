package dio;

// Singleton preguiçoso
// NAO DISPONIVILIDADE A INSTANCIA DE IMEDIATO
public class SingletonLazy {
    private static SingletonLazy instancia;

    // CONTRUTOR DEVE SER PRIVADO, PARA GARANTIR QUE NÃO SEJA INSTANCIADO DE FORMA INCORRETA;
    private SingletonLazy(){
        super();
    }


    // METODO QUE EXPOE A INSTANCIA DE FORMA PUBLICA
    public static SingletonLazy getInstancia(){
        // SE NAO HOUVE UMA INSTANCIA ATIVA, UMA É CRIADA;
        if( instancia == null) {
            instancia = new SingletonLazy();
        }

        return instancia;
    }
}
