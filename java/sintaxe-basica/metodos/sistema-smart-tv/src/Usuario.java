public class Usuario {
    public static void main(String[] args) throws Exception {
        SmartTv smartTv = new SmartTv();

        smartTv.diminuirVolume();
        smartTv.diminuirVolume();
        smartTv.diminuirVolume();

        smartTv.aumentarVolume();
        System.out.println("EM QUE CANAL ? " + smartTv.canal);
        smartTv.mudarCanal(30);

        System.out.println("TV LIGADA ? " + smartTv.ligada);
        System.out.println("EM QUE CANAL ? " + smartTv.canal);
        System.out.println("E QUAL É O VOLUME ? " + smartTv.volume);

        smartTv.ligar();
        System.out.println("TV LIGOU ? " + smartTv.ligada);

        smartTv.desligar();
        System.out.println("ESTÁ LIGADA AINDA ? " + smartTv.ligada);
    }
}
