# Collections FrameWork

Estruturas de dados utilizada para agrupar muitos elementos. Collections não aceitam tipos primitivos, elas aceitam apenas `objetos`

Podem ser `homogeneas ( de mesmo tipo )` ou `heterogenas ( de tipos diferentes )` comumente as homogenas são as mais utilizadas.

Existem 4 grandes tipos, `List, Set, Queue e Map`

![Untitled](./Untitled%20(2).png)

Todas as classes e interfaces estão dentro do pacote `java.util`

### Generic Types:

Classes genérica parametriza em relação a tipos.

```jsx
public class Box {
    private Object object;

    public void set(Object object) { this.object = object; }
    public Object get() { return object; }
}
```

`< >` Diamond operator e é utilizado no contexto de tipos genéricos

```jsx
/**
Versão genérica da classe Box.
@param <T> o tipo do valor sendo armazenado
*/
public class Box<T> {
	// T representa "Type" (tipo)
    private T t;

    public void set(T t) { this.t = t; }
    public T get() { return t; }
}
```

Parametros mais comumentes utilizados:

- E - Elemento (usado extensivamente pelo Java Collections Framework)
- K - Chave
- N - Número
- T - Tipo
- V - Valor
- S, U, V, etc. - 2º, 3º, 4º tipos

### Comporable e Comparator:

`comparable` fornece um sequência de ordenação dos dados,

`comparable`Modifica a classe atual;

`comparable` Fornece o método `compareTo()` 

`comparable` Está presente no pacote `java.lang` 

Elementos de lista podem ser ordenados com `Collections.sort(list)`

`comparator` fornece o método `compare()`

`comparator` fornece múltiplas sequencias de ordenação

`comparator` não afeta a classe atual

`comparator` está no pacote `java.util`

Elementos de lista podem ser ordenados com `Collections.sort(list, Comparador)`

<aside>
📌 Collections é um classe utilitária do java para operações comuns em coleções.

</aside>

```jsx
package main.java.comparableXcomparator;

import java.util.Comparator;

// Uma classe 'Livro' que implementa Comparable
class Livro implements Comparable<Livro> {
	private String titulo;
	private String autor;
	private int ano;

	// Construtor
	public Livro(String ti, String au, int an) {
		this.titulo = ti;
		this.autor = au;
		this.ano = an;
	}

	// Usado para ordenar livros por ano
	public int compareTo(Livro l) {
		return titulo.compareTo(l.titulo);
	}

	// Métodos getters para acessar os dados privados
	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public int getAno() {
		return ano;
	}
}

// Classe para comparar Livro por autor
class CompararAutor implements Comparator<Livro> {
  @Override
  public int compare(Livro l1, Livro l2) {
		return l1.getAutor().compareTo(l2.getAutor());
	}
}

// Classe para comparar Livro por ano
class CompararAno implements Comparator<Livro> {
  @Override
  public int compare(Livro l1, Livro l2) {
		if (l1.getAno() < l2.getAno())
			return -1;
		if (l1.getAno() > l2.getAno())
			return 1;
		else
			return 0;
	}
}

class CompararAnoAutorTitulo implements Comparator<Livro> {
	@Override
	public int compare(Livro l1, Livro l2) {
		int ano = Integer.compare(l1.getAno(), l2.getAno());
		if (ano != 0)
			return ano;
		int autor = l1.getAutor().compareTo(l2.getAutor());
		if (autor != 0)
			return autor;
		return l1.getTitulo().compareTo(l2.getTitulo());
	}
}
```

### Interface `list:`

Coleção ordenada que permite que permite a inclusão de elemento duplicados.

Umas das coleções mais utilizadas em JAVA, as classes de implementação mais comuns são `Arryalist` e `LinkedList`

### Interface `set:`

Não pode ter elementos duplicados.

Possui 3 implementações `HashSet, TreeSet e LinkedHashSet`

`HashSet` → os elementos são salvos em ordem aleatório;

`TreeSet` → é possível informar como os elementos devem ser salvos

Utilizado para representar conjuntos.

Para percorrer um `Set` o mais comum é o uso de um `loop for each`

```java
package set.operacoesBaiscas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidados {
// Implementando o SET
    private Set<Convidado> convidadoSet;
// Contrutor 
    public ConjuntoConvidados(){
        this.convidadoSet = new HashSet<>();
    }
// Métodos que implementando so métodos do set
    public void adicionarConvidado(String nome, int codigoConvite){
        convidadoSet.add(new Convidado(nome, codigoConvite));
    }

    public void removerConvidadoPorCodigoDoConvite(int codigoConvite){
        Convidado convidadoParaRomover = null;

        for( Convidado convidado : convidadoSet){
            if(convidado.getCodigoConvite() == codigoConvite) {
                convidadoParaRomover = convidado;
                break;
            }
        }

        convidadoSet.remove(convidadoParaRomover);
    }

    public int contarConvidados(){
        return convidadoSet.size();
    }

    public void exibirConvidados(){
        System.out.println(convidadoSet);
    }
}
```

### Interface `MAP`

Mapeia dados `chave : valor`

Pode conter chaves duplicadas, mas cada chave de mapear apenas um dados;

Possui três implementações: `HashMap, TreeMap e LinkedHashMap`

Operações básicas são: 

`put ( inserrir ),` 

`get ( obter ),` 

`containsKey ( verifica se a chave existe ),` 

`containsValue ( verifica se o valor existe ),` 

`size ( obtém tamanho ), isEmpty ( verifica se está vazio )`

```java
package map.agendaContatos;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {
    private Map<String, Integer> agendaContatoMap;

    public AgendaContatos() {
        this.agendaContatoMap = new HashMap<>();
    }

    public void adicionarContato(String nome, Integer telefone) {
        agendaContatoMap.put(nome, telefone);
    }

    public void removerContato(String nome) {
        if (!agendaContatoMap.isEmpty()) {
            agendaContatoMap.remove(nome);
        }
    }

    public void exibirContato() {
        System.out.println(agendaContatoMap);
    }

    public Integer pesquisarPorNome(String nome) {
        Integer numeroPorNome = null;

        if (!agendaContatoMap.isEmpty()) {
            numeroPorNome = agendaContatoMap.get(nome);
        }

        return numeroPorNome;

    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.adicionarContato("Wagner", 1234234234);
        agendaContatos.adicionarContato("Wagner", 5678567);
        agendaContatos.adicionarContato("Natasha", 5785678);
        agendaContatos.adicionarContato("Lili", 987894234);

        agendaContatos.removerContato("Lili");

        agendaContatos.exibirContato();

        System.out.println(agendaContatos.pesquisarPorNome("Wagner"));

    }

}
```

a