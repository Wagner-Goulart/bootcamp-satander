// Declarando variáriveis com typescript
let ligado: boolean = true
let nome: string = 'Pessoa'
let numero: number = 1234

// null e undefined
let nulo: null = null
let indefinido: undefined = undefined

//tipos abrangentes any ( qualquer coisa ) e void ( vazio)
let retorno: void //  utilzida em funções que não retoram nada, como um query no banco de dados
let retornoView: any // aceita qualquer tipo de dados, utilizadas em funções que não tem retorno prevísivel

// objeto sem previsibilidade
let produto: object = { // só recebe objetos como valor,
    // as propriedades do objeto podem ser qualquer, seja em tipo e quantidade
    name:'Nome1',
    Cidade: 'AlgumaCidade',
    idade:'00'
}

// declarando um type,
type ProdutoLoja={
    name: string,
    preco: number,
    unidades: number
}

// objeto tipado com previsibilidade
let meuProduto: ProdutoLoja = {
    name:'tenis',
    preco: 89.99,
    unidades: 10
}

// Arrays
let dados: string[] = ['nome', 'nome2', 'nome3']
let dados2: Array<string> = ['nome', 'nome2', 'nome3']

// Arrays Muli tipos
let infos:(string | number)[] = ['nome3', 33]

// TUPLAS => array de multi tipos, porém com lugar certo para cada tipo dado
// As informações tem que ser passadas na ordem definida na declaração
let boleto:[string, number, number] = ['agua conta', 120.0, 1234554 ]

// DATAS
let aniversario: Date = new Date('2023-09-02 05:00')


// ---------------------FUNÇÕES----------------------------

function addNumber(x: number,y: number) {
    return x + y
}
// ao tipar os parametros de uma função,
// Se essa função for guardada e uma variável, a variável dever ser do mesmo tipo
let soma: number = addNumber(3,4) // 7

// Funções multi Tipos, parametros podem ser tipados com mais de um tipo
function callToPhone(phone: string | number) {
    return phone
}

// Funções Assincronas

// Funções assincronas, além de tipar o parametro é necessário tipar a Promise para o tipo que se quer retornar
async function getDatase(id: number): Promise<number | string>{
    return '123124'
}

//----------INTERFACES-------------------

// Types são utilizados para tipar variáveis e objetos, 
//Equanto as interfaces são utilizadas para tipar Classs

interface robot{
    id: number | string, // podem ser multi-tipos
    name: string;
    readonly ativo: boolean // readonly, modificador que não permite alterção do valor 
}

//--------------CLASSES----------
// Utilizadas para criar coisas, a partir de um molde.

// Estrutura Básica
class Character{
    // declaração das propriedades da classe

    // private vai indicar que a pripriedade só pode ser pega por dentro da classe
     private name: string; 
    // Classes e subclasses que herdam, conseguem acessar a propriedade
    protected strenght: number;
    skill: number;

    // Chamada do contrutor para criar da classe    
    constructor(name: string, strenght: number, skill: number ) {
        this.name = name;
        this.strenght = strenght;
        this.skill = skill
    }

    // Método atribuido como propriedade da classe
    atack(): void {
        console.log(`Attack with ${this.strenght} points`)
    }
}

// chamada para criação de um novo personagem
const p1 = new Character('Ryu',1000, 10)

// Data modifiers
//Modificadores de acesso que indicam quem pode acessar os dados da classe
/*
    - public
    - private
    - protected
 */

/*
---------------SUBCLASSES----------------
 */
// Charatecter = Super Class
// Magician = subclass -> herda as propriedades da classe Pai (Super Class )

// Criação de uma nova class (Magician) que herda as proprieddades da Super Class (Character)
// extends --> palavra revervada que indica de qual classe estão se herdado as propriedades
class Magician extends Character {
    // nova propriedade que existe apenas para Magician
    magicPoints: number

    // chama do construtor para classe Magician
    constructor(name: string, strenght: number, skill: number, magicPoints: number){
        // super() chama o contrutor da classe pai,
        // obrigatório ser chamado em subclasses
        super(name, strenght, skill)

        this.magicPoints = magicPoints
    }
}

const p2 = new Magician('Mago', 1, 2, 10000)

/*
----------------GENERICS--------------
Deixar o retorno da função mais genéricos,e indicamos o tipo de retorno e entrada ao chamar a função
Declara com --> <T> antes de passar os parametros da função
 */

// <T> indica um Generics, que as os tipos de entrada e retorno serão dinamicos
// T[] substitui os tipos declarados,informa que a entrada e saída serão arrays genéricos
function concatArray<T>(...itens: T[]):T[]{
    return new Array().concat(...itens) 
}

// Ao invocar a função, indicamos de queremos como entrada e retorno um array do tipo Number
const numArray = concatArray<number[]>([1], [2,3])
// Mesma função sendo invocada, mas agora a entrada e retorno, são arrays de strings
const stringArray = concatArray<string[]>(['Wagner'], [' Goulart'])

