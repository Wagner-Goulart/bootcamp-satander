"use strict";
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
// Declarando variáriveis com typescript
let ligado = true;
let nome = 'Pessoa';
let numero = 1234;
// null e undefined
let nulo = null;
let indefinido = undefined;
//tipos abrangentes any ( qualquer coisa ) e void ( vazio)
let retorno; //  utilzida em funções que não retoram nada, como um query no banco de dados
let retornoView; // aceita qualquer tipo de dados, utilizadas em funções que não tem retorno prevísivel
// objeto sem previsibilidade
let produto = {
    // as propriedades do objeto podem ser qualquer seja em tipo e quantidade
    name: 'Wagner',
    Cidade: 'Itajaí',
    idade: '34'
};
// objeto tipado com previsibilidade
let meuProduto = {
    name: 'tenis',
    preco: 89.99,
    unidades: 10
};
// Arrays
let dados = ['wagner', 'liandra', 'natasha'];
let dados2 = ['wagner', 'liandra', 'natasha'];
// Arrays Muli tipos
let infos = ['wagner', 33];
// TUPLAS => array de multi tipos, porém com lugar certo para cada tipo dado
// As informações tem que ser passados na ordem definida na declaração
let boleto = ['agua conta', 120.0, 1234554];
// DATAS
let aniversario = new Date('2023-09-02 05:00');
// ---------------------FUNÇÕES----------------------------
function addNumber(x, y) {
    return x + y;
}
// ao tipar os parametros de uma função,
// Se essa função for guardada e uma variável, a variável dever ser do mesmo tipo
let soma = addNumber(3, 4); // 7
// Funções multi Tipos, parametros podem ser tipados com mais de um tipo
function callToPhone(phone) {
    return phone;
}
// Funções Assincronas
// Funções assincronas, além de tipar o parametro é necessário tipar a Promise para o tipo que se quer retornar
function getDatase(id) {
    return __awaiter(this, void 0, void 0, function* () {
        return '123124';
    });
}
//--------------CLASSES----------
// Utilizadas para cirar coisas, a partir de um molde.
// Estrutura Básica
class Character {
    // Chamada do contrutor para criar da classe    
    constructor(name, strenght, skill) {
        this.name = name;
        this.strenght = strenght;
        this.skill = skill;
    }
    // Método atribuido como propriedade da classa
    atack() {
        console.log(`Attack with ${this.strenght} points`);
    }
}
// chamado para criação de um novo personagem
const p1 = new Character('Ryu', 1000, 10);
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
    // chama do construtor para classe Magician
    constructor(name, strenght, skill, magicPoints) {
        // super() chama o contrutor da classe pai,
        // obrigatório ser chamado em subclasses
        super(name, strenght, skill);
        this.magicPoints = magicPoints;
    }
}
const p2 = new Magician('Mago', 1, 2, 10000);
/*
----------------GENERICS--------------
Deixar o retorno da função mais genéricos,a indicamos o tipo de retorno e entrada ao chamar a função
Declara com --> <T> antes de passar os parametros da função
 */
// <T> indica um Generics, que as os tipos de entrada e retorno serão dinamicos
// T[] substitui os tipos declarados,informa que a entrada e saída serão arrays genéricos
function concatArray(...itens) {
    return new Array().concat(...itens);
}
// Ao invocar a função, indicamos de queremos como entrada e retorno um array do tipo Number
const numArray = concatArray([1], [2, 3]);
// Mesma função sendo invocada, mas agora a entrada e retorno, são arrays de strings
const stringArray = concatArray(['Wagner'], [' Goulart']);
