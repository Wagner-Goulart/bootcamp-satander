// CRIANDO UM ENUM DE ESTADOS
public enum EstadoBrasileiro {
    SAO_PAULO("SP", "São Paulo"),
    RIO_DE_JANEIRO("RJ", "Rio de janeiro"),
    PIAUI("PI", "Piaui"),
    MARANHAO("MA", "Maranhão"),
    SANTA_CATARINA("SC", "Santa Catarina");

    private String nome;
    private String sigla;

    private EstadoBrasileiro(String sigla, String nome) {
        this.sigla = sigla;
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public String getNome() {
        return nome;
    }

    public String getNomeMaiusculo() {
        return nome.toUpperCase();
    }

}
