package sala.exemplo1comErro;

public enum EstadosDeTransicoesDosClimas {
    SOL(0.6, 0.4),
    CHUVA(0.7, 0.3);

    private final double probabilidadeSol;
    private final double probabilidadeChuva;

    EstadosDeTransicoesDosClimas(double probabilidadeSol, double probabilidadeChuva) {
        this.probabilidadeSol = probabilidadeSol;
        this.probabilidadeChuva = probabilidadeChuva;
    }

    public double getProbabilidadeSol() {
        return probabilidadeSol;
    }

    public double getProbabilidadeChuva() {
        return probabilidadeChuva;
    }

    public double getProbabilidadeTransicao(EstadosDeTransicoesDosClimas destino) {
        if (destino == SOL) {
            return this == SOL ? probabilidadeSol : probabilidadeChuva;
        } else if (destino == CHUVA) {
            return this == SOL ? probabilidadeChuva : probabilidadeSol;
        }
        return 0;
    }
}

