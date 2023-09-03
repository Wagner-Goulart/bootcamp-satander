// definada a classe que servirá como compenente
// Ela herda todas as características de um elemento HTML
class TituloDinamico extends HTMLElement{ 
    constructor(){ // chama o contrutor da classe
        super() // chama o contrutor da super classe

        // criar um referência para shadow com a variável shadow
        // anexa ela a classe que foi criada
        // mode: 'open' indica que ela está aberta a alterações externas
        const shadow = this.attachShadow({mode:'open'})

        // criar um elemento <h1> na Shadow Dom
        const componentRoot = document.createElement('h1')
        // indica que o texto, será o que vier dentro do atributo 'titulo'
        // esse atribuito funciona como uma props ( algo comum em frameworks)
        componentRoot.textContent = this.getAttribute('titulo');

        // cria uma tag 'style'
        const style = document.createElement('style')
        // recebo o CSS que servirá como estilo
        style.textContent = `
            h1 {
                color:red;
            }
        ` 
   
        // anexa os elememtos criado a variável shadow
        shadow.appendChild(componentRoot)
        shadow.appendChild(style)
    }
}

// defino o elemento custimizado
// primeiro parametro é como iremos chamar ele no HTML, é obrigatório o hífen (meu-componete)
// segundo parametro referencia a classe que tem o construtor
customElements.define('titulo-dinamico', TituloDinamico)