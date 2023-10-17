package subsistema2.cep;

public class CepApi {
    private static CepApi cep = new CepApi();

    private CepApi() {
        super();
    }

    public static CepApi getCep() {
        return cep;
    }

    public String recuperarCidade(String cep) {
        return "Itajaí";
    }

    public String recuperarEstado(String cep) {
        return "SC";
    }
}
