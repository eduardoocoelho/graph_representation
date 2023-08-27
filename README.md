# Descrição da Tarefa
Seu programa deverá ler o conteúdo do arquivo e representar o grafo direcionado em memória utilizando uma das estruturas discutidas em nossas aulas. Depois disso, sua implementação deve utilizar a estrutura escolhida para produzir as seguintes informações: 

- (i): grau de saída e conjunto de sucessores para o vértice de maior valor de grau de saída; 
- (ii): grau de entrada e conjunto de predecessores para o vértice de maior valor de grau de entrada. 

OBS.: É necessário produzir tais informações apenas para um vértice, caso ocorra empates.

## Formato dos arquivos de teste
Seu programa deverá ler as informações sobre o grafo a partir de um arquivo texto. A primeira linha desse arquivo contém o número "n" de vértices seguido do número "m" de arestas. Você deve considerar que os vértices são numerados (rotulados) de 1 a "n". Depois disso, o arquivo contém uma lista com as "m" arestas (sendo uma aresta por linha) em que cada aresta é representada pelos seus vértices de origem e de destino.

## Estrutura utilizada
Para representar o grafo, foi utilizada uma Matriz de Incidência, onde as colunas da matriz representam as arestas do grafo e as linhas representam os vértices. Na matriz, as posições com valor "-1" representam uma aresta saindo do vértice e as posições com valor "1" representam uma aresta entrando no vértice. Posições com valor "0" indicam que a aresta não incide no vértice.

## Como rodar
Para rodar o código, basta realizar o download dos arquivos "graph-test-100.txt" e "Main.java" e rodar o arquivo .java em uma IDE de preferência. Caso queira utilizar outro arquivo de teste, basta inserir o arquivo na mesma pasta e escrever o nome do novo arquivo de teste durante a execução do programa, quando for solicitado.
