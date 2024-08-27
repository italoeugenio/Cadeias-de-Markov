package sala.exemplo2simples;

public class ProbabilidadeCaminho {
    public static void main(String[] args) {

        double SolParaChuva = 0.4;
        double ChuvaParaSol = 0.7;
        double SolParaSol = 0.6;
        double ChuvaParaChuva = 0.3;

        // SOL → SOL → SOL → SOL
        double probabilidadeCaminhoA = SolParaSol * SolParaSol * SolParaSol;
        System.out.printf("Probabilidade do Caminho A: %.3f%n", probabilidadeCaminhoA);

        // SOL → CHUVA → SOL → SOL
        double probabilidadeCaminhoB = SolParaChuva * ChuvaParaSol * SolParaSol;
        System.out.printf("Probabilidade do Caminho B: %.3f%n", probabilidadeCaminhoB);

        // SOL → SOL → CHUVA → SOL
        double probabilidadeCaminhoC = SolParaSol * SolParaChuva * ChuvaParaSol;
        System.out.printf("Probabilidade do Caminho C: %.3f%n", probabilidadeCaminhoC);

        // SOL → CHUVA → CHUVA → SOL
        double probabilidadeCaminhoD = SolParaChuva * ChuvaParaChuva * ChuvaParaSol;
        System.out.printf("Probabilidade do Caminho D: %.3f%n", probabilidadeCaminhoD);

        double somaProbabilidades = probabilidadeCaminhoA + probabilidadeCaminhoB + probabilidadeCaminhoC + probabilidadeCaminhoD;
        System.out.printf("Soma das Probabilidades: %.3f%n", somaProbabilidades);

        double percentual = somaProbabilidades * 100;
        System.out.printf("Percentual: %.1f%%%n", percentual);
    }
}
