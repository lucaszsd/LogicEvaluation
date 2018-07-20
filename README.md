O projeto é um resolvedor de instâncias do problema SAT. Seu programa receberá expressões bem-formadas da lógica proposicional e deverá retornar a solução do problema. Seu programa deve solucionar as instâncias a partir de 2 métodos vistos em sala de aula: Método da Tabela-Verdade e Método da Resolução.

Entrada
A entrada será dada pelo arquivo Entrada.in
A primeira linha da entrada conterá um inteiro N representando o número de problemas (proposições) que seu programa deve resolver.
As N linhas seguintes conterão proposições, onde cada uma pode estar em um dos seguintes formatos:
TT proposição
RE proposição
O prefixo "TT" significa que seu programa deve resolver o problema usando o método da Tabela-Verdade, enquanto "RE" significa que ele deve resolvê-lo pelo método da Resolução.
Sintaxe
Operadores: cada entrada será composta por 5 operadores. Seus símbolos usados estão listados abaixo.

~  | Negação
v  | Disjunção
&  | Conjunção
>  | Implicação
<  | Equivalência (bi-implicação)

Variáveis: a entrada terá no máximo 4 variáveis - P, Q, R e S.
Parênteses:
Tabela-Verdade: todas as subexpressões (exceto variáveis) estão envoltas em parênteses:
(~subexpressão) ou (subexpressão1 v/&/>/< subexpressão2)

Resolução: todas as cláusulas estão envoltas em parênteses, até mesmo as unitárias.
Saída
Seu programa deve gerar 2 saídas distintas, Tabela.out e Resolucao.out, que conterão as soluções dos problemas resolvidos pelo método da Tabela-Verdade e pelo da Resolução, respectivamente.
Para cada caso, a saída deve conter "Problema #x", onde x é o número do caso, iniciando de 1.
Cada caso deve ser separado por uma linha em branco.
Tabela-Verdade
Na primeira linha da tabela, devem ser impressas todas as subexpressões da proposição em ordem crescente de complexidade.
Nas linhas seguintes devem ser impressos os valores-verdade. Considere que as valorações das variáveis seguem em ordem crescente.
Após a tabela, seu programa deve imprimir a resposta do problema: "Sim, é satisfatível." ou "Não, não é satisfatível."
Resolução
A Resolução só aceitará proposições que estiverem na FNC e (nesse projeto) com todas as cláusulas sendo de Horn.
 Sendo assim, caso a expressão não esteja na FNC, seu programa deve imprimir "Não está na FNC.".
 Caso esteja, mas há cláusulas que não são de Horn, seu programa deve imprimir "Nem todas as cláusulas são de Horn.". 
Caso contrário, seu programa deve imprimir a resposta do problema: "Sim, é satisfatível." ou "Não, não é satisfatível."
