package Facade;

import java.io.PrintStream;
import java.util.List;

public class ViewFacade {
    public void start(){
        System.out.printf("%60s\n", "------------------------------------------------------------------------------");
        System.out.printf("%60s\n", "                         BEM VINDO AO JOGO DO TERMO                             ");
        System.out.printf("%60s\n", "                         VAMOS COMEÇAR?                                         ");
        System.out.printf("%60s\n", "------------------------------------------------------------------------------");
    }

    public void tries(int tentativas){
        System.out.printf("%60s\n", "------------------------------------------------------------------------------");
        System.out.printf("%60s\n", "                           Nº DE TENTATIVAS RESTANTES                         ");
        System.out.printf("%29s%2s%29s\n", "                                ", tentativas, " Tentativas                                ");
    }

    public void pedirPalavra(int caracters){
        System.out.printf("\n%29s%2s%29s\n", "                      DIGITE UMA PALAVRA DE ", caracters, " CARACTERES:                           ");
    }

    public void resultado(String[] resultFinal, String word, List<String> colors){
        System.out.printf("%60s\n\n", "------------------------------------------------------------------------------");

        int i= 0;
        char[] palavraList = word.toCharArray();

        System.out.printf("%5s", "                      ");
        for (String result : resultFinal){
            String colorFinal = colors.get((colors.size() - 1));

            if (result.equals("vermelho")){
                System.out.printf("%15s", colors.get(2) + palavraList[i] + colorFinal);

            } else if (result.equals("amarelo")) {
                System.out.printf("%15s", colors.get(1) + palavraList[i] + colorFinal);

            }else{
                System.out.printf("%15s", colors.get(0) + palavraList[i] + colorFinal);
            }
            i++;
        }
        System.out.println("\n");
    }

    public void end(Boolean resultado) {

        if (resultado){
            System.out.printf("%60s\n", "------------------------------------------------------------------------------");
            System.out.printf("%60s\n", "  PARABENS JOGADOR! VOCÊ ACERTOU A PALAVRA SECRETA!              ");
            System.out.printf("%60s\n", "------------------------------------------------------------------------------");

        }else{
            System.out.printf("%60s\n", "------------------------------------------------------------------------------");
            System.out.printf("%60s\n", "        Você Errou! Fim !!       ");
            System.out.printf("%60s\n", "------------------------------------------------------------------------------");
        }
    }
}
