public class TiposDeOperadores {
    public static void main(String[] args) throws Exception {
        boolean condicao1 = true;
        boolean condicao2 = true;

        if( condicao1 && condicao2){
            System.out.println("AS DUAS SÃO VERDADEIRAS");

          return;
        }

        if(condicao1 || condicao2) {
            System.out.println("UMA DELAS É VERDADEIRA");
        }

        System.out.println("FIM");
    }
}
