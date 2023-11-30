package Facade;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class FiltroFacade {
    public List<String> filter(BufferedReader br, List<String> list, int size) throws IOException {
        String linha;

        while ((linha = br.readLine()) != null) {
            if (linha.length() == size) {
                list.add(linha);
            }
        }
        return list;
    }
}
