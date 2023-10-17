package dio;

public class SingletonLazyHolder {

    // PARA ESSE UM INNER CLASSE É CRIADO, E ESSA CLASSE CONTROLA A INSTANCIA.
    private static class Holder {
       public static SingletonLazyHolder instancia = new SingletonLazyHolder();
    };
  
       // CONTRUTOR PRIVADO
       private SingletonLazyHolder(){
           super();
       }
   
       // RETORNA A INSTANCIA CRIADA
       public static SingletonLazyHolder getInstancia(){
           return Holder.instancia;
       }
}
