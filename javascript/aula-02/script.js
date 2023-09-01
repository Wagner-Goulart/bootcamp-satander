// tipos primitivos

//Boolean
// let vOuF = false

// console.log(typeof(vOuF))

// //Numder
// let numero = 1
// console.log(typeof(numero))

// //string
// let nome = 'nome'
// console.log(typeof(nome))

var escopoGlocal = 'global'
console.log(escopoGlocal)

function escopoLocal() {
    let escopoLocalInter = 'local'
    console.log(escopoLocalInter)
}

escopoLocal()



