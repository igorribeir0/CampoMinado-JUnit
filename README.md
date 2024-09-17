# Projeto Campo Minado

Este projeto é uma implementação do jogo **Campo Minado**, onde o objetivo é revelar todos os campos que não contêm minas, sem que o jogador acione uma explosão. O projeto é estruturado em duas classes principais: `Tabuleiro` e `Campo`, além de conter uma exceção customizada chamada `ExplosaoExeption`.

## Estrutura do Projeto

### 1. Classe `Tabuleiro`
A classe `Tabuleiro` é responsável por gerenciar o conjunto de campos e suas operações. Ela define o tamanho do tabuleiro (número de linhas e colunas), distribui aleatoriamente as minas e permite que os campos sejam abertos ou marcados.

#### Principais Atributos:
- **`linhas`**: Número de linhas do tabuleiro.
- **`colunas`**: Número de colunas do tabuleiro.
- **`minas`**: Quantidade de minas presentes no tabuleiro.
- **`campos`**: Lista de objetos da classe `Campo`, representando cada posição do tabuleiro.

#### Principais Métodos:
- **`abrir(int linha, int coluna)`**: Tenta abrir um campo; se for uma mina, dispara a exceção `ExplosaoExeption` e abre todos os campos.
- **`alterarMarcacao(int linha, int coluna)`**: Alterna a marcação de um campo como protegido (marcado).
- **`gerarCampos()`**: Gera todos os campos do tabuleiro.
- **`associarOsVizinhos()`**: Associa os campos vizinhos uns aos outros.
- **`sortearMinas()`**: Sorteia e coloca minas em posições aleatórias no tabuleiro.
- **`objetivoAlcancado()`**: Verifica se o objetivo do jogo foi alcançado, ou seja, se todos os campos sem minas foram abertos e todos os campos com minas estão marcados.
- **`reiniciar()`**: Reinicializa o tabuleiro, removendo as marcações e re-sorteando as minas.

#### Exemplo de Utilização:
```java
Tabuleiro tabuleiro = new Tabuleiro(10, 10, 5);  // 10 linhas, 10 colunas, 5 minas
tabuleiro.abrir(3, 5);  // Abre o campo na linha 3, coluna 5
tabuleiro.alterarMarcacao(4, 6);  // Marca o campo na linha 4, coluna 6
```


## Testes Unitários

Os testes unitários são fundamentais para garantir que o jogo **Campo Minado** funcione corretamente em diferentes cenários. A seguir, estão descritos alguns exemplos de testes unitários usando **JUnit**.

### 1. Configuração do Ambiente

Para realizar os testes unitários, certifique-se de que o **JUnit 5** está devidamente configurado no projeto. Se estiver usando Maven, adicione a seguinte dependência no arquivo `pom.xml`:

```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-api</artifactId>
    <version>5.7.0</version>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-engine</artifactId>
    <version>5.7.0</version>
    <scope>test</scope>
</dependency>
