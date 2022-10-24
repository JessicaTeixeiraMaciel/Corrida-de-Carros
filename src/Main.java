import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Jogo jogo = new Jogo();
        DadosCorrida dadosCorrida = new DadosCorrida();

        jogo.limpaTela();
        jogo.boasVidas();
        jogo.continuar();
        jogo.limpaTela();
        jogo.inscricao();
        jogo.equipes();
        jogo.continuar();
        jogo.limpaTela();
        jogo.regras();
        jogo.continuar();
        jogo.limpaTela();
        jogo.rodadas();


    }

}