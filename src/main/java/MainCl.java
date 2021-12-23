import service.CharCombinationService;

import java.io.IOException;

public class MainCl {
    public static void main(String[] args) throws IOException {
        CharCombinationService distributionOfLettersService
                = new CharCombinationService("src/main/java/charSequence.txt"
                ,"src/main/java/allCharCombination.txt");
        distributionOfLettersService.createAllDifferentSequences(6);
    }
}

