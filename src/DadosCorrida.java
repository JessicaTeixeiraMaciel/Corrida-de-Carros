public class DadosCorrida{

    String nomeJogador;
    Integer idadeJogador;
    Enum sexoJogador;
    String equipeJogador;


    Piloto pilotoA = new Piloto("Max Verstappen", 25, Sexo.masculino,"Red Bull Racing");
    Piloto pilotoB = new Piloto("Lewis Hamilton", 37, Sexo.masculino,"Mercedes");
    Piloto pilotoC = new Piloto("Fernando Alonso", 41, Sexo.masculino,"Alpine");
    Piloto pilotoD = new Piloto(nomeJogador, idadeJogador, sexoJogador,equipeJogador);
    CarroCorrida carroA = new CarroCorrida(1, pilotoA.getNome(),350.0,0.0,true,0.0);
    CarroCorrida carroB = new CarroCorrida(2, pilotoB.getNome(),340.0,0.0,true,0.0);
    CarroCorrida carroC = new CarroCorrida(3, pilotoC.getNome(),330.0,0.0,true,0.0);
    CarroCorrida carroD = new CarroCorrida(4, pilotoD.getNome(),350.0,0.0,true,0.0);


}
