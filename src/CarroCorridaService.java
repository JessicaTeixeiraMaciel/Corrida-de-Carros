public class CarroCorridaService {
    String ANSI_VERMELHO = "\u001B[33m";
    String ANSI_RESET = "\u001B[0m";

    public void acelerar (Double valor, CarroCorrida carro){
        double novaVelocidade = carro.getVelocidadeAtual() + valor;
        double novaDistanciaPercorrida = carro.getDistanciaPercorrida() + (0.5 * carro.getVelocidadeAtual()) / 60;

        if (!carro.getLigado()){
            System.out.printf(ANSI_VERMELHO + "O carro %d está desligado. Para acelera-lo primeiro ligue-o.\n" + ANSI_RESET,carro.getNumeroCarro());
        }else if(valor < 0){
            System.out.printf( ANSI_VERMELHO + "Entrada inválida. O valor inserido deve ser maior ou igual a zero. O carro %d se mantém a %.2f km/h.\n" + ANSI_RESET,carro.getNumeroCarro(), carro.getVelocidadeAtual());
        }else if(carro.getVelocidadeAtual()==0 && carro.getLigado() && valor == 0){
            System.out.printf( ANSI_VERMELHO + "O carro %d se mantém parado.\n" + ANSI_RESET,carro.getNumeroCarro());
        }else if(carro.getVelocidadeAtual().equals(carro.getVelocidadeMaxima()) && carro.getLigado() && valor == 0){
            System.out.printf( ANSI_VERMELHO + "O carro %d se mantém a %.2f km/h.\n" + ANSI_RESET,carro.getNumeroCarro(), carro.getVelocidadeAtual());
        }else if(carro.getVelocidadeAtual().equals(carro.getVelocidadeMaxima()) && carro.getLigado() && valor > 0){
            System.out.printf( ANSI_VERMELHO + "O carro %d já está na velocidade máxima! Ele se mantém a %.2f km/h.\n" + ANSI_RESET,carro.getNumeroCarro(), carro.getVelocidadeAtual());
        }else{
            if (novaVelocidade >= carro.getVelocidadeMaxima() && carro.getLigado()) {
                carro.setVelocidadeAtual(carro.getVelocidadeMaxima());
                carro.setDistanciaPercorrida(novaDistanciaPercorrida);
                System.out.printf( ANSI_VERMELHO + "O carro %d atingiu a velocida máxima de %.2f km/h.\n" + ANSI_RESET,carro.getNumeroCarro(), carro.getVelocidadeAtual());
            }else if (carro.getLigado() && valor == 0){
                carro.setVelocidadeAtual(novaVelocidade);
                carro.setDistanciaPercorrida(novaDistanciaPercorrida);
                System.out.printf( ANSI_VERMELHO + "O carro %d se mantém a %.2f km/h.\n" + ANSI_RESET,carro.getNumeroCarro(), carro.getVelocidadeAtual());
            }else if (carro.getLigado() && valor > 0){
                carro.setVelocidadeAtual(novaVelocidade);
                carro.setDistanciaPercorrida(novaDistanciaPercorrida);
                System.out.printf( ANSI_VERMELHO + "O carro %d atingiu a velocidade de %.2f km/h.\n" + ANSI_RESET,carro.getNumeroCarro(), carro.getVelocidadeAtual());
            }else {
                System.out.printf( ANSI_VERMELHO + "Entrada inválida. A velocidade deve ser um número real. O carro %d se mantém a %.2f km/h.\n" + ANSI_RESET,carro.getNumeroCarro(), carro.getVelocidadeAtual());
            }
        }
    }

    public void ligar(CarroCorrida carro){
        if(carro.getVelocidadeAtual() == 0.0 && !carro.getLigado()){
            carro.setLigado(true);
            System.out.printf( ANSI_VERMELHO + "O carro %d foi ligado.\n" + ANSI_RESET,carro.getNumeroCarro());
        }else{
            System.out.printf( ANSI_VERMELHO + "Atenção! O carro %d já está ligado.\n" + ANSI_RESET,carro.getNumeroCarro());
        }
    }

    public void desligar(CarroCorrida carro){

        if(carro.getVelocidadeAtual() == 0.0 && carro.getLigado()){
            carro.setLigado(false);
            System.out.printf(ANSI_VERMELHO + "O carro %d foi desligado.\n" + ANSI_RESET,carro.getNumeroCarro());
        }else if(carro.getLigado()){
            System.out.printf(ANSI_VERMELHO + "Entrada inválida! O carro %d não pode ser desligado pois ainda está em movimento. \nO carro %d se mantém a %.2f km/h.\n" + ANSI_RESET,carro.getNumeroCarro(),carro.getNumeroCarro(), carro.getVelocidadeAtual());
        }else{
            System.out.printf(ANSI_VERMELHO + "Atenção! O carro %d já está desligado.\n" + ANSI_RESET,carro.getNumeroCarro());
        }
    }

    public void frear(Double valor, CarroCorrida carro){
        double novaVelocidade = carro.getVelocidadeAtual() - valor;

        if(!carro.getLigado()) {
            System.out.printf(ANSI_VERMELHO + "O carro %d está desligado. Para frea-lo primeiro ligue-o.\n" + ANSI_RESET,carro.getNumeroCarro());
        }else if(valor < 0){
            System.out.printf(ANSI_VERMELHO + "Entrada inválida. O valor inserido deve ser maior ou igual a zero. O carro %d se mantém a %.2f km/h.\n" + ANSI_RESET,carro.getNumeroCarro(), carro.getVelocidadeAtual());
        }else if(carro.getVelocidadeAtual() - valor < 0){
            System.out.printf(ANSI_VERMELHO + "Entrada inválida. O carro %d se mantém parado.\n" + ANSI_RESET, carro.getNumeroCarro());
        }else if(carro.getVelocidadeAtual()==0 && carro.getLigado() && valor == 0) {
            System.out.printf(ANSI_VERMELHO + "Atenção! O carro %d já está parado.\n", carro.getNumeroCarro());
        }else{
            if(carro.getLigado() && valor == 0){
                carro.setVelocidadeAtual(novaVelocidade);
                System.out.printf(ANSI_VERMELHO + "O carro %d se mantém a %.2f km/h.\n" + ANSI_RESET,carro.getNumeroCarro(), carro.getVelocidadeAtual());
            }else if (carro.getLigado() && valor > 0 && novaVelocidade == 0){
                carro.setVelocidadeAtual(novaVelocidade);
                System.out.printf(ANSI_VERMELHO + "O carro %d reduziu a velocidade até parar.\n" + ANSI_RESET,carro.getNumeroCarro());
            }else if (carro.getLigado() && valor > 0){
                carro.setVelocidadeAtual(novaVelocidade);
                System.out.printf(ANSI_VERMELHO + "A velocidade do carro %d reduziu para %.2f km/h.\n" + ANSI_RESET,carro.getNumeroCarro(), carro.getVelocidadeAtual());
            }else {
                System.out.printf(ANSI_VERMELHO + "Entrada inválida. A velocidade deve ser um número real. O carro %d se mantém a %.2f km/h.\n" + ANSI_RESET,carro.getNumeroCarro(), carro.getVelocidadeAtual());
            }
        }
    }

    public void parar(CarroCorrida carro){
        double novaVelocidade = 0.0;
        double novaDistanciaPercorrida = carro.getDistanciaPercorrida() + (0.5 * carro.getVelocidadeAtual()) / 60;

        if(carro.getVelocidadeAtual() == 0.0 && carro.getLigado()){
            System.out.printf(ANSI_VERMELHO + "Atenção! O carro %d já está parado.\n" + ANSI_RESET,carro.getNumeroCarro());
        }else if (carro.getLigado()){
            carro.setVelocidadeAtual(novaVelocidade);
            carro.setDistanciaPercorrida(novaDistanciaPercorrida);
            System.out.printf(ANSI_VERMELHO + "O carro %d reduziu a velocidade até parar.\n" + ANSI_RESET,carro.getNumeroCarro());
        }else {
            System.out.printf(ANSI_VERMELHO + "Atenção! O carro %d está deligado. Não há como para-lo.\n" + ANSI_RESET,carro.getNumeroCarro());
        }
    }
}
