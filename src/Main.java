import Facade.ColorFacade;
import Facade.FiltroFacade;
import Facade.PalavrasFacade;
import Facade.ViewFacade;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        File arquivo = new File("src/txt/words.txt");
        List<String> list = new ArrayList<>();
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);

        FiltroFacade filterFacade = new FiltroFacade();
        PalavrasFacade wordFacade = new PalavrasFacade();
        ViewFacade viewFacade = new ViewFacade();
        ColorFacade colorFacade = new ColorFacade();

        FileReader fr = new FileReader(arquivo);
        BufferedReader br = new BufferedReader(fr);
        Map<Integer, Boolean> verificacao = new HashMap<Integer, Boolean>();

        String userWord = null;
        Boolean acerto = true;
        int caracteres = 5;
        int tentativas = 7;
        Boolean resultado = null;

        filterFacade.filter(br, list, caracteres);
        String aleatoria = wordFacade.getRandomWord(rand, list);
        String palavra = wordFacade.format(aleatoria).toUpperCase();

        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_RESET = "\u001B[0m";

        colorFacade.setColor(ANSI_GREEN);     // -> Verde
        colorFacade.setColor(ANSI_YELLOW);    // -> Amarelo
        colorFacade.setColor(ANSI_RED);       // -> Verde
        colorFacade.setColor(ANSI_RESET);     // -> Encerra as cores

        viewFacade.start();

        while (tentativas > 0) {
            while (acerto) {
                viewFacade.pedirPalavra(caracteres);
                userWord = scan.nextLine().toUpperCase();
                verificacao = wordFacade.verifySize(userWord, tentativas);

                for (Map.Entry<Integer, Boolean> entry : verificacao.entrySet()) {
                    tentativas = entry.getKey();
                    acerto = entry.getValue();
                }
            }

            resultado = wordFacade.verifyWord(userWord, palavra, acerto);
            Map<Boolean, String[]> resultadoFinal = wordFacade.verifyLetters(userWord, palavra);

            Boolean resultadoBoolean = null;
            String[] resultadoLista = new String[0];

            for (Map.Entry<Boolean, String[]> entry : resultadoFinal.entrySet()) {
                resultadoBoolean = entry.getKey();
                resultadoLista = entry.getValue();
            }

            viewFacade.resultado(resultadoLista, userWord, colorFacade.getColors());

            if (resultadoBoolean || tentativas == 0) {
                viewFacade.end(resultado);
                break;
            } else {
                acerto = true;
            }
            viewFacade.tries(tentativas);
        }

        br.close();
    }
}