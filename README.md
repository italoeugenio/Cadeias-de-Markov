# Simulação de Caminhos em Cadeia de Markov

## Visão Geral

Este projeto implementa uma simulação de caminhos usando Cadeias de Markov para calcular probabilidades de transição entre estados (Sol e Chuva) ao longo de dias da semana.

## Estrutura do Código

### 1. Exemplo Simples

**Classe: `ProbabilidadeCaminho`**

Este exemplo calcula probabilidades de caminhos específicos em uma cadeia de Markov:
- **Caminho A (SOL → SOL → SOL → SOL)**
- **Caminho B (SOL → CHUVA → SOL → SOL)**
- **Caminho C (SOL → SOL → CHUVA → SOL)**
- **Caminho D (SOL → CHUVA → CHUVA → SOL)**

A soma das probabilidades e o percentual total são calculados e exibidos.

### 2. Exemplo Complexo

**Classe: `Markov`**

Este exemplo usa uma matriz de transição para calcular as probabilidades de todos os caminhos possíveis entre dois dias da semana. A classe contém métodos para:
- Calcular a diferença entre dias da semana.
- Elevar a matriz de transição ao número de transições.
- Multiplicar matrizes para determinar as probabilidades finais.

**Classe: `Main`**

Executa a simulação, mostrando as probabilidades dos caminhos de "Quinta-feira" até "Domingo".

## Uso

- **Exemplo Simples:** Execute `ProbabilidadeCaminho.java` para ver as probabilidades de caminhos específicos.
- **Exemplo Complexo:** Execute `Main.java` para calcular as probabilidades de todos os caminhos possíveis entre dois dias da semana.

## Licença

Este projeto está sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes.
