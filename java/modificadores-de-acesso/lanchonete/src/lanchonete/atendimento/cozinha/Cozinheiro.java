package lanchonete.atendimento.cozinha;

public class Cozinheiro {
    public void adicionarLancheNoBalcao() {
        System.out.println("Adicionando Hamburguer no balcao");
    }

    public void adicionarSucoNoBalcao() {
        System.out.println("Adicionando suco no balcao");
    }

    public void adicionarComboNoBalcao() {
        adicionarSucoNoBalcao();
        adicionarLancheNoBalcao();
    }

    private void prepararLanche() {
        System.out.println("Preparando Hamburguer");
    }

    private void prepararVitamina() {
        System.out.println("Preparando suca");
    }

    public void prepararCombo() {
        prepararLanche();
        prepararVitamina();
    }

    void pedirIngredientes (Almoxarife almoxarife) {
        almoxarife.entregarIngredientes();
    }
}