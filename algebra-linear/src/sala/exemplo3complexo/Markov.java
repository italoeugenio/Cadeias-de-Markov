package sala.exemplo3complexo;

import java.util.Objects;

public class Markov {
    private String[] diasDaSemana = {
            "Domingo", "Segunda-feira", "Terça-feira", "Quarta-feira",
            "Quinta-feira", "Sexta-feira", "Sábado"
    };

    private double[][] matrizDeTransicao = {
            {0.6, 0.4}, //SOL
            {0.7, 0.3}  //CHUVA
    };

    public int diferencaEntreDias(String dia1, String dia2) {
        int indexDia1 = -1;
        int indexDia2 = -1;

        for (int x = 0; x < diasDaSemana.length; x++) {
            if (Objects.equals(diasDaSemana[x], dia1)) {
                indexDia1 = x;
                break;
            }
        }

        for (int i = 0; i < diasDaSemana.length; i++) {
            if (Objects.equals(diasDaSemana[i], dia2)) {
                indexDia2 = i;
                break;
            }
        }

        return Math.abs(indexDia1 - indexDia2);
    }

    public double[][] elevarMatrizDeTransicao(int numTransicoes) {
        double[][] matrizElevada = matrizDeTransicao;

        for (int i = 1; i < numTransicoes; i++) {
            matrizElevada = multiplicarMatrizes(matrizElevada, matrizDeTransicao);
        }

        return matrizElevada;
    }

    private double[][] multiplicarMatrizes(double[][] matrizA, double[][] matrizB) {
        int tamanho = matrizA.length;
        double[][] resultado = new double[tamanho][tamanho];

        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                resultado[i][j] = 0;
                for (int k = 0; k < tamanho; k++) {
                    resultado[i][j] += matrizA[i][k] * matrizB[k][j];
                }
            }
        }

        return resultado;
    }

    public void calcularTodosOsCaminhos(String diaInicial, String diaFinal) {
        int numTransicoes = diferencaEntreDias(diaInicial, diaFinal);

        double[][] matrizElevada = elevarMatrizDeTransicao(numTransicoes);

        System.out.println("Probabilidades dos caminhos de " + diaInicial + " até " + diaFinal + ":");

        for (int estadoInicial = 0; estadoInicial < 2; estadoInicial++) {
            for (int estadoFinal = 0; estadoFinal < 2; estadoFinal++) {
                double probabilidade = matrizElevada[estadoInicial][estadoFinal] * 100;
                String estadoInicialNome = estadoInicial == 0 ? "SOL" : "CHUVA";
                String estadoFinalNome = estadoFinal == 0 ? "SOL" : "CHUVA";
                System.out.printf("Caminho: %s -> ... -> %s = %.2f%%\n", estadoInicialNome, estadoFinalNome, probabilidade);
            }
        }
    }

}
