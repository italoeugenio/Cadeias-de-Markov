package sala.exemplo1comErro;

public class Main {
    public static void main(String[] args) {
        // Usando o enum para obter as probabilidades
        double probSolParaSol = EstadosDeTransicoesDosClimas.SOL.getProbabilidadeTransicao(EstadosDeTransicoesDosClimas.SOL);     // SOL -> SOL
        double probSolParaChuva = EstadosDeTransicoesDosClimas.SOL.getProbabilidadeTransicao(EstadosDeTransicoesDosClimas.CHUVA);   // SOL -> CHUVA
        double probChuvaParaSol = EstadosDeTransicoesDosClimas.CHUVA.getProbabilidadeTransicao(EstadosDeTransicoesDosClimas.SOL);   // CHUVA -> SOL
        double probChuvaParaChuva = EstadosDeTransicoesDosClimas.CHUVA.getProbabilidadeTransicao(EstadosDeTransicoesDosClimas.CHUVA); // CHUVA -> CHUVA

        // Caminhos possíveis
        double caminhoA = probSolParaSol * probSolParaSol * probSolParaSol;  // SOL -> SOL -> SOL -> SOL
        double caminhoB = probSolParaChuva * probChuvaParaChuva * probChuvaParaSol;  // SOL -> CHUVA -> CHUVA -> SOL
        double caminhoC = probSolParaChuva * probChuvaParaSol * probSolParaSol;  // SOL -> CHUVA -> SOL -> SOL
        double caminhoD = probSolParaSol * probSolParaSol * probSolParaChuva * probSolParaSol;  // SOL -> SOL -> CHUVA -> SOL

        // Probabilidade total
        double probabilidadeTotal = caminhoA + caminhoB + caminhoC + caminhoD;

        // Exibindo o resultado
        System.out.println("A probabilidade de ter sol no sábado e domingo é: " + (probabilidadeTotal * 100) + "%");
    }
}
