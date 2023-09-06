//---------------DECORATORS--------------
/*
    Gatilho que é colocado em um função.
    A função é disparada sempre que o gatilho é acionado
 */

// Função que receberá o Decorator
function ExibirNome(target: any){
    console.log(target)
}

// Gatilho da função colocado em cima da classe para disparar a função
@ExibirNome
class Funcionario{}

//---------------------------------------
function apiVersion(version: string){
    return(target: any)=>{
        Object.assign(target.prototype, {__version: version })
    }
}

//---------------ATRIBUTE DECORATOR-------------
/*
    Decorator que é colocado em cima de um atributo
 */

    // Criar a função que servirá como decorator
// função receber um paramentro length que dever ser um tipo number
function minLenght(lenght: number) {

    return(target:any, key: string)=>{
        // value recebera as informaçoes que propriedade que está com o gatilho
       let _value = target[key]

       // variáveis getter e setter, irão sobrescrever os métodos get e set do objeto
       // ao valor de getter é atribuído o valor de _value
       const getter = () => _value
       // setter faz a validação de do Length recebido
       const setter = (value: string) => {
        if(value.length < lenght){
            throw new Error(`Tamanho menor que ${lenght}`)
        } else {
            _value = value
        }
       }
       // sobrescreve os métodos get e set,para se comportarem como as variáveis getter e setter
       Object.defineProperty(target, key, {
        get:getter,
        set:setter,
       })
    }
}

class Api{
    //chama o decorator, passando como tamanho minimo, 3 caracteres
    @minLenght(3)
    name: string;

    constructor(name:string){
        this.name = name
    }
}

const api = new Api("usa")
