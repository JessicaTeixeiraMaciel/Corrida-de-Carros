public class CarroCorridaService {
    public void acelerar (Double valor, CarroCorrida carro){
        double novaVelocidade = carro.getVelocidadeAtual() + valor;
        double novaDistanciaPercorrida = carro.getDistanciaPercorrida() + (0.5 * carro.getVelocidadeAtual()) / 60;

        if (!carro.getLigado()){
            System.out.printf("O carro %d está desligado. Para acelera-lo primeiro ligue-o.\n",carro.getNumeroCarro());
        }else if(valor < 0){
            System.out.println("Entrada inválida. O valor inserido deve ser maior ou igual a zero.");
        }else if(carro.getVelocidadeAtual()==0 && carro.getLigado() && valor == 0){
            System.out.printf("O carro %d se mantém parado.\n",carro.getNumeroCarro());
        }else if(carro.getVelocidadeAtual().equals(carro.getVelocidadeMaxima()) && carro.getLigado() && valor == 0){
            System.out.printf("O carro %d se mantém a %.2f km/h.\n",carro.getNumeroCarro(), carro.getVelocidadeAtual());
        }else if(carro.getVelocidadeAtual().equals(carro.getVelocidadeMaxima()) && carro.getLigado() && valor > 0){
            System.out.printf("O carro %d já está na velocidade máxima! Ele se mantém a %.2f km/h.\n",carro.getNumeroCarro(), carro.getVelocidadeAtual());
        }else{
            if (novaVelocidade >= carro.getVelocidadeMaxima() && carro.getLigado()) {
                carro.setVelocidadeAtual(carro.getVelocidadeMaxima());
                carro.setDistanciaPercorrida(novaDistanciaPercorrida);
                System.out.printf("O carro %d atingiu a velocida máxima de %.2f km/h.\n",carro.getNumeroCarro(), carro.getVelocidadeAtual());
            }else if (carro.getLigado() && valor == 0){
                carro.setVelocidadeAtual(novaVelocidade);
                carro.setDistanciaPercorrida(novaDistanciaPercorrida);
                System.out.printf("O carro %d se mantém a %.2f km/h.\n",carro.getNumeroCarro(), carro.getVelocidadeAtual());
            }else if (carro.getLigado() && valor > 0){
                carro.setVelocidadeAtual(novaVelocidade);
                carro.setDistanciaPercorrida(novaDistanciaPercorrida);
                System.out.printf("O carro %d atingiu a velocidade de %.2f km/h.\n",carro.getNumeroCarro(), carro.getVelocidadeAtual());
            }else {
                System.out.println("Entrada inválida. A velocidade deve ser um número real.");
            }
        }
    }

    public void ligar(CarroCorrida carro){
        if(carro.getVelocidadeAtual() == 0.0 && !carro.getLigado()){
            carro.setLigado(true);
            System.out.printf("O carro %d foi ligado.\n",carro.getNumeroCarro());
        }else{
            System.out.printf("Atenção! O carro %d já está ligado.\n",carro.getNumeroCarro());
        }
    }

    public void desligar(CarroCorrida carro){

        if(carro.getVelocidadeAtual() == 0.0 && carro.getLigado()){
            carro.setLigado(false);
            System.out.printf("O carro %d foi desligado.\n",carro.getNumeroCarro());
        }else if(carro.getLigado()){
            System.out.printf("O carro %d não pode ser desligado pois ainda está em movimento.\n",carro.getNumeroCarro());
        }else{
            System.out.printf("Atenção! O carro %d já está desligado.\n",carro.getNumeroCarro());
        }
    }

    public void frear(Double valor, CarroCorrida carro){
        double novaVelocidade = carro.getVelocidadeAtual() - valor;
        double novaDistanciaPercorrida = carro.getDistanciaPercorrida() + (0.5 * carro.getVelocidadeAtual()) / 60;

        if(!carro.getLigado()) {
            System.out.printf("O carro %d está desligado. Para frea-lo primeiro ligue-o.\n",carro.getNumeroCarro());
        }else if(valor < 0){
            System.out.println("Entrada inválida. O valor inserido deve ser maior ou igual a zero.");
        }else if(carro.getVelocidadeAtual()==0 && carro.getLigado() && valor == 0) {
            System.out.printf("Atenção! O carro %d já está parado.\n", carro.getNumeroCarro());
        }else{
            if(carro.getLigado() && valor == 0){
                carro.setVelocidadeAtual(novaVelocidade);
                carro.setDistanciaPercorrida(novaDistanciaPercorrida);
                System.out.printf("O carro %d se mantém a %.2f km/h.\n",carro.getNumeroCarro(), carro.getVelocidadeAtual());
            }else if (carro.getLigado() && valor > 0 && novaVelocidade == 0){
                carro.setVelocidadeAtual(novaVelocidade);
                carro.setDistanciaPercorrida(novaDistanciaPercorrida);
                System.out.printf("O carro %d reduziu a velocidade até parar.\n",carro.getNumeroCarro());
            }else if (carro.getLigado() && valor > 0){
                carro.setVelocidadeAtual(novaVelocidade);
                carro.setDistanciaPercorrida(novaDistanciaPercorrida);
                System.out.printf("A velocidade do carro %d reduziu para %.2f km/h.\n",carro.getNumeroCarro(), carro.getVelocidadeAtual());
            }else {
                System.out.println("Entrada inválida. A velocidade deve ser um número real.");
            }
        }
    }

    public void parar(CarroCorrida carro){
        double novaVelocidade = 0.0;
        double novaDistanciaPercorrida = carro.getDistanciaPercorrida() + (0.5 * carro.getVelocidadeAtual()) / 60;

        if(carro.getVelocidadeAtual() == 0.0 && carro.getLigado()){
            System.out.printf("Atenção! O carro %d já está parado.\n",carro.getNumeroCarro());
        }else{
            carro.setVelocidadeAtual(novaVelocidade);
            carro.setDistanciaPercorrida(novaDistanciaPercorrida);
            System.out.printf("O carro %d parou.\n",carro.getNumeroCarro());
        }


    }

    public double exibirDistanciaPercorrida (CarroCorrida carro){
        return carro.getDistanciaPercorrida();
    }
}
