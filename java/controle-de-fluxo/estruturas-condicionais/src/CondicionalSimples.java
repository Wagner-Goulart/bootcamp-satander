public class CondicionalSimples {
    public static void main(String[] args) throws Exception {
        double saldo = 25.0;
        double valorSolicitado = 17.0;

        // A CONDIÇÃO PRECISA SER VERDADEIRA PARA QUE O BLOCO SEGUINTE SEJA EXCUTADO;
        // SE O RESULTADO FOR FALSE, IRÁ PASSAR PARA A PRÓXIMA LINHA.
        if(valorSolicitado < saldo) 
            saldo = saldo - valorSolicitado;

        System.out.println(saldo);
    }
}
