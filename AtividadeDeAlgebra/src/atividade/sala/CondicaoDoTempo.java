package atividade.sala;

import java.util.HashMap;
import java.util.Map;

public enum CondicaoDoTempo {
    SOL,
    CHUVA;

    // Mapa para armazenar as probabilidades de transição
    private static final Map<CondicaoDoTempo, Map<CondicaoDoTempo, Double>> probabilidadesTransicao = new HashMap<>();

    static {
        // Inicializando as probabilidades de transição
        for (CondicaoDoTempo de : CondicaoDoTempo.values()) {
            probabilidadesTransicao.put(de, new HashMap<>());
        }

        // Definindo as probabilidades de transição
        probabilidadesTransicao.get(SOL).put(SOL, 0.60);
        probabilidadesTransicao.get(SOL).put(CHUVA, 0.40);

        probabilidadesTransicao.get(CHUVA).put(CHUVA, 0.30);
        probabilidadesTransicao.get(CHUVA).put(SOL, 0.70);
    }

    // Método para obter a probabilidade de transição para outro estado
    public double getProbabilidadeTransicao(CondicaoDoTempo para) {
        return probabilidadesTransicao.get(this).getOrDefault(para, 0.0);
    }

    public static void main(String[] args) {
        // Testando as probabilidades de transição
        System.out.println("Probabilidade de transição de SOL para SOL: " + SOL.getProbabilidadeTransicao(SOL));
        System.out.println("Probabilidade de transição de SOL para CHUVA: " + SOL.getProbabilidadeTransicao(CHUVA));
        System.out.println("Probabilidade de transição de CHUVA para CHUVA: " + CHUVA.getProbabilidadeTransicao(CHUVA));
        System.out.println("Probabilidade de transição de CHUVA para SOL: " + CHUVA.getProbabilidadeTransicao(SOL));
    }
}

