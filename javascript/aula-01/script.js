// alert('Olá mundo')

function numeroTriangular(n) {
    if (n === 1) {
      return 1;
    } else {
      return n + numeroTriangular(n - 1);
    }
  }
  
  function mostrarTrianguloEquivalente(n) {
    const numeroTriangularN = numeroTriangular(n);
  
    for (let i = 1; i <= n; i++) {
      let linha = '';
      for (let j = 1; j <= i; j++) {
        linha += '* ';
      }
      console.log(linha);
    }
  
    console.log(`Triângulo equivalente ao ${n}-ésimo número triangular (${numeroTriangularN}):`);
  }
  
  // Exemplo de uso:
  const n = 5;
  mostrarTrianguloEquivalente(n);