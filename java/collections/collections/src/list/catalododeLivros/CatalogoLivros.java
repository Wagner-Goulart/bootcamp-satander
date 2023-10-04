package list.catalododeLivros;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {
    private List<Livro> livroList;

    public CatalogoLivros() {
        this.livroList = new ArrayList<>();
    }

    public void adicionarLivro(String titulo, String autor, int anoPublicao) {
        livroList.add(new Livro(titulo, autor, anoPublicao));
    }

    public List<Livro> pesquisearAutor(String autor) {

        List<Livro> livrosPorAutor = new ArrayList<>();
        if (!livroList.isEmpty()) {
            for (Livro l : livroList) {
                if (l.getAutor().equalsIgnoreCase(autor)) {
                    livrosPorAutor.add(l);
                }
            }
        }
        return livrosPorAutor;

    }

    public List<Livro> pesquisarPorIntervalorDeAno(int anoInicial, int anoFinal) {

        List<Livro> livrosPorIntervaloDeAno = new ArrayList<>();

        if (!livroList.isEmpty()) {
            for (Livro l : livroList) {
                if (l.getAnoPublicacao() >= anoInicial && l.getAnoPublicacao() <= anoFinal) {
                    livrosPorIntervaloDeAno.add(l);
                }
            }
        }

        return livrosPorIntervaloDeAno;
    }

    public Livro pesquisarPorTitulo(String titulo) {
        Livro livroPorTitulo = null;

        if (!livroList.isEmpty()) {
            for (Livro l : livroList) {
                if (l.getTitulo().equalsIgnoreCase(titulo)) {
                    livroPorTitulo = l;
                    break;
                }
            }
        }

        return livroPorTitulo;
    }

    public static void main(String[] args) {
        CatalogoLivros catalogoLivros = new CatalogoLivros();

        catalogoLivros.adicionarLivro("Livro 1", "Autor A", 1999);
        catalogoLivros.adicionarLivro("Livro 1", "Autor A", 1999);
        catalogoLivros.adicionarLivro("Livro 3", "Autor B", 2000);
        catalogoLivros.adicionarLivro("Livro 3", "Autor C", 2001);
        catalogoLivros.adicionarLivro("Livro 4", "Autor D", 2002);

        System.out.println(catalogoLivros.pesquisearAutor("Autor C"));
        System.out.println(catalogoLivros.pesquisarPorIntervalorDeAno(1999, 2000));
        System.out.println(catalogoLivros.pesquisarPorTitulo("Livro 1"));
    }

}
