import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;
public class Jogo {
    DadosCorrida dadosCorrida = new DadosCorrida();
    CarroCorridaService carroCorridaService = new CarroCorridaService();
    String ANSI_RESET = "\u001B[0m";
    String ANSI_ROXO = "\u001B[35m";
    String ANSI_VERDE = "\u001B[32m";
    String ANSI_AMARELO = "\u001B[33m";
    String ANSI_AZUL = "\u001B[34m";
    String ANSI_CIANO = "\u001B[36m";
    int tempo = 180;
    int tamanhoPercurso = 10;

    public void boasVidas(){
        System.out.println("Seja bem vindo(a) ao\n" + ANSI_CIANO +
                "░█▀▀█ ░█▀▀█ ─█▀▀█ ░█▄─░█ ░█▀▀▄ 　 ░█▀▀█ ░█▀▀█ ░█▀▀▀ ░█▀▄▀█ ▀█▀ ░█─░█ ░█▀▄▀█ 　 ─█▀▀█ ░█▀▀▄ ─█▀▀█ 　 ░█▀▀█ █▀▀█ \n" +
                "░█─▄▄ ░█▄▄▀ ░█▄▄█ ░█░█░█ ░█─░█ 　 ░█▄▄█ ░█▄▄▀ ░█▀▀▀ ░█░█░█ ░█─ ░█─░█ ░█░█░█ 　 ░█▄▄█ ░█─░█ ░█▄▄█ 　 ░█▀▀▄ ──▀▄ \n" +
                "░█▄▄█ ░█─░█ ░█─░█ ░█──▀█ ░█▄▄▀ 　 ░█─── ░█─░█ ░█▄▄▄ ░█──░█ ▄█▄ ─▀▄▄▀ ░█──░█ 　 ░█─░█ ░█▄▄▀ ░█─░█ 　 ░█▄▄█ █▄▄█\n\n\n" + ANSI_RESET +
                "Estamos muito felizes que você tenha aceitado participar do GRAND PREMUIM ADA B3! Ouvimos muito a seu respeito\n" +
                "e concerteza será um grande privilégio tê-lo conosco nesta competição!\n" +
                "Mas antes de tudo, precisamos que você finalize a sua inscrição...\n");

    }
    public void inscricao(){

        Scanner sc = new Scanner(System.in);

        System.out.println("|-------------------------------------------------------------------------------------------------------------|\n" +
                "|                                        FORMULÁRIO DE INSCRIÇÃO                                              |\n" +
                "|-------------------------------------------------------------------------------------------------------------|\n");
        System.out.println("1) Nome:");
        dadosCorrida.nomeJogador = sc.next();

        System.out.println("2) Idade:");
        dadosCorrida.idadeJogador = sc.nextInt();

        System.out.println("3) Sexo (f/m):");
        switch (sc.next()){
            case "f":
                dadosCorrida.sexoJogador = Sexo.feminino;
                break;
            case "m":
                dadosCorrida.sexoJogador = Sexo.masculino;
                break;
        }

        System.out.println("4) Nome da equipe:");
        dadosCorrida.equipeJogador = sc.next();

        System.out.println("---------------------------------------------------------------------------------------------------------------");
    }

    public void equipes(){
        System.out.printf("Inscrição finalizada com sucesso! Veja abaixo a lista completa de participantes:\n\n" +
                "- Carro 1: %s, %d anos, sexo %s, equipe %s\n" +
                "- Carro 2: %s, %d anos, sexo %s, equipe %s\n" +
                "- Carro 3: %s, %d anos, sexo %s, equipe %s\n" +
                "- Carro 4: %s, %d anos, sexo %s, equipe %s\n\n",dadosCorrida.pilotoA.getNome(),dadosCorrida.pilotoA.getIdade(),dadosCorrida.pilotoA.getSexo(),dadosCorrida.pilotoA.getEquipe(),
                dadosCorrida.pilotoB.getNome(),dadosCorrida.pilotoB.getIdade(),dadosCorrida.pilotoB.getSexo(),dadosCorrida.pilotoB.getEquipe(),
                dadosCorrida.pilotoC.getNome(),dadosCorrida.pilotoC.getIdade(),dadosCorrida.pilotoC.getSexo(),dadosCorrida.pilotoC.getEquipe(),
                dadosCorrida.nomeJogador,dadosCorrida.idadeJogador,dadosCorrida.sexoJogador,dadosCorrida.equipeJogador);

    }
    public void continuar(){
        Scanner sc = new Scanner(System.in);
        System.out.println(ANSI_CIANO + "Insira qualquer digito para continuar:" + ANSI_RESET);
        sc.next();
    }

    public void regras(){

        System.out.println("Antes de iniciar a competição gostariamos de passar algumas informações importantes:\n\n"+
                "- O circuito completo tem 10km e a corrida será de volta única.\n" +
                "- No km 7 há uma CURVA MUITO PERIGOSA, por isso é importante estar no MÁXIMO a 220km/h quando passar por ela!\n" +
                "- Você gastará 30s a cada comando que você der ao seu veículo.\n" +
                "- O tempo máximo para finalizar o circuito é de 180s, após isso o competidor será automaticamente desclassificado.\n");

        System.out.println("      " + ANSI_AZUL + "____/   ___                  " + ANSI_VERDE + "____/   ___                  " + ANSI_AMARELO + "____/   ___                  " + ANSI_ROXO +"____/   ___\n" +
                "     " + ANSI_AZUL + "|_ 1 \\__'  _\\                " + ANSI_VERDE + "|_ 2 \\__'  _\\                " + ANSI_AMARELO + "|_ 3 \\__'  _\\                " + ANSI_ROXO + "|_ 4 \\__'  _\\      \n" +
                "     " + ANSI_AZUL + "`-(*)----(*)'                " + ANSI_VERDE + "`-(*)----(*)'                " + ANSI_AMARELO + "`-(*)----(*)'                " + ANSI_ROXO + "`-(*)----(*)'\n" + ANSI_RESET +
                "Todos os competidores a postos. A corrida vai começar em 3... 2... 1... E FOI DADA A LARGADA!");
    }

    public void  limpaTela(){
        for(int i = 0;i < 50; i++){
                System.out.print("\n");
        }
    }

    public void rodadas(){
        Scanner sc = new Scanner(System.in);
        tempo = 330;
        double novaDistanciaPercorrida = 0;
        dadosCorrida.rodada = 0;
        while (tempo > 0 && novaDistanciaPercorrida < tamanhoPercurso && dadosCorrida.carroA.getDistanciaPercorrida() < tamanhoPercurso && dadosCorrida.carroB.getDistanciaPercorrida() < tamanhoPercurso && dadosCorrida.carroC.getDistanciaPercorrida() < tamanhoPercurso){
            painelDeControle();
            switch(sc.nextInt()){
                case 1:
                    carroCorridaService.ligar(dadosCorrida.carroD);
                    novaDistanciaPercorrida = dadosCorrida.carroD.getDistanciaPercorrida() + (0.5 * dadosCorrida.carroD.getVelocidadeAtual()) / 60;
                    dadosCorrida.carroD.setDistanciaPercorrida(novaDistanciaPercorrida);
                    break;
                case 2 :
                    carroCorridaService.acelerar(60.0,dadosCorrida.carroD);
                    novaDistanciaPercorrida = dadosCorrida.carroD.getDistanciaPercorrida() + (0.5 * dadosCorrida.carroD.getVelocidadeAtual()) / 60;
                    dadosCorrida.carroD.setDistanciaPercorrida(novaDistanciaPercorrida);
                    break;
                case 3 :
                    carroCorridaService.frear(60.0,dadosCorrida.carroD);
                    novaDistanciaPercorrida = dadosCorrida.carroD.getDistanciaPercorrida() + (0.5 * dadosCorrida.carroD.getVelocidadeAtual()) / 60;
                    dadosCorrida.carroD.setDistanciaPercorrida(novaDistanciaPercorrida);
                    break;
                case 4 :
                    carroCorridaService.acelerar(0.0,dadosCorrida.carroD);
                    novaDistanciaPercorrida = dadosCorrida.carroD.getDistanciaPercorrida() + (0.5 * dadosCorrida.carroD.getVelocidadeAtual()) / 60;
                    dadosCorrida.carroD.setDistanciaPercorrida(novaDistanciaPercorrida);
                    break;
                case 5 :
                    carroCorridaService.parar(dadosCorrida.carroD);
                    novaDistanciaPercorrida = dadosCorrida.carroD.getDistanciaPercorrida() + (0.5 * dadosCorrida.carroD.getVelocidadeAtual()) / 60;
                    dadosCorrida.carroD.setDistanciaPercorrida(novaDistanciaPercorrida);
                    break;
                case 6 :
                    carroCorridaService.desligar(dadosCorrida.carroD);
                    novaDistanciaPercorrida = dadosCorrida.carroD.getDistanciaPercorrida() + (0.5 * dadosCorrida.carroD.getVelocidadeAtual()) / 60;
                    dadosCorrida.carroD.setDistanciaPercorrida(novaDistanciaPercorrida);
                    break;
            }
            linhaDoTempo();
            tempo = tempo - 30;
            dadosCorrida.rodada++;;
        }

        if (dadosCorrida.carroD.getDistanciaPercorrida() >= tamanhoPercurso){
            System.out.println("Parabéns! Você finalizou o percurso!");
        }else if {
            System.out.println("O tempo acabou e voce foi desclassificado!");
        }else {
            System.out.println("O tempo acabou e voce foi desclassificado!");
        }
    }

    public void painelDeControle(){
        String status;

        if (dadosCorrida.carroD.getLigado()) {
            status = "Ligado";
        } else {
            status = "Desligado";
        }
            System.out.printf("\nTempo de prova restante: %ds\n"+
                    "Colocação atual: %dº\n"+
                    "|------------------------------------------------------------------------|\n" +
                    "|                             PAINEL DE CONTROLE                         |\n" +
                    "|------------------------------------------------------------------------|\n" +
                    " Opção '1' - Ligar o carro            | Status do veículo: %s \n" +
                    " Opção '2' - Acelerar (+ 60 km/h)     | Velocidade atual:  %.1f km/h \n" +
                    " Opção '3' - Frear (- 60 km/h)        | Km percorridos: %.1f km  \n" +
                    " Opção '4' - Manter Velocidade        |   \n" +
                    " Opção '5' - Parar o carro            |                         \n" +
                    " Opção '6' - Desligar o carro         |                         \n" +
                    "--------------------------------------------------------------------------\n" +
                    ANSI_CIANO + "O que você vai fazer? Insira sua opção aqui:" + ANSI_RESET,tempo,1,status,dadosCorrida.carroD.getVelocidadeAtual(),dadosCorrida.carroD.getDistanciaPercorrida());
    }

    public void linhaDoTempo(){
        if (dadosCorrida.rodada == 0){
            if (dadosCorrida.carroA.getDistanciaPercorrida() < tamanhoPercurso){
            carroCorridaService.acelerar(60.0, dadosCorrida.carroA);
            }
            if (dadosCorrida.carroB.getDistanciaPercorrida() < tamanhoPercurso){
                carroCorridaService.ligar(dadosCorrida.carroB);
            }
            if (dadosCorrida.carroC.getDistanciaPercorrida() < tamanhoPercurso){
                carroCorridaService.acelerar(60.0, dadosCorrida.carroC);
            }
        } else if (dadosCorrida.rodada == 1){
            if (dadosCorrida.carroA.getDistanciaPercorrida() < tamanhoPercurso){
                carroCorridaService.acelerar(60.0, dadosCorrida.carroA);
            }
            if (dadosCorrida.carroB.getDistanciaPercorrida() < tamanhoPercurso){
                carroCorridaService.acelerar(60.0, dadosCorrida.carroB);
            }
            if (dadosCorrida.carroC.getDistanciaPercorrida() < tamanhoPercurso){
                carroCorridaService.acelerar(0.0, dadosCorrida.carroC);
            }
        } else if (dadosCorrida.rodada == 2){
            if (dadosCorrida.carroA.getDistanciaPercorrida() < tamanhoPercurso){
                carroCorridaService.acelerar(60.0, dadosCorrida.carroA);
            }
            if (dadosCorrida.carroB.getDistanciaPercorrida() < tamanhoPercurso){
                carroCorridaService.frear(60.0, dadosCorrida.carroB);
            }
            if (dadosCorrida.carroC.getDistanciaPercorrida() < tamanhoPercurso){
                carroCorridaService.acelerar(0.0, dadosCorrida.carroC);
            }
        } else if (dadosCorrida.rodada == 3){
            if (dadosCorrida.carroA.getDistanciaPercorrida() < tamanhoPercurso){
                carroCorridaService.acelerar(0.0, dadosCorrida.carroA);
            }
            if (dadosCorrida.carroB.getDistanciaPercorrida() < tamanhoPercurso){
                carroCorridaService.desligar(dadosCorrida.carroB);
            }
            if (dadosCorrida.carroC.getDistanciaPercorrida() < tamanhoPercurso){
                carroCorridaService.acelerar(60.0, dadosCorrida.carroC);
            }
        } else if (dadosCorrida.rodada == 4){
            if (dadosCorrida.carroA.getDistanciaPercorrida() < tamanhoPercurso){
                carroCorridaService.acelerar(0.0, dadosCorrida.carroA);
            }
            if (dadosCorrida.carroB.getDistanciaPercorrida() < tamanhoPercurso){
                carroCorridaService.ligar(dadosCorrida.carroB);
            }
            if (dadosCorrida.carroC.getDistanciaPercorrida() < tamanhoPercurso){
                carroCorridaService.acelerar(60.0, dadosCorrida.carroC);
            }
        } else if (dadosCorrida.rodada == 5){
            if (dadosCorrida.carroA.getDistanciaPercorrida() < tamanhoPercurso){
                carroCorridaService.acelerar(60.0, dadosCorrida.carroA);
            }
            if (dadosCorrida.carroB.getDistanciaPercorrida() < tamanhoPercurso){
                carroCorridaService.acelerar(60.0, dadosCorrida.carroB);
            }
            if (dadosCorrida.carroC.getDistanciaPercorrida() < tamanhoPercurso){
                carroCorridaService.frear(60.0, dadosCorrida.carroC);
            }
        } else if (dadosCorrida.rodada == 6){
            if (dadosCorrida.carroA.getDistanciaPercorrida() < tamanhoPercurso){
                carroCorridaService.acelerar(60.0, dadosCorrida.carroA);
            }
            if (dadosCorrida.carroB.getDistanciaPercorrida() < tamanhoPercurso){
                carroCorridaService.acelerar(60.0, dadosCorrida.carroB);
            }
            if (dadosCorrida.carroC.getDistanciaPercorrida() <  tamanhoPercurso){
                carroCorridaService.parar(dadosCorrida.carroC);
            }
        } else if (dadosCorrida.rodada == 7){
            if (dadosCorrida.carroA.getDistanciaPercorrida() < tamanhoPercurso){
                carroCorridaService.acelerar(0.0, dadosCorrida.carroA);
            }
            if (dadosCorrida.carroB.getDistanciaPercorrida() < tamanhoPercurso){
                carroCorridaService.acelerar(60.0, dadosCorrida.carroB);
            }
            if (dadosCorrida.carroC.getDistanciaPercorrida() < tamanhoPercurso){
                carroCorridaService.acelerar(60.0, dadosCorrida.carroC);
            }
        } else if (dadosCorrida.rodada == 8){
            if (dadosCorrida.carroA.getDistanciaPercorrida() < tamanhoPercurso){
                carroCorridaService.frear(60.0, dadosCorrida.carroA);
            }
            if (dadosCorrida.carroB.getDistanciaPercorrida() < tamanhoPercurso){
                carroCorridaService.acelerar(60.0, dadosCorrida.carroB);
            }
            if (dadosCorrida.carroC.getDistanciaPercorrida() < tamanhoPercurso){
                carroCorridaService.acelerar(60.0, dadosCorrida.carroC);
            }
        } else if (dadosCorrida.rodada == 9){
            if (dadosCorrida.carroA.getDistanciaPercorrida() < tamanhoPercurso){
                carroCorridaService.acelerar(60.0, dadosCorrida.carroA);
            }
            if (dadosCorrida.carroB.getDistanciaPercorrida() < tamanhoPercurso){
                carroCorridaService.acelerar(0.0, dadosCorrida.carroB);
            }
            if (dadosCorrida.carroC.getDistanciaPercorrida() < tamanhoPercurso){
                carroCorridaService.acelerar(60.0, dadosCorrida.carroC);
            }
        } else if (dadosCorrida.rodada == 10){
            if (dadosCorrida.carroA.getDistanciaPercorrida() < tamanhoPercurso){
                carroCorridaService.acelerar(60.0, dadosCorrida.carroA);
            }
            if (dadosCorrida.carroB.getDistanciaPercorrida() < tamanhoPercurso){
                carroCorridaService.acelerar(60.0, dadosCorrida.carroB);
            }
            if (dadosCorrida.carroC.getDistanciaPercorrida() < tamanhoPercurso){
                carroCorridaService.acelerar(60.0, dadosCorrida.carroC);
            }
        }
    }
}
