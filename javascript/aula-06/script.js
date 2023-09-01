function calculadora() {
    const operacao = prompt('Escolha sua operação: \n 1 - soma(+)  \n 2 - subtração(-) \n 3 - Multiplucação (*)\n 4 - Divisão (/)\n 5 - Divisão inteira (%)\n 6 - Pontenciação(**)')



    if (!operacao || operacao >= 7) {
        alert('Erro na escolha da operação')
        calculadora()
    } else {
        let n1 = Number(prompt('Insira o primeiro valor'))
        let n2 = Number(prompt('Insira o segunda valor'))
        let resultado


        function soma() {
            resultado = n1 + n2
            alert(`${n1} + ${n2} = ${resultado}`)
        }

        function subtracao() {
            resultado = n1 - n2
            alert(`${n1} - ${n2} = ${resultado}`)
        }

        function multiplicacao() {
            resultado = n1 * n2
            alert(`${n1} * ${n2} = ${resultado}`)
        }

        function divisao() {
            resultado = n1 / n2
            alert(`${n1} / ${n2} = ${resultado}`)
        }

        function divisaoInteira() {
            resultado = n1 % n2
            alert(` O resto da divisão entre ${n1} divido por ${n2} é = ${resultado}`)
        }

        function potenciacao() {
            resultado = n1 ** n2
            alert(`${n1} elavado a ${n2} = ${resultado}`)
        }

        if (operacao == 1) {
            soma()
        } else if (operacao == 2) {
            subtracao()
        } else if (operacao == 3) {
            multiplicacao()
        } else if (operacao == 4) {
            divisao()
        } else if (operacao == 5) {
            divisaoInteira()
        } else if (operacao == 6) {
            potenciacao()
        }
    }


}
calculadora()
