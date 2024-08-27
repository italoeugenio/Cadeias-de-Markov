package sala.exemplo3complexo;

import java.util.Scanner;

import java.util.Scanner;

import java.util.Scanner;

public class ProbabilidadeCaminho {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Probabilidades de transição
        double pSolParaChuva = 0.4;
        double pChuvaParaSol = 0.7;
        double pSolParaSol = 0.6;
        double pChuvaParaChuva = 0.3;

        // Matriz de transição
        double[][] matrizTransicao = {
                {pSolParaSol, pSolParaChuva}, // Transições a partir de SOL
                {pChuvaParaSol, pChuvaParaChuva} // Transições a partir de CHUVA
        };

        // Entrada do usuário para o estado inicial e final
        System.out.println("Digite o estado inicial (SOL/CHUVA):");
        Estado estadoInicial = obterEstado(scanner);

        System.out.println("Digite o estado final (SOL/CHUVA):");
        Estado estadoFinal = obterEstado(scanner);

        // Número de dias (estados) - Quinta a Domingo = 4 dias
        int numeroDias = 4;

        // Geração e cálculo das probabilidades de todas as sequências
        double somaProbabilidades = calcularProbabilidades(estadoInicial, estadoFinal, numeroDias, matrizTransicao);

        // Exibição da probabilidade total
        System.out.printf("Probabilidade total de todas as sequências possíveis de %s a %s em %d dias: %.3f%n",
                estadoInicial, estadoFinal, numeroDias, somaProbabilidades);

        scanner.close();
    }

    private static Estado obterEstado(Scanner scanner) {
        String entrada = scanner.nextLine().toUpperCase();
        try {
            return Estado.valueOf(entrada);
        } catch (IllegalArgumentException e) {
            System.out.println("Estado inválido. Use SOL ou CHUVA.");
            System.exit(1);
            return null; // Nunca alcançado, mas necessário para compilar
        }
    }

    private static double calcularProbabilidades(Estado estadoInicial, Estado estadoFinal, int numeroDias, double[][] matrizTransicao) {
        double somaProbabilidades = 0.0;

        // Geração de todas as sequências possíveis
        Estado[] sequencia = new Estado[numeroDias];
        sequencia[0] = estadoInicial;
        gerarSequencias(sequencia, 1, estadoFinal, matrizTransicao, somaProbabilidades);

        return somaProbabilidades;
    }

    private static void gerarSequencias(Estado[] sequencia, int posicao, Estado estadoFinal, double[][] matrizTransicao, double somaProbabilidades) {
        if (posicao == sequencia.length) {
            if (sequencia[sequencia.length - 1] == estadoFinal) {
                double probabilidade = calcularProbabilidadeSequencia(sequencia, matrizTransicao);
                somaProbabilidades += probabilidade;
            }
            return;
        }

        for (Estado estado : Estado.values()) {
            sequencia[posicao] = estado;
            gerarSequencias(sequencia, posicao + 1, estadoFinal, matrizTransicao, somaProbabilidades);
        }
    }

    private static double calcularProbabilidadeSequencia(Estado[] sequencia, double[][] matrizTransicao) {
        double probabilidade = 1.0;
        for (int i = 0; i < sequencia.length - 1; i++) {
            int estadoAtual = sequencia[i].ordinal();
            int estadoProximo = sequencia[i + 1].ordinal();
            probabilidade *= matrizTransicao[estadoAtual][estadoProximo];
        }
        return probabilidade;
    }
}
