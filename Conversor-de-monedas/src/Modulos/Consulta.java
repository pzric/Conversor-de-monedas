package Modulos;

class Consulta {
    private String fechaHora;
    private double monto;
    private String divisaOrigen;
    private String resultadoDeLaConversion;
    private String divisaDestino;

    public Consulta(
            String fechaHora,
            double monto,
            String divisaOrigen,
            String resultadoDeLaConversion,
            String divisaDestino){
        this.fechaHora = fechaHora;
        this.monto = monto;
        this.divisaOrigen = divisaOrigen;
        this.resultadoDeLaConversion = resultadoDeLaConversion;
        this.divisaDestino = divisaDestino;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getDivisaOrigen() {
        return divisaOrigen;
    }

    public void setDivisaOrigen(String divisaOrigen) {
        this.divisaOrigen = divisaOrigen;
    }

    public String getResultadoDeLaConversion() {
        return resultadoDeLaConversion;
    }

    public void setResultadoDeLaConversion(String resultadoDeLaConversion) {
        this.resultadoDeLaConversion = resultadoDeLaConversion;
    }

    public String getDivisaDestino() {
        return divisaDestino;
    }

    public void setDivisaDestino(String divisaDestino) {
        this.divisaDestino = divisaDestino;
    }
}