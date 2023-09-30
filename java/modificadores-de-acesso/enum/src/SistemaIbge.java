public class SistemaIbge {
    // FAZENDO USO DO ENAUM
    public static void main(String[] args) {
        for ( EstadoBrasileiro e: EstadoBrasileiro.values()){
            System.out.println(e.getSigla() + " - " + e.getNome());
        }

        EstadoBrasileiro eb = EstadoBrasileiro.SANTA_CATARINA;

        System.out.println(eb.getNomeMaiusculo());
    }
}
