public class CarroCorrida {

    private Integer numeroCarro;
    private String piloto;
    private Double velocidadeMaxima;
    private Double velocidadeAtual;
    private Boolean ligado;

    private Double distanciaPercorrida;

    public CarroCorrida(Integer numeroCarro, String piloto, Double velocidadeMaxima, Double velocidadeAtual, Boolean ligado, Double distanciaPercorrida){
        this.numeroCarro = numeroCarro;
        this.piloto = piloto;
        this.velocidadeMaxima = velocidadeMaxima;
        this.velocidadeAtual = velocidadeAtual;
        this.ligado = ligado;
        this.distanciaPercorrida = distanciaPercorrida;
    }

    public Integer getNumeroCarro() {
        return numeroCarro;
    }

    public void setNumeroCarro(Integer numeroCarro) {
        this.numeroCarro = numeroCarro;
    }

    public String getPiloto() {
        return piloto;
    }

    public void setPiloto(String piloto) {
        this.piloto = piloto;
    }

    public Double getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public void setVelocidadeMaxima(Double velocidadeMaxima) {
        this.velocidadeMaxima = velocidadeMaxima;
    }

    public Double getVelocidadeAtual() {
        return velocidadeAtual;
    }

    public void setVelocidadeAtual(Double velocidadeAtual) {
        this.velocidadeAtual = velocidadeAtual;
    }

    public Boolean getLigado() {
        return ligado;
    }

    public void setLigado(Boolean ligado) {
        this.ligado = ligado;
    }

    public Double getDistanciaPercorrida() {
        return distanciaPercorrida;
    }

    public void setDistanciaPercorrida(Double distanciaPercorrida) {
        this.distanciaPercorrida = distanciaPercorrida;
    }
}
