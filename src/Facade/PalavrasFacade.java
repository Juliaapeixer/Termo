package Facade;

import java.text.Normalizer;
import java.util.*;

public class PalavrasFacade {
    private Map<Boolean, String[]> result;

    public String getRandomWord(Random rand, List<String> list) {

        int random = rand.nextInt(list.size());
        return list.get(random);
    }

    public String format(String word) {
        return Normalizer.normalize(word, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "");
    }

    public Map<Integer, Boolean> verifySize(String word, Integer tentativas) {
        Map<Integer, Boolean> result = new HashMap<Integer, Boolean>();

        if (word.length() == 5) {
            tentativas -= 1;
            result.put(tentativas, false);

            return result;
        }else {
            result.put(tentativas, true);
            return result;
        }
    }

    public Boolean verifyWord(String userWord, String systemWord, Boolean acerto) {
        return !acerto && Objects.equals(userWord, systemWord);
    }

    public Map<Boolean, String[]> verifyLetters(String userWord, String systemWord){
        result = new HashMap<>();

        char[] listUser = userWord.toCharArray();
        char[] listSystem = systemWord.toCharArray();
        String[] resultados = new String[listSystem.length];

        for (int i = 0; i < listSystem.length; i++){
            resultados[i] = "vermelho";
        }

        for (int i = 0; i < listSystem.length; i++) {
            char user = listUser[i];

            for (int j = 0; j < listUser.length; j++) {
                char system = listSystem[j];
                if (system == user) {
                    resultados[i] = "amarelo";

                    if (i == j){
                        resultados[i] = "verde";
                        break;
                    }
                }
            }
        }
        Boolean correto = true;

        for (String result : resultados){
            if (!Objects.equals(result, "verde")){
                correto = false;
                break;
            }
        }

        result.put(correto, resultados);
        return result;
    }
}
